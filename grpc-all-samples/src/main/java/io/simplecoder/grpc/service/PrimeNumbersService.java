package io.simplecoder.grpc.service;

import com.google.common.util.concurrent.Uninterruptibles;
import io.grpc.Context;
import io.grpc.stub.StreamObserver;
import io.simplecoder.grpc.generated.protobufs.*;
import io.simplecoder.grpc.observers.request.AreNumbersPrimeAsyncRequestObserver;
import io.simplecoder.grpc.observers.request.AreNumbersPrimeRequestObserver;
import io.simplecoder.grpc.utils.PrimeNumbersUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.simplecoder.grpc.server.constants.ServerConstants.DELAY_IN_SECONDS_CONTEXT_KEY;
import static io.simplecoder.grpc.utils.ValidityUtil.checkIfValidForIsPrime;

public class PrimeNumbersService extends PrimeNumbersServiceGrpc.PrimeNumbersServiceImplBase {

    @Override
    public void getNthPrimeNumbers(NthPrimeNumberRequest request, StreamObserver<NthPrimeNumberResponse> responseObserver) {
        List<Integer> numbers = request.getNumbersList();
        System.out.println(numbers);
        List<Long> primeNumbers = new ArrayList<>();
        for (Integer n: numbers) {
            checkIfValidForIsPrime(n, responseObserver);
            primeNumbers.add(PrimeNumbersUtils.getNthPrimeNumber(n));
        }
        NthPrimeNumberResponse nthPrimeNumberResponse = NthPrimeNumberResponse.newBuilder()
                .addAllPrimeNumbers(primeNumbers)
                .build();
        //sleep to simulate load on server... to test deadline
        //sleep value we will take from context just for fun!
        //this sleep is sent by client themselves using headers!
        //if not sent then we will use default
        Uninterruptibles.sleepUninterruptibly(DELAY_IN_SECONDS_CONTEXT_KEY.get(), TimeUnit.SECONDS);
        responseObserver.onNext(nthPrimeNumberResponse);
        responseObserver.onCompleted();
        System.out.println(nthPrimeNumberResponse);
    }

    @Override
    public void getFirstNPrimeNumbers(FirstNPrimeNumbersRequest request, StreamObserver<FirstNPrimeNumbersResponseChunk> responseObserver) {
        int n = request.getN();
        System.out.println(n);
        for (int i=1; i<=n; i++) {
            if (Context.current().isCancelled()) {
                System.out.println("Chalo jane do kisi ko padi hi nai hai response ki!");
                break;
            }
            FirstNPrimeNumbersResponseChunk firstNPrimeNumbersResponseChunk = FirstNPrimeNumbersResponseChunk.newBuilder()
                    .setPrimeNumber(PrimeNumbersUtils.getNthPrimeNumber(i))
                    .build();
            System.out.println(firstNPrimeNumbersResponseChunk);
            responseObserver.onNext(
                    firstNPrimeNumbersResponseChunk
            );
            //explicit sleep to know the behaviour of server streaming
            try {
                Thread.sleep(3000);
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
