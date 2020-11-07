package gui.account;

import controller.TransferController;
import controller.TransferDetails;
import gui.Gui;
import lombok.AllArgsConstructor;

import javax.swing.*;
import java.math.BigDecimal;

@AllArgsConstructor
public class TransferGui implements Gui {

    private final BigDecimal balance;
    private final int userId;


    @Override
    public void show() {
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
            TransferController transferController = new TransferController();
            TransferDetails transferDetails = new TransferDetails(cashText.getText(), titleText.getText(), idRecipientText.getText(), balance, userId);
            try {
                transferController.makeTransfer(transferDetails);
                frame.dispose();
            } catch (IllegalArgumentException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
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
