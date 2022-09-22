package io.simplecoder.grpc.utils;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public final class ChannelUtil {

    private ChannelUtil() {}

    public static ManagedChannel getManagedChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();
    }

    public static ManagedChannel getManagedChannelLoadBalanced() {
        return ManagedChannelBuilder.forTarget("prime-numbers-service")
                .usePlaintext()
                .defaultLoadBalancingPolicy("round_robin")
                .build();
    }

}
