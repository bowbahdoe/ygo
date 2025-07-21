package dev.mccue.ygo;

import static dev.mccue.ygo.bindings.yugioh_h.*;

public enum CardPos {
    FACEUP_ATTACK(POS_FACEUP_ATTACK()),
    FACEDOWN_ATTACK(POS_FACEDOWN_ATTACK()),
    FACEUP_DEFENSE(POS_FACEUP_DEFENSE()),
    FACEDOWN_DEFENSE(POS_FACEDOWN_DEFENSE()),
    FACEUP(POS_FACEUP()),
    FACEDOWN(POS_FACEDOWN()),
    ATTACK(POS_ATTACK()),
    DEFENSE(POS_DEFENSE());

    final int value;

    CardPos(int value) {
        this.value = value;
    }
}
