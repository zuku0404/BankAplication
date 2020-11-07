package data_base.login;

import data_base.ConnectionUtil;
import model.cipher.CaesarDecipher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordCheckerDB {
    public boolean checkPassword(String login, String password) {
        String downloadPassword = "SELECT PASSWORD FROM ACCOUNT JOIN USERS ON Users.ID = model.account.ID WHERE Users.login = ? ";
        Connection connection = ConnectionUtil.createConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(downloadPassword);
            ps.setString(1,login);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if ((CaesarDecipher.decryptPassword(rs.getString("password"))).equals(password)){
                return true;
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
        return false;
    }
}
// czy mozna passwordChecker i LoginChecke zrobic w jednym zapytaniu