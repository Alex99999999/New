package application.service;

import application.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    void deleteUser();

    User getUserById(long id);

    User getUserByName(String name);

    void updateUser(User user);

}
