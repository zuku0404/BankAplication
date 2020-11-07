package data_base.register;

import data_base.ConnectionUtil;
import model.domain.userLog.User;

import java.sql.*;

public class AccountDataRecorderDB {
    public void sendAccountDateToServer(User user) {
        String userData = "Insert into account (PASSWORD) values (?)";
        Connection connection = ConnectionUtil.createConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(userData, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getPassword());
            ps.addBatch();
            ps.executeBatch();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

        } catch (SQLException ex) {
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
    }
}

