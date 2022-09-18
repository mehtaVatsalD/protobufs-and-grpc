package io.tshapeddev.grpc.learnings.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Cell> cells;
    private static final int NUMBER_OF_CELLS = 100;

    public Board() {
        this.cells = new ArrayList<>();
        resetBord();
    }

    private void validatePosition(int position) {
        if (position <= 0 || position > NUMBER_OF_CELLS) {
            throw new IllegalArgumentException(String.format("position value to query for cell must be between 1 and %s (both inclusive)", NUMBER_OF_CELLS));
        }
    }

    public Cell getCellAtPosition(int position) {
        validatePosition(position);
        return cells.get(position-1);
    }

    private void resetBord() {
        cells.clear();
        for (int i=0; i<NUMBER_OF_CELLS; i++) {
            cells.add(new Cell(i+1));
        }
    }

    public boolean isPossibleShiftPlayer(int currentPosition, int hops) {
        validatePosition(currentPosition);
        return currentPosition + hops <= NUMBER_OF_CELLS;
    }

    public boolean isFinalPosition(int currentPosition) {
        validatePosition(currentPosition);
        return currentPosition == NUMBER_OF_CELLS;
    }

    @Override
    public String toString() {
        return cells.toString();
    }
}
