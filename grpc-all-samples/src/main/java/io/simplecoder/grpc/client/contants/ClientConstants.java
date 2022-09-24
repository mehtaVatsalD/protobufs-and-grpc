package io.simplecoder.grpc.client.contants;

import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.simplecoder.grpc.marshaller.IntegerMarshaller;

public class ClientConstants {

    public static final Metadata.Key<String> HUMAN_CODE_METADATA_KEY = Metadata.Key.of("human-code", Metadata.ASCII_STRING_MARSHALLER);
    public static final CallOptions.Key<String> RPC_TYPE_CALL_OPTION_KEY = CallOptions.Key.createWithDefault("rpc-type", "unary");
    public static final Metadata.Key<Integer> MIN_METADATA_KEY = Metadata.Key.of("min-delay", new IntegerMarshaller());
    public static final Metadata.Key<Integer> RANDOM_INT_CRED_METADATA_KEY = Metadata.Key.of("random-cred", new IntegerMarshaller());
    public static final Metadata.Key<String> CONSTANT_INT_CRED_METADATA_KEY = Metadata.Key.of("constant-cred", Metadata.ASCII_STRING_MARSHALLER);

    public static final Metadata CONSTANT_CRED_METADATA = new Metadata();

    static {
        CONSTANT_CRED_METADATA.put(CONSTANT_INT_CRED_METADATA_KEY, "THIS_IS_CONSTANT_CRED_OR_TOKEN_SENT_SAME_FOR_ALL_CALLS");
    }


}
