package org.example.bankingjavafx.Controllers;


import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.bankingjavafx.Models.Model;
import org.example.bankingjavafx.Views.AccountType;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public ChoiceBox<AccountType> account_selector;
    public Label user_id_lbl;
    public TextField user_id_field;
    public Label user_password_lbl;
    public TextField user_password_field;
    public Button login_button;
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        account_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT, AccountType.ADMIN));
        account_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        account_selector.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(account_selector.getValue()));
        login_button.setOnAction(event -> onLogin());
    }

    private void onLogin() {
        Stage stage = (Stage) error_lbl.getScene().getWindow();

        if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CLIENT) {
            // validate login credentials for client
            Model.getInstance().evaluateClientCred(user_id_field.getText(), user_password_field.getText());
            if (Model.getInstance().isClientLoginSuccessFlag()) {
                // close login stage
                Model.getInstance().getViewFactory().closeStage(stage);
            } else {
                user_id_field.setText("");
                user_password_field.setText("");
                error_lbl.setText("Incorrect username or password");
            }
        } else {
            Model.getInstance().getViewFactory().showAdminWindow();
        }
    }
}
