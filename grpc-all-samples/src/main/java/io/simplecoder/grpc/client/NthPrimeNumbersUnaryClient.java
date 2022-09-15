package io.simplecoder.grpc.client;

import io.simplecoder.grpc.generated.protobufs.models.NthPrimeNumberRequest;
import io.simplecoder.grpc.generated.protobufs.models.NthPrimeNumberResponse;
import io.simplecoder.grpc.generated.protobufs.models.PrimeNumbersServiceGrpc;

import static io.simplecoder.grpc.utils.ChannelUtil.getManagedChannel;

public class NthPrimeNumbersUnaryClient {

    public static void main(String[] args) {
        PrimeNumbersServiceGrpc.PrimeNumbersServiceBlockingStub blockingStub = PrimeNumbersServiceGrpc.newBlockingStub(getManagedChannel());
        NthPrimeNumberRequest nthPrimeNumberRequest = NthPrimeNumberRequest.newBuilder()
                        .addNumbers(5)
                        .addNumbers(13)
                        .addNumbers(50)
                        .build();
        NthPrimeNumberResponse nthPrimeNumbers = blockingStub.getNthPrimeNumbers(nthPrimeNumberRequest);
        System.out.println(nthPrimeNumbers);
    }

}