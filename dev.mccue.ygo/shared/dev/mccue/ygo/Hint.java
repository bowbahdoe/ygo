package dev.mccue.ygo;

import java.util.*;
import static dev.mccue.ygo.bindings.yugioh_h.*;

public enum Hint {
    EVENT(HINT_EVENT()),
    MESSAGE(HINT_MESSAGE()),
    SELECTMSG(HINT_SELECTMSG()),
    OPSELECTED(HINT_OPSELECTED()),
    EFFECT(HINT_EFFECT()),
    RACE(HINT_RACE()),
    ATTRIB(HINT_ATTRIB()),
    CODE(HINT_CODE()),
    NUMBER(HINT_NUMBER()),
    CARD(HINT_CARD()),
    ZONE(HINT_ZONE());

    final int value;

    static final Map<Integer, Hint> values;

    static {
        var vs = new LinkedHashMap<Integer, Hint>();

        for (var v : Hint.values()) {
            vs.put(v.value, v);
        }

        values = Collections.unmodifiableMap(vs);
    }

    Hint(int value) {
        this.value = value;
    }

    static Hint fromInt(int value) {
        var v = values.get(value);
        if (v == null) {
            throw new IllegalArgumentException("Unknown Hint: " + value);
        }
        else {
            return v;
        }
    }
}

