package data_base.login;

import data_base.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCheckerDB {
    public int checkLogin(String login) {
        String downloadLogs = " SELECT id from users WHERE login = ? ";
        Connection connection = ConnectionUtil.createConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(downloadLogs);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException sqlexp) {
                sqlexp.printStackTrace();
            }
        }
        return 0;
    }
}
