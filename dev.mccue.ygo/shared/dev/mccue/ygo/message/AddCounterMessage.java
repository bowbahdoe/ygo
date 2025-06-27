package dev.mccue.ygo.message;

public record AddCounterMessage(
        short cttype,
        byte controller,
        byte location,
        byte sequence,
        short pcount
) implements Message {
    // 	message->write<uint16_t>(cttype);
    //	message->write<uint8_t>(current.controler);
    //	message->write<uint8_t>(current.location);
    //	message->write<uint8_t>(current.sequence);
    //	message->write<uint16_t>(pcount);
}
