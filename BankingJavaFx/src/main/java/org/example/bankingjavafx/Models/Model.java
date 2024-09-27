package org.example.bankingjavafx.Models;

import org.example.bankingjavafx.Views.AccountType;
import org.example.bankingjavafx.Views.ViewFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    private AccountType loginAccountType = AccountType.CLIENT;

    // Client Data Section
    private Client client;
    private boolean clientLoginSuccessFlag; // validate correct login credentials
    // Admin Data Section

    private Model() {
        this.viewFactory = new ViewFactory();
        try {
            this.databaseDriver = new DatabaseDriver();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Client Data Section
        this.clientLoginSuccessFlag = false;
        this.client = new Client(" ", "", "", null, null, null);

    }
    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }
    public DatabaseDriver getDatabaseDriver() {
        return databaseDriver;
    }
    public AccountType getLoginAccountType() { return loginAccountType; }
    public void setLoginAccountType(AccountType loginAccountType) { this.loginAccountType = loginAccountType; }

    /*
    Client Method Section
     */
    public boolean isClientLoginSuccessFlag() { return this.clientLoginSuccessFlag; }

    public void setClientLoginSuccessFlag(boolean clientLoginSuccessFlag) { this.clientLoginSuccessFlag = clientLoginSuccessFlag; }

    public Client getClient() { return client; }

    public void evaluateClientCred(String pAddress, String password) {
        CheckingAccount checkingAccount;
        SavingsAccount savingsAccount;
        ResultSet resultSet = databaseDriver.getClientData(pAddress, password);
        try {
            if(resultSet.isBeforeFirst()) {
                this.client.firstNameProperty().set(resultSet.getString("FirstName"));
                this.client.lastNameProperty().set(resultSet.getString("LastName"));
                this.client.payeeAddressProperty().set(resultSet.getString("PayeeAddress"));
                String[] dateParts = resultSet.getString("Date Created").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                this.client.dateCreatedProperty().set(date);
                this.clientLoginSuccessFlag = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}








