// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PrimeNumbers.proto

package io.simplecoder.grpc.generated.protobufs;

public interface AreNumbersPrimeResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:AreNumbersPrimeResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .AreNumbersPrimeModel response = 1;</code>
   */
  java.util.List<AreNumbersPrimeModel>
      getResponseList();
  /**
   * <code>repeated .AreNumbersPrimeModel response = 1;</code>
   */
  AreNumbersPrimeModel getResponse(int index);
  /**
   * <code>repeated .AreNumbersPrimeModel response = 1;</code>
   */
  int getResponseCount();
  /**
   * <code>repeated .AreNumbersPrimeModel response = 1;</code>
   */
  java.util.List<? extends AreNumbersPrimeModelOrBuilder>
      getResponseOrBuilderList();
  /**
   * <code>repeated .AreNumbersPrimeModel response = 1;</code>
   */
  AreNumbersPrimeModelOrBuilder getResponseOrBuilder(
      int index);
}
