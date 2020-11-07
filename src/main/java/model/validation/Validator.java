package model.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public boolean checkCash (String cashToCheck) {
        String regex = "^\\d+[.,]\\d{1,2}$|^\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cashToCheck);
        return matcher.matches();
    }
    public boolean checkTitle (String title) {
        String regex = "\\S(.*)";
        return Pattern.matches(regex,title);
    }
    public boolean checkIdUserRecipient (String idUserRecipient) {
        String regex = "^[1-9](\\d*$)";
        return Pattern.matches(regex,idUserRecipient);
    }
    public boolean checkPassword (String password){
        String regex = "^(?=.*?[A-Z])(?=.*?\\d)(?=.*?[a-z])(?=.*[$@!%*?&.])\\S{8,}";
        return Pattern.matches(regex,password);
    }
    public boolean checkLogin (String login) {
        String regex = "(?=.*?[A-Z])\\S{8,}";
        return Pattern.matches(regex, login);
    }
    public boolean checkNameSurname(String word){
        String regex = "^[A-Z]{1}[a-z]{1,}$";
        return Pattern.matches(regex, word);
    }
    public boolean checkDataOfBirth (String birth){
        String regex = "^[0-3][0-9]-[0-3][0-9]-[1-2][0-9]{3}$";
        return Pattern.matches(regex, birth);
    }
    public boolean checkPesel (String pesel) {
        String regex = "^\\d{11}$";
        return Pattern.matches(regex, pesel);
    }
}
