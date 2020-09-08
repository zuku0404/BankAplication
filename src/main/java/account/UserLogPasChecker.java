package account;

import data_base.login.LoginCheckerDB;
import data_base.login.PasswordCheckerDB;
import gui.account.AccountGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// nie wiem czy tak może być ze zwraca id lub 0 pozniej w drugiej funkcji znowu to sprawdza  !!!!!
public class UserLogPasChecker implements ActionListener {
    JTextField login;
    JTextField password;

    public UserLogPasChecker(JTextField login, JTextField password) {
        this.login = login;
        this.password = password;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int id = checkAccount();
        if (id!=0) {
            AccountGui accountGui = new AccountGui();
            accountGui.createAccountGui(id);
        }
    }
    private int checkAccount() {
        LoginCheckerDB loginCheckerDB = new LoginCheckerDB();
        PasswordCheckerDB passwordCheckerDB = new PasswordCheckerDB();
        int id = loginCheckerDB.checkLogin(login.getText());
        if (id == 0) {
            System.out.println("login not exist");
            return 0;
        } else if (!passwordCheckerDB.checkPassword(login.getText(), password.getText())) {
            System.out.println("password incorrect");
            return 0;
        } else
            return id;
    }
}
