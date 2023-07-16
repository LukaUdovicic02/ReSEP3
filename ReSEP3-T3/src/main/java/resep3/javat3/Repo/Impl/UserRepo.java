package resep3.javat3.Repo.Impl;

import org.lognet.springboot.grpc.GRpcService;
import resep3.javat3.Repo.Interfaces.IUserRepo;
import resep3.javat3.model.User;
import resep3.javat3.persistance.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@GRpcService
public class UserRepo implements IUserRepo {

    private final DBConnection initializer = new DBConnection();


    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        User user = null;


        initializer.connect();

        Connection connection = initializer.getConnection();
        Statement statement = connection.createStatement();
        String selectQuery = "SELECT username, password FROM User WHERE username = '"
                + username + "' AND password = '" + password + "'";


        ResultSet resultSet = statement.executeQuery(selectQuery);

        if (resultSet.next()) {

            String fetchedUsername = resultSet.getString("username");

            user = new User();
            user.setUsername(fetchedUsername);
            user.setPassword(password);
        } else {

            System.out.println("We can't find given user in database");
        }

        // Disconnect from the database
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
