package io.simplecoder.grpc.observers.response;

import io.grpc.stub.StreamObserver;
import io.simplecoder.grpc.generated.protobufs.AreNumbersPrimeModel;
import io.simplecoder.grpc.generated.protobufs.AreNumbersPrimeResponse;

import java.util.concurrent.CountDownLatch;

public class AreNumbersPrimeResponseObserver implements StreamObserver<AreNumbersPrimeResponse> {

    private final CountDownLatch countDownLatch;

    public AreNumbersPrimeResponseObserver(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void onNext(AreNumbersPrimeResponse areNumbersPrimeResponse) {
        for (AreNumbersPrimeModel areNumbersPrimeModel: areNumbersPrimeResponse.getResponseList()) {
            System.out.println("Number: " + areNumbersPrimeModel.getNumber());
            System.out.println("IsPrime: " + areNumbersPrimeModel.getIsPrime());
            System.out.println();
        }
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
