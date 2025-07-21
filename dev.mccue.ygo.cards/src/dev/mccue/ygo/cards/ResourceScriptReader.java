package dev.mccue.ygo.cards;

import dev.mccue.ygo.ScriptReader;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Optional;

public class ResourceScriptReader implements ScriptReader {
    @Override
    public Optional<String> read(String name) {
        var resource = ResourceScriptReader.class.getResourceAsStream("dev/mccue/ygo/cards/" + name);
        if (resource == null) {
            return Optional.empty();
        }
        try (var is = resource) {
            return Optional.of(
                    new String(is.readAllBytes())
            );
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
