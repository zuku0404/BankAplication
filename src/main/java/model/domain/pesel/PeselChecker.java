package model.domain.pesel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PeselChecker {

    public boolean checkPesel(String numberPesel, String dateOfBirth) {
        String[] psn = numberPesel.split("");

        if (!isFirstSixNumberCorrect(psn, dateOfBirth))
            return false;
        else if (!isRestOfNumbersCorrect(psn))
            return false;
        else {
            JOptionPane.showMessageDialog(null, "model.account has been created");
            return true;
        }
    }

    private List<String> modificationDateOfBirth(String dateOfBirth) {
        List<String> listOfChangedBirthDigit = new ArrayList<>();
        int[] positionDigit = {6, 7, 0, 1, 2, 3};
        String[] nobString = dateOfBirth.split("-");
        StringBuilder sb = new StringBuilder();
        for (String a : nobString) {
            sb.append(a);
        }
        String txt = sb.toString();
        String[] nobArray = txt.split("");
        for (int value : positionDigit) {
            listOfChangedBirthDigit.add(nobArray[value]);
        }
        return listOfChangedBirthDigit;
    }

    private boolean isFirstSixNumberCorrect(String[] psn, String dateOfBirth) {
        List<String> newList = modificationDateOfBirth(dateOfBirth);
        for (int i = 0; i < newList.size(); i++) {
            if (!psn[i].equals(newList.get(i))) {
                JOptionPane.showMessageDialog(null, "number of pesel and date do not fit");
                return false;
            }
        }
        return true;
    }

    private boolean isRestOfNumbersCorrect(String[] psn) {
        int sum = 0;
        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

        for (int i = 0; i <= psn.length - 2; i++) {
            sum = sum + (weights[i] * (Integer.parseInt(psn[i])));
        }
        if (10 - (sum % 10) != Integer.parseInt(psn[10])) {
            JOptionPane.showMessageDialog(null, "pesel verification failed");
            return false;
        }
        return true;
    }
}
