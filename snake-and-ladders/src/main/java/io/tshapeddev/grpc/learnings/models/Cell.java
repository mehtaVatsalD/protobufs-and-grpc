package io.tshapeddev.grpc.learnings.models;

import lombok.*;

@Getter
public class Cell {

    private final int value;
    @Setter
    private PositionShifter positionShifter;

    public Cell(int value) {
        this.value = value;
    }
}
