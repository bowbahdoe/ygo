package dev.mccue.ygo;

import static dev.mccue.ygo.bindings.yugioh_h.*;

public enum Attribute {
    // /* Attributes */
    //#define ATTRIBUTE_EARTH  0x01
    //#define ATTRIBUTE_WATER  0x02
    //#define ATTRIBUTE_FIRE   0x04
    //#define ATTRIBUTE_WIND   0x08
    //#define ATTRIBUTE_LIGHT  0x10
    //#define ATTRIBUTE_DARK   0x20
    //#define ATTRIBUTE_DIVINE 0x40
    EARTH(ATTRIBUTE_EARTH()),
    WATER(ATTRIBUTE_WATER()),
    FIRE(ATTRIBUTE_FIRE()),
    WIND(ATTRIBUTE_WIND()),
    LIGHT(ATTRIBUTE_LIGHT()),
    DARK(ATTRIBUTE_DARK()),
    DIVINE(ATTRIBUTE_DIVINE());
    
    final int value;
    
    Attribute(int value) {
        this.value = value;
    }
}
