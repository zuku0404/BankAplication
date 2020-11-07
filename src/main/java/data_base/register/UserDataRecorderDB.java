package data_base.register;

import data_base.ConnectionUtil;
import model.domain.userLog.User;

import java.sql.*;

public class UserDataRecorderDB {
    public void sendUserDateToServer(User user) {
        String userData = "Insert into users (PESEL, NAME, SURNAME, DATE_OF_BIRTH, LOGIN, ACCOUNT_NUMBER) values (?,?,?,?,?,?)";
        Connection connection = ConnectionUtil.createConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(userData, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, Long.toString(user.getPesel().getNumber()));
            ps.setString(2, user.getName());
            ps.setString(3, user.getSurname());
            ps.setString(4, user.getDateOfBirth());
            ps.setString(5, user.getLogin());
            ps.setString(6, user.getAccount().getNumber());
            ps.addBatch();
            ps.executeBatch();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

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
    }
}
