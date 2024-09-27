package org.example.bankingjavafx.Controllers.admin;

import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateClientController implements Initializable {
    public TextField fname_fld;
    public TextField lname_fld;
    public PasswordField pwd_fld;
    public CheckBox payee_check_box;
    public Label payee_addr_lbl;
    public CheckBox ch_acc_chkbox;
    public TextField ch_acc_bal_fld;
    public CheckBox sv_acc_fld;
    public TextField sv_acc_bal_fld;
    public Button create_client_btn;
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
