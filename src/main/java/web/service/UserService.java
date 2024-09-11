package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    List<User> getLimitedUsers(int count);

    User getUserById(int id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
}
