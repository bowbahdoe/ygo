package dev.mccue.ygo.message;

public record CardHintMessage(
        LocInfo locInfo,
        byte hintDesc,
        long desc
) implements Message {

    public record LocInfo(
            byte controller,
            byte location,
            int sequence,
            int position
    ) {}
    // struct loc_info {
    //	uint8_t controler;
    //	uint8_t location;
    //	uint32_t sequence;
    //	uint32_t position;
    //};

    // 		auto message = pduel->new_message(MSG_CARD_HINT);
    //		message->write(get_info_location());
    //		message->write<uint8_t>(CHINT_DESC_ADD);
    //		message->write<uint64_t>(peffect->description);
    //	}
}
