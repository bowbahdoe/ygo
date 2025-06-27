package dev.mccue.ygo.message;

public record WinMessage(
        byte player,
        byte reason
) implements Message {
}
