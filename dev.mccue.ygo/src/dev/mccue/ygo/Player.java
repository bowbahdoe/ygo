package dev.mccue.ygo;

public record Player(
        int drawCountPerTurn,
        int startingDrawCount,
        int startingLP
) {
    public Player() {
        this(1, 5, 8000);
    }
}
