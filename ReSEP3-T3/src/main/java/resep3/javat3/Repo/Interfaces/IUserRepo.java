package resep3.javat3.Repo.Interfaces;

import org.springframework.stereotype.Component;
import resep3.javat3.model.User;

import java.sql.SQLException;

@Component
public interface IUserRepo
{
    User getUserByUsernameAndPassword(String username, String password) throws SQLException;
    User createUser(User user) throws SQLException;
}

