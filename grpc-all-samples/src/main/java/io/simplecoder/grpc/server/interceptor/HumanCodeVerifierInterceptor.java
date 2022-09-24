package io.simplecoder.grpc.server.interceptor;

import io.grpc.*;

import java.util.Arrays;
import java.util.List;

import static io.simplecoder.grpc.server.constants.ServerConstants.*;

public class HumanCodeVerifierInterceptor implements ServerInterceptor {

    private static final List<String> allowedHumanCodes = Arrays.asList("HC101", "HC102", "HC103", "HC104");

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        String humanCode = headers.get(HUMAN_CODE_METADATA_KEY);
        // this is random credential added uniquely for every call
        Integer randomCred = headers.get(RANDOM_INT_CRED_METADATA_KEY);
        // this is constant credential added same for all calls
        String constantCred = headers.get(CONSTANT_INT_CRED_METADATA_KEY);
        System.out.println("HumanCode: " + humanCode);
        System.out.println("RandomCred: " + randomCred);
        System.out.println("ConstantCred: " + constantCred);
        if (humanCode != null && allowedHumanCodes.contains(humanCode)) {
            return next.startCall(call, headers);
        } else {
            call.close(Status.UNAUTHENTICATED.withDescription("you are not allowed here!"), headers);
        }
        return new ServerCall.Listener<ReqT>() {};


    }
}
