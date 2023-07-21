package resep3.javat3.model;

public class WorkoutPlan
{
    private int wpID;
    private String wpName;
    private int timeGoal;
    private String type;
    private int userID;
    private User user;


    public WorkoutPlan( String wpName, int timeGoal, String type, int userID) {

        this.wpName = wpName;
        this.timeGoal = timeGoal;
        this.type = type;
        this.userID = userID;
        user = new User();
    }
    public WorkoutPlan() {
    }

    public WorkoutPlan(int userid) {
        userID = userid;
    }


    public int getWpID() {
        return wpID;
    }

    public void setWpID(int wpID) {
        this.wpID = wpID;
    }

    public String getWpName() {
        return wpName;
    }

    public void setWpName(String wpName) {
        this.wpName = wpName;
    }

    public int getTimeGoal() {
        return timeGoal;
    }

    public void setTimeGoal(int timeGoal) {
        this.timeGoal = timeGoal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
