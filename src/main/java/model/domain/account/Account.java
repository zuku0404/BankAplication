package model.domain.account;

public class Account {
    private String number;
    private double cash;

    public Account (String number, double cash) {
        this.number = number;
        this.cash = cash;
    }

    public String getNumber() {
        return number;
    }

    public double getCash() {
        return cash;
    }
}
