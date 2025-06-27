help:
    just --list

# Download and buld the core engine for yugioh
clone_ygopro_core:
    rm -rf ygopro-core
    git clone --recurse-submodules  https://github.com/edo9300/ygopro-core
    cd ygopro-core && ./scripts/install-premake5.sh macosx
    cd ygopro-core && ./premake5 gmake2
    cd ygopro-core && make -Cbuild ocgcoreshared config=release
    # Later on I can include the static lib in the jmod for hermetic images
    cd ygopro-core && make -Cbuild ocgcore config=release


# Download the Scripts for Different cards
clone_ygopro_scripts:
    rm -rf ygopro-scripts
    git clone https://github.com/Fluorohydride/ygopro-scripts
    mkdir -p dev.mccue.ygo.cards/src/dev/mccue/ygo/cards
    cp -r ygopro-scripts/*.lua dev.mccue.ygo.cards/src/dev/mccue/ygo/cards

# Generate Java bindings for ygopro_core
generate_ygo_bindings:
    rm -rf dev.mccue.ygo/mac_aarch64
    jextract \
        --include-dir ygopro-core \
        --output dev.mccue.ygo/mac_aarch64 \
        --library ocgcore \
        --use-system-load-library \
        --target-package dev.mccue.ygo.bindings \
        dev.mccue.ygo/c/yugioh.h

clean:
    rm -rf build

compile: clean
    javac \
      --module-source-path "./*/shared:./*/{{os()}}_{{arch()}}" \
      --module dev.mccue.ygo \
      -d build/javac \
      --release 22 \
      -g

package: compile
    mkdir -p build/jmod/mac_aarch64/

    mkdir -p build/jmod/temp

    mkdir -p build/jmod/temp/legal-notices
    cp ygopro-core/COPYING build/jmod/temp/legal-notices/COPYING
    cp ygopro-core/LICENSE build/jmod/temp/legal-notices/LICENSE

    mkdir -p build/jmod/temp/header-files
    cp ygopro-core/ocgapi.h build/jmod/temp/header-files
    cp ygopro-core/ocgapi_types.h build/jmod/temp/header-files
    cp ygopro-core/ocgapi_constants.h build/jmod/temp/header-files

    jmod create \
        --class-path build/javac/dev.mccue.ygo \
        --libs ygopro-core/bin/release \
        --legal-notices build/jmod/temp/legal-notices \
        --header-files build/jmod/temp/header-files \
        build/jmod/mac_aarch64/dev.mccue.ygo.jmod

    rm -rf build/jmod/temp
