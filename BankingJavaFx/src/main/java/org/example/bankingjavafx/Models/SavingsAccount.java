package org.example.bankingjavafx.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SavingsAccount extends Account{

    private final IntegerProperty withdrawalLimit; // per month

    public SavingsAccount(String owner, String accountNumber, double balance, int withdrawalLimit) {
        super(owner, accountNumber, balance);
        this.withdrawalLimit = new SimpleIntegerProperty(this, "withdrawalLimit", withdrawalLimit);
    }

    public IntegerProperty getWithdrawalLimit() {
        return withdrawalLimit;
    }
}
