package io.tshapeddev.grpc.learnings.models;

import io.tshapeddev.grpc.learnings.enums.GameStatus;
import io.tshapeddev.grpc.learnings.enums.PositionShifterType;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Log
@Getter
public class Game {

    private final int id;
    private final Board board;
    private final List<GameToken> gameTokens;
    private final Dice dice;
    private GameStatus gameStatus;
    private int turnIndex;
    private GameToken winner;

    public Game(int id) {
        this.id = id;
        this.board = new Board();
        this.dice = new Dice();
        this.gameStatus = GameStatus.CREATED;
        this.gameTokens = new ArrayList<>();
        this.turnIndex = 0;
    }

    public void addPlayerToGame(@NonNull Player player, @NonNull String tokenColorHash) {
        GameToken gameToken = GameToken.builder()
                .player(player)
                .tokenColorHash(tokenColorHash)
                .currentCell(board.getCellAtPosition(1))
                .build();
        gameTokens.add(gameToken);
    }

    public TakeTurnOutcome takeTurnIfPossible() {
        checkIfPossibleToTakeTurn();
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        GameToken currentGameToken = gameTokens.get(turnIndex);
        TakeTurnOutcome takeTurnOutcome = takeTurn(currentGameToken);
        changeTurn();
        checkForGameCompletion(currentGameToken);
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return takeTurnOutcome;
    }

    private TakeTurnOutcome takeTurn(GameToken currentGameToken) {
        Player currentPlayer = currentGameToken.getPlayer();
        log.info("Current turn: " + currentPlayer.getName());
        int outcomeOfDiceRoll = dice.roll();
        log.info("Dice roll outcome: " + outcomeOfDiceRoll);
        return shiftPosition(currentGameToken, outcomeOfDiceRoll);
    }

    private TakeTurnOutcome shiftPosition(GameToken currentGameToken, int outcomeOfDiceRoll) {
        int currentCellValue = currentGameToken.getCurrentCell().getValue();
        log.info("Current position of player: " + currentCellValue);
        TakeTurnOutcome.TakeTurnOutcomeBuilder takeTurnOutcomeBuilder = TakeTurnOutcome.builder()
                .playerTokenWhoTookTurn(currentGameToken)
                .diceOutCome(outcomeOfDiceRoll)
                .oldPlace(currentCellValue);
        if (board.isPossibleShiftPlayer(currentCellValue, outcomeOfDiceRoll)) {
            Cell newCell = board.getCellAtPosition(currentCellValue + outcomeOfDiceRoll);
            log.info("New possible position of player: " + newCell.getValue());
            Cell finalNewCell = handlePositionShifterIfPresent(newCell);
            currentGameToken.setCurrentCell(finalNewCell);
            takeTurnOutcomeBuilder.newPlace(newCell.getValue())
                    .finalNewPlace(finalNewCell.getValue())
                    .positionShifterWhichAffectedMove(finalNewCell.getPositionShifter());
        } else {
            takeTurnOutcomeBuilder.newPlace(currentCellValue)
                    .finalNewPlace(currentCellValue);
            log.info("Not possible to move as there not enough cells ahead");
        }
        return takeTurnOutcomeBuilder.build();
    }

    private Cell handlePositionShifterIfPresent(Cell newCell) {
        log.info("Position shifter present: " + (newCell.getPositionShifter() == null ? "None" : newCell.getPositionShifter().getPositionShifterType()));
        Cell finalNewCell = newCell.getPositionShifter() == null ? newCell : newCell.getPositionShifter().getNewPosition(newCell);
        log.info("FINAL new possible position of player: " + finalNewCell.getValue());
        return finalNewCell;
    }

    private void checkForGameCompletion(GameToken gameToken) {
        if (board.isFinalPosition(gameToken.getCurrentCell().getValue())) {
            gameStatus = GameStatus.COMPLETED;
            winner = gameToken;
            log.info("GAME COMPLETED!!");
            log.info("Winner: " + winner.getPlayer().getName());
        }
    }

    private void checkIfPossibleToTakeTurn() {
        if (gameStatus != GameStatus.RUNNING) {
            throw new IllegalStateException("Game is not running! Hence not possible to take turns. Either game is either not begun, aborted or already completed.");
        }
    }

    public void addPositionShifter(int from, int to, @NonNull PositionShifterType positionShifterType) {
        Cell startingCell = board.getCellAtPosition(from);
        Cell endingCell = board.getCellAtPosition(to);
        PositionShifter positionShifter = getPositionShifterByType(positionShifterType);
        startingCell.setPositionShifter(positionShifter);
        endingCell.setPositionShifter(positionShifter);
        positionShifter.addCells(startingCell, endingCell);
    }

    private PositionShifter getPositionShifterByType(PositionShifterType positionShifterType) {
        return positionShifterType == PositionShifterType.SNAKE
            ? new Snake()
            : new Ladder();
    }

    public void startGame() {
        if (gameTokens.size() < 2) {
            throw new IllegalStateException("At least add two players to start the game");
        }
        gameStatus = GameStatus.RUNNING;
    }

    public void abortGame() {
        gameStatus = GameStatus.ABORTED;
    }

    public GameToken whoseTurnIsItNext() {
        return gameTokens.get(turnIndex);
    }

    private void changeTurn() {
        turnIndex = (turnIndex + 1)%gameTokens.size();
    }

}
