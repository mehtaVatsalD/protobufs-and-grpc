package io.tshapeddev.grpc.learnings.clients;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.tshapeddev.grpc.learnings.clients.observers.GameResponseObserver;
import io.tshapeddev.grpc.learnings.generated.AddPositionShifterRequest;
import io.tshapeddev.grpc.learnings.generated.GameServiceGrpc;
import io.tshapeddev.grpc.learnings.generated.PositionShifter;
import io.tshapeddev.grpc.learnings.generated.PositionShifterType;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class AddSnakeAndLadderClient {

    private static final Map<Integer, Integer> snakesMap = new HashMap<>();
    private static final Map<Integer, Integer> ladderMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8888)
                .usePlaintext()
                .build();
        GameServiceGrpc.GameServiceStub stub = GameServiceGrpc.newStub(managedChannel);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        StreamObserver<AddPositionShifterRequest> addPositionShifterRequestStreamObserver = stub.addPositionShifters(new GameResponseObserver(countDownLatch));
        populateHardCodedSnakesMap();
        populateHardCodedLaddersMap();
        addAllStaticSnakesAndLadders(addPositionShifterRequestStreamObserver, snakesMap, PositionShifterType.SNAKE);
        addAllStaticSnakesAndLadders(addPositionShifterRequestStreamObserver, ladderMap, PositionShifterType.LADDER);
        addPositionShifterRequestStreamObserver.onCompleted();
        countDownLatch.await();

    }

    private static void populateHardCodedSnakesMap() {
        snakesMap.put(49, 11);
        snakesMap.put(47, 26);
        snakesMap.put(61, 19);
        snakesMap.put(58, 41);
        snakesMap.put(86, 24);
        snakesMap.put(95, 75);
        snakesMap.put(93, 73);
        snakesMap.put(98, 78);
    }

    private static void populateHardCodedLaddersMap() {
        ladderMap.put(4, 14);
        ladderMap.put(9, 31);
        ladderMap.put(20, 37);
        ladderMap.put(21, 42);
        ladderMap.put(28, 84);
        ladderMap.put(36, 57);
        ladderMap.put(51, 73);
        ladderMap.put(71, 92);
        ladderMap.put(80, 99);
    }

    private static void addAllStaticSnakesAndLadders(StreamObserver<AddPositionShifterRequest> addPositionShifterRequestStreamObserver, Map<Integer, Integer> positionShifterMap, PositionShifterType positionShifterType) {
        positionShifterMap.forEach((start, end) -> {
            addPositionShifterRequestStreamObserver.onNext(
                    AddPositionShifterRequest.newBuilder().setPositionShifter(
                            PositionShifter.newBuilder()
                                    .setPositionShifterType(positionShifterType)
                                    .setStart(start)
                                    .setEnd(end)
                                    .build()
                    )
                            .setGameId(10).build()
            );
        });

    }
}
