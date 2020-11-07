package model.cipher;

import java.util.ArrayList;
import java.util.List;

public class CaesarCipher {
    public String encryptPassword(String password) {
        if (checkIfPasswordContainOnlyLetters(password)) {
            StringBuilder sb = new StringBuilder();
            List<Character> allLetters = new ArrayList<>();
            int numberOffsetLetters = 10;

            for (int i = 0; i <= password.length() - 1; i++) {
                if (Character.isUpperCase(password.charAt(i))) {
                    char letter = (char) (((int) password.charAt(i) + numberOffsetLetters - 65) % 26 + 65);
                    allLetters.add(letter);
                } else {
                    char letter = (char) (((int) password.charAt(i) + numberOffsetLetters - 97) % 26 + 97);
                    allLetters.add(letter);
                }
            }
            for (Character a : allLetters) {
                sb.append(a);
            }
            return sb.toString();
        }
        else
            throw new IllegalArgumentException("you have to give only letters try again");
    }
    private boolean checkIfPasswordContainOnlyLetters (String password) {
        String passwordOnlyLowerCase = password.toLowerCase();
        char [] charactersFromPassword = passwordOnlyLowerCase.toCharArray();
        for(int i=0;i<charactersFromPassword.length;i++){
            char singleCharacter = charactersFromPassword[i];
            if(!(singleCharacter>='a' && singleCharacter<='z')){
                return false;
            }
        }
        return true;
    }
}
