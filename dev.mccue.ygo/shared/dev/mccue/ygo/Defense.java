package dev.mccue.ygo;

public record Defense(int value) {
    @Override
    public String toString() {
        return "Defense[" + value + "]";
    }
}
