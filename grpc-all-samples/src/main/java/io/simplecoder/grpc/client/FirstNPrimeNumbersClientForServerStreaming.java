package io.simplecoder.grpc.client;

import io.simplecoder.grpc.generated.protobufs.models.*;
import io.simplecoder.grpc.observers.response.FirstNPrimeNumbersResponseObserver;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

import static io.simplecoder.grpc.utils.ChannelUtil.getManagedChannel;

public class FirstNPrimeNumbersClientForServerStreaming {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Using blocking stub");
        PrimeNumbersServiceGrpc.PrimeNumbersServiceBlockingStub blockingStub = PrimeNumbersServiceGrpc.newBlockingStub(getManagedChannel());
        FirstNPrimeNumbersRequest firstNPrimeNumbersRequest = FirstNPrimeNumbersRequest.newBuilder()
                .setN(10)
                .build();
        blockingStub.getFirstNPrimeNumbers(firstNPrimeNumbersRequest)
                .forEachRemaining(System.out::println);
        System.out.println("Done!!!");

        System.out.println("Using non blocking stub now");
        PrimeNumbersServiceGrpc.PrimeNumbersServiceStub stub = PrimeNumbersServiceGrpc.newStub(getManagedChannel());
        CountDownLatch countDownLatch = new CountDownLatch(1);
        stub.getFirstNPrimeNumbers(firstNPrimeNumbersRequest, new FirstNPrimeNumbersResponseObserver(countDownLatch));
        System.out.println("Might be not yet done [that's what she said] but still printed. Power of non blocking!!");
        countDownLatch.await();

    }

}
