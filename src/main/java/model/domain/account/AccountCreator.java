package model.domain.account;

import data_base.register.AccountFinderDB;

import java.util.Random;

public class AccountCreator {

    private Random random = new Random();
    public Account createAccount() {
        return new Account(generateAccountNumber(),0.0);
    }

    private String generateAccountNumber() {
        AccountFinderDB accountFinderDB = new AccountFinderDB();
        for (int i = 0; i< 30; i++) {
            String newAccountNumber = createRandomAccountNumber();
            if (accountFinderDB.checkIfAccountNumberIsAvailable(newAccountNumber)) {
                return newAccountNumber;
            }
        }
        return null;   // TODO zwrocic Exception
    }
    private String createRandomAccountNumber() {
        StringBuilder bld = new StringBuilder();
        bld.append("1140");
        for (int i = 1; i < 23; i++) {
            bld.append((random.nextInt(10)));
    }
        return bld.toString();
    }

     String generateAccountNumber2() {
        AccountFinderDB accountFinderDB = new AccountFinderDB();
        for (int i = 0; i< 30; i++) {
            String newAccountNumber = createRandomAccountNumber();
            if (accountFinderDB.checkIfAccountNumberIsAvailable(newAccountNumber)) {
                return newAccountNumber;
            }
        }
        throw new IllegalStateException();   // TODO zwrocic Exception
    }
}
