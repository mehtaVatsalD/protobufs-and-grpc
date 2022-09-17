package io.tshapeddev.grpc.learnings.models;

import lombok.NonNull;

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

    public void addPositionShifter(int from, int to, @NonNull PositionShifter positionShifter) {
        Cell startingCell = getCellAtPosition(from);
        Cell endingCell = getCellAtPosition(to);
        startingCell.setPositionShifter(positionShifter);
        endingCell.setPositionShifter(positionShifter);
        positionShifter.addCells(startingCell, endingCell);
    }

    public void resetBord() {
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

}
