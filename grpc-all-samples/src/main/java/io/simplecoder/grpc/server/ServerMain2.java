package io.simplecoder.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.simplecoder.grpc.service.PrimeNumbersService;

import java.io.IOException;

public class ServerMain2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 7575;
        System.out.println("Starting server");
        Server server = ServerBuilder.forPort(port)
                .addService(new PrimeNumbersService())
                .build();

        server.start();
        System.out.println("Server started on port " + port);
        server.awaitTermination();
    }

}
