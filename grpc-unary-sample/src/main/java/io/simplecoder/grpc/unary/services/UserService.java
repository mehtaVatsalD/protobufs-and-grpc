package io.simplecoder.grpc.unary.services;

import io.grpc.stub.StreamObserver;
import io.simplecoder.grpc.unary.generated.protobufs.models.UserQueryByIdRequest;
import io.simplecoder.grpc.unary.generated.protobufs.models.UserRegistrationRequest;
import io.simplecoder.grpc.unary.generated.protobufs.models.UserResponse;
import io.simplecoder.grpc.unary.generated.protobufs.services.UserServiceGrpc;

import java.util.HashMap;
import java.util.Map;

public class UserService extends UserServiceGrpc.UserServiceImplBase {

    private final Map<Long, UserResponse> users = new HashMap<>();
    private Long userIdSequence = 0L;

    @Override
    public void registerUser(UserRegistrationRequest request, StreamObserver<UserResponse> responseObserver) {
        long userId;
        synchronized ("userIdSequence") {
            userId = ++userIdSequence;
        }
        System.out.println("Received request to register user...");
        System.out.println("~~~~~~~~~~~~~~~~~~~~REQUEST~~~~~~~~~~~~~~~~~~~~");
        System.out.println(request);
        System.out.println("Registering user with id " + userId);
        UserResponse userResponse = UserResponse.newBuilder()
                .setUserId(userId)
                .setUserName(request.getUserName())
                .setFirstName(request.getFirstName())
                .setLastName(request.getLastName())
                .setEmail(request.getEmail())
                .addAllPhoneNumbers(request.getPhoneNumbersList())
                .setAddress(request.getAddress())
                .build();
        users.put(userId, userResponse);
        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();
        System.out.println("User registered and response sent successfully");
        System.out.println("~~~~~~~~~~~~~~~~~~~~RESPONSE~~~~~~~~~~~~~~~~~~~~");
        System.out.println(userResponse);
    }

    @Override
    public void getUserById(UserQueryByIdRequest request, StreamObserver<UserResponse> responseObserver) {
        System.out.println("Received query for userId " + request.getUserId());
        System.out.println("~~~~~~~~~~~~~~~~~~~~REQUEST~~~~~~~~~~~~~~~~~~~~");
        System.out.println(request);
        UserResponse userResponse = users.get(request.getUserId());
        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();
        System.out.println("User fetched and response sent successfully");
        System.out.println("~~~~~~~~~~~~~~~~~~~~RESPONSE~~~~~~~~~~~~~~~~~~~~");
        System.out.println(userResponse);
    }
}
