package dev.mccue.ygo;

public record CardData(
        CardCode code,
        int alias,
        short[] setcodes,
        int type,
        int level,
        int attribute,
        long race,
        int attack,
        int defense,
        int lscale,
        int rscale,
        int link_marker
) {
    public CardData(CardCode code) {
        this(code, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }
}
