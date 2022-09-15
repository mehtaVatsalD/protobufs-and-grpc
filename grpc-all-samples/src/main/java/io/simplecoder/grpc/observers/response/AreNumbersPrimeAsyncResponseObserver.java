package io.simplecoder.grpc.observers.response;

import io.grpc.stub.StreamObserver;
import io.simplecoder.grpc.generated.protobufs.AreNumbersPrimeModel;

import java.util.concurrent.CountDownLatch;

public class AreNumbersPrimeAsyncResponseObserver implements StreamObserver<AreNumbersPrimeModel> {

    private final CountDownLatch countDownLatch;

    public AreNumbersPrimeAsyncResponseObserver(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void onNext(AreNumbersPrimeModel areNumbersPrimeModel) {
        System.out.println("Number: " + areNumbersPrimeModel.getNumber());
        System.out.println("IsPrime: " + areNumbersPrimeModel.getIsPrime());
        System.out.println();
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
