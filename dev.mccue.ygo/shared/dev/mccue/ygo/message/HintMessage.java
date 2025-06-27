package dev.mccue.ygo.message;

import dev.mccue.ygo.Hint;

public record HintMessage(
        Hint hint,
        byte player,
        long __
) implements Message {

}
