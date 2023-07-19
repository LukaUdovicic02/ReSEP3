using Model;



public class DataSession
{
    private static readonly Lazy<DataSession> instance = new(() => new DataSession());

    public static DataSession Instance => instance.Value;

    public User User { get; private set; }

    private DataSession()
    { }
}