package resep3.javat3.Repo.Impl;

import org.lognet.springboot.grpc.GRpcService;
import resep3.javat3.Repo.Interfaces.IUserRepo;
import resep3.javat3.model.User;
import resep3.javat3.model.WorkoutPlan;
import resep3.javat3.persistance.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@GRpcService
public class UserRepo implements IUserRepo {

    private final DBConnection initializer = new DBConnection();


    public ArrayList<WorkoutPlan> getWpByUserId(int userid) throws SQLException {
        ArrayList<WorkoutPlan> workoutPlans = new ArrayList<>();
        initializer.connect();

        Connection connection = initializer.getConnection();
        Statement statement = connection.createStatement();
        String selectQuery = "SELECT * FROM WorkoutPlan WHERE userid = " + userid;

        ResultSet resultSet = statement.executeQuery(selectQuery);
        while (resultSet.next()) {

            WorkoutPlan workoutPlan = new WorkoutPlan();
            workoutPlan.setWpID(resultSet.getInt("wpid"));
            workoutPlan.setWpName(resultSet.getString("wpname"));
            workoutPlan.setTimeGoal(resultSet.getInt("timegoal"));
            workoutPlan.setType(resultSet.getString("type"));
            workoutPlan.setUserID(resultSet.getInt("userid"));

            workoutPlans.add(workoutPlan);
        }

        initializer.disconnect();
        return workoutPlans;
    }


    // Add a new method to get the complete user information by username and password
    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        User user = null;

        initializer.connect();

        Connection connection = initializer.getConnection();
        Statement statement = connection.createStatement();
        String selectQuery = "SELECT * FROM User WHERE username = '" + username + "' AND password = '" + password + "'";

        ResultSet resultSet = statement.executeQuery(selectQuery);

        if (resultSet.next()) {
            // Retrieve the complete user information from the database
            int uid = resultSet.getInt("uid"); // Assuming the user ID is stored in a column named "uid"
            System.out.println(uid);
            float bodyWeight = resultSet.getFloat("bodyWeight"); // Assuming the body weight is stored in a column named "bodyWeight"
            float fatPercentage = resultSet.getFloat("fatPercentage"); // Assuming the fat percentage is stored in a column named "fatPercentage"

            // Create the complete User object
            user = new User(uid, username, password, bodyWeight, fatPercentage);
        } else {
            System.out.println("We can't find the given user in the database.");
        }

        initializer.disconnect();

        return user;
    }


    public User createUser(User user) throws SQLException {
        try {

            initializer.connect();
            Connection connection = initializer.getConnection();
            Statement statement = connection.createStatement();

            String insertQuery = "INSERT INTO User ( username, password )" +
                    " VALUES ( '" + user.getUsername() + "', '" + user.getPassword() + "')";

            statement.executeUpdate(insertQuery);

            System.out.println("Account created.");

            initializer.disconnect();
        } catch (Exception e) {
            System.out.println("Account not created .");
        }

        return user;

    }


}
