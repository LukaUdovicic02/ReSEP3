package resep3.javat3.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: WorkoutPlan.proto")
public final class WorkoutPlanServiceGrpc {

  private WorkoutPlanServiceGrpc() {}

  public static final String SERVICE_NAME = "WorkoutPlanService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<resep3.javat3.protobuf.WorkoutPlanRequest,
      resep3.javat3.protobuf.WorkoutPlanResponse> getCreateWorkoutPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createWorkoutPlan",
      requestType = resep3.javat3.protobuf.WorkoutPlanRequest.class,
      responseType = resep3.javat3.protobuf.WorkoutPlanResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<resep3.javat3.protobuf.WorkoutPlanRequest,
      resep3.javat3.protobuf.WorkoutPlanResponse> getCreateWorkoutPlanMethod() {
    io.grpc.MethodDescriptor<resep3.javat3.protobuf.WorkoutPlanRequest, resep3.javat3.protobuf.WorkoutPlanResponse> getCreateWorkoutPlanMethod;
    if ((getCreateWorkoutPlanMethod = WorkoutPlanServiceGrpc.getCreateWorkoutPlanMethod) == null) {
      synchronized (WorkoutPlanServiceGrpc.class) {
        if ((getCreateWorkoutPlanMethod = WorkoutPlanServiceGrpc.getCreateWorkoutPlanMethod) == null) {
          WorkoutPlanServiceGrpc.getCreateWorkoutPlanMethod = getCreateWorkoutPlanMethod =
              io.grpc.MethodDescriptor.<resep3.javat3.protobuf.WorkoutPlanRequest, resep3.javat3.protobuf.WorkoutPlanResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createWorkoutPlan"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  resep3.javat3.protobuf.WorkoutPlanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  resep3.javat3.protobuf.WorkoutPlanResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WorkoutPlanServiceMethodDescriptorSupplier("createWorkoutPlan"))
              .build();
        }
      }
    }
    return getCreateWorkoutPlanMethod;
  }

  private static volatile io.grpc.MethodDescriptor<resep3.javat3.protobuf.GetWorkoutPlanRequest,
      resep3.javat3.protobuf.GetWorkoutPlanResponse> getGetWorkoutPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getWorkoutPlan",
      requestType = resep3.javat3.protobuf.GetWorkoutPlanRequest.class,
      responseType = resep3.javat3.protobuf.GetWorkoutPlanResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<resep3.javat3.protobuf.GetWorkoutPlanRequest,
      resep3.javat3.protobuf.GetWorkoutPlanResponse> getGetWorkoutPlanMethod() {
    io.grpc.MethodDescriptor<resep3.javat3.protobuf.GetWorkoutPlanRequest, resep3.javat3.protobuf.GetWorkoutPlanResponse> getGetWorkoutPlanMethod;
    if ((getGetWorkoutPlanMethod = WorkoutPlanServiceGrpc.getGetWorkoutPlanMethod) == null) {
      synchronized (WorkoutPlanServiceGrpc.class) {
        if ((getGetWorkoutPlanMethod = WorkoutPlanServiceGrpc.getGetWorkoutPlanMethod) == null) {
          WorkoutPlanServiceGrpc.getGetWorkoutPlanMethod = getGetWorkoutPlanMethod =
              io.grpc.MethodDescriptor.<resep3.javat3.protobuf.GetWorkoutPlanRequest, resep3.javat3.protobuf.GetWorkoutPlanResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getWorkoutPlan"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  resep3.javat3.protobuf.GetWorkoutPlanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  resep3.javat3.protobuf.GetWorkoutPlanResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WorkoutPlanServiceMethodDescriptorSupplier("getWorkoutPlan"))
              .build();
        }
      }
    }
    return getGetWorkoutPlanMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WorkoutPlanServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkoutPlanServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkoutPlanServiceStub>() {
        @java.lang.Override
        public WorkoutPlanServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkoutPlanServiceStub(channel, callOptions);
        }
      };
    return WorkoutPlanServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WorkoutPlanServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkoutPlanServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkoutPlanServiceBlockingStub>() {
        @java.lang.Override
        public WorkoutPlanServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkoutPlanServiceBlockingStub(channel, callOptions);
        }
      };
    return WorkoutPlanServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WorkoutPlanServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkoutPlanServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkoutPlanServiceFutureStub>() {
        @java.lang.Override
        public WorkoutPlanServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkoutPlanServiceFutureStub(channel, callOptions);
        }
      };
    return WorkoutPlanServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class WorkoutPlanServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createWorkoutPlan(resep3.javat3.protobuf.WorkoutPlanRequest request,
        io.grpc.stub.StreamObserver<resep3.javat3.protobuf.WorkoutPlanResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateWorkoutPlanMethod(), responseObserver);
    }

    /**
     */
    public void getWorkoutPlan(resep3.javat3.protobuf.GetWorkoutPlanRequest request,
        io.grpc.stub.StreamObserver<resep3.javat3.protobuf.GetWorkoutPlanResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWorkoutPlanMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateWorkoutPlanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                resep3.javat3.protobuf.WorkoutPlanRequest,
                resep3.javat3.protobuf.WorkoutPlanResponse>(
                  this, METHODID_CREATE_WORKOUT_PLAN)))
          .addMethod(
            getGetWorkoutPlanMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                resep3.javat3.protobuf.GetWorkoutPlanRequest,
                resep3.javat3.protobuf.GetWorkoutPlanResponse>(
                  this, METHODID_GET_WORKOUT_PLAN)))
          .build();
    }
  }

  /**
   */
  public static final class WorkoutPlanServiceStub extends io.grpc.stub.AbstractAsyncStub<WorkoutPlanServiceStub> {
    private WorkoutPlanServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkoutPlanServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkoutPlanServiceStub(channel, callOptions);
    }

    /**
     */
    public void createWorkoutPlan(resep3.javat3.protobuf.WorkoutPlanRequest request,
        io.grpc.stub.StreamObserver<resep3.javat3.protobuf.WorkoutPlanResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWorkoutPlanMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getWorkoutPlan(resep3.javat3.protobuf.GetWorkoutPlanRequest request,
        io.grpc.stub.StreamObserver<resep3.javat3.protobuf.GetWorkoutPlanResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWorkoutPlanMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WorkoutPlanServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<WorkoutPlanServiceBlockingStub> {
    private WorkoutPlanServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkoutPlanServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkoutPlanServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public resep3.javat3.protobuf.WorkoutPlanResponse createWorkoutPlan(resep3.javat3.protobuf.WorkoutPlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWorkoutPlanMethod(), getCallOptions(), request);
    }

    /**
     */
    public resep3.javat3.protobuf.GetWorkoutPlanResponse getWorkoutPlan(resep3.javat3.protobuf.GetWorkoutPlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWorkoutPlanMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WorkoutPlanServiceFutureStub extends io.grpc.stub.AbstractFutureStub<WorkoutPlanServiceFutureStub> {
    private WorkoutPlanServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkoutPlanServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkoutPlanServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<resep3.javat3.protobuf.WorkoutPlanResponse> createWorkoutPlan(
        resep3.javat3.protobuf.WorkoutPlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWorkoutPlanMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<resep3.javat3.protobuf.GetWorkoutPlanResponse> getWorkoutPlan(
        resep3.javat3.protobuf.GetWorkoutPlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWorkoutPlanMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_WORKOUT_PLAN = 0;
  private static final int METHODID_GET_WORKOUT_PLAN = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WorkoutPlanServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WorkoutPlanServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_WORKOUT_PLAN:
          serviceImpl.createWorkoutPlan((resep3.javat3.protobuf.WorkoutPlanRequest) request,
              (io.grpc.stub.StreamObserver<resep3.javat3.protobuf.WorkoutPlanResponse>) responseObserver);
          break;
        case METHODID_GET_WORKOUT_PLAN:
          serviceImpl.getWorkoutPlan((resep3.javat3.protobuf.GetWorkoutPlanRequest) request,
              (io.grpc.stub.StreamObserver<resep3.javat3.protobuf.GetWorkoutPlanResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class WorkoutPlanServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WorkoutPlanServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return resep3.javat3.protobuf.WorkoutPlan.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WorkoutPlanService");
    }
  }

  private static final class WorkoutPlanServiceFileDescriptorSupplier
      extends WorkoutPlanServiceBaseDescriptorSupplier {
    WorkoutPlanServiceFileDescriptorSupplier() {}
  }

  private static final class WorkoutPlanServiceMethodDescriptorSupplier
      extends WorkoutPlanServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WorkoutPlanServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (WorkoutPlanServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WorkoutPlanServiceFileDescriptorSupplier())
              .addMethod(getCreateWorkoutPlanMethod())
              .addMethod(getGetWorkoutPlanMethod())
              .build();
        }
      }
    }
    return result;
  }
}
