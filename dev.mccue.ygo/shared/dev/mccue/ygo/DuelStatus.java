package dev.mccue.ygo;

import dev.mccue.ygo.bindings.yugioh_h;

public enum DuelStatus {
    END(yugioh_h.OCG_DUEL_STATUS_END()),
    AWAITING(yugioh_h.OCG_DUEL_STATUS_AWAITING()),
    CONTINUE(yugioh_h.OCG_DUEL_STATUS_CONTINUE());

    final int value;

    DuelStatus(int value) {
        this.value = value;
    }
}
