package org.example.bankingjavafx.Views;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.bankingjavafx.Controllers.Client.ClientController;
import org.example.bankingjavafx.Controllers.admin.AdminController;

import java.io.IOException;

public class ViewFactory {

    private AccountType loginAccountType;

    // Client Views
    private final ObjectProperty<ClientMenuOptions> clientSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane transactionsView;
    private AnchorPane accountsView;

    //Admin Views
    private final ObjectProperty<AdminMenuOptions> adminSelectedMenuItem;
    private AnchorPane createClientView;
    private AnchorPane clientView;
    private AnchorPane depositView;

    public ViewFactory() {
        this.loginAccountType = AccountType.CLIENT;
        this.clientSelectedMenuItem = new SimpleObjectProperty <>();
        this.adminSelectedMenuItem = new SimpleObjectProperty <>();
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public ObjectProperty <ClientMenuOptions> getClientSelectedMenuItem() {
        return clientSelectedMenuItem;
    }

    public ObjectProperty <AdminMenuOptions> getAdminSelectedMenuItem() {
        return adminSelectedMenuItem;
    }
    /*
        Client Views Section
     */

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

    public void showClientWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Client/client.fxml"));
        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader);
    }
    /*
        Admin Views Section
     */

    public AnchorPane getCreateClientView() {
        try {
            if (createClientView == null) {
                createClientView = new FXMLLoader(getClass().getResource("/FXML/Admin/CreateClient.fxml")).load();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return createClientView;
    }
    public AnchorPane getClientView() {
        try {
            if (clientView == null) {
                clientView = new FXMLLoader(getClass().getResource("/FXML/Admin/Clients.fxml")).load();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return clientView;
    }
    public AnchorPane getDepositView() {
        try {
            if (depositView == null) {
                depositView = new FXMLLoader(getClass().getResource("/FXML/Admin/Deposit.fxml")).load();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return depositView;
    }

    public AnchorPane getAdmin;

    public void showAdminWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Admin/admin.fxml"));
        AdminController adminController = new AdminController();
        loader.setController(adminController);
        createStage(loader);
    }


    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));
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
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/bank.png"))));
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Banking Java FX");
        stage.show();
    }
    public void closeStage(Stage stage) {
        stage.close();
    }


}
