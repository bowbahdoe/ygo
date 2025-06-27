package dev.mccue.ygo;

public enum Team {
    ZERO((byte) 0),
    ONE((byte) 1);

    final byte value;

    Team(byte value) {
        this.value = value;
    }

    static Team fromInt(int value) {
        if (value == 0) {
            return ZERO;
        }
        else if (value == 1) {
            return ONE;
        }
        else {
            throw new IllegalStateException("Illegal Team value: " + value);
        }
    }
}
