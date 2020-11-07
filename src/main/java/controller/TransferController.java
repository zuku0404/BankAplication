package controller;

import data_base.TransferDB;
import gui.account.AccountGui;
import model.domain.transaction.TransactionChecker;
import model.domain.transaction.TransactionType;
import model.domain.transaction.Transfer;
import model.validation.Validator;

import java.math.BigDecimal;
import java.util.Optional;

public class TransferController {

    public void makeTransfer(TransferDetails details) {

        validateTransferData(details.getCash(), details.getTitle(), details.getRecipientId());

        Optional<BigDecimal> verifiedCash = TransactionChecker.checkFoundsOnAccount(details.getBalance(), details.getCash());

        verifiedCash.ifPresentOrElse(c -> transfer(c, details),
                () -> throwExceptionWithMessage("You cannot withdraw money. Insufficient funds."));
    }

    private void transfer(BigDecimal cash, TransferDetails details) {
        TransferDB transferDB = new TransferDB(details.getUserId(), Integer.parseInt(details.getRecipientId()), TransactionType.TRANSFER,
                cash, details.getCash());
        transferDB.createTransfer();
    }

    private void validateTransferData(String cash, String title, String recipientId) {
        final Validator validator = new Validator();

        if (!validator.checkCash(cash)) {
            throwExceptionWithMessage("Wrong amount was entered");
        } else if (!validator.checkTitle(title)) {
            throwExceptionWithMessage("Transfer title is missing");
        } else if (!validator.checkIdUserRecipient(recipientId)) {
            throwExceptionWithMessage("Wrong recipient id");
        }
    }

    private void throwExceptionWithMessage(String message) {
        throw new IllegalArgumentException(message);
    }
}
