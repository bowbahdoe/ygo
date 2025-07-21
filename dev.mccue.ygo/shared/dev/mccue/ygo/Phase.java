package dev.mccue.ygo;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static dev.mccue.ygo.bindings.yugioh_h.*;

public enum Phase {
    STANDBY(PHASE_STANDBY()),
    DRAW(PHASE_DRAW()),
    MAIN1(PHASE_MAIN1()),
    BATTLE(PHASE_BATTLE()),
    BATTLE_START(PHASE_BATTLE_START()),
    BATTLE_STEP(PHASE_BATTLE_STEP()),
    DAMAGE(PHASE_DAMAGE()),
    DAMAGE_CAL(PHASE_DAMAGE_CAL()),
    MAIN2(PHASE_MAIN2()),
    END(PHASE_END());

    final int value;

    Phase(int value) {
        this.value = value;
    }

    static final Map<Integer, Phase> values;

    static {
        var vs = new LinkedHashMap<Integer, Phase>();

        for (var v : Phase.values()) {
            vs.put(v.value, v);
        }

        values = Collections.unmodifiableMap(vs);
    }


    static Phase fromInt(int value) {
        var v = values.get(value);
        if (v == null) {
            throw new IllegalArgumentException("Unknown Hint: " + value);
        }
        else {
            return v;
        }
    }
}
