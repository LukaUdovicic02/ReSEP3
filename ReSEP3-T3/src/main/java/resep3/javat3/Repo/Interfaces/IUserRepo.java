package resep3.javat3.Repo.Interfaces;

import org.springframework.stereotype.Component;
import resep3.javat3.model.User;
import resep3.javat3.model.WorkoutPlan;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
public interface IUserRepo
{
    User getUserByUsernameAndPassword(String username, String password) throws SQLException;
    User createUser(User user) throws SQLException;
    ArrayList<WorkoutPlan> getWpByUserId(int userid) throws SQLException;
}

