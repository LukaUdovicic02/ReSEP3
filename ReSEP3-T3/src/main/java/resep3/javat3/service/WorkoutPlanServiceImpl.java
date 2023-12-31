package resep3.javat3.service;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import resep3.javat3.Repo.Impl.WorkoutRepo;
import resep3.javat3.model.WorkoutPlan;
import resep3.javat3.protobuf.WorkoutPlanServiceGrpc;

import java.util.ArrayList;


@GRpcService
public class WorkoutPlanServiceImpl extends WorkoutPlanServiceGrpc.WorkoutPlanServiceImplBase {

    private final WorkoutRepo workoutRepo;


    public WorkoutPlanServiceImpl() {
        this.workoutRepo = new WorkoutRepo();
    }

    @Override
    public void createWorkoutPlan(resep3.javat3.protobuf.WorkoutPlanRequest request, StreamObserver<resep3.javat3.protobuf.WorkoutPlanResponse> responseStreamObserver) {

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


    @Override
    public void getWorkoutPlan(resep3.javat3.protobuf.GetWorkoutPlanRequest request, StreamObserver<resep3.javat3.protobuf.GetWorkoutPlanResponse> responseStreamObserver) {

        try {
            ArrayList<WorkoutPlan> workoutPlans = workoutRepo.getWorkoutPlans();

            resep3.javat3.protobuf.GetWorkoutPlanResponse.Builder responseBuilder = resep3.javat3.protobuf.GetWorkoutPlanResponse.newBuilder();
            for (WorkoutPlan workoutPlan : workoutPlans) {
                resep3.javat3.protobuf.WPData data = resep3.javat3.protobuf.WPData.newBuilder()
                        .setWpid(workoutPlan.getWpID())
                        .setWpname(workoutPlan.getWpName())
                        .setTimegoal(workoutPlan.getTimeGoal())
                        .setType(workoutPlan.getType())
                        .setUserid(workoutPlan.getUserID())
                        .build();
                responseBuilder.addData(data);
            }

            resep3.javat3.protobuf.GetWorkoutPlanResponse response = responseBuilder.build();
            responseStreamObserver.onNext(response);
            responseStreamObserver.onCompleted();

        } catch
        (Exception e) {
            e.printStackTrace();

            System.out.println("could not fetch workout plans");
        }
    }

    @Override
    public void deleteWorkoutPlan(resep3.javat3.protobuf.DeleteWorkoutPlanRequest request, StreamObserver<resep3.javat3.protobuf.empty> streamObserver) {
        try {
            workoutRepo.deleteWorkoutPlan(request.getWpid());
            streamObserver.onNext(null);
            streamObserver.onCompleted();

        } catch
        (Exception e) {
            e.printStackTrace();
            System.out.println("could not delete workout plan");
        }
    }


    @Override
    public void updateWorkoutPlan(resep3.javat3.protobuf.UpdateWorkoutPlanRequest request, StreamObserver<resep3.javat3.protobuf.UpdateWorkoutPlanResponse> responseStreamObserver) {
        WorkoutPlan workoutPlan = new WorkoutPlan(request.getWpid(), request.getWpname(), request.getTimegoal(), request.getType(), request.getUserid());

        try {

            workoutRepo.updateWorkoutPlan(workoutPlan);
            resep3.javat3.protobuf.UpdateWorkoutPlanResponse response = resep3.javat3.protobuf.UpdateWorkoutPlanResponse.newBuilder().setWpid(workoutPlan.getWpID()).build();

            responseStreamObserver.onNext(response);
            responseStreamObserver.onCompleted();

            System.out.println("Workout plan has been updated");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("could not update the workout plan");
        }
    }


    @Override
    public void getWorkoutPlanById(resep3.javat3.protobuf.GetWorkoutPlanRequest request, StreamObserver<resep3.javat3.protobuf.GetWorkoutPlanResponse> streamObserver) {

        try {
            WorkoutPlan workoutPlan = workoutRepo.getWorkoutPlanById(request.getWpid());


            resep3.javat3.protobuf.WPData wpData = resep3.javat3.protobuf.WPData.newBuilder().setWpid(workoutPlan.getWpID()).setWpname(workoutPlan.getWpName())
                    .setTimegoal(workoutPlan.getTimeGoal()).setType(workoutPlan.getType()).setUserid(workoutPlan.getUserID()).build();


            resep3.javat3.protobuf.GetWorkoutPlanResponse response = resep3.javat3.protobuf.GetWorkoutPlanResponse.newBuilder().addData(wpData).build();

            streamObserver.onNext(response);
            streamObserver.onCompleted();

            System.out.println("Workout plan has been fetched");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not fetch the workout plan");
        }
    }

}
