package io.simplecoder.grpc.utils;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public final class ValidityUtil {

    private ValidityUtil(){}

    public static void checkIfValidForIsPrime(int n, StreamObserver<?> responseObserver) {
        if (n <= 0) {
            Status status = Status.FAILED_PRECONDITION.withDescription("n should be > 0");
            responseObserver.onError(status.asRuntimeException());
        }
    }

}
