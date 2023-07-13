using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace Model
{
    public class User
    {
        public int Id { get; set; }

        [Required]
        [JsonPropertyName("username")]
        public string Username { get; set; }

        [Required]
        [JsonPropertyName("password")]
        public string Password { get; set; }


        public User(string username, string password)
        {
            this.Username = username;
            this.Password = password;
        }
    }
}