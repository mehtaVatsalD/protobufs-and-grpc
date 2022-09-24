package io.simplecoder.grpc.client;

import io.grpc.Deadline;
import io.simplecoder.grpc.generated.protobufs.NthPrimeNumberRequest;
import io.simplecoder.grpc.generated.protobufs.NthPrimeNumberResponse;
import io.simplecoder.grpc.generated.protobufs.PrimeNumbersServiceGrpc;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static io.simplecoder.grpc.client.contants.ClientConstants.RPC_TYPE_CALL_OPTION_KEY;
import static io.simplecoder.grpc.utils.ChannelUtil.getManagedChannel;

public class NthPrimeNumbersUnaryClient {

    public static void main(String[] args) {
        PrimeNumbersServiceGrpc.PrimeNumbersServiceBlockingStub blockingStub = PrimeNumbersServiceGrpc.newBlockingStub(getManagedChannel());

        for (int i=0; i<2; i++) {
            NthPrimeNumberRequest nthPrimeNumberRequest = NthPrimeNumberRequest.newBuilder()
                    .addNumbers(ThreadLocalRandom.current().nextInt(1, 100001))
                    .addNumbers(ThreadLocalRandom.current().nextInt(1, 100001))
                    .addNumbers(ThreadLocalRandom.current().nextInt(1, 100001))
                    .build();
            System.out.println(nthPrimeNumberRequest);
            NthPrimeNumberResponse nthPrimeNumbers = blockingStub
                    .withDeadline(Deadline.after(10, TimeUnit.SECONDS))
                    .withOption(RPC_TYPE_CALL_OPTION_KEY, "unary")
                    .getNthPrimeNumbers(nthPrimeNumberRequest);
            System.out.println(nthPrimeNumbers);
        }



    }

}
