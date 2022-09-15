package io.simplecoder.grpc.observers.response;

import io.grpc.stub.StreamObserver;
import io.simplecoder.grpc.generated.protobufs.models.FirstNPrimeNumbersResponseChunk;

import java.util.concurrent.CountDownLatch;

public class FirstNPrimeNumbersResponseObserver implements StreamObserver<FirstNPrimeNumbersResponseChunk> {

    private final CountDownLatch countDownLatch;

    public FirstNPrimeNumbersResponseObserver(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void onNext(FirstNPrimeNumbersResponseChunk firstNPrimeNumbersResponseStream) {
        System.out.println(firstNPrimeNumbersResponseStream);
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println(throwable.getMessage());
        countDownLatch.countDown();
    }

    @Override
    public void onCompleted() {
        System.out.println("Done!!!");
        countDownLatch.countDown();
    }
}
