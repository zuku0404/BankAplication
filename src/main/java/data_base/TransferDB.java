package data_base;

import model.domain.transaction.TransactionType;

import java.math.BigDecimal;
import java.sql.*;

public class TransferDB {
    private int idUser;
    private int idUserRecipient;
    private String transactionType;
    private BigDecimal transferCash;
    private String titleText;

    public TransferDB(int idUser, int idUserRecipient, TransactionType transactionType, BigDecimal transferCash, String titleText) {

        this.idUser = idUser;
        this.idUserRecipient = idUserRecipient;
        this.transactionType = transactionType.getTypeOfTransaction();
        this.transferCash = transferCash;
        this.titleText = titleText;
    }

    public void createTransfer() {

        Connection connect = ConnectionUtil.createConnection();
        PreparedStatement ps = null;
        String query = "Insert into TRANSFER (ID_USER, ID_USER_RECIPIENT, TRANSFER_TYPE, TRANSFER_CASH," +
                " TITLE) values(?,?,?,?,?) ";
        try {
            ps = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idUser);
            ps.setInt(2, idUserRecipient);
            ps.setString(3, transactionType);
            ps.setBigDecimal(4, transferCash);
            ps.setString(5, titleText);
            ps.addBatch();
            ps.executeBatch();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
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
}
