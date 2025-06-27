package dev.mccue.ygo;

import java.lang.foreign.MemorySegment;
import java.util.Optional;

public interface ScriptReader {
    // int apply(MemorySegment payload, MemorySegment duel, MemorySegment name);
    Optional<String> read(String name);
}
