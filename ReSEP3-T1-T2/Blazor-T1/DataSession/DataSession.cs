using System;
using System.Threading.Tasks;
using Model;



public class DataSession
{
    private static readonly Lazy<DataSession> instance = new(() => new DataSession());

    public static DataSession Instance => instance.Value;

    public static LoginHttpClient HttpClient;

    public User User { get; set; }
    public WorkoutPlan WorkoutPlan { get; private set; }

    private DataSession()
    {
        User = new User();
        HttpClient = new LoginHttpClient();
        WorkoutPlan = new WorkoutPlan();
        
    }

    public static async Task CreateInstance(User user)
    {
        Instance.User = user;
        //Instance.WorkoutPlan = HttpClient.GetWpByUserID(user.Uid);
    }
    
    
    
}