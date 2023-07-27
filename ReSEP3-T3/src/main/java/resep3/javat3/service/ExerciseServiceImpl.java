package resep3.javat3.service;


import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import resep3.javat3.Repo.Impl.ExerciseRepo;
import resep3.javat3.model.Exercise;
import resep3.javat3.protobuf.ExerciseServiceGrpc;

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

            for (Exercise exercise : exercises) {
                resep3.javat3.protobuf.GetAllExerciseResponse responseBuilder = resep3.javat3.protobuf.GetAllExerciseResponse.newBuilder()
                        .setEid(exercise.getEid())
                        .setEName(exercise.getEName())
                        .setNrOfReps(exercise.getNrOfReps())
                        .setNrOfSets(exercise.getNrOfSets())
                        .setWorkoutId(exercise.getWorkoutId())
                        .build();


                streamObserver.onNext(responseBuilder);
            }

            System.out.println("All exercises has been fetch");
            streamObserver.onCompleted();



        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("All exercises can not be fetched");

        }


    }


}
