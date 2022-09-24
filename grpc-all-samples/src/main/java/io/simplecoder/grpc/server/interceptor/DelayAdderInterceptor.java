package io.simplecoder.grpc.server.interceptor;

import io.grpc.*;

import static io.simplecoder.grpc.server.constants.ServerConstants.DELAY_IN_SECONDS_CONTEXT_KEY;
import static io.simplecoder.grpc.server.constants.ServerConstants.MIN_METADATA_KEY;

public class DelayAdderInterceptor implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        Integer minDelay = headers.get(MIN_METADATA_KEY);
        Context newContext = Context.current().withValue(DELAY_IN_SECONDS_CONTEXT_KEY, minDelay);
        return Contexts.interceptCall(newContext, call, headers, next);
    }
}
