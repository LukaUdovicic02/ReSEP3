using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace Model
{
    public class User
    {
        [JsonPropertyName("UID")]
        [Key]
        public int Uid { get; set; }

        [Required]
        [JsonPropertyName("username")]
        public string Username { get; set; }

        [Required]
        [JsonPropertyName("password")]
        public string Password { get; set; }

        [JsonPropertyName("bodyWeight")]
        public float BodyWeight { get; set; }

        [JsonPropertyName("fatPercentage")]
        public float FatPercentage { get; set; }
        
        public bool IsAuthenticated { get; set; }
        
        
        public IEnumerable<WorkoutPlan> WorkoutPlans { get; set; }

        public User(int uid, string username, string password, float bodyWeight, float fatPercentage, IList<WorkoutPlan> workoutPlans)
        {
            Uid = uid;
            Username = username;
            Password = password;
            BodyWeight = bodyWeight;
            FatPercentage = fatPercentage;
            WorkoutPlans = workoutPlans;
        }

        public User()
        {
        }

        public User(string username,string password )
        {
            this.Username = username;
            this.Password = password;
        } 
        public User(int id, string username,string password )
        {
            this.Uid = id;
            this.Username = username;
            this.Password = password;
        }

        public User(int uid,string username, string password, float body,float fat)
        {
            Uid = uid;
            Username = username;
            Password = password;
            BodyWeight = body;
            FatPercentage = fat;
        }


    }
}