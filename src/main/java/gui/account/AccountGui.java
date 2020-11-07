package gui.account;

import data_base.account_information.AccountInformationFetcher;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class AccountGui {
    public static void main(String[] args) {
        AccountGui accountGui = new AccountGui();
        accountGui.createAccountGui(6);
    }
    public void createAccountGui(int id) {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();

        JLabel cash = new JLabel(getCurrentAccountBalance(id).toString());
        JLabel numberAccount = new JLabel("Your model.account number : ");
        AccountInformationFetcher accountInformationFetcher = new AccountInformationFetcher();
        JLabel accountNumber = new JLabel(accountInformationFetcher.getUserAccountNumber(id));
        JLabel cashOnAccount = new JLabel("Cash on your model.account: ");

        JButton transferButton = new JButton("transfer");
        transferButton.addActionListener(actionEvent -> TransferGui.createTransferGui(getCurrentAccountBalance(id),id,cash));

        JButton creditCardButton = new JButton("use card");
        creditCardButton.addActionListener(actionEvent -> CreditCardGui.createCreditCardGui(getCurrentAccountBalance(id),id,cash));

        JButton depositButton = new JButton("deposit");
        depositButton.addActionListener(actionEvent -> DepositGui.createDepositGui(id,cash));

        JButton checkTransferHistoryButton = new JButton("check History");
                checkTransferHistoryButton.addActionListener(actionEvent -> {
                    HistoryGui gui = new HistoryGui(id);
                    gui.createTable();
                });

        mainPanel.add(cashOnAccount);
        mainPanel.add(cash);
        mainPanel.add(numberAccount);
        mainPanel.add(accountNumber);
        mainPanel.add(transferButton);
        mainPanel.add(creditCardButton);
        mainPanel.add(depositButton);
        mainPanel.add(checkTransferHistoryButton);

        frame.getContentPane().add(mainPanel);
        frame.setSize(280, 300);
        frame.setVisible(true);
    }
    public static BigDecimal getCurrentAccountBalance(int id) {
        AccountInformationFetcher ac = new AccountInformationFetcher();
        return ac.getCurrentCash(id).setScale(2, RoundingMode.CEILING);
    }
}