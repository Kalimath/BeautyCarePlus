package domain.db.user;
import domain.model.User;

import java.util.List;

public interface UserDb {

    List<User> getAll();

    void update(User newUser);

    User get(String email);

    //written not tested
    void add(User userO);

    //written not tested
    void delete(String emailUser);

    //written not tested
    void delete(int userId);
}
