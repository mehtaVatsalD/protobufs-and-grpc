package io.simplecoder.grpc.unary.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.simplecoder.grpc.unary.services.UserService;

import java.io.IOException;

public class ServerMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 8888;
        System.out.println("Starting server");
        Server server = ServerBuilder.forPort(port)
                .addService(new UserService())
                .build();

        server.start();
        System.out.println("Server started on port " + port);
        server.awaitTermination();
    }

}
