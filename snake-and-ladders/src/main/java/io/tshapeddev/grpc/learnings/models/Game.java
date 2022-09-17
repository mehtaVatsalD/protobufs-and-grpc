package io.tshapeddev.grpc.learnings.models;

import io.tshapeddev.grpc.learnings.enums.GameStatus;
import lombok.NonNull;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log
public class Game {

    private final Board board;
    private final List<GameToken> gameTokens;
    private final Dice dice;
    private GameStatus gameStatus;
    private int turnIndex;
    private GameToken winner;

    public Game() {
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
                .currentCell(board.getCellAtPosition(0))
                .build();
        gameTokens.add(gameToken);
    }

    public void takeTurnIfPossible() {
        checkIfPossibleToTakeTurn();
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        GameToken currentGameToken = gameTokens.get(turnIndex);
        takeTurn(currentGameToken);
        checkForGameCompletion(currentGameToken);
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private void takeTurn(GameToken currentGameToken) {
        Player currentPlayer = currentGameToken.getPlayer();
        log.info("Current turn: " + currentPlayer.getName());
        int outcomeOfDiceRoll = dice.roll();
        log.info("Dice roll outcome: " + outcomeOfDiceRoll);
        shiftPosition(currentGameToken, outcomeOfDiceRoll);
    }

    private void shiftPosition(GameToken currentGameToken, int outcomeOfDiceRoll) {
        int currentCellValue = currentGameToken.getCurrentCell().getValue();
        log.info("Current position of player: " + currentCellValue);
        if (board.isPossibleShiftPlayer(currentCellValue, outcomeOfDiceRoll)) {
            Cell newCell = board.getCellAtPosition(currentCellValue + outcomeOfDiceRoll);
            log.info("New possible position of player: " + newCell.getValue());
            Cell finalNewCell = handlePositionShifterIfPresent(newCell);
            currentGameToken.setCurrentCell(finalNewCell);
        } else {
            log.info("Not possible to move as there not enough cells ahead");
        }
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

    public void startGame() {
        gameStatus = GameStatus.RUNNING;
    }

    public void abortGame() {
        gameStatus = GameStatus.ABORTED;
    }

    public GameToken whoseTurnIsItNext() {
        return gameTokens.get(turnIndex);
    }

    public int whatsOnTopOfDice() {
        return dice.getTop();
    }

    public Optional<GameToken> whoWon() {
        return winner == null ? Optional.empty() : Optional.of(winner);
    }

    private void changeTurn() {
        turnIndex = (turnIndex + 1)%gameTokens.size();
    }

}
