package application.service.postgresimpl;

import application.dao.UserDao;
import application.db.Queries;
import application.entity.User;
import application.operations.UserOperations;
import application.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final Queries userQueries;
    private String sql;

    public UserServiceImpl(UserDao userDao, Queries userQueries) {
        this.userDao = userDao;
        this.userQueries = userQueries;
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public void deleteUser() {

    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public User getUserByName(String name) {
        return null;
    }

    @Override
    public void updateUser(User user) {
        sql = userQueries.getQuery(UserOperations.UPDATE_USER.getOperationName());
        userDao.updateUser(user, sql);
    }

}
