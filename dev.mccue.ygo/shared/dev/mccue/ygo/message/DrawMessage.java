package dev.mccue.ygo.message;

import dev.mccue.ygo.CardCode;

import java.util.List;

public record DrawMessage(
        byte playerId,
        List<DrawnCard> drawnCards
) implements Message {
    public record DrawnCard(CardCode code, int position) {}
    // 			auto message = pduel->new_message(MSG_DRAW);
    //			message->write<uint8_t>(playerid);
    //			message->write<uint32_t>(drawn);
    //			for(const auto& pcard : cv) {
    //				message->write<uint32_t>(pcard->data.code);
    //				message->write<uint32_t>(pcard->current.position);
    //			}
    //			if(core.deck_reversed && (public_count < drawn)) {
    //				message = pduel->new_message(MSG_CONFIRM_CARDS);
    //				message->write<uint8_t>(1 - playerid);
    //				message->write<uint32_t>(drawn_set.size());
    //				for(auto& pcard : drawn_set) {
    //					message->write<uint32_t>(pcard->data.code);
    //					message->write<uint8_t>(pcard->current.controler);
    //					message->write<uint8_t>(pcard->current.location);
    //					message->write<uint32_t>(pcard->current.sequence);
    //				}
    //				shuffle(playerid, LOCATION_HAND);
    //			}
    //			for (auto& pcard : drawn_set) {
    //				if(pcard->owner != pcard->current.controler) {
    //					effect* deffect = pduel->new_effect();
    //					deffect->owner = pcard;
    //					deffect->code = 0;
    //					deffect->type = EFFECT_TYPE_SINGLE;
    //					deffect->flag[0] = EFFECT_FLAG_CANNOT_DISABLE | EFFECT_FLAG_CLIENT_HINT;
    //					deffect->description = 67;
    //					deffect->reset_flag = RESET_EVENT + 0x1fe0000;
    //					pcard->add_effect(deffect);
    //				}
    //				raise_single_event(pcard, nullptr, EVENT_DRAW, reason_effect, reason, reason_player, playerid, 0);
    //				raise_single_event(pcard, nullptr, EVENT_TO_HAND, reason_effect, reason, reason_player, playerid, 0);
    //				raise_single_event(pcard, nullptr, EVENT_MOVE, reason_effect, reason, reason_player, playerid, 0);
    //			}
    //			process_single_event();
    //			raise_event(drawn_set, EVENT_DRAW, reason_effect, reason, reason_player, playerid, drawn);
    //			raise_event(drawn_set, EVENT_TO_HAND, reason_effect, reason, reason_player, playerid, drawn);
    //			raise_event(drawn_set, EVENT_MOVE, reason_effect, reason, reason_player, playerid, drawn);
    //			process_instant_event();
}
