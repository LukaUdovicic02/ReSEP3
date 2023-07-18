package resep3.javat3.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import resep3.javat3.Repo.Impl.WorkoutRepo;
import resep3.javat3.model.WorkoutPlan;
import resep3.javat3.protobuf.WorkoutPlanServiceGrpc;


@GRpcService
public class WorkoutPlanServiceImpl extends WorkoutPlanServiceGrpc.WorkoutPlanServiceImplBase
{

    private final WorkoutRepo workoutRepo;


    public WorkoutPlanServiceImpl() {
        this.workoutRepo = new WorkoutRepo();
    }

    @Override
    public void createWorkoutPlan(resep3.javat3.protobuf.WorkoutPlanRequest request , StreamObserver<resep3.javat3.protobuf.WorkoutPlanResponse> responseStreamObserver) {

        WorkoutPlan wp = new WorkoutPlan(request.getWpName(), request.getTimeGoal(), request.getType(), request.getUserID());

        try {
            workoutRepo.createWorkoutPlan(wp);

            resep3.javat3.protobuf.WorkoutPlanResponse response = resep3.javat3.protobuf.WorkoutPlanResponse
                    .newBuilder().setWpid(wp.getWpID()).build();

            responseStreamObserver.onNext(response);
            responseStreamObserver.onCompleted();

        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Could not create an workout plan");
        }

    }


}
