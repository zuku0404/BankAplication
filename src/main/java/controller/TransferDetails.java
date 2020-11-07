package controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class TransferDetails {
    private String cash;
    private String title;
    private String recipientId;

    private BigDecimal balance;
    private int userId;
}
