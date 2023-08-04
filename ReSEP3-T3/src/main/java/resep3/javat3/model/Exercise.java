package resep3.javat3.model;

public class Exercise {

    private int Eid;
    private String EName;
    private int NrOfSets;
    private int NrOfReps;
    private int WorkoutId;

    public Exercise(String EName, int nrOfSets, int nrOfReps, int workoutId) {

        this.EName = EName;
        NrOfSets = nrOfSets;
        NrOfReps = nrOfReps;
        WorkoutId = workoutId;
    }

    public Exercise() {

    }

    public int getEid() {
        return Eid;
    }

    public void setEid(int eid) {
        Eid = eid;
    }

    public String getEName() {
        return EName;
    }

    public void setEName(String EName) {
        this.EName = EName;
    }

    public int getNrOfSets() {
        return NrOfSets;
    }

    public void setNrOfSets(int nrOfSets) {
        NrOfSets = nrOfSets;
    }

    public int getNrOfReps() {
        return NrOfReps;
    }

    public void setNrOfReps(int nrOfReps) {
        NrOfReps = nrOfReps;
    }

    public int getWorkoutId() {
        return WorkoutId;
    }

    public void setWorkoutId(int workoutId) {
        WorkoutId = workoutId;
    }
}
