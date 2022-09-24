package io.simplecoder.grpc.client.interceptors;

import io.grpc.*;

import java.util.concurrent.TimeUnit;

public class DeadlineInterceptor implements ClientInterceptor {

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        if (callOptions.getDeadline() == null) {
            callOptions = callOptions.withDeadlineAfter(2, TimeUnit.SECONDS);
        }
        return next.newCall(method, callOptions);
    }
}
