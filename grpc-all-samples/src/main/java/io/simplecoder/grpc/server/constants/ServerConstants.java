package io.simplecoder.grpc.server.constants;

import io.grpc.Context;
import io.grpc.Metadata;
import io.simplecoder.grpc.marshaller.IntegerMarshaller;

public class ServerConstants {

    public static final Metadata.Key<String> HUMAN_CODE_METADATA_KEY = Metadata.Key.of("human-code", Metadata.ASCII_STRING_MARSHALLER);
    public static final Metadata.Key<Integer> MIN_METADATA_KEY = Metadata.Key.of("min-delay", new IntegerMarshaller());
    public static final Context.Key<Integer> DELAY_IN_SECONDS_CONTEXT_KEY = Context.keyWithDefault("delay", 5);
    public static final Metadata.Key<Integer> RANDOM_INT_CRED_METADATA_KEY = Metadata.Key.of("random-cred", new IntegerMarshaller());
    public static final Metadata.Key<String> CONSTANT_INT_CRED_METADATA_KEY = Metadata.Key.of("constant-cred", Metadata.ASCII_STRING_MARSHALLER);

}
