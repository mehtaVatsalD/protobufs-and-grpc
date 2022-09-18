package io.tshapeddev.grpc.learnings.services.observers;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import io.tshapeddev.grpc.learnings.generated.AddPositionShifterRequest;
import io.tshapeddev.grpc.learnings.generated.AddPositionShifterResponse;
import io.tshapeddev.grpc.learnings.generated.GameResponse;
import io.tshapeddev.grpc.learnings.generated.PositionShifterType;
import io.tshapeddev.grpc.learnings.mappers.GamerMapper;
import io.tshapeddev.grpc.learnings.models.Game;
import io.tshapeddev.grpc.learnings.models.PositionShifter;
import io.tshapeddev.grpc.learnings.models.Snake;
import io.tshapeddev.grpc.learnings.repository.Repository;

import java.util.function.BiConsumer;

public class AddPositionShifterRequestObserver implements StreamObserver<AddPositionShifterRequest> {

    private final Repository<Game> gameRepository;
    private final StreamObserver<AddPositionShifterResponse> responseObserver;
    private final BiConsumer<Integer, StreamObserver<?>> validityCheckConsumer;

    public AddPositionShifterRequestObserver(Repository<Game> gameRepository, StreamObserver<AddPositionShifterResponse> responseObserver, BiConsumer<Integer, StreamObserver<?>> validityCheckConsumer) {
        this.gameRepository = gameRepository;
        this.responseObserver = responseObserver;
        this.validityCheckConsumer = validityCheckConsumer;
    }

    @Override
    public void onNext(AddPositionShifterRequest addPositionShifterRequest) {
        validityCheckConsumer.accept(addPositionShifterRequest.getGameId(), responseObserver);
        Game game = gameRepository.getById(addPositionShifterRequest.getGameId());
        game.addPositionShifter(addPositionShifterRequest.getPositionShifter().getStart(),
                addPositionShifterRequest.getPositionShifter().getEnd(),
                io.tshapeddev.grpc.learnings.enums.PositionShifterType.valueOf(
                        addPositionShifterRequest.getPositionShifter().getPositionShifterType().name()
                ));
        responseObserver.onNext(AddPositionShifterResponse.newBuilder()
                .setGameId(game.getId())
                .setBoardDisplay(game.getBoard().toString())
                .build()
        );
    }

    @Override
    public void onError(Throwable throwable) {
        responseObserver.onError(Status.INTERNAL.withDescription(throwable.getMessage()).asRuntimeException());
    }

    @Override
    public void onCompleted() {
        System.out.println("Added all position shifters");
        responseObserver.onCompleted();
    }
}
