package dev.mccue.ygo;

import java.util.EnumSet;
import java.util.Set;

public record CardData(
        CardCode code,
        int alias,
        short[] setcodes,
        int type,
        int level,
        Set<Attribute> attribute,
        long race,
        Attack attack,
        Defense defense,
        PendulumScale lscale,
        PendulumScale rscale,
        Set<LinkMarker> linkMarker
) {
    public CardData(CardCode code) {
        this(
                code,
                0,
                null,
                0,
                0,
                EnumSet.noneOf(Attribute.class),
                0,
                new Attack(0),
                new Defense(0),
                new PendulumScale(0),
                new PendulumScale(0),
                EnumSet.noneOf(LinkMarker.class)
        );
    }
}
