package io.tshapeddev.grpc.learnings.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Cell {

    private final int value;
    @Setter
    private PositionShifter positionShifter;

    public Cell(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "[" + ((positionShifter == null) ? "" : positionShifter) + "]";
    }
}
