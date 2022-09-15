package io.simplecoder.grpc.observers.request;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import io.simplecoder.grpc.generated.protobufs.models.AreNumbersPrimeModel;
import io.simplecoder.grpc.generated.protobufs.models.AreNumbersPrimeRequestChunk;
import io.simplecoder.grpc.generated.protobufs.models.AreNumbersPrimeResponse;
import io.simplecoder.grpc.utils.PrimeNumbersUtils;

import java.util.ArrayList;
import java.util.List;

import static io.simplecoder.grpc.utils.ValidityUtil.checkIfValidForIsPrime;

public class AreNumbersPrimeRequestObserver implements StreamObserver<AreNumbersPrimeRequestChunk> {

    private final List<AreNumbersPrimeModel> areNumbersPrimeModelList;
    private final StreamObserver<AreNumbersPrimeResponse> responseStreamObserver;

    public AreNumbersPrimeRequestObserver(StreamObserver<AreNumbersPrimeResponse> responseStreamObserver) {
        this.areNumbersPrimeModelList = new ArrayList<>();
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
        areNumbersPrimeModelList.add(
                areNumbersPrimeModel
        );
    }

    @Override
    public void onError(Throwable throwable) {
        responseStreamObserver.onError(Status.INTERNAL.withDescription(throwable.getMessage()).asRuntimeException());
    }

    @Override
    public void onCompleted() {
        responseStreamObserver.onNext(
                AreNumbersPrimeResponse.newBuilder()
                        .addAllResponse(areNumbersPrimeModelList)
                        .build()
        );
        responseStreamObserver.onCompleted();
    }
}
