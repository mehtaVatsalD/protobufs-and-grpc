package io.simplecoder.grpc.client.interceptors;

import io.grpc.*;
import io.simplecoder.grpc.client.credentials.RandomCredentials;

public class RandomCredentialInterceptor implements ClientInterceptor {

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        return next.newCall(method, callOptions.withCallCredentials(new RandomCredentials()));
    }
}
