package io.simplecoder.grpc.client.registry;

import io.grpc.EquivalentAddressGroup;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomServiceRegistry {

    private static final Map<String, List<EquivalentAddressGroup>> hostAddressMap = new HashMap<>();

    public static void register(String serviceName, List<String> instances) {
        List<EquivalentAddressGroup> equivalentAddressGroups = instances.stream()
                .map(instance -> instance.split(":"))
                .map(values -> new InetSocketAddress(values[0], Integer.parseInt(values[1])))
                .map(EquivalentAddressGroup::new)
                .collect(Collectors.toList());

        hostAddressMap.put(serviceName, equivalentAddressGroups);
    }

    public static List<EquivalentAddressGroup> getInstances(String serviceName) {
        return hostAddressMap.get(serviceName);
    }


}
