package data_base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtil {

    public static Connection createConnection() {
        String url = "jdbc:h2:~/aplikaBankowaa";
        Connection connection = null;
        Properties properties = new Properties();
        properties.setProperty("user", "sa");
        properties.setProperty("password", "");
        try {
//            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(url, properties);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
