package data_base;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'file:tablesAndData.sql'";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
