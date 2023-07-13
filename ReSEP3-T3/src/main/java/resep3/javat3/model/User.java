package resep3.javat3.model;

public class User
{
    private String username;
    private String password;

    public User() {
        this.username = "john";
        this.password = "secret";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
