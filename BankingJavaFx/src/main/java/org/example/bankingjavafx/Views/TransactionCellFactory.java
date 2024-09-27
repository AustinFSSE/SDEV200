package org.example.bankingjavafx.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import org.example.bankingjavafx.Controllers.Client.TransactionCellController;
import org.example.bankingjavafx.Models.Transaction;

import java.io.IOException;

public class TransactionCellFactory extends ListCell<Transaction> {
    @Override
    protected void updateItem(Transaction item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Client/TransactionCell.fxml"));
            TransactionCellController controller = new TransactionCellController(item);
            fxmlLoader.setController(controller);
            setText(null);
            try {
                setGraphic(fxmlLoader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
