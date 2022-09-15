package io.simplecoder.grpc.utils;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public final class ChannelUtil {

    private ChannelUtil() {}

    public static ManagedChannel getManagedChannel() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8888)
                .usePlaintext()
                .build();
        return managedChannel;
    }

}
