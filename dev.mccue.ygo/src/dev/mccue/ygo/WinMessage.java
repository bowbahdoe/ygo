package dev.mccue.ygo;

public record WinMessage(
        byte player,
        byte reason
) implements Message {
}
