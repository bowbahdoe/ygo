package dev.mccue.ygo;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static dev.mccue.ygo.bindings.yugioh_h.*;

record RawMessage(byte[] data) {
    Message parse() {
        Message message;

        var bb = dataBB();
        var type = MessageType.fromInt(bb.get());
        if (type.value == MSG_HINT()) {
            var hint = Hint.fromInt(bb.get());
            message = new HintMessage(hint, bb.get(), bb.getLong());
        } else if (type.value == MSG_ADD_COUNTER()) {
            message = new AddCounterMessage(
                    bb.getShort(),
                    bb.get(),
                    bb.get(),
                    bb.get(),
                    bb.getShort()
            );
        } else if (type.value == MSG_NEW_TURN()) {
            message = new NewTurnMessage(bb.get());
        } else if (type.value == MSG_WIN()) {
            message = new WinMessage(
                    bb.get(),
                    bb.get()
            );
        } else if (type.value == MSG_NEW_PHASE()) {
            message = new NewPhaseMessage(bb.getShort());
        } else {
            throw new IllegalStateException("Unknown message type: " + type);
        }

        if (bb.remaining() != 0) {
            throw new IllegalStateException("Did not read all the message data");
        }

        return message;
    }

    ByteBuffer dataBB() {
        return ByteBuffer.wrap(data)
                .order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override
    public String toString() {
        return "RawMessage[" +
               "data=" + Arrays.toString(data) +
               ']';
    }
}
