package org.example.bankingjavafx.Controllers.admin;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.bankingjavafx.Models.Client;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientCellController implements Initializable {
    public Label fName_lbl;
    public Label lName_lbl;
    public Label pAddr_lbl;
    public Label ch_acc_lbl;
    public Label sv_acc_lbl;
    public Label date_lbl;
    public Button delete_btn;

    private final Client client;
    public Client getClient() {
        return client;
    }

    public ClientCellController(Client item) {
        this.client = item;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
