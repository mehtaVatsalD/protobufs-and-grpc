package io.simplecoder.grpc.observers.request;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import io.simplecoder.grpc.generated.protobufs.AreNumbersPrimeModel;
import io.simplecoder.grpc.generated.protobufs.AreNumbersPrimeRequestChunk;
import io.simplecoder.grpc.utils.PrimeNumbersUtils;

import static io.simplecoder.grpc.utils.ValidityUtil.checkIfValidForIsPrime;

public class AreNumbersPrimeAsyncRequestObserver implements StreamObserver<AreNumbersPrimeRequestChunk> {

    private final StreamObserver<AreNumbersPrimeModel> responseStreamObserver;

    public AreNumbersPrimeAsyncRequestObserver(StreamObserver<AreNumbersPrimeModel> responseStreamObserver) {
        this.responseStreamObserver = responseStreamObserver;
    }

    @Override
    public void onNext(AreNumbersPrimeRequestChunk areNumbersPrimeRequestChunk) {
        int number = areNumbersPrimeRequestChunk.getNumber();
        checkIfValidForIsPrime(number, responseStreamObserver);
        AreNumbersPrimeModel areNumbersPrimeModel = AreNumbersPrimeModel.newBuilder()
                .setNumber(number)
                .setIsPrime(PrimeNumbersUtils.isPrime(number))
                .build();
        System.out.println(areNumbersPrimeModel);
        responseStreamObserver.onNext(areNumbersPrimeModel);
    }

    @Override
    public void onError(Throwable throwable) {
        responseStreamObserver.onError(Status.INTERNAL.withDescription(throwable.getMessage()).asRuntimeException());
    }

    @Override
    public void onCompleted() {
        responseStreamObserver.onCompleted();
    }
}
