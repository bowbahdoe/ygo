#include <stdint.h>

struct JavaByteArrayAccess {
    uint8_t (*get)(int32_t);
    int32_t (*length)();
};

void call(struct JavaByteArrayAccess access) {
    int32_t length = access->length();
    for (int i = 0; i < length; i++) {
        uint8_t v = access->get(i);
        printf("%d: %d", i, v);
    }
}