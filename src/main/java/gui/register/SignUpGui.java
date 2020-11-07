package gui.register;

import model.domain.split_class.Converter;

import javax.swing.*;
import java.awt.*;

public class SignUpGui  {
    public static void main(String[] args) {
        SignUpGui.createGui();
    }

    public static void createGui() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JLabel label = new JLabel("Registration Form: ");
        label.setFont(new Font("", Font.BOLD, 20));

        JLabel loginLabel = new JLabel("Login: ");
        JTextField loginText = new JTextField(25);
        JTextArea errorLogin = new JTextArea("",2,40);
        errorLogin.setLineWrap(true);
        errorLogin.setWrapStyleWord(true);
        errorLogin.setForeground(Color.RED);
        errorLogin.setOpaque(false);

        JLabel passwordLabel = new JLabel("Password: ");
        JTextField passwordText = new JTextField(25);
        JTextArea errorPassword = new JTextArea("",2,40);
        errorPassword.setLineWrap(true);
        errorPassword.setWrapStyleWord(true);
        errorPassword.setForeground(Color.RED);
        errorPassword.setOpaque(false);

        JLabel nameLabel = new JLabel("Name: ");
        JTextField nameText = new JTextField(25);
        JTextArea errorName = new JTextArea("",2,40);
        errorName.setLineWrap(true);
        errorName.setWrapStyleWord(true);
        errorName.setForeground(Color.RED);
        errorName.setOpaque(false);

        JLabel surnameLabel = new JLabel("Surname: ");
        JTextField surnameText = new JTextField(25);
        JTextArea errorSurname = new JTextArea("",2,40);
        errorSurname.setLineWrap(true);
        errorSurname.setWrapStyleWord(true);
        errorSurname.setForeground(Color.RED);
        errorSurname.setOpaque(false);

        JLabel pesel = new JLabel("Pesel: ");
        JTextField peselText = new JTextField(25);
        JTextArea errorPesel = new JTextArea("",2,40);
        errorPesel.setLineWrap(true);
        errorPesel.setWrapStyleWord(true);
        errorPesel.setForeground(Color.RED);
        errorPesel.setOpaque(false);

        JLabel dateOfBirth = new JLabel("date of birth:");
        JTextField dateOfBirthText = new JTextField(25);
        JTextArea errorDateOfBirth = new JTextArea("",2,40);
        errorDateOfBirth.setLineWrap(true);
        errorDateOfBirth.setWrapStyleWord(true);
        errorDateOfBirth.setForeground(Color.RED);
        errorDateOfBirth.setOpaque(false);


        JButton createAccount = new JButton("create");
        createAccount.addActionListener(actionEvent -> {
            Converter converter = new Converter(loginText, passwordText, peselText, dateOfBirthText, nameText, surnameText,
                errorLogin,errorPassword,errorName,errorSurname,errorDateOfBirth,errorPesel);
            converter.createAccountOrShowError();
        });
        panel.setLayout(new GridLayout(0, 1));

        JPanel firstPanel = new JPanel();
        firstPanel.add(loginLabel);
        firstPanel.add(loginText);
        firstPanel.add(errorLogin);

        JPanel secondPanel = new JPanel();
        secondPanel.add(passwordLabel);
        secondPanel.add(passwordText);
        secondPanel.add(errorPassword);

        JPanel thirdPanel = new JPanel();
        thirdPanel.add(nameLabel);
        thirdPanel.add(nameText);
        thirdPanel.add(errorName);

        JPanel fourthPanel = new JPanel();
        fourthPanel.add(surnameLabel);
        fourthPanel.add(surnameText);
        fourthPanel.add(errorSurname);

        JPanel fifthPanel = new JPanel();
        fifthPanel.add(createAccount);

        JPanel sixthPanel = new JPanel();
        sixthPanel.add(pesel);
        sixthPanel.add(peselText);
        sixthPanel.add(errorPesel);

        JPanel seventhPanel = new JPanel();
        seventhPanel.add(dateOfBirth);
        seventhPanel.add(dateOfBirthText);
        seventhPanel.add(errorDateOfBirth);

        panel.add(label);
        panel.add(firstPanel);
        panel.add(secondPanel);
        panel.add(thirdPanel);
        panel.add(fourthPanel);
        panel.add(seventhPanel);
        panel.add(sixthPanel);
        panel.add(fifthPanel);

        frame.getContentPane().add(panel);
        frame.setSize(520, 600);
        frame.setVisible(true);
    }
}

