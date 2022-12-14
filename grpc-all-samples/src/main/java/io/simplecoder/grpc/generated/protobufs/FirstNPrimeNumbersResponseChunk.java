// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PrimeNumbers.proto

package io.simplecoder.grpc.generated.protobufs;

/**
 * Protobuf type {@code FirstNPrimeNumbersResponseChunk}
 */
public  final class FirstNPrimeNumbersResponseChunk extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:FirstNPrimeNumbersResponseChunk)
    FirstNPrimeNumbersResponseChunkOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FirstNPrimeNumbersResponseChunk.newBuilder() to construct.
  private FirstNPrimeNumbersResponseChunk(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FirstNPrimeNumbersResponseChunk() {
    primeNumber_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FirstNPrimeNumbersResponseChunk(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            primeNumber_ = input.readInt64();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return PrimeNumbers.internal_static_FirstNPrimeNumbersResponseChunk_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return PrimeNumbers.internal_static_FirstNPrimeNumbersResponseChunk_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            FirstNPrimeNumbersResponseChunk.class, FirstNPrimeNumbersResponseChunk.Builder.class);
  }

  public static final int PRIME_NUMBER_FIELD_NUMBER = 1;
  private long primeNumber_;
  /**
   * <code>int64 prime_number = 1;</code>
   */
  public long getPrimeNumber() {
    return primeNumber_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (primeNumber_ != 0L) {
      output.writeInt64(1, primeNumber_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (primeNumber_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, primeNumber_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof FirstNPrimeNumbersResponseChunk)) {
      return super.equals(obj);
    }
    FirstNPrimeNumbersResponseChunk other = (FirstNPrimeNumbersResponseChunk) obj;

    boolean result = true;
    result = result && (getPrimeNumber()
        == other.getPrimeNumber());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PRIME_NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getPrimeNumber());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static FirstNPrimeNumbersResponseChunk parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static FirstNPrimeNumbersResponseChunk parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static FirstNPrimeNumbersResponseChunk parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static FirstNPrimeNumbersResponseChunk parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static FirstNPrimeNumbersResponseChunk parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static FirstNPrimeNumbersResponseChunk parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static FirstNPrimeNumbersResponseChunk parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static FirstNPrimeNumbersResponseChunk parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static FirstNPrimeNumbersResponseChunk parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static FirstNPrimeNumbersResponseChunk parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static FirstNPrimeNumbersResponseChunk parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static FirstNPrimeNumbersResponseChunk parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(FirstNPrimeNumbersResponseChunk prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code FirstNPrimeNumbersResponseChunk}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:FirstNPrimeNumbersResponseChunk)
          FirstNPrimeNumbersResponseChunkOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return PrimeNumbers.internal_static_FirstNPrimeNumbersResponseChunk_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return PrimeNumbers.internal_static_FirstNPrimeNumbersResponseChunk_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              FirstNPrimeNumbersResponseChunk.class, FirstNPrimeNumbersResponseChunk.Builder.class);
    }

    // Construct using io.simplecoder.grpc.generated.protobufs.models.FirstNPrimeNumbersResponseChunk.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      primeNumber_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return PrimeNumbers.internal_static_FirstNPrimeNumbersResponseChunk_descriptor;
    }

    @java.lang.Override
    public FirstNPrimeNumbersResponseChunk getDefaultInstanceForType() {
      return FirstNPrimeNumbersResponseChunk.getDefaultInstance();
    }

    @java.lang.Override
    public FirstNPrimeNumbersResponseChunk build() {
      FirstNPrimeNumbersResponseChunk result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public FirstNPrimeNumbersResponseChunk buildPartial() {
      FirstNPrimeNumbersResponseChunk result = new FirstNPrimeNumbersResponseChunk(this);
      result.primeNumber_ = primeNumber_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof FirstNPrimeNumbersResponseChunk) {
        return mergeFrom((FirstNPrimeNumbersResponseChunk)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(FirstNPrimeNumbersResponseChunk other) {
      if (other == FirstNPrimeNumbersResponseChunk.getDefaultInstance()) return this;
      if (other.getPrimeNumber() != 0L) {
        setPrimeNumber(other.getPrimeNumber());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      FirstNPrimeNumbersResponseChunk parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (FirstNPrimeNumbersResponseChunk) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long primeNumber_ ;
    /**
     * <code>int64 prime_number = 1;</code>
     */
    public long getPrimeNumber() {
      return primeNumber_;
    }
    /**
     * <code>int64 prime_number = 1;</code>
     */
    public Builder setPrimeNumber(long value) {
      
      primeNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 prime_number = 1;</code>
     */
    public Builder clearPrimeNumber() {
      
      primeNumber_ = 0L;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:FirstNPrimeNumbersResponseChunk)
  }

  // @@protoc_insertion_point(class_scope:FirstNPrimeNumbersResponseChunk)
  private static final FirstNPrimeNumbersResponseChunk DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new FirstNPrimeNumbersResponseChunk();
  }

  public static FirstNPrimeNumbersResponseChunk getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FirstNPrimeNumbersResponseChunk>
      PARSER = new com.google.protobuf.AbstractParser<FirstNPrimeNumbersResponseChunk>() {
    @java.lang.Override
    public FirstNPrimeNumbersResponseChunk parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FirstNPrimeNumbersResponseChunk(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FirstNPrimeNumbersResponseChunk> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FirstNPrimeNumbersResponseChunk> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public FirstNPrimeNumbersResponseChunk getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

