package io.tshapeddev.grpc.learnings.services;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import io.tshapeddev.grpc.learnings.generated.*;
import io.tshapeddev.grpc.learnings.mappers.GamerMapper;
import io.tshapeddev.grpc.learnings.models.Game;
import io.tshapeddev.grpc.learnings.models.Player;
import io.tshapeddev.grpc.learnings.models.TakeTurnOutcome;
import io.tshapeddev.grpc.learnings.repository.Repository;
import io.tshapeddev.grpc.learnings.repository.impl.GameRepositoryMapBasedImpl;
import io.tshapeddev.grpc.learnings.services.observers.AddPositionShifterRequestObserver;

public class GameService extends io.tshapeddev.grpc.learnings.generated.GameServiceGrpc.GameServiceImplBase {

    private final Repository<Game> gameRepository;

    public GameService() {
        this.gameRepository = GameRepositoryMapBasedImpl.getInstance();
    }

    @Override
    public void createNewGame(CreateNewGameRequest request, StreamObserver<GameResponse> responseObserver) {
        Game game = new Game(request.getId());
        gameRepository.save(game);
        responseObserver.onNext(GamerMapper.mapToGameResponse(game));
        responseObserver.onCompleted();
    }

    @Override
    public void getGame(GetGameRequest request, StreamObserver<GameResponse> responseObserver) {
        throwErrorIfGameNotPresent(request.getId(), responseObserver);
        responseObserver.onNext(GamerMapper.mapToGameResponse(gameRepository.getById(request.getId())));
        responseObserver.onCompleted();    }

    @Override
    public void addPlayersToGame(io.tshapeddev.grpc.learnings.generated.AddPlayersRequest request, StreamObserver<GameResponse> responseObserver) {
        throwErrorIfGameNotPresent(request.getGameId(), responseObserver);
        Game game = gameRepository.getById(request.getGameId());
        request.getGameTokensList()
                .forEach(gameToken -> game.addPlayerToGame(Player.builder().name(gameToken.getPlayerName()).build(), gameToken.getTokenColorHash()));
        responseObserver.onNext(GamerMapper.mapToGameResponse(game));
        responseObserver.onCompleted();
    }

    @Override
    public void startGame(StartGameRequest request, StreamObserver<GameResponse> responseObserver) {
        throwErrorIfGameNotPresent(request.getGameId(), responseObserver);
        Game game = gameRepository.getById(request.getGameId());
        game.startGame();
        responseObserver.onNext(GamerMapper.mapToGameResponse(game));
        responseObserver.onCompleted();
    }

    @Override
    public void abortGame(AbortGameRequest request, StreamObserver<GameResponse> responseObserver) {
        throwErrorIfGameNotPresent(request.getGameId(), responseObserver);
        Game game = gameRepository.getById(request.getGameId());
        game.abortGame();
        responseObserver.onNext(GamerMapper.mapToGameResponse(game));
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<AddPositionShifterRequest> addPositionShifters(StreamObserver<AddPositionShifterResponse> responseObserver) {
        return new AddPositionShifterRequestObserver(gameRepository, responseObserver, this::throwErrorIfGameNotPresent);
    }

    @Override
    public void takeTurn(TakeTurnRequest request, StreamObserver<TakeTurnGameResponse> responseObserver) {
        throwErrorIfGameNotPresent(request.getGameId(), responseObserver);
        Game game = gameRepository.getById(request.getGameId());
        TakeTurnOutcome takeTurnOutcome = game.takeTurnIfPossible();
        TakeTurnGameResponse takeTurnGameResponse =
                TakeTurnGameResponse.newBuilder()
                        .setTakeTurnOutcome(GamerMapper.mapToTakeTurnOutcome(takeTurnOutcome))
                        .setGameResponse(GamerMapper.mapToGameResponse(game))
                        .build();
        responseObserver.onNext(takeTurnGameResponse);
        responseObserver.onCompleted();
    }

    private void throwErrorIfGameNotPresent(int gameId, StreamObserver<?> responseObserver) {
        if (!gameRepository.isPresent(gameId)) {
            responseObserver.onError(Status.FAILED_PRECONDITION.withDescription("game with id " + gameId + " does not exist").asRuntimeException());
            throw new IllegalArgumentException("game with id " + gameId + " does not exist");
        }
    }

}
