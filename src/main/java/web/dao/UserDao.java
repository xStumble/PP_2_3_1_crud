package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void updateUser(long id, User user);
    void deleteUser(long id);
    User getUser(long id);
    List<User> getAllUsers();
}
