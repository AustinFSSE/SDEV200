package org.example.bankingjavafx.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import org.example.bankingjavafx.Controllers.admin.ClientCellController;
import org.example.bankingjavafx.Models.Client;

import java.io.IOException;

public class ClientCellFactory extends ListCell <Client> {

    @Override
    protected void updateItem(Client item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Admin/ClientCell.fxml"));
            ClientCellController controller = new ClientCellController(item);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
