package persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private Connection connection;
    private final String USER;
    private final String PASSWORD;
    private final String URL;

    public Database(String user, String password, String url)  {
        this.connection = connection;
        USER = user;
        PASSWORD = password;
        URL = url;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Der er en fejl i database constructor");

        }
    }

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
           System.out.println("Der er en fejl i connection");
        }
        return connection;
    }


}
