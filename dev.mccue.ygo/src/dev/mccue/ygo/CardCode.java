package dev.mccue.ygo;

public record CardCode(int value) {
    @Override
    public String toString() {
        return "CardCode[value=" + Integer.toUnsignedString(value) + "]";
    }
}
