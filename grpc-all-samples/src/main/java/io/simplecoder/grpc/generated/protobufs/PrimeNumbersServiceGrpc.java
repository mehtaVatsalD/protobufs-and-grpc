package io.simplecoder.grpc.generated.protobufs;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.*;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.*;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.22.1)",
    comments = "Source: PrimeNumbers.proto")
public final class PrimeNumbersServiceGrpc {

  private PrimeNumbersServiceGrpc() {}

  public static final String SERVICE_NAME = "PrimeNumbersService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<NthPrimeNumberRequest,
          NthPrimeNumberResponse> getGetNthPrimeNumbersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNthPrimeNumbers",
      requestType = NthPrimeNumberRequest.class,
      responseType = NthPrimeNumberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<NthPrimeNumberRequest,
          NthPrimeNumberResponse> getGetNthPrimeNumbersMethod() {
    io.grpc.MethodDescriptor<NthPrimeNumberRequest, NthPrimeNumberResponse> getGetNthPrimeNumbersMethod;
    if ((getGetNthPrimeNumbersMethod = PrimeNumbersServiceGrpc.getGetNthPrimeNumbersMethod) == null) {
      synchronized (PrimeNumbersServiceGrpc.class) {
        if ((getGetNthPrimeNumbersMethod = PrimeNumbersServiceGrpc.getGetNthPrimeNumbersMethod) == null) {
          PrimeNumbersServiceGrpc.getGetNthPrimeNumbersMethod = getGetNthPrimeNumbersMethod = 
              io.grpc.MethodDescriptor.<NthPrimeNumberRequest, NthPrimeNumberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PrimeNumbersService", "GetNthPrimeNumbers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  NthPrimeNumberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  NthPrimeNumberResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PrimeNumbersServiceMethodDescriptorSupplier("GetNthPrimeNumbers"))
                  .build();
          }
        }
     }
     return getGetNthPrimeNumbersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FirstNPrimeNumbersRequest,
          FirstNPrimeNumbersResponseChunk> getGetFirstNPrimeNumbersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFirstNPrimeNumbers",
      requestType = FirstNPrimeNumbersRequest.class,
      responseType = FirstNPrimeNumbersResponseChunk.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<FirstNPrimeNumbersRequest,
          FirstNPrimeNumbersResponseChunk> getGetFirstNPrimeNumbersMethod() {
    io.grpc.MethodDescriptor<FirstNPrimeNumbersRequest, FirstNPrimeNumbersResponseChunk> getGetFirstNPrimeNumbersMethod;
    if ((getGetFirstNPrimeNumbersMethod = PrimeNumbersServiceGrpc.getGetFirstNPrimeNumbersMethod) == null) {
      synchronized (PrimeNumbersServiceGrpc.class) {
        if ((getGetFirstNPrimeNumbersMethod = PrimeNumbersServiceGrpc.getGetFirstNPrimeNumbersMethod) == null) {
          PrimeNumbersServiceGrpc.getGetFirstNPrimeNumbersMethod = getGetFirstNPrimeNumbersMethod = 
              io.grpc.MethodDescriptor.<FirstNPrimeNumbersRequest, FirstNPrimeNumbersResponseChunk>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "PrimeNumbersService", "GetFirstNPrimeNumbers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FirstNPrimeNumbersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FirstNPrimeNumbersResponseChunk.getDefaultInstance()))
                  .setSchemaDescriptor(new PrimeNumbersServiceMethodDescriptorSupplier("GetFirstNPrimeNumbers"))
                  .build();
          }
        }
     }
     return getGetFirstNPrimeNumbersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<AreNumbersPrimeRequestChunk,
          AreNumbersPrimeResponse> getAreNumbersPrimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AreNumbersPrime",
      requestType = AreNumbersPrimeRequestChunk.class,
      responseType = AreNumbersPrimeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<AreNumbersPrimeRequestChunk,
          AreNumbersPrimeResponse> getAreNumbersPrimeMethod() {
    io.grpc.MethodDescriptor<AreNumbersPrimeRequestChunk, AreNumbersPrimeResponse> getAreNumbersPrimeMethod;
    if ((getAreNumbersPrimeMethod = PrimeNumbersServiceGrpc.getAreNumbersPrimeMethod) == null) {
      synchronized (PrimeNumbersServiceGrpc.class) {
        if ((getAreNumbersPrimeMethod = PrimeNumbersServiceGrpc.getAreNumbersPrimeMethod) == null) {
          PrimeNumbersServiceGrpc.getAreNumbersPrimeMethod = getAreNumbersPrimeMethod = 
              io.grpc.MethodDescriptor.<AreNumbersPrimeRequestChunk, AreNumbersPrimeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "PrimeNumbersService", "AreNumbersPrime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AreNumbersPrimeRequestChunk.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AreNumbersPrimeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PrimeNumbersServiceMethodDescriptorSupplier("AreNumbersPrime"))
                  .build();
          }
        }
     }
     return getAreNumbersPrimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<AreNumbersPrimeRequestChunk,
          AreNumbersPrimeModel> getAreNumbersPrimeAsyncMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AreNumbersPrimeAsync",
      requestType = AreNumbersPrimeRequestChunk.class,
      responseType = AreNumbersPrimeModel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<AreNumbersPrimeRequestChunk,
          AreNumbersPrimeModel> getAreNumbersPrimeAsyncMethod() {
    io.grpc.MethodDescriptor<AreNumbersPrimeRequestChunk, AreNumbersPrimeModel> getAreNumbersPrimeAsyncMethod;
    if ((getAreNumbersPrimeAsyncMethod = PrimeNumbersServiceGrpc.getAreNumbersPrimeAsyncMethod) == null) {
      synchronized (PrimeNumbersServiceGrpc.class) {
        if ((getAreNumbersPrimeAsyncMethod = PrimeNumbersServiceGrpc.getAreNumbersPrimeAsyncMethod) == null) {
          PrimeNumbersServiceGrpc.getAreNumbersPrimeAsyncMethod = getAreNumbersPrimeAsyncMethod = 
              io.grpc.MethodDescriptor.<AreNumbersPrimeRequestChunk, AreNumbersPrimeModel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "PrimeNumbersService", "AreNumbersPrimeAsync"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AreNumbersPrimeRequestChunk.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AreNumbersPrimeModel.getDefaultInstance()))
                  .setSchemaDescriptor(new PrimeNumbersServiceMethodDescriptorSupplier("AreNumbersPrimeAsync"))
                  .build();
          }
        }
     }
     return getAreNumbersPrimeAsyncMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PrimeNumbersServiceStub newStub(io.grpc.Channel channel) {
    return new PrimeNumbersServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PrimeNumbersServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PrimeNumbersServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PrimeNumbersServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PrimeNumbersServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PrimeNumbersServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getNthPrimeNumbers(NthPrimeNumberRequest request,
                                   io.grpc.stub.StreamObserver<NthPrimeNumberResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNthPrimeNumbersMethod(), responseObserver);
    }

    /**
     */
    public void getFirstNPrimeNumbers(FirstNPrimeNumbersRequest request,
                                      io.grpc.stub.StreamObserver<FirstNPrimeNumbersResponseChunk> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFirstNPrimeNumbersMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<AreNumbersPrimeRequestChunk> areNumbersPrime(
        io.grpc.stub.StreamObserver<AreNumbersPrimeResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAreNumbersPrimeMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<AreNumbersPrimeRequestChunk> areNumbersPrimeAsync(
        io.grpc.stub.StreamObserver<AreNumbersPrimeModel> responseObserver) {
      return asyncUnimplementedStreamingCall(getAreNumbersPrimeAsyncMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetNthPrimeNumbersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                      NthPrimeNumberRequest,
                      NthPrimeNumberResponse>(
                  this, METHODID_GET_NTH_PRIME_NUMBERS)))
          .addMethod(
            getGetFirstNPrimeNumbersMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                      FirstNPrimeNumbersRequest,
                      FirstNPrimeNumbersResponseChunk>(
                  this, METHODID_GET_FIRST_NPRIME_NUMBERS)))
          .addMethod(
            getAreNumbersPrimeMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                      AreNumbersPrimeRequestChunk,
                      AreNumbersPrimeResponse>(
                  this, METHODID_ARE_NUMBERS_PRIME)))
          .addMethod(
            getAreNumbersPrimeAsyncMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                      AreNumbersPrimeRequestChunk,
                      AreNumbersPrimeModel>(
                  this, METHODID_ARE_NUMBERS_PRIME_ASYNC)))
          .build();
    }
  }

  /**
   */
  public static final class PrimeNumbersServiceStub extends io.grpc.stub.AbstractStub<PrimeNumbersServiceStub> {
    private PrimeNumbersServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PrimeNumbersServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrimeNumbersServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PrimeNumbersServiceStub(channel, callOptions);
    }

    /**
     */
    public void getNthPrimeNumbers(NthPrimeNumberRequest request,
                                   io.grpc.stub.StreamObserver<NthPrimeNumberResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetNthPrimeNumbersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFirstNPrimeNumbers(FirstNPrimeNumbersRequest request,
                                      io.grpc.stub.StreamObserver<FirstNPrimeNumbersResponseChunk> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetFirstNPrimeNumbersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<AreNumbersPrimeRequestChunk> areNumbersPrime(
        io.grpc.stub.StreamObserver<AreNumbersPrimeResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAreNumbersPrimeMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<AreNumbersPrimeRequestChunk> areNumbersPrimeAsync(
        io.grpc.stub.StreamObserver<AreNumbersPrimeModel> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getAreNumbersPrimeAsyncMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class PrimeNumbersServiceBlockingStub extends io.grpc.stub.AbstractStub<PrimeNumbersServiceBlockingStub> {
    private PrimeNumbersServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PrimeNumbersServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrimeNumbersServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PrimeNumbersServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public NthPrimeNumberResponse getNthPrimeNumbers(NthPrimeNumberRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetNthPrimeNumbersMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<FirstNPrimeNumbersResponseChunk> getFirstNPrimeNumbers(
        FirstNPrimeNumbersRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetFirstNPrimeNumbersMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PrimeNumbersServiceFutureStub extends io.grpc.stub.AbstractStub<PrimeNumbersServiceFutureStub> {
    private PrimeNumbersServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PrimeNumbersServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrimeNumbersServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PrimeNumbersServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<NthPrimeNumberResponse> getNthPrimeNumbers(
        NthPrimeNumberRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetNthPrimeNumbersMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_NTH_PRIME_NUMBERS = 0;
  private static final int METHODID_GET_FIRST_NPRIME_NUMBERS = 1;
  private static final int METHODID_ARE_NUMBERS_PRIME = 2;
  private static final int METHODID_ARE_NUMBERS_PRIME_ASYNC = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PrimeNumbersServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PrimeNumbersServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_NTH_PRIME_NUMBERS:
          serviceImpl.getNthPrimeNumbers((NthPrimeNumberRequest) request,
              (io.grpc.stub.StreamObserver<NthPrimeNumberResponse>) responseObserver);
          break;
        case METHODID_GET_FIRST_NPRIME_NUMBERS:
          serviceImpl.getFirstNPrimeNumbers((FirstNPrimeNumbersRequest) request,
              (io.grpc.stub.StreamObserver<FirstNPrimeNumbersResponseChunk>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ARE_NUMBERS_PRIME:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.areNumbersPrime(
              (io.grpc.stub.StreamObserver<AreNumbersPrimeResponse>) responseObserver);
        case METHODID_ARE_NUMBERS_PRIME_ASYNC:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.areNumbersPrimeAsync(
              (io.grpc.stub.StreamObserver<AreNumbersPrimeModel>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PrimeNumbersServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PrimeNumbersServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return PrimeNumbers.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PrimeNumbersService");
    }
  }

  private static final class PrimeNumbersServiceFileDescriptorSupplier
      extends PrimeNumbersServiceBaseDescriptorSupplier {
    PrimeNumbersServiceFileDescriptorSupplier() {}
  }

  private static final class PrimeNumbersServiceMethodDescriptorSupplier
      extends PrimeNumbersServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PrimeNumbersServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PrimeNumbersServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PrimeNumbersServiceFileDescriptorSupplier())
              .addMethod(getGetNthPrimeNumbersMethod())
              .addMethod(getGetFirstNPrimeNumbersMethod())
              .addMethod(getAreNumbersPrimeMethod())
              .addMethod(getAreNumbersPrimeAsyncMethod())
              .build();
        }
      }
    }
    return result;
  }
}
