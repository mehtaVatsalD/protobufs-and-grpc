package io.tshapeddev.grpc.learnings.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.tshapeddev.grpc.learnings.services.GameService;

import java.io.IOException;

public class ServerMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 8888;
        System.out.println("Starting server");
        Server server = ServerBuilder.forPort(port)
                .addService(new GameService())
                .build();

        server.start();
        System.out.println("Server started on port " + port);
        server.awaitTermination();
    }

}
