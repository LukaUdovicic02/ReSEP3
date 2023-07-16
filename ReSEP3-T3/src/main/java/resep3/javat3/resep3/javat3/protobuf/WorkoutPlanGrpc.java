package resep3.javat3.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: WorkoutPlan.proto")
public final class WorkoutPlanGrpc {

  private WorkoutPlanGrpc() {}

  public static final String SERVICE_NAME = "WorkoutPlan";

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
    if ((getCreateWorkoutPlanMethod = WorkoutPlanGrpc.getCreateWorkoutPlanMethod) == null) {
      synchronized (WorkoutPlanGrpc.class) {
        if ((getCreateWorkoutPlanMethod = WorkoutPlanGrpc.getCreateWorkoutPlanMethod) == null) {
          WorkoutPlanGrpc.getCreateWorkoutPlanMethod = getCreateWorkoutPlanMethod =
              io.grpc.MethodDescriptor.<resep3.javat3.protobuf.WorkoutPlanRequest, resep3.javat3.protobuf.WorkoutPlanResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createWorkoutPlan"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  resep3.javat3.protobuf.WorkoutPlanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  resep3.javat3.protobuf.WorkoutPlanResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WorkoutPlanMethodDescriptorSupplier("createWorkoutPlan"))
              .build();
        }
      }
    }
    return getCreateWorkoutPlanMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WorkoutPlanStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkoutPlanStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkoutPlanStub>() {
        @java.lang.Override
        public WorkoutPlanStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkoutPlanStub(channel, callOptions);
        }
      };
    return WorkoutPlanStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WorkoutPlanBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkoutPlanBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkoutPlanBlockingStub>() {
        @java.lang.Override
        public WorkoutPlanBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkoutPlanBlockingStub(channel, callOptions);
        }
      };
    return WorkoutPlanBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WorkoutPlanFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkoutPlanFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkoutPlanFutureStub>() {
        @java.lang.Override
        public WorkoutPlanFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkoutPlanFutureStub(channel, callOptions);
        }
      };
    return WorkoutPlanFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class WorkoutPlanImplBase implements io.grpc.BindableService {

    /**
     */
    public void createWorkoutPlan(resep3.javat3.protobuf.WorkoutPlanRequest request,
        io.grpc.stub.StreamObserver<resep3.javat3.protobuf.WorkoutPlanResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateWorkoutPlanMethod(), responseObserver);
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
          .build();
    }
  }

  /**
   */
  public static final class WorkoutPlanStub extends io.grpc.stub.AbstractAsyncStub<WorkoutPlanStub> {
    private WorkoutPlanStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkoutPlanStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkoutPlanStub(channel, callOptions);
    }

    /**
     */
    public void createWorkoutPlan(resep3.javat3.protobuf.WorkoutPlanRequest request,
        io.grpc.stub.StreamObserver<resep3.javat3.protobuf.WorkoutPlanResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWorkoutPlanMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WorkoutPlanBlockingStub extends io.grpc.stub.AbstractBlockingStub<WorkoutPlanBlockingStub> {
    private WorkoutPlanBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkoutPlanBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkoutPlanBlockingStub(channel, callOptions);
    }

    /**
     */
    public resep3.javat3.protobuf.WorkoutPlanResponse createWorkoutPlan(resep3.javat3.protobuf.WorkoutPlanRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWorkoutPlanMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WorkoutPlanFutureStub extends io.grpc.stub.AbstractFutureStub<WorkoutPlanFutureStub> {
    private WorkoutPlanFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkoutPlanFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkoutPlanFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<resep3.javat3.protobuf.WorkoutPlanResponse> createWorkoutPlan(
        resep3.javat3.protobuf.WorkoutPlanRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWorkoutPlanMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_WORKOUT_PLAN = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WorkoutPlanImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WorkoutPlanImplBase serviceImpl, int methodId) {
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

  private static abstract class WorkoutPlanBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WorkoutPlanBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return resep3.javat3.protobuf.WorkoutPlanOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WorkoutPlan");
    }
  }

  private static final class WorkoutPlanFileDescriptorSupplier
      extends WorkoutPlanBaseDescriptorSupplier {
    WorkoutPlanFileDescriptorSupplier() {}
  }

  private static final class WorkoutPlanMethodDescriptorSupplier
      extends WorkoutPlanBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WorkoutPlanMethodDescriptorSupplier(String methodName) {
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
      synchronized (WorkoutPlanGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WorkoutPlanFileDescriptorSupplier())
              .addMethod(getCreateWorkoutPlanMethod())
              .build();
        }
      }
    }
    return result;
  }
}
