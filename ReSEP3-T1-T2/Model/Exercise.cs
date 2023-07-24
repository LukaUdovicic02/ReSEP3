using System.Text.Json.Serialization;

namespace Model;

public class Exercise
{
    [JsonPropertyName("eId")] public int EId { get; set; }

    [JsonPropertyName("eName")] public string EName { get; set; }

    [JsonPropertyName("nrOfSets")] public int NrOfSets { get; set; }

    [JsonPropertyName("nrOfReps")] public int NrOfReps { get; set; }

    public Exercise()
    {
    }

    public Exercise(int eId, string eName, int nrOfSets, int nrOfReps)
    {
        EId = eId;
        EName = eName;
        NrOfSets = nrOfSets;
        NrOfReps = nrOfReps;
    }
}