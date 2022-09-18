package io.tshapeddev.grpc.learnings.models;

import io.tshapeddev.grpc.learnings.enums.PositionShifterType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ladder implements PositionShifter {

    private final PositionShifterType positionShifterType = PositionShifterType.LADDER;
    private Cell base;
    private Cell tip;

    @Override
    public Cell getNewPosition(@NonNull Cell currentCell) {
        if (base.getValue() == currentCell.getValue()) {
            return tip;
        }
        return currentCell;
    }

    @Override
    public PositionShifterType getPositionShifterType() {
        return positionShifterType;
    }

    @Override
    public void addCells(@NonNull Cell startingCell, @NonNull Cell endCell) {
        this.base = startingCell;
        this.tip = endCell;
    }

    @Override
    public Cell from() {
        return base;
    }

    @Override
    public Cell to() {
        return tip;
    }

    @Override
    public String toString() {
        return "Ladder(" + base.getValue() + "->" + tip.getValue() + ")";
    }
}
