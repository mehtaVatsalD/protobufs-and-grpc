package io.simplecoder.grpc.client;

import io.grpc.Deadline;
import io.simplecoder.grpc.generated.protobufs.FirstNPrimeNumbersRequest;
import io.simplecoder.grpc.generated.protobufs.PrimeNumbersServiceGrpc;
import io.simplecoder.grpc.observers.response.FirstNPrimeNumbersResponseObserver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static io.simplecoder.grpc.utils.ChannelUtil.getManagedChannel;

public class FirstNPrimeNumbersClientForServerStreaming {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Using blocking stub");
        PrimeNumbersServiceGrpc.PrimeNumbersServiceBlockingStub blockingStub = PrimeNumbersServiceGrpc.newBlockingStub(getManagedChannel());
        FirstNPrimeNumbersRequest firstNPrimeNumbersRequest = FirstNPrimeNumbersRequest.newBuilder()
                .setN(10)
                .build();
        blockingStub
                .withDeadline(Deadline.after(4, TimeUnit.SECONDS))
                .getFirstNPrimeNumbers(firstNPrimeNumbersRequest)
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
