package dev.mccue.ygo;

import java.util.Set;

import static dev.mccue.ygo.bindings.yugioh_h.*;

public enum LinkMarker {
    BOTTOM_LEFT(LINK_MARKER_BOTTOM_LEFT()) {
        @Override
        public String toString() {
            return "↙";
        }
    },
    BOTTOM(LINK_MARKER_BOTTOM()) {
        @Override
        public String toString() {
            return "↓";
        }
    },
    BOTTOM_RIGHT(LINK_MARKER_BOTTOM_RIGHT()) {
        @Override
        public String toString() {
            return "↘";
        }
    },
    LEFT(LINK_MARKER_LEFT()) {
        @Override
        public String toString() {
            return "←";
        }
    },
    RIGHT(LINK_MARKER_RIGHT()) {
        @Override
        public String toString() {
            return "→";
        }
    },
    TOP_LEFT(LINK_MARKER_TOP_LEFT()) {
        @Override
        public String toString() {
            return "↖";
        }
    },
    TOP(LINK_MARKER_TOP()) {
        @Override
        public String toString() {
            return "↑";
        }
    },
    TOP_RIGHT(LINK_MARKER_TOP_RIGHT()) {
        @Override
        public String toString() {
            return "↗";
        }
    };

    final int value;

    LinkMarker(int value) {
        this.value = value;
    }

    static int combine(Set<LinkMarker> markers) {
        int total = 0;
        for (var marker : markers) {
            total |= marker.value;
        }
        return total;
    }
}
