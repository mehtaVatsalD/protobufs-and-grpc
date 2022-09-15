// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PrimeNumbers.proto

package io.simplecoder.grpc.generated.protobufs;

public final class PrimeNumbers {
  private PrimeNumbers() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_NthPrimeNumberRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_NthPrimeNumberRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_NthPrimeNumberResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_NthPrimeNumberResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_FirstNPrimeNumbersRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_FirstNPrimeNumbersRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_FirstNPrimeNumbersResponseChunk_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_FirstNPrimeNumbersResponseChunk_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AreNumbersPrimeRequestChunk_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AreNumbersPrimeRequestChunk_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AreNumbersPrimeModel_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AreNumbersPrimeModel_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AreNumbersPrimeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AreNumbersPrimeResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022PrimeNumbers.proto\"(\n\025NthPrimeNumberRe" +
      "quest\022\017\n\007numbers\030\001 \003(\005\"/\n\026NthPrimeNumber" +
      "Response\022\025\n\rprime_numbers\030\001 \003(\003\"&\n\031First" +
      "NPrimeNumbersRequest\022\t\n\001n\030\001 \001(\005\"7\n\037First" +
      "NPrimeNumbersResponseChunk\022\024\n\014prime_numb" +
      "er\030\001 \001(\003\"-\n\033AreNumbersPrimeRequestChunk\022" +
      "\016\n\006number\030\001 \001(\005\"8\n\024AreNumbersPrimeModel\022" +
      "\016\n\006number\030\001 \001(\005\022\020\n\010is_prime\030\002 \001(\010\"B\n\027Are" +
      "NumbersPrimeResponse\022\'\n\010response\030\001 \003(\0132\025" +
      ".AreNumbersPrimeModel2\323\002\n\023PrimeNumbersSe" +
      "rvice\022E\n\022GetNthPrimeNumbers\022\026.NthPrimeNu" +
      "mberRequest\032\027.NthPrimeNumberResponse\022W\n\025" +
      "GetFirstNPrimeNumbers\022\032.FirstNPrimeNumbe" +
      "rsRequest\032 .FirstNPrimeNumbersResponseCh" +
      "unk0\001\022K\n\017AreNumbersPrime\022\034.AreNumbersPri" +
      "meRequestChunk\032\030.AreNumbersPrimeResponse" +
      "(\001\022O\n\024AreNumbersPrimeAsync\022\034.AreNumbersP" +
      "rimeRequestChunk\032\025.AreNumbersPrimeModel(" +
      "\0010\001B2\n.io.simplecoder.grpc.generated.pro" +
      "tobufs.modelsP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_NthPrimeNumberRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_NthPrimeNumberRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_NthPrimeNumberRequest_descriptor,
        new java.lang.String[] { "Numbers", });
    internal_static_NthPrimeNumberResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_NthPrimeNumberResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_NthPrimeNumberResponse_descriptor,
        new java.lang.String[] { "PrimeNumbers", });
    internal_static_FirstNPrimeNumbersRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_FirstNPrimeNumbersRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_FirstNPrimeNumbersRequest_descriptor,
        new java.lang.String[] { "N", });
    internal_static_FirstNPrimeNumbersResponseChunk_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_FirstNPrimeNumbersResponseChunk_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_FirstNPrimeNumbersResponseChunk_descriptor,
        new java.lang.String[] { "PrimeNumber", });
    internal_static_AreNumbersPrimeRequestChunk_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_AreNumbersPrimeRequestChunk_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AreNumbersPrimeRequestChunk_descriptor,
        new java.lang.String[] { "Number", });
    internal_static_AreNumbersPrimeModel_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_AreNumbersPrimeModel_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AreNumbersPrimeModel_descriptor,
        new java.lang.String[] { "Number", "IsPrime", });
    internal_static_AreNumbersPrimeResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_AreNumbersPrimeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AreNumbersPrimeResponse_descriptor,
        new java.lang.String[] { "Response", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
