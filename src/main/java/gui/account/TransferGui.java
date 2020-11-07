package gui.account;

import data_base.TransferDB;
import model.domain.transaction.TransactionChecker;
import model.domain.transaction.TransactionType;
import model.validation.Validator;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Optional;

import static javax.swing.JOptionPane.showMessageDialog;

public class TransferGui {
    private TransferGui(){}

    public static void createTransferGui(BigDecimal allCashOnAccount, int userId, JLabel labelCash) {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();

        JLabel title = new JLabel("title: ");
        JTextField titleText = new JTextField(20);

        JLabel idRecipient = new JLabel("id user recipient: ");
        JTextField idRecipientText = new JTextField(20);

        JLabel cash = new JLabel("cash: ");
        JTextField cashText = new JTextField(20);

        JButton transferButton = new JButton("make a transfer");

        transferButton.addActionListener(actionEvent -> {
            Validator validator = new Validator();
            boolean firstCondition = validator.checkCash(cashText.getText());
            boolean secondCondition = validator.checkTitle(titleText.getText());
            boolean thirdCondition = validator.checkIdUserRecipient(idRecipientText.getText());

            if (!firstCondition) {
                JOptionPane.showMessageDialog(null, "the wrong amount was entered");
            }
            else if (!secondCondition) {
                JOptionPane.showMessageDialog(null, "you didn't write transfer title");
            }
            else if (!thirdCondition) {
                JOptionPane.showMessageDialog(null, "something wrong with recipient id");
            }
            else {
                   Optional<BigDecimal> cashBigDecimal = TransactionChecker.checkFoundsOnAccount(allCashOnAccount, cashText.getText());
                  if (cashBigDecimal.isPresent()) {
                      TransferDB transferDB = new TransferDB(userId, Integer.parseInt(idRecipientText.getText()), TransactionType.TRANSFER,
                              cashBigDecimal.get(), titleText.getText());
                      transferDB.createTransfer();
                      labelCash.setText(AccountGui.getCurrentAccountBalance(userId).toString());
                      frame.dispose();
                  }
                  else {
                      showMessageDialog(null, "you cannot withdraw money insufficient funds in your model.account");
                  }
               }
        });

        JPanel firstPanel = new JPanel();
        firstPanel.add(title);
        firstPanel.add(titleText);

        JPanel secondPanel = new JPanel();
        secondPanel.add(idRecipient);
        secondPanel.add(idRecipientText);

        JPanel thirdPanel = new JPanel();
        thirdPanel.add(cash);
        thirdPanel.add(cashText);

        JPanel fourthPanel = new JPanel();
        fourthPanel.add(transferButton);

        frame.getContentPane().add(mainPanel);
        mainPanel.add(firstPanel);
        mainPanel.add(secondPanel);
        mainPanel.add(thirdPanel);
        mainPanel.add(fourthPanel);

        frame.setVisible(true);
        frame.setSize(300, 300);
    }
}
