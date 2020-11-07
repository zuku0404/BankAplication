package model.domain.split_class;

import model.validation.Validator;

public class ConditionsOfValidation {
    private Validator validator = new Validator();

    public String checkLogin(String login) {
        if (!validator.checkLogin(login)) {
            return "login is too short, must be at least 8 characters long or does not contain uppercase";
        }
        return "";
}

    public String checkPassword(String password) {
        if (!validator.checkPassword(password)) {
            return ("Your password must contain an uppercase letter, a lowercase letter, a special character " +
                    "and must be at least 8 characters long ");
        }
        return "";
    }
    public String checkName (String name) {
        if (!validator.checkNameSurname(name)) {
            return ("Name is too short or does not contain uppercase");
        }
        return "";
    }
    public String checkSurname (String surname) {
        if (!validator.checkNameSurname(surname)) {
            return ("surname is too short or does not contain uppercase");
        }
        return "";
    }
    public String checkDate(String date) {
        if (!validator.checkDataOfBirth(date)) {
            return ("format of data is not correct [XX-XX-XXXX]");
        }
        return "";
    }
    public String checkPesel(String pesel) {
        if (!validator.checkPesel(pesel)) {
            return ("format of data is not correct [XX-XX-XXXX]");
        }
        return "";
    }
}