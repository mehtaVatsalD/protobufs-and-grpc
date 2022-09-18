package io.tshapeddev.grpc.learnings.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TakeTurnOutcome {

    private GameToken playerTokenWhoTookTurn;
    private int diceOutCome;
    private int oldPlace;
    private int newPlace;
    private int finalNewPlace;
    private PositionShifter positionShifterWhichAffectedMove;

}
