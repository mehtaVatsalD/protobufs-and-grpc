package io.simplecoder.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.simplecoder.grpc.server.interceptor.DelayAdderInterceptor;
import io.simplecoder.grpc.server.interceptor.HumanCodeVerifierInterceptor;
import io.simplecoder.grpc.service.PrimeNumbersService;

import java.io.IOException;

public class ServerMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 6565;
        System.out.println("Starting server");
        Server server = ServerBuilder.forPort(port)
                .intercept(new HumanCodeVerifierInterceptor())
                .intercept(new DelayAdderInterceptor())
                .addService(new PrimeNumbersService())
                .build();

        server.start();
        System.out.println("Server started on port " + port);
        server.awaitTermination();
    }

}
