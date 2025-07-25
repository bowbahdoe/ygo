// Generated by jextract

package dev.mccue.ygo.bindings;

import java.lang.invoke.*;
import java.lang.foreign.*;
import java.nio.ByteOrder;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.PathElement.*;

/**
 * {@snippet lang=c :
 * struct OCG_Player {
 *     uint32_t startingLP;
 *     uint32_t startingDrawCount;
 *     uint32_t drawCountPerTurn;
 * }
 * }
 */
public class OCG_Player {

    OCG_Player() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
        yugioh_h.C_INT.withName("startingLP"),
        yugioh_h.C_INT.withName("startingDrawCount"),
        yugioh_h.C_INT.withName("drawCountPerTurn")
    ).withName("OCG_Player");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final OfInt startingLP$LAYOUT = (OfInt)$LAYOUT.select(groupElement("startingLP"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * uint32_t startingLP
     * }
     */
    public static final OfInt startingLP$layout() {
        return startingLP$LAYOUT;
    }

    private static final long startingLP$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * uint32_t startingLP
     * }
     */
    public static final long startingLP$offset() {
        return startingLP$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * uint32_t startingLP
     * }
     */
    public static int startingLP(MemorySegment struct) {
        return struct.get(startingLP$LAYOUT, startingLP$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * uint32_t startingLP
     * }
     */
    public static void startingLP(MemorySegment struct, int fieldValue) {
        struct.set(startingLP$LAYOUT, startingLP$OFFSET, fieldValue);
    }

    private static final OfInt startingDrawCount$LAYOUT = (OfInt)$LAYOUT.select(groupElement("startingDrawCount"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * uint32_t startingDrawCount
     * }
     */
    public static final OfInt startingDrawCount$layout() {
        return startingDrawCount$LAYOUT;
    }

    private static final long startingDrawCount$OFFSET = 4;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * uint32_t startingDrawCount
     * }
     */
    public static final long startingDrawCount$offset() {
        return startingDrawCount$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * uint32_t startingDrawCount
     * }
     */
    public static int startingDrawCount(MemorySegment struct) {
        return struct.get(startingDrawCount$LAYOUT, startingDrawCount$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * uint32_t startingDrawCount
     * }
     */
    public static void startingDrawCount(MemorySegment struct, int fieldValue) {
        struct.set(startingDrawCount$LAYOUT, startingDrawCount$OFFSET, fieldValue);
    }

    private static final OfInt drawCountPerTurn$LAYOUT = (OfInt)$LAYOUT.select(groupElement("drawCountPerTurn"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * uint32_t drawCountPerTurn
     * }
     */
    public static final OfInt drawCountPerTurn$layout() {
        return drawCountPerTurn$LAYOUT;
    }

    private static final long drawCountPerTurn$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * uint32_t drawCountPerTurn
     * }
     */
    public static final long drawCountPerTurn$offset() {
        return drawCountPerTurn$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * uint32_t drawCountPerTurn
     * }
     */
    public static int drawCountPerTurn(MemorySegment struct) {
        return struct.get(drawCountPerTurn$LAYOUT, drawCountPerTurn$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * uint32_t drawCountPerTurn
     * }
     */
    public static void drawCountPerTurn(MemorySegment struct, int fieldValue) {
        struct.set(drawCountPerTurn$LAYOUT, drawCountPerTurn$OFFSET, fieldValue);
    }

    /**
     * Obtains a slice of {@code arrayParam} which selects the array element at {@code index}.
     * The returned segment has address {@code arrayParam.address() + index * layout().byteSize()}
     */
    public static MemorySegment asSlice(MemorySegment array, long index) {
        return array.asSlice(layout().byteSize() * index);
    }

    /**
     * The size (in bytes) of this struct
     */
    public static long sizeof() { return layout().byteSize(); }

    /**
     * Allocate a segment of size {@code layout().byteSize()} using {@code allocator}
     */
    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout());
    }

    /**
     * Allocate an array of size {@code elementCount} using {@code allocator}.
     * The returned segment has size {@code elementCount * layout().byteSize()}.
     */
    public static MemorySegment allocateArray(long elementCount, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(elementCount, layout()));
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, Arena arena, Consumer<MemorySegment> cleanup) {
        return reinterpret(addr, 1, arena, cleanup);
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code elementCount * layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, long elementCount, Arena arena, Consumer<MemorySegment> cleanup) {
        return addr.reinterpret(layout().byteSize() * elementCount, arena, cleanup);
    }
}

