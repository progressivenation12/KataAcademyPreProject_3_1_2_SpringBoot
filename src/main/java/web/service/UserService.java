package web.service;

import web.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsersList();

    User getUserByEmail(String email);

    boolean isEmailUnique(String email, int userId);

    User getUserByID(int id);

    void saveUser(User user);

    void updateUser(int id, User updateUser);

    void deleteUser(int id);
}
