package io.simplecoder.grpc.client.credentials;

import com.google.common.util.concurrent.Uninterruptibles;
import io.grpc.CallCredentials;
import io.grpc.Metadata;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static io.simplecoder.grpc.client.contants.ClientConstants.RANDOM_INT_CRED_METADATA_KEY;

public class RandomCredentials extends CallCredentials {

    public RandomCredentials() {
        super();
    }

    @Override
    public void applyRequestMetadata(RequestInfo requestInfo, Executor appExecutor, MetadataApplier applier) {
        appExecutor.execute(() -> {
            System.out.println("waiting for token");
            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
            System.out.println("received token");
            Metadata metadata = new Metadata();
            Integer randomCred = ThreadLocalRandom.current().nextInt();
            System.out.println("RandomCred: " + randomCred);
            metadata.put(RANDOM_INT_CRED_METADATA_KEY, randomCred);
            applier.apply(metadata);
        });
    }

    @Override
    public void thisUsesUnstableApi() {}
}
