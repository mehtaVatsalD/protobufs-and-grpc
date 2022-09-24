package io.simplecoder.grpc.utils;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.MetadataUtils;
import io.simplecoder.grpc.client.interceptors.DeadlineInterceptor;
import io.simplecoder.grpc.client.interceptors.CustomMetaDataInterceptor;
import io.simplecoder.grpc.client.interceptors.RandomCredentialInterceptor;

import static io.simplecoder.grpc.client.contants.ClientConstants.CONSTANT_CRED_METADATA;

public final class ChannelUtil {

    private ChannelUtil() {}

    public static ManagedChannel getManagedChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .intercept(new DeadlineInterceptor())
                .intercept(new CustomMetaDataInterceptor())
                .intercept(new RandomCredentialInterceptor())
                .intercept(MetadataUtils.newAttachHeadersInterceptor(CONSTANT_CRED_METADATA))
                .build();
    }

    public static ManagedChannel getManagedChannelLoadBalanced() {
        return ManagedChannelBuilder.forTarget("prime-numbers-service")
                .usePlaintext()
                .defaultLoadBalancingPolicy("round_robin")
                .build();
    }

}
