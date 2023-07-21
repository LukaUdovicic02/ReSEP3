package resep3.javat3.model;

import java.util.ArrayList;

public class User {

    private int uid;
    private String username;
    private String password;
    private float bodyWeight;
    private float fatPercentage;


    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }



    public User(int uid, String username, String password, float bodyWeight, float fatPercentage) {
        this.username = username;
        this.password = password;
        this.uid = uid;
        this.bodyWeight = bodyWeight;
        this.fatPercentage = fatPercentage;
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

}
