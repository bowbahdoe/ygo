package dev.mccue.ygo;

public record Attack(int value) {
    @Override
    public String toString() {
        return "Attack[" + value + "]";
    }
}
