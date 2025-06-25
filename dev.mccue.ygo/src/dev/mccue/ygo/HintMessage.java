package dev.mccue.ygo;

public record HintMessage(
        Hint hint,
        byte player,
        long __
) implements Message {

}
