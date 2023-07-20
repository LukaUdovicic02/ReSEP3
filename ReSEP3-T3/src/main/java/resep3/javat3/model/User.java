package resep3.javat3.model;

import java.util.ArrayList;

public class User
{
    private int uid;
    private String username;
    private String password;
    private float bodyWeight;
    private float fatPercentage;
    private ArrayList<WorkoutPlan> workoutPlans;

    public ArrayList<WorkoutPlan> getWorkoutPlans() {
        return workoutPlans;
    }

    public void setWorkoutPlans(ArrayList<WorkoutPlan> workoutPlans) {
        this.workoutPlans = workoutPlans;
    }

    public User(int uid, String username, String password, float bodyWeight, float fatPercentage, ArrayList<WorkoutPlan> workoutPlans) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.bodyWeight = bodyWeight;
        this.fatPercentage = fatPercentage;
        this.workoutPlans = workoutPlans;
    }

    public User()
    {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public User(int uid, String username, String password,float bodyWeight,float fatPercentage  ) {
        this.username = username;
        this.password = password;
        this.uid = uid;
        this.bodyWeight = bodyWeight;
        this.fatPercentage = fatPercentage;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
