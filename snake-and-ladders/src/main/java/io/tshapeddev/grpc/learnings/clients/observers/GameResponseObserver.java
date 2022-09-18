package io.tshapeddev.grpc.learnings.clients.observers;

import io.grpc.stub.StreamObserver;
import io.tshapeddev.grpc.learnings.generated.AddPositionShifterResponse;

import java.util.concurrent.CountDownLatch;

public class GameResponseObserver implements StreamObserver<AddPositionShifterResponse> {

    private final CountDownLatch countDownLatch;

    public GameResponseObserver(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void onNext(AddPositionShifterResponse addPositionShifterResponse) {
        System.out.println(addPositionShifterResponse);
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println(throwable.getMessage());
        countDownLatch.countDown();
    }

    @Override
    public void onCompleted() {
        System.out.println("Added all snakes and ladders");
        countDownLatch.countDown();
    }
}
