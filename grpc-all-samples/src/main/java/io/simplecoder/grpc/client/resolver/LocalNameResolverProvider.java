package io.simplecoder.grpc.client.resolver;

import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;

import java.net.URI;

public class LocalNameResolverProvider extends NameResolverProvider {

    @Override
    protected boolean isAvailable() {
        return true;
    }

    @Override
    protected int priority() {
        return 6;
    }

    @Override
    public NameResolver newNameResolver(URI targetUri, NameResolver.Args args) {
        System.out.println("Resolving for: " + targetUri.getPath());
        return new LocalNameResolver(targetUri.getPath());
    }

    @Override
    public String getDefaultScheme() {
        return "localResolution";
    }



}
