package resep3.javat3.Repo.Interfaces;

import resep3.javat3.model.WorkoutPlan;

import java.util.ArrayList;

public interface IWorkoutRepo
{
    void createWorkoutPlan(WorkoutPlan workoutPlan);
    ArrayList<WorkoutPlan> getWorkoutPlans();
    void deleteWorkoutPlan(int id);
}
