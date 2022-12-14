package io.simplecoder.grpc.client;

import io.grpc.stub.StreamObserver;
import io.simplecoder.grpc.generated.protobufs.AreNumbersPrimeRequestChunk;
import io.simplecoder.grpc.generated.protobufs.PrimeNumbersServiceGrpc;
import io.simplecoder.grpc.observers.response.AreNumbersPrimeAsyncResponseObserver;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import static io.simplecoder.grpc.utils.ChannelUtil.getManagedChannel;

public class AreNumbersPrimeBiDirectionalStreamingClient {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Have to use non blocking stub only!");
        PrimeNumbersServiceGrpc.PrimeNumbersServiceStub stub = PrimeNumbersServiceGrpc.newStub(getManagedChannel());

        CountDownLatch countDownLatch = new CountDownLatch(1);
        StreamObserver<AreNumbersPrimeRequestChunk> areNumbersPrimeRequestObserver = stub.areNumbersPrimeAsync(new AreNumbersPrimeAsyncResponseObserver(countDownLatch));
        for (int i=0; i<15; i++) {
            int randomVal;
            Random random = new Random();
            do {
                randomVal = random.nextInt();
            } while (randomVal <= 0);
            System.out.println("Is " + randomVal + " prime?");
            areNumbersPrimeRequestObserver.onNext(
                    AreNumbersPrimeRequestChunk.newBuilder()
                            .setNumber(randomVal)
                            .build()
            );
            Thread.sleep(500);
        }
        areNumbersPrimeRequestObserver.onCompleted();
        System.out.println("Sent all!!");
        countDownLatch.await();

    }

}
