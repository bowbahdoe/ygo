package dev.mccue.ygo;

import static dev.mccue.ygo.bindings.yugioh_h.*;


public enum Location {
    DECK(LOCATION_DECK()),
    HAND(LOCATION_HAND()),
    MZONE(LOCATION_MZONE()),
    SZONE(LOCATION_SZONE()),
    GRAVE(LOCATION_GRAVE()),
    REMOVED(LOCATION_REMOVED()),
    EXTRA(LOCATION_EXTRA()),
    OVERLAY(LOCATION_OVERLAY()),
    ONFIELD(LOCATION_ONFIELD()),
   /*  FZONE(LOCATION_FZONE()),
    PZONE(LOCATION_PZONE()),
    STZONE(LOCATION_STZONE()),
    MMZONE(LOCATION_MMZONE()),
    EMZONE(LOCATION_EMZONE()),
    DECKBOT(LOCATION_DECKBOT()),
    DECKSHF(LOCATION_DECKSHF())*/;

    final int value;

    Location(int value) {
        this.value = value;
    }
}
