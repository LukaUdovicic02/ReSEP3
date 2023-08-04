using System;
using System.Threading.Tasks;
using Model;


public class DataSession
{
    private static readonly Lazy<DataSession> instance = new(() => new DataSession());

    public static DataSession Instance => instance.Value;
 
    public User User { get; set; }
    public bool IsAuthenticated { get; private set; }
    public WorkoutPlan WorkoutPlan { get; set; }

    private DataSession()
    {
        User = new User();
        WorkoutPlan = new WorkoutPlan();
    }

    public static async Task CreateInstance(User user)
    {
        Instance.User = user;
        Instance.IsAuthenticated = true;
        
    
    }

    public static async Task CreateWorkoutInstance(WorkoutPlan workoutPlan)
    {
        Instance.WorkoutPlan = workoutPlan;
        
    }

    public static async Task DeleteInstance()
    {
        Instance.User = null;
        Instance.IsAuthenticated = false;
    }
    
    
    
}