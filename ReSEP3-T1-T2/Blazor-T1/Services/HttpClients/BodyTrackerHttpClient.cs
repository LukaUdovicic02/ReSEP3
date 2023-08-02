

public class BodyTrackerHttpClient : IBodyTrackerService
{
    private readonly HttpClient httpClient;
    public BodyTrackerHttpClient(HttpClient httpClient)
    {
        this.httpClient = httpClient;
    }
    
    
    public async Task<float> GetBodyStats(int uid, float bodyWeight, float fatPercentage)
    {
        
        HttpResponseMessage response = await httpClient.GetAsync($"http://localhost:5052/  "); ///more here
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception("could not fetch the body stats");
        }
        
        return bodyWeight+ fatPercentage;

    }

    public Task CreateBodyStats(int uid, float bodyWeight, float fatPercentage)
    {
        
    }

    public Task DeleteBodyStats(int uid, float bodyWeight, float fatPercentage)
    {
        
    }
}