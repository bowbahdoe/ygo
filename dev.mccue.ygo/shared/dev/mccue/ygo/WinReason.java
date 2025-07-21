package dev.mccue.ygo;

public enum WinReason {
    SURRENDERED(0x0, "Surrendered"),
    LP_REACHED_0(0x1, "LP reached 0"),
    CARDS_CANT_BE_DRAWN(0x2, "Cards can't be drawn"),
    TIME_LIMIT_UP(0x3, "Time limit up"),
    LOST_CONNECTION(0x4, "Lost connection"),
    EXODIA_THE_FORBIDDEN_ONE(0x10, "Victory by the effect of \"Exodia the Forbidden One\""),
    FINAL_COUNTDOWN(0x11, "Victory by the effect of \"Final Countdown\""),
    Vennominaga_the_Deity_of_Poisonous_Snakes(0x12, "Victory by the effect of \"Vennominaga the Deity of Poisonous Snakes\"");
    // #Victory Reasons
    //!victory 0x0 Surrendered
    //!victory 0x1 LP reached 0
    //!victory 0x2 Cards can't be drawn
    //!victory 0x3 Time limit up
    //!victory 0x4 Lost connection
    //!victory 0x10 Victory by the effect of "Exodia the Forbidden One"
    //!victory 0x11 Victory by the effect of "Final Countdown"
    //!victory 0x12 Victory by the effect of "Vennominaga the Deity of Poisonous Snakes"
    //!victory 0x13 Victory by the effect of "Holactie the Creator of Light"
    //!victory 0x14 Victory by the effect of "Exodius the Ultimate Forbidden Lord"
    //!victory 0x15 Victory by the effect of "Destiny Board"
    //!victory 0x16 Victory by the effect of "Last Turn"
    //!victory 0x17 Victory by the effect of "Number 88: Gimmick Puppet of Leo"
    //!victory 0x18 Victory by the effect of "Number C88: Gimmick Puppet Disaster Leo"
    //!victory 0x19 Victory by the effect of "Jackpot 7"
    //!victory 0x1a Victory by the effect of "Relay Soul"
    //!victory 0x1b Victory by the effect of "Ghostrick Angel of Mischief"
    //!victory 0x1c Victory by the effect of "Phantasm Spiral Assault"
    //!victory 0x1d Victory by the effect of "F.A. Winners"
    //!victory 0x1e Victory by the effect of "Flying Elephant"
    //!victory 0x1f Victory by the effect of "Exodia, the Legendary Defender"
    //!victory 0x20 Match Victory by the effect of 「%ls」
    //!victory 0x21 Victory by the effect of "True Exodia"
    //!victory 0x30 Victory by the effect of "Creator of Miracles"
    //!victory 0x51 Victory by the effect of "Evil 1"
    //!victory 0x52 Victory by the effect of "Number iC1000: Numerounius Numerounia"
    //!victory 0x53 Victory by the effect of "Zero Gate of the Void"
    //!victory 0x54 Victory by the effect of "Deuce"
    //!victory 0x55 Victory by the rules of Action Field
    //!victory 0x56 Victory by the rules of Deck Masters
    //!victory 0x57 Victory by the effect of "Draw of Fate"
    //!victory 0x58 Victory by the effect of "Musical Sumo Dice Games"
    //!victory 0x59 Victory by the effect of "Summer Schoolwork Successful!"

    final int value;
    final String text;

    WinReason(int value, String text) {
        this.value = value;
        this.text = text;
    }
}
