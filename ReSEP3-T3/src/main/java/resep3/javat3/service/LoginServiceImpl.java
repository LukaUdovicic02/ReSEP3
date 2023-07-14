package resep3.javat3.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import resep3.javat3.model.User;


@GRpcService
public class LoginServiceImpl extends resep3.javat3.protobuf.LoginServiceGrpc.LoginServiceImplBase {
    private final User user = new User();

    @Override
    public void login(resep3.javat3.protobuf.LoginRequest request, StreamObserver<resep3.javat3.protobuf.LoginResponse> responseObserver) {

        if (user.getUsername().equals(request.getUsername()) && user.getPassword().equals(request.getPassword())) {
            String successIGuess = request.getUsername() +" "+ request.getPassword();
            System.out.println("Received user" + successIGuess);

            resep3.javat3.protobuf.LoginResponse response = resep3.javat3.protobuf.LoginResponse.newBuilder().setMessage("Success").setSuccess(true).build();


            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
        else
        {
            System.out.println("Something went wrong, invalid credentials");
            // Handle the case when the credentials are invalid
            resep3.javat3.protobuf.LoginResponse response = resep3.javat3.protobuf.LoginResponse.newBuilder()
                    .setMessage("Invalid credentials")
                    .setSuccess(false)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}