package dev.mccue.ygo;

import dev.mccue.ygo.bindings.yugioh_h;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;

final class MessageType {
    final String name;
    final int value;

    private static final Map<Integer, MessageType> values;
    static {
        var vs = new LinkedHashMap<Integer, MessageType>();

        Arrays.stream(yugioh_h.class.getMethods())
                .filter(method -> (method.getModifiers() & Modifier.STATIC) != 0)
                .filter(method -> method.getName().startsWith("MSG_"))
                .forEach(method -> {
                    try {
                        int value = (int) method.invoke(yugioh_h.class);
                        vs.put(value, new MessageType(method.getName(), value));
                    } catch (InvocationTargetException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });

        values = Collections.unmodifiableMap(vs);
    }

    private MessageType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    static MessageType fromInt(int value) {
        var v = values.get(value);
        if (v == null) {
           throw new IllegalArgumentException("Unknown Message: " + value);
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
