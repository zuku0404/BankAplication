package model.domain.split_class;

import javax.swing.*;
import java.util.List;

public class Converter {
    private JTextField login;
    private JTextField password;
    private JTextField pesel;
    private JTextField dateOfBirth;
    private JTextField name;
    private JTextField surname;
    private JTextArea errorLogin;
    private JTextArea errorPassword;
    private JTextArea errorName;
    private JTextArea errorSurname;
    private JTextArea errorDateOfBirth;
    private JTextArea errorPesel;

    public Converter(JTextField login, JTextField password, JTextField pesel, JTextField dateOfBirth, JTextField name,
                     JTextField surname, JTextArea errorLogin, JTextArea errorPassword, JTextArea errorName,
                     JTextArea errorSurname, JTextArea errorDateOfBirth, JTextArea errorPesel) {

        this.login = login;
        this.password = password;
        this.pesel = pesel;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.surname = surname;
        this.errorLogin = errorLogin;
        this.errorPassword = errorPassword;
        this.errorName = errorName;
        this.errorSurname = errorSurname;
        this.errorDateOfBirth = errorDateOfBirth;
        this.errorPesel = errorPesel;
    }

    public void createAccountOrShowError() {
        CorrectnessUserDataChecker user = new CorrectnessUserDataChecker(login.getText(), password.getText(), pesel.getText(), dateOfBirth.getText(),
                name.getText(), surname.getText());
        List<String> textSetter = user.checkValidationData();

        errorLogin.setText(textSetter.get(0));
        errorPassword.setText(textSetter.get(1));
        errorName.setText(textSetter.get(2));
        errorSurname.setText(textSetter.get(3));
        errorDateOfBirth.setText(textSetter.get(4));
        errorPesel.setText(textSetter.get(5));
    }
}
