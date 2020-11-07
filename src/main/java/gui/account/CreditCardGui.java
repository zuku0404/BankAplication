package gui.account;

import data_base.TransferDB;
import model.domain.transaction.TransactionChecker;
import model.domain.transaction.TransactionType;
import model.validation.Validator;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Optional;

import static javax.swing.JOptionPane.showMessageDialog;

public class CreditCardGui {
    private CreditCardGui (){}
    private  static final String TITLE = "cash withdrawal at an ATM";

    public static void createCreditCardGui(BigDecimal allCashOnAccount, int userId, JLabel labelCash) {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();

        JLabel creditCardCash = new JLabel("how much money do you want to withdraw ");
        JTextField creditCardCashText = new JTextField(20);
        JButton confirmButton = new JButton("confirm");
        confirmButton.addActionListener(actionEvent -> {
            Validator validator = new Validator();
            if (validator.checkCash(creditCardCashText.getText())) {
                Optional<BigDecimal> cashBigDecimal = TransactionChecker.checkFoundsOnAccount(allCashOnAccount, creditCardCashText.getText());
                if (cashBigDecimal.isPresent()) {
                    TransferDB transferDB = new TransferDB(userId, userId, TransactionType.CREDIT_CARD, cashBigDecimal.get(), TITLE);
                    transferDB.createTransfer();
                    labelCash.setText(AccountGui.getCurrentAccountBalance(userId).toString());
                    frame.dispose();
                }
                else {
                    showMessageDialog(null, "you cannot withdraw money insufficient funds in your model.account");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "the wrong amount was entered");
            }
        });

        mainPanel.add(creditCardCash);
        mainPanel.add(creditCardCashText);
        mainPanel.add(confirmButton);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
        frame.setSize(300, 150);
    }
}

