//package data_base.register;
//
//import data_base.ConnectionUtil;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class InitialTablesAndRowDB {
//    public void createTables (){
//        Connection connection = null;
//        Statement st = null;
//        String createTableAccountQuery = "Create table account (id int(10) Primary key, password varchar(20) Not null)";
//        String createTableTransferQuery = "Create table transfer id_transfer, id_user,id_user_recipient," +
//                "transfer_type,transfer_cash,title";
//        try{
//            connection = ConnectionUtil.createConnection();
//            st = connection.createStatement();
//            st.executeUpdate();
//        }
//        catch(SQLException ex){
//            ex.printStackTrace();
//        }
//    }
//
//}
