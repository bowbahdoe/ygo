package dev.mccue.ygo;

public record CardCode(int value) {
    public CardCode {
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be greater than zero");
        }
    }
    @Override
    public String toString() {
        return "CardCode[" + Integer.toUnsignedString(value) + "]";
    }
}
