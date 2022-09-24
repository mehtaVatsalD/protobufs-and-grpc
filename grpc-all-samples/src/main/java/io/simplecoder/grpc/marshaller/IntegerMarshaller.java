package io.simplecoder.grpc.marshaller;

import io.grpc.Metadata;

public class IntegerMarshaller implements Metadata.AsciiMarshaller<Integer> {

    @Override
    public String toAsciiString(Integer value) {
        return value == null ? "" : String.valueOf(value);
    }

    @Override
    public Integer parseAsciiString(String serialized) {
        return serialized == null ? null : Integer.parseInt(serialized);
    }
}
