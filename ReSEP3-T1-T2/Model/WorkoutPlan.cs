using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace Model
{
    public class WorkoutPlan
    {
        [JsonPropertyName("wpid")] public int Wpid { get; set; }

        [JsonPropertyName("wpname")] public string WPname { get; set; }

        [JsonPropertyName("timegoal")] public int Timegoal { get; set; }

        [JsonPropertyName("type")] public string Type { get; set; }

        [JsonPropertyName("userid")] public int UserID { get; set; }

        
        public WorkoutPlan()
        {
        }

        public WorkoutPlan(int wpid, string wPname, int timegoal, string type, int userId)
        {
            Wpid = wpid;
            WPname = wPname;
            Timegoal = timegoal;
            Type = type;
            UserID = userId;
        }

        public WorkoutPlan(string wPname, int timegoal, string type)
        {
            WPname = wPname;
            Timegoal = timegoal;
            Type = type;
        }
    }
}