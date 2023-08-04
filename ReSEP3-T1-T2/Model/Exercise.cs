using System.Text.Json.Serialization;

namespace Model
{
    public class Exercise
    {
        [JsonPropertyName("eId")] public int EId { get; set; }
        [JsonPropertyName("EName")] public string EName { get; set; }
        [JsonPropertyName("nrOfSets")] public int NrOfSets { get; set; }
        [JsonPropertyName("nrOfReps")] public int NrOfReps { get; set; }

        [JsonPropertyName("WorkoutPlanID")] public int WorkoutPlanId { get; set; }


        public Exercise()
        {
        }

        public Exercise(string eName, int nrOfSets, int nrOfReps, int workoutPlanId)
        {
            EName = eName;
            NrOfSets = nrOfSets;
            NrOfReps = nrOfReps;
            WorkoutPlanId = workoutPlanId;
        }
 
        public Exercise(int eid,string eName, int nrOfSets, int nrOfReps, int workoutPlanId)
        {
            EName = eName;
            NrOfSets = nrOfSets;
            NrOfReps = nrOfReps;
            WorkoutPlanId = workoutPlanId;
            EId = eid;
        }

        public Exercise(int eId, string eName, int nrOfSets, int nrOfReps)
        {
            EId = eId;
            EName = eName;
            NrOfReps = nrOfReps;
            NrOfSets = nrOfSets;
        }
    }
}