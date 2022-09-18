package io.tshapeddev.grpc.learnings.mappers;

import io.tshapeddev.grpc.learnings.generated.*;
import io.tshapeddev.grpc.learnings.models.Game;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GamerMapper {

    public static GameResponse mapToGameResponse(Game game) {
        GameResponse.Builder builder = GameResponse.newBuilder()
                .setId(game.getId())
                .setGameStatus(GameStatus.valueOf(game.getGameStatus().toString()))
                .setBoardDisplay(game.getBoard().toString())
                .addAllGameTokens(game.getGameTokens().stream().map(GamerMapper::mapToGameToken).collect(Collectors.toList()));
        if (game.getWinner() != null) {
            builder = builder.setWinner(mapToGameToken(game.getWinner()));
        }
        return builder.build();
    }

    public static GameToken mapToGameToken(io.tshapeddev.grpc.learnings.models.GameToken gameToken) {
        if (gameToken == null) {
            return null;
        }
        return GameToken.newBuilder()
                .setPlayerName(gameToken.getPlayer().getName())
                .setTokenColorHash(gameToken.getTokenColorHash())
                .setCurrentCell(gameToken.getCurrentCell().getValue())
                .build();
    }

    public static TakeTurnOutcome mapToTakeTurnOutcome(io.tshapeddev.grpc.learnings.models.TakeTurnOutcome takeTurnOutcome) {
        TakeTurnOutcome.Builder builder = TakeTurnOutcome.newBuilder()
                .setDiceOutcome(takeTurnOutcome.getDiceOutCome())
                .setFinalNewPlace(takeTurnOutcome.getFinalNewPlace())
                .setNewPlace(takeTurnOutcome.getNewPlace())
                .setOldPlace(takeTurnOutcome.getOldPlace())
                .setPlayerWhoTookTurn(takeTurnOutcome.getPlayerTokenWhoTookTurn().getPlayer().getName());

        if (takeTurnOutcome.getPositionShifterWhichAffectedMove() != null) {
            builder = builder
                    .setPositionShifterAffectingMove(
                            PositionShifter.newBuilder()
                                    .setStart(takeTurnOutcome.getPositionShifterWhichAffectedMove().from().getValue())
                                    .setEnd(takeTurnOutcome.getPositionShifterWhichAffectedMove().to().getValue())
                                    .setPositionShifterTypeValue(takeTurnOutcome.getPositionShifterWhichAffectedMove().getPositionShifterType().ordinal())
                                    .build()
                    );
        }
        return builder.build();
    }

}
