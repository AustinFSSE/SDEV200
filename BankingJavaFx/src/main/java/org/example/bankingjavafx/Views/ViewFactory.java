package org.example.bankingjavafx.Views;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.bankingjavafx.Controllers.Client.ClientController;

import java.io.IOException;

public class ViewFactory {

    // Client Views
    private final StringProperty clientSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane transactionsView;
    private AnchorPane accountsView;



    public ViewFactory() {
        this.clientSelectedMenuItem = new SimpleStringProperty();
    }

    public StringProperty getClientSelectedMenuItem() {
        return clientSelectedMenuItem;
    }

    public AnchorPane getDashboardView() {
        if (dashboardView == null) {
            try {
                dashboardView = new FXMLLoader(getClass().getResource("/FXML/Client/Dashboard.fxml")).load();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return dashboardView;
    }

    public AnchorPane getTransactionsView() {
        try {
            if (transactionsView == null) {
                transactionsView = new FXMLLoader(getClass().getResource("/FXML/Client/Transactions.fxml")).load();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return transactionsView;
    }

    public AnchorPane getAccountsView() {
        try {
            if (accountsView == null) {
                accountsView = new FXMLLoader(getClass().getResource("/FXML/Client/Accounts.fxml")).load();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return accountsView;
    }

    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));
        createStage(loader);
    }

    public void showClientWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Client/client.fxml"));
        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Banking Java FX");
        stage.show();
    }
    public void closeStage(Stage stage) {
        stage.close();
    }


}
