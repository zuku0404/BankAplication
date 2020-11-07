package gui.account;

import data_base.TransferDB;
import model.validation.Validator;

import javax.swing.*;
import java.math.BigDecimal;

import static model.domain.transaction.TransactionType.DEPOSIT;

public class DepositGui {
    private DepositGui (){}
    private  static final String TITLE = "payment of money";

    public static void createDepositGui(int userId, JLabel labelCash) {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();

        JLabel depositCash = new JLabel("amount deposited into the model.account ");
        JTextField depositCashText = new JTextField(20);
        JButton confirmButton = new JButton("confirm");
        confirmButton.addActionListener(actionEvent -> {
            Validator validator = new Validator();
            if (validator.checkCash(depositCashText.getText())) {
                BigDecimal depositCashDecimal = new BigDecimal(depositCashText.getText());
                TransferDB transferDB = new TransferDB(userId, userId, DEPOSIT, depositCashDecimal, TITLE);
                transferDB.createTransfer();
                labelCash.setText(AccountGui.getCurrentAccountBalance(userId).toString());
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "the wrong amount was entered");
            }
        });

        mainPanel.add(depositCash);
        mainPanel.add(depositCashText);
        mainPanel.add(confirmButton);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
        frame.setSize(300, 150);
    }
}
