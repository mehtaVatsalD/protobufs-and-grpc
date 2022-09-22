package io.simplecoder.grpc.client;

import io.grpc.NameResolverRegistry;
import io.simplecoder.grpc.client.registry.CustomServiceRegistry;
import io.simplecoder.grpc.client.resolver.LocalNameResolverProvider;
import io.simplecoder.grpc.generated.protobufs.NthPrimeNumberRequest;
import io.simplecoder.grpc.generated.protobufs.NthPrimeNumberResponse;
import io.simplecoder.grpc.generated.protobufs.PrimeNumbersServiceGrpc;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static io.simplecoder.grpc.utils.ChannelUtil.getManagedChannelLoadBalanced;

public class NthPrimeNumbersUnaryClientLB {

    public static void main(String[] args) {
        CustomServiceRegistry.register("/prime-numbers-service",
                Arrays.asList("localhost:6565", "localhost:7575"));

        NameResolverRegistry.getDefaultRegistry().register(new LocalNameResolverProvider());

        PrimeNumbersServiceGrpc.PrimeNumbersServiceBlockingStub blockingStub = PrimeNumbersServiceGrpc.newBlockingStub(getManagedChannelLoadBalanced());

        for (int i=0; i<100; i++) {
            NthPrimeNumberRequest nthPrimeNumberRequest = NthPrimeNumberRequest.newBuilder()
                    .addNumbers(ThreadLocalRandom.current().nextInt(1, 100001))
                    .addNumbers(ThreadLocalRandom.current().nextInt(1, 100001))
                    .addNumbers(ThreadLocalRandom.current().nextInt(1, 100001))
                    .build();
            System.out.println(nthPrimeNumberRequest);
            NthPrimeNumberResponse nthPrimeNumbers = blockingStub.getNthPrimeNumbers(nthPrimeNumberRequest);
            System.out.println(nthPrimeNumbers);
        }



    }

}
