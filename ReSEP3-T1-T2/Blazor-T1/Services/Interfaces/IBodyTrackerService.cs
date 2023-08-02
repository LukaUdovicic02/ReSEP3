

using Model;

public interface IBodyTrackerService
{   
  
    Task<float> GetBodyStats(int uid, float bodyWeight, float fatPercentage);
    Task CreateBodyStats(int uid, float bodyWeight, float fatPercentage);
    Task DeleteBodyStats(int uid, float bodyWeight, float fatPercentage);
}