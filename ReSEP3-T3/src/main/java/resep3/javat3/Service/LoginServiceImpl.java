package resep3.javat3.Service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import resep3.javat3.model.User;


@GRpcService
public class LoginServiceImpl extends protobuffer.LoginServiceGrpc.LoginServiceImplBase {
    private final User user = new User();

    @Override
    public void login(protobuffer.LoginRequest request, StreamObserver<protobuffer.LoginResponse> responseObserver) {

        if (user.getUsername().equals(request.getUsername()) && user.getPassword().equals(request.getPassword())) {
            String successIGuess = request.getUsername() +" "+ request.getPassword();
            System.out.println("Received user" + successIGuess);

            protobuffer.LoginResponse response = protobuffer.LoginResponse.newBuilder().setMessage("Success").setSuccess(true).build();


            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
        else
        {
            System.out.println("Something went wrong, invalid credentials");
            // Handle the case when the credentials are invalid
            protobuffer.LoginResponse response = protobuffer.LoginResponse.newBuilder()
                    .setMessage("Invalid credentials")
                    .setSuccess(false)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}