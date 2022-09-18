package io.tshapeddev.grpc.learnings.models;

import io.tshapeddev.grpc.learnings.enums.PositionShifterType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Snake implements PositionShifter {

    private final PositionShifterType positionShifterType = PositionShifterType.SNAKE;
    private Cell head;
    private Cell tail;

    @Override
    public Cell getNewPosition(@NonNull Cell currentCell) {
        if (head.getValue() == currentCell.getValue()) {
            return tail;
        }
        return currentCell;
    }

    @Override
    public PositionShifterType getPositionShifterType() {
        return positionShifterType;
    }

    @Override
    public void addCells(@NonNull Cell startingCell, @NonNull Cell endCell) {
        this.head = startingCell;
        this.tail = endCell;
    }

    @Override
    public Cell from() {
        return head;
    }

    @Override
    public Cell to() {
        return tail;
    }

    @Override
    public String toString() {
        return "Snake(" + head.getValue() + "->" + tail.getValue() + ")";
    }
}
