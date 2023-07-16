package resep3.javat3.service;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import resep3.javat3.Repo.Impl.UserRepo;
import resep3.javat3.model.User;

import java.sql.SQLException;


@GRpcService
public class LoginServiceImpl extends resep3.javat3.protobuf.LoginServiceGrpc.LoginServiceImplBase {


    private final UserRepo userRepo;

    public LoginServiceImpl() {
        this.userRepo = new UserRepo();
    }

    @Override
    public  void login(resep3.javat3.protobuf.LoginRequest request, StreamObserver<resep3.javat3.protobuf.LoginResponse> responseObserver) {
        try {
            User user = userRepo.getUserByUsernameAndPassword(request.getUsername(), request.getPassword());

            if (user != null) {

                resep3.javat3.protobuf.LoginResponse response = resep3.javat3.protobuf.LoginResponse.newBuilder()
                        .setMessage("Success")
                        .setSuccess(true)
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } else {

                resep3.javat3.protobuf.LoginResponse response = resep3.javat3.protobuf.LoginResponse.newBuilder()
                        .setMessage("Invalid credentials")
                        .setSuccess(false)
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        } catch (SQLException e) {
            System.out.println("Failed to get user from the database.");
            e.printStackTrace();
        }
    }
}