package dev.mccue.ygo.message;

public record NewTurnMessage(byte player)
        implements Message {
}
