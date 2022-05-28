package application.context.impl;

import application.context.ApplicationContext;
import application.dao.UserDao;
import application.dao.postgresimpl.UserDaoImpl;
import application.db.DbConnectionProvider;
import application.db.Queries;
import application.db.postgres.queries.user.PostgresUserQueries;
import application.service.UserService;
import application.service.postgresimpl.UserServiceImpl;

public class PostgresApplicationContextImpl implements ApplicationContext {

    private final Queries postgresUserQueries;
    private final UserDao userDao;
    private final UserService userService;

    public PostgresApplicationContextImpl(DbConnectionProvider connectionProvider) {
        this.postgresUserQueries = new PostgresUserQueries();
        this.userDao = new UserDaoImpl(connectionProvider);
        this.userService = new UserServiceImpl(userDao, postgresUserQueries);
    }

    public UserService getUserService() {
        return userService;
    }
}
