package io.simplecoder.grpc.client.interceptors;

import io.grpc.*;
import io.grpc.stub.MetadataUtils;
import io.simplecoder.grpc.client.storage.HumanCodeStorage;

import static io.simplecoder.grpc.client.contants.ClientConstants.*;

public class CustomMetaDataInterceptor implements ClientInterceptor {


    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        String rpcType = callOptions.getOption(RPC_TYPE_CALL_OPTION_KEY);
        Metadata metadata = new Metadata();
        metadata.put(HUMAN_CODE_METADATA_KEY, HumanCodeStorage.getHumanCode(rpcType));
        metadata.put(MIN_METADATA_KEY, 1);
        return MetadataUtils.newAttachHeadersInterceptor(metadata).interceptCall(method, callOptions, next);
    }
}
