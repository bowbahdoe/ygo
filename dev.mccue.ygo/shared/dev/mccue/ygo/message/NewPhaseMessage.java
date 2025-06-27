package dev.mccue.ygo.message;

import dev.mccue.ygo.Phase;

public record NewPhaseMessage(Phase phase)
        implements Message {
}
