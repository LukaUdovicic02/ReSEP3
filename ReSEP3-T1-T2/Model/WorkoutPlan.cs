using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace Model
{
    public class WorkoutPlan
    {
        [JsonPropertyName("WPID")]
        private int Wpid { get; set; }
        
        
        [JsonPropertyName("WPname")]
        public string WPname { get; set; }  
        
        
        [JsonPropertyName("timegoal")]
        public int timegoal { get; set; }
        
        [JsonPropertyName("timegoal")]
        public string Type { get; set; }
        
        [JsonPropertyName("UserID")]
        public int UserID { get; set; }

        
        [ForeignKey("UserID")]
        public User User { get; set; }
 

        public WorkoutPlan(int wpid, string wPname, int timegoal, string type, int userId)
        {
            Wpid = wpid;
            WPname = wPname;
            this.timegoal = timegoal;
            Type = type;
            UserID = userId;
        }
    }
}