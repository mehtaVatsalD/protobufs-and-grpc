package io.simplecoder.grpc.client.storage;

import java.util.HashMap;
import java.util.Map;

public class HumanCodeStorage {

    private static final Map<String, String> RPC_TYPE_TO_HUMAN_CODE_MAP = new HashMap<>();

    static {
        RPC_TYPE_TO_HUMAN_CODE_MAP.put("unary", "HC101");
        RPC_TYPE_TO_HUMAN_CODE_MAP.put("client-streaming", "HC102");
        RPC_TYPE_TO_HUMAN_CODE_MAP.put("server-streaming", "HC103");
        RPC_TYPE_TO_HUMAN_CODE_MAP.put("bi-streaming", "HC104");
    }

    public static String getHumanCode(String rpcType) {
        return RPC_TYPE_TO_HUMAN_CODE_MAP.get(rpcType);
    }

}
