package data_base.account_information;

import data_base.ConnectionUtil;
import model.domain.transaction.Transfer;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountInformationFetcher {
    public String getUserAccountNumber(int id) {
        String numberAccount = "";
        String query = "Select * from USERS where ID = ?";
        Connection connect = ConnectionUtil.createConnection();
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            numberAccount = rs.getString("ACCOUNT_NUMBER");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                connect.close();
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
        return numberAccount;
    }

    public BigDecimal getCurrentCash(int id) {
        String query = "SELECT SUM(TRANSFER_CASH) FROM TRANSFER Where id_user = ?";
        Connection connect = ConnectionUtil.createConnection();
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getBigDecimal("SUM(TRANSFER_CASH)");
        } catch (Exception ex) {
            ex.printStackTrace();
            return BigDecimal.ZERO;
        } finally {
            try {
                connect.close();
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

    public List<Transfer> getHistory(int userId) {
        List<Transfer> historyUserList = new ArrayList<>();
        String query2 = "SELECT name_mod.name  Name_Owner, surname_modi.surname Surname_owner , name_mod2.name NAME_RECIPIENT ," +
                " surname_mod2.surname SURNAME_RECIPIENT, TRANSFER_TYPE, TRANSFER_CASH, TITLE\n" +
                "FROM TRANSFER t1\n" +
                "JOIN Users name_mod ON t1.ID_USER = name_mod.id\n" +
                "JOIN Users surname_modi ON t1.ID_USER = surname_modi.id\n" +
                "JOIN Users name_mod2 ON t1.ID_USER_RECIPIENT = name_mod2.id\n" +
                "JOIN Users surname_mod2 ON t1.ID_USER_RECIPIENT = surname_mod2.id\n" +
                " WHERE ID_USER = ? " +
                " ORDER BY ID_TRANSFER DESC";
        Connection connect = ConnectionUtil.createConnection();
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(query2);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { // (&& historyUserList.size() < 20)
                Transfer userTransfer = Transfer.builder()
                        .userName(rs.getString("NAME_OWNER"))
                        .userSurname(rs.getString("SURNAME_OWNER"))
                        .recipientName(rs.getString("NAME_RECIPIENT"))
                        .recipientSurname(rs.getString("SURNAME_RECIPIENT"))
                        .transferType(rs.getString("TRANSFER_TYPE"))
                        .transferCash(rs.getDouble("TRANSFER_CASH"))
                        .title(rs.getString("TITLE"))
                        .build();
                historyUserList.add(userTransfer);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                connect.close();
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
        return historyUserList;
    }
}
