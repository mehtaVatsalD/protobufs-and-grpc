package io.simplecoder.grpc.unary.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.simplecoder.grpc.unary.generated.protobufs.models.Address;
import io.simplecoder.grpc.unary.generated.protobufs.models.UserQueryByIdRequest;
import io.simplecoder.grpc.unary.generated.protobufs.models.UserRegistrationRequest;
import io.simplecoder.grpc.unary.generated.protobufs.models.UserResponse;
import io.simplecoder.grpc.unary.generated.protobufs.services.UserServiceGrpc;

public class UserServiceClient {

    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8888)
                .usePlaintext()
                .build();

        UserServiceGrpc.UserServiceBlockingStub blockingStub = UserServiceGrpc.newBlockingStub(managedChannel);
        UserResponse userResponse;
        System.out.println("~~~~~~~~~~~~~~~~~~~~REGISTERING USER~~~~~~~~~~~~~~~~~~~~");
        userResponse = blockingStub.registerUser(getUserRegistrationRequest());
        System.out.println(userResponse);
        System.out.println("~~~~~~~~~~~~~~~~~~~~FETCHING USER BY ID~~~~~~~~~~~~~~~~~~~~");
        userResponse = blockingStub.getUserById(getUserQueryByIdRequest());
        System.out.println(userResponse);

    }

    private static UserRegistrationRequest getUserRegistrationRequest() {
        return UserRegistrationRequest.newBuilder()
                .setUserName("vatsalm")
                .setFirstName("Vatsal")
                .setLastName("Mehta")
                .setEmail("mehtavatsald02@gmail.com")
                .addPhoneNumbers(123)
                .setAddress(Address.newBuilder()
                        .setAddressLine1("FakeAddr1")
                        .setAddressLine2("FakeAddr2")
                        .setDistrict("FakeDistrict")
                        .setState("FakeState")
                        .setCountry("FakeCountry")
                        .setPinCode("123456")
                        .build())
                .build();
    }

    private static UserQueryByIdRequest getUserQueryByIdRequest() {
        return UserQueryByIdRequest.newBuilder()
                .setUserId(1)
                .build();
    }

}
