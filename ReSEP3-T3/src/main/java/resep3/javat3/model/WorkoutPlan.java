package resep3.javat3.model;

public class WorkoutPlan
{
    private int wpID;
    private String wpName;
    private int timeGoal;
    private String type;
    private int userID;


    public WorkoutPlan(int wpID, String wpName, int timeGoal, String type, int userID) {
        this.wpID = wpID;
        this.wpName = wpName;
        this.timeGoal = timeGoal;
        this.type = type;
        this.userID = userID;
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
