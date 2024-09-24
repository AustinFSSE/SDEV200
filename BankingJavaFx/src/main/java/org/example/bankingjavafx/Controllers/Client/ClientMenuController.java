package org.example.bankingjavafx.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.bankingjavafx.Models.Model;

import java.util.ResourceBundle;
import java.net.URL;


public class ClientMenuController implements Initializable {
    public Button dashboard_btn;
    public Button transactions_btn;
    public Button accounts_btn;
    public Button profile_btn;
    public Button logout_btn;
    public Button report_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();

    }
    private void addListeners() {
        dashboard_btn.setOnAction(e -> onDashboard());
        transactions_btn.setOnAction(e -> onTransactions());
        accounts_btn.setOnAction(e -> onAccounts());
    }

    private void onAccounts() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Accounts");
    }

    private void onTransactions() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Transactions");
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Dashboard");
    }
}
