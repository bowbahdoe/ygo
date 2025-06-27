package dev.mccue.ygo;

public record CardData(
        CardCode code,
        int alias,
        short[] setcodes,
        int type,
        int level,
        int attribute,
        long race,
        Attack attack,
        Defense defense,
        PendulumScale lscale,
        PendulumScale rscale,
        int link_marker
) {
    public CardData(CardCode code) {
        this(
                code,
                0,
                null,
                0,
                0,
                0,
                0,
                new Attack(0),
                new Defense(0),
                new PendulumScale(0),
                new PendulumScale(0),
                0
        );
    }
}
