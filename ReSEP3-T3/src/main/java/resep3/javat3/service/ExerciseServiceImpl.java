package resep3.javat3.service;


import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import resep3.javat3.Repo.Impl.ExerciseRepo;
import resep3.javat3.model.Exercise;
import resep3.javat3.protobuf.ExerciseServiceGrpc;

import java.sql.SQLException;
import java.util.ArrayList;

@GRpcService
public class ExerciseServiceImpl extends ExerciseServiceGrpc.ExerciseServiceImplBase {
    private final ExerciseRepo exerciseRepo;

    public ExerciseServiceImpl(ExerciseRepo exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }


    @Override
    public void createExercise(resep3.javat3.protobuf.CreateExerciseRequest request, StreamObserver<resep3.javat3.protobuf.CreateExerciseResponse> responseStreamObserver) {
        Exercise exercise = new Exercise(request.getEName(), request.getNrOfSets(), request.getNrOfReps(), request.getWorkoutId());

        try {
            exerciseRepo.CreateExercise(exercise);

            resep3.javat3.protobuf.CreateExerciseResponse response = resep3.javat3.protobuf.CreateExerciseResponse.newBuilder().setEid(exercise.getEid()).build();

            responseStreamObserver.onNext(response);
            responseStreamObserver.onCompleted();

            System.out.println("Exercise created");

        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Could not create exercise");
        }
    }




    @Override
    public void getAllExercises(resep3.javat3.protobuf.GetAllExercisesRequest request, StreamObserver<resep3.javat3.protobuf.GetAllExerciseResponse> streamObserver) {

        try {
            ArrayList<Exercise> exercises = exerciseRepo.GetAllExercises();

            resep3.javat3.protobuf.GetAllExerciseResponse.Builder responseBuilder = resep3.javat3.protobuf.GetAllExerciseResponse.newBuilder();

            for (Exercise exercise : exercises) {
                resep3.javat3.protobuf.EData data = resep3.javat3.protobuf.EData.newBuilder()
                        .setEid(exercise.getEid())
                        .setEName(exercise.getEName())
                        .setNrOfReps(exercise.getNrOfReps())
                        .setNrOfSets(exercise.getNrOfSets())
                        .setWorkoutId(exercise.getWorkoutId())
                        .build();

                responseBuilder.addData(data);
            }

            resep3.javat3.protobuf.GetAllExerciseResponse response = responseBuilder.build();
            streamObserver.onNext(response);


            System.out.println("All exercises have been fetched");
            streamObserver.onCompleted();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("All exercises cannot be fetched");
            streamObserver.onError(e);
        }
    }

    @Override
    public void deleteExercise(resep3.javat3.protobuf.DeleteExerciseRequest request, StreamObserver<resep3.javat3.protobuf.empty> streamObserver) {
        try {

            exerciseRepo.DeleteExercise(request.getEid());

            streamObserver.onNext(null);
            streamObserver.onCompleted();
            System.out.println("exercise deleted");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("exercise cannot be deleted");
        }
    }


    @Override
    public void getExByWid(resep3.javat3.protobuf.getExByWidRequest request, StreamObserver<resep3.javat3.protobuf.getExByWidResponse> streamObserver) {
        try {
            ArrayList<Exercise> exercises = exerciseRepo.getExByWpid(request.getWpid());

            resep3.javat3.protobuf.getExByWidResponse.Builder responseBuilder = resep3.javat3.protobuf.getExByWidResponse.newBuilder();
            for (Exercise e : exercises) {
                resep3.javat3.protobuf.EData data = resep3.javat3.protobuf.EData.newBuilder().
                        setEid(e.getEid()).
                        setEName(e.getEName()).
                        setNrOfReps(e.getNrOfReps()).
                        setNrOfSets(e.getNrOfSets()).
                        setWorkoutId(e.getWorkoutId()).
                        build();
                responseBuilder.addData(data);
            }

            resep3.javat3.protobuf.getExByWidResponse response = responseBuilder.build();
            streamObserver.onNext(response);
            streamObserver.onCompleted();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
