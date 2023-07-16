package resep3.javat3.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import resep3.javat3.Repo.Impl.UserRepo;
import resep3.javat3.model.User;


@GRpcService
public class RegisterServiceImpl extends resep3.javat3.protobuf.RegisterServiceGrpc.RegisterServiceImplBase {

    private final UserRepo userRepo;

    public RegisterServiceImpl() {
        this.userRepo = new UserRepo();
    }

    @Override
    public void register(resep3.javat3.protobuf.RegisterRequest request, StreamObserver<resep3.javat3.protobuf.RegisterResponse> responseStreamObserver) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());


        try {
            user = userRepo.createUser(user);

            resep3.javat3.protobuf.RegisterResponse response = resep3.javat3.protobuf.RegisterResponse.newBuilder().
                    setMessage("Account has been created").
                    setSuccess(true).
                    build();

            responseStreamObserver.onNext(response);
            responseStreamObserver.onCompleted();

        } catch (Exception e) {

            resep3.javat3.protobuf.RegisterResponse response = resep3.javat3.protobuf.RegisterResponse.newBuilder().
                    setMessage("Account has been not created").
                    setSuccess(false).
                    build();

            responseStreamObserver.onNext(response);
            responseStreamObserver.onCompleted();

        }
    }


}

