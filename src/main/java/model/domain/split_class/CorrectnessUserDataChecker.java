package model.domain.split_class;

import java.util.ArrayList;
import java.util.List;

public class CorrectnessUserDataChecker {
    private String login;
    private String password;
    private String pesel;
    private String dateOfBirth;
    private String name;
    private String surname;

    private ConditionsOfValidation cv = new ConditionsOfValidation();
    private ArrayList<String> text = new ArrayList<>();

    public CorrectnessUserDataChecker(String login, String password, String pesel, String dateOfBirth, String name,
                                      String surname) {

        this.login = login;
        this.password = password;
        this.pesel = pesel;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.surname = surname;

    }
    public List<String> checkValidationData() {
        if (areAllConditionCorrect()) {
            UserCreator userCreator = new UserCreator();
            userCreator.createUser(login,password,name,surname,dateOfBirth,pesel);
        }
        return text;
    }

    private boolean areAllConditionCorrect() {
        text.add(cv.checkLogin(login));
        text.add(cv.checkPassword(password));
        text.add(cv.checkName(name));
        text.add(cv.checkSurname(surname));
        text.add(cv.checkDate(dateOfBirth));
        text.add(cv.checkPesel(pesel));

        return text.get(0).isEmpty() && text.get(1).isEmpty() && text.get(2).isEmpty() && text.get(3).isEmpty() &&
                text.get(4).isEmpty() && text.get(5).isEmpty(); //TODO lambda
    }
}