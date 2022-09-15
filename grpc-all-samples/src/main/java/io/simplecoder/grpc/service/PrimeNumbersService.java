package io.simplecoder.grpc.service;

import io.grpc.stub.StreamObserver;
import io.simplecoder.grpc.generated.protobufs.*;
import io.simplecoder.grpc.observers.request.AreNumbersPrimeAsyncRequestObserver;
import io.simplecoder.grpc.observers.request.AreNumbersPrimeRequestObserver;
import io.simplecoder.grpc.utils.PrimeNumbersUtils;

import java.util.ArrayList;
import java.util.List;

import static io.simplecoder.grpc.utils.ValidityUtil.checkIfValidForIsPrime;

public class PrimeNumbersService extends PrimeNumbersServiceGrpc.PrimeNumbersServiceImplBase {

    @Override
    public void getNthPrimeNumbers(NthPrimeNumberRequest request, StreamObserver<NthPrimeNumberResponse> responseObserver) {
        List<Integer> numbers = request.getNumbersList();
        List<Long> primeNumbers = new ArrayList<>();
        for (Integer n: numbers) {
            checkIfValidForIsPrime(n, responseObserver);
            primeNumbers.add(PrimeNumbersUtils.getNthPrimeNumber(n));
        }
        NthPrimeNumberResponse nthPrimeNumberResponse = NthPrimeNumberResponse.newBuilder()
                .addAllPrimeNumbers(primeNumbers)
                .build();
        responseObserver.onNext(nthPrimeNumberResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getFirstNPrimeNumbers(FirstNPrimeNumbersRequest request, StreamObserver<FirstNPrimeNumbersResponseChunk> responseObserver) {
        int n = request.getN();
        for (int i=1; i<=n; i++) {
            responseObserver.onNext(
                    FirstNPrimeNumbersResponseChunk.newBuilder()
                    .setPrimeNumber(PrimeNumbersUtils.getNthPrimeNumber(i))
                    .build()
            );
            //explicit sleep to know the behaviour of server streaming
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<AreNumbersPrimeRequestChunk> areNumbersPrime(StreamObserver<AreNumbersPrimeResponse> responseObserver) {
        return new AreNumbersPrimeRequestObserver(responseObserver);
    }

    @Override
    public StreamObserver<AreNumbersPrimeRequestChunk> areNumbersPrimeAsync(StreamObserver<AreNumbersPrimeModel> responseObserver) {
        return new AreNumbersPrimeAsyncRequestObserver(responseObserver);
    }
}
