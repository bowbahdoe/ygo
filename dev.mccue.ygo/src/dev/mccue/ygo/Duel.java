package dev.mccue.ygo;

import dev.mccue.ygo.bindings.*;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static dev.mccue.ygo.bindings.yugioh_h.*;
import static java.lang.foreign.ValueLayout.JAVA_BYTE;

public final class Duel implements AutoCloseable {
    private final Arena arena;
    private final MemorySegment duel;

    private record DataReaderDelegate(CardReader cardReader)
            implements OCG_DataReader.Function {

        @Override
        public void apply(MemorySegment payload, int code, MemorySegment data) {
            var cardData = cardReader.read(new CardCode(code));
            OCG_CardData.code(data, cardData.code().value());
            OCG_CardData.attack(data, cardData.attack());
            OCG_CardData.defense(data, cardData.defense());
        }
    }

    private record ScriptReaderDelegate(ScriptReader scriptReader)
            implements OCG_ScriptReader.Function {

        @Override
        public int apply(MemorySegment payload, MemorySegment duel, MemorySegment name) {
            var script = scriptReader.read(name.getString(0)).orElse(null);

            if (script != null) {
                try (var arena = Arena.ofConfined()) {
                    var bytes = script.getBytes(StandardCharsets.UTF_8);
                    var arr = arena.allocate(JAVA_BYTE, bytes.length);
                    for (int i = 0; i < bytes.length; i++) {
                        arr.set(JAVA_BYTE, i, bytes[i]);
                    }
                    OCG_LoadScript(duel, arr, bytes.length, name);
                }
                return 1;
            }
            return 0;
        }
    }

    private Duel(Builder builder) {
        this.arena = Arena.ofConfined();

        long[] seed;
        if (builder.seed != null) {
            seed = builder.seed;
        }
        else {
            var random = ThreadLocalRandom.current();
            seed = new long[] {
                    random.nextLong(),
                    random.nextLong(),
                    random.nextLong(),
                    random.nextLong()
            };
        }

        var options = OCG_DuelOptions.allocate(arena);

        OCG_DuelOptions.seed(options, 0, seed[0]);
        OCG_DuelOptions.seed(options, 1, seed[1]);
        OCG_DuelOptions.seed(options, 2, seed[2]);
        OCG_DuelOptions.seed(options, 3, seed[3]);

        var team1 = OCG_Player.allocate(arena);
        OCG_Player.drawCountPerTurn(team1, builder.team1.drawCountPerTurn());
        OCG_Player.startingDrawCount(team1, builder.team1.startingDrawCount());
        OCG_Player.startingLP(team1, builder.team1.startingLP());

        var team2 = OCG_Player.allocate(arena);
        OCG_Player.drawCountPerTurn(team2, builder.team2.drawCountPerTurn());
        OCG_Player.startingDrawCount(team2, builder.team2.startingDrawCount());
        OCG_Player.startingLP(team2, builder.team2.startingLP());

        OCG_DuelOptions.team1(options, team1);
        OCG_DuelOptions.team2(options, team2);

        var dataReader = OCG_DataReader.allocate(
                new DataReaderDelegate(builder.cardReader),
                arena
        );

        OCG_DuelOptions.cardReader(options, dataReader);

        var scriptReader = OCG_ScriptReader.allocate(
                new ScriptReaderDelegate(builder.scriptReader),
                arena
        );

        OCG_DuelOptions.scriptReader(options, scriptReader);

        var duelPtr = arena.allocate(C_POINTER);

        int duelCreationResult = OCG_CreateDuel(duelPtr, options);
        if (duelCreationResult != OCG_DUEL_CREATION_SUCCESS()) {
            if (duelCreationResult == OCG_DUEL_CREATION_INCOMPATIBLE_LUA_API()) {
                throw new IllegalStateException("OCG_DUEL_CREATION_INCOMPATIBLE_LUA_API");
            }
            if (duelCreationResult == OCG_DUEL_CREATION_NO_OUTPUT()) {
                throw new IllegalStateException("OCG_DUEL_CREATION_NO_OUTPUT");
            }
            if (duelCreationResult == OCG_DUEL_CREATION_NOT_CREATED()) {
                throw new IllegalStateException("OCG_DUEL_CREATION_NOT_CREATED");
            }
            if (duelCreationResult == OCG_DUEL_CREATION_NULL_DATA_READER()) {
                throw new IllegalStateException("OCG_DUEL_CREATION_NULL_DATA_READER");
            }
            if (duelCreationResult == OCG_DUEL_CREATION_NULL_RNG_SEED()) {
                throw new IllegalStateException("OCG_DUEL_CREATION_NULL_RNG_SEED");
            }
            if (duelCreationResult == OCG_DUEL_CREATION_NULL_SCRIPT_READER()) {
                throw new IllegalStateException("OCG_DUEL_CREATION_NULL_SCRIPT_READER");
            }
            throw new IllegalStateException("Unknown Duel Creation Error: " + duelCreationResult);
        }

        this.duel = duelPtr.get(OCG_Duel, 0);
    }

    public void addCard() {

    }

    public void start() {
        OCG_StartDuel(duel);
    }
    public DuelStatus process() {
        int status = OCG_DuelProcess(duel);
        for (var statusEnum : DuelStatus.values()) {
            if (status == statusEnum.value) {
                return statusEnum;
            }
        }

        throw new IllegalStateException("Unexpected duel status: " + status);
    }

    public static Builder builder(CardReader cardReader, ScriptReader scriptReader) {
        return new Builder(cardReader, scriptReader);
    }

    public static final class Builder {
        private long[] seed = null;
        private Player team1 = new Player();
        private Player team2 = new Player();
        private final CardReader cardReader;
        private final ScriptReader scriptReader;

        private Builder(CardReader cardReader, ScriptReader scriptReader) {
            this.cardReader = Objects.requireNonNull(cardReader);
            this.scriptReader = Objects.requireNonNull(scriptReader);
        }

        public Builder seed(long[] seed) {
            if (seed.length != 4) {
                throw new IllegalArgumentException("Seed must be exactly 4 longs. Got " + seed.length);
            }
            this.seed = seed;
            return this;
        }

        public Builder team1(Player player) {
            this.team1 = Objects.requireNonNull(player);
            return this;
        }

        public Builder team2(Player player) {
            this.team2 = Objects.requireNonNull(player);
            return this;
        }

        public Duel build() {
            return new Duel(this);
        }
    }

    @Override
    public void close() {
        OCG_DestroyDuel(duel);
        arena.close();
    }

    public static void main(String[] args) {
        var d = Duel.builder(
                code -> new CardData(code),
                name -> java.util.Optional.empty()
        ).build();
        d.start();

        while (d.process() != DuelStatus.AWAITING) {
            System.out.println(d.getMessages().stream().map(RawMessage::parse)
                    .toList());;
        }
    }

    List<RawMessage> getMessages() {
        var messages = new ArrayList<RawMessage>();
        try (var innerArena = Arena.ofConfined()) {
            var lengthPtr = innerArena.allocate(C_INT);
            var msgBuffer = OCG_DuelGetMessage(duel, lengthPtr);
            var length = lengthPtr.get(C_INT, 0);
            if (length == 0){
                return Collections.unmodifiableList(messages);
            }
            msgBuffer = msgBuffer.reinterpret(length);

            byte[] bytes = msgBuffer.toArray(C_CHAR);

            var buffer = ByteBuffer.wrap(bytes)
                    .order(ByteOrder.LITTLE_ENDIAN);

            int totalLength = bytes.length;
            int lengthSoFar = 0;

            while (lengthSoFar < totalLength) {
                int size = buffer.getInt();
                lengthSoFar += 4;
                byte[] bs = new byte[size];
                for (int i = 0; i < size; i++) {
                    bs[i] = buffer.get();
                    lengthSoFar++;
                }

                messages.add(new RawMessage(bs));
            }
        }
        return Collections.unmodifiableList(messages);
    }


    @Override
    public String toString() {
        return "Duel[" + duel + "]";
    }
}
