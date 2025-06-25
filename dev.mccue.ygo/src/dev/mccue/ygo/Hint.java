package dev.mccue.ygo;

import dev.mccue.ygo.bindings.yugioh_h;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;

final class Hint {
    final String name;
    final int value;

    private static final Map<Integer, Hint> values;
    static {
        var vs = new LinkedHashMap<Integer, Hint>();

        Arrays.stream(yugioh_h.class.getMethods())
                .filter(method -> (method.getModifiers() & Modifier.STATIC) != 0)
                .filter(method -> method.getName().startsWith("HINT_"))
                .forEach(method -> {
                    try {
                        int value = (int) method.invoke(yugioh_h.class);
                        vs.put(value, new Hint(method.getName(), value));
                    } catch (InvocationTargetException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });

        values = Collections.unmodifiableMap(vs);
    }

    private Hint(String name, int value) {
        this.name = name;
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

    @Override
    public String toString() {
        return name;
    }
}

