package application.db;

import java.sql.Connection;

public interface DbConnectionProvider {

    Connection getConnection();

}
