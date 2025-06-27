package dev.mccue.ygo;

import dev.mccue.ygo.bindings.OCG_NewCardInfo;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

public record NewCardInfo(
        Team team,
        byte duelist,
        CardCode code,
        byte con,
        Location loc,
        int seq,
        int pos
) {
    // typedef struct OCG_NewCardInfo {
    //	uint8_t team; /* either 0 or 1 */
    //	uint8_t duelist; /* index of original owner */
    //	uint32_t code;
    //	uint8_t con;
    //	uint32_t loc;
    //	uint32_t seq;
    //	uint32_t pos;
    //}OCG_NewCardInfo;

    MemorySegment allocate(Arena arena) {
        var segment = OCG_NewCardInfo.allocate(arena);
        OCG_NewCardInfo.team(segment, team.value);
        OCG_NewCardInfo.duelist(segment, duelist);
        OCG_NewCardInfo.code(segment, code.value());
        OCG_NewCardInfo.con(segment, con);
        OCG_NewCardInfo.loc(segment, loc.value);
        OCG_NewCardInfo.seq(segment, seq);
        OCG_NewCardInfo.pos(segment, pos);
        return segment;
    }
}
