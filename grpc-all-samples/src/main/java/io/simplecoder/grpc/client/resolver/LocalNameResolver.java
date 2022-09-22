package io.simplecoder.grpc.client.resolver;

import io.grpc.NameResolver;
import io.simplecoder.grpc.client.registry.CustomServiceRegistry;

public class LocalNameResolver extends NameResolver {

    private Listener2 listener;

    private final String service;

    public LocalNameResolver(String service) {
        this.service = service;
    }

    @Override
    public String getServiceAuthority() {
        return "/prime-numbers-service";
    }

    @Override
    public void shutdown() {
    }

    @Override
    public void start(Listener2 listener) {
        this.listener = listener;
        updateListener(listener);
    }

    private void updateListener(Listener2 listener) {
        ResolutionResult resolutionResult = ResolutionResult.newBuilder()
                .setAddresses(CustomServiceRegistry.getInstances(service))
                .build();
        listener.onResult(
                resolutionResult
        );
    }

    @Override
    public void refresh() {
        updateListener(listener);
    }
}
