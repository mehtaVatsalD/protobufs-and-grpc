// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: models/User.proto

package io.simplecoder.grpc.unary.generated.protobufs.models;

public interface UserRegistrationRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:models.UserRegistrationRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string user_name = 1;</code>
   */
  java.lang.String getUserName();
  /**
   * <code>string user_name = 1;</code>
   */
  com.google.protobuf.ByteString
      getUserNameBytes();

  /**
   * <code>string first_name = 2;</code>
   */
  java.lang.String getFirstName();
  /**
   * <code>string first_name = 2;</code>
   */
  com.google.protobuf.ByteString
      getFirstNameBytes();

  /**
   * <code>string last_name = 3;</code>
   */
  java.lang.String getLastName();
  /**
   * <code>string last_name = 3;</code>
   */
  com.google.protobuf.ByteString
      getLastNameBytes();

  /**
   * <code>string email = 4;</code>
   */
  java.lang.String getEmail();
  /**
   * <code>string email = 4;</code>
   */
  com.google.protobuf.ByteString
      getEmailBytes();

  /**
   * <code>repeated fixed32 phone_numbers = 5;</code>
   */
  java.util.List<java.lang.Integer> getPhoneNumbersList();
  /**
   * <code>repeated fixed32 phone_numbers = 5;</code>
   */
  int getPhoneNumbersCount();
  /**
   * <code>repeated fixed32 phone_numbers = 5;</code>
   */
  int getPhoneNumbers(int index);

  /**
   * <code>.models.Address address = 6;</code>
   */
  boolean hasAddress();
  /**
   * <code>.models.Address address = 6;</code>
   */
  Address getAddress();
  /**
   * <code>.models.Address address = 6;</code>
   */
  AddressOrBuilder getAddressOrBuilder();
}
