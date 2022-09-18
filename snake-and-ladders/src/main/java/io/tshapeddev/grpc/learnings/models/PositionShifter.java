package io.tshapeddev.grpc.learnings.models;

import io.tshapeddev.grpc.learnings.enums.PositionShifterType;
import lombok.NonNull;

public interface PositionShifter {

    Cell getNewPosition(@NonNull Cell currentCell);
    void addCells(@NonNull Cell startingCell, @NonNull Cell endCell);
    PositionShifterType getPositionShifterType();
    Cell from();
    Cell to();

}
