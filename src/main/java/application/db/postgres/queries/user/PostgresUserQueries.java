package application.db.postgres.queries.user;

import application.db.Queries;
import application.operations.UserOperations;

import java.util.HashMap;
import java.util.Map;

public class PostgresUserQueries implements Queries {

    private Map<String, String> queries;

    public PostgresUserQueries() {
        populateQueries();
    }

    private void populateQueries() {
        queries = new HashMap<>();
        queries.put(UserOperations.UPDATE_USER.getOperationName(), "UPDATE user SET family_name = ?,  given_name = ?, phone_number = ?, age = ? WHERE id = ?;");
    }

    public String getQuery(String key) {
        return queries.get(key);
    }

}