package model.domain.transaction;

import java.math.BigDecimal;
import java.util.Optional;

public class TransactionChecker {
    private TransactionChecker(){}
    public static Optional<BigDecimal> checkFoundsOnAccount(BigDecimal allCashOnAccount, String creditCardCashText) {
        BigDecimal amount = new BigDecimal(creditCardCashText);
        if (allCashOnAccount.compareTo(amount) >= 0) {
            return Optional.of(amount.negate());
        } else {
            return Optional.empty();
        }
    }
}
