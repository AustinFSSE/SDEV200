package com.github.austinfsse.sdev200.paone;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Staffing implements Initializable {

    DatabaseDriver driver = new DatabaseDriver();

    public Button view_btn;
    public Button insert_btn;
    public Button update_btn;
    public Button clear_btn;
    public TextField id_fld;
    public TextField lname_fld;
    public TextField mInitial_fld;
    public TextField fname_fld;
    public TextField addr_fld;
    public TextField state_fld;
    public TextField city_fld;
    public TextField telephone_fld;
    public Label error_lbl;
    public Label success_lbl;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        insert_btn.setOnAction(e -> {
            driver.createTable();
            String Id = id_fld.getText().isEmpty() ? "null" : id_fld.getText();
            String firstName = fname_fld.getText().isEmpty() ? "null" : fname_fld.getText();
            String lastName = lname_fld.getText().isEmpty() ? "null": lname_fld.getText();
            String initial = mInitial_fld.getText().isEmpty() ? "null" : mInitial_fld.getText();
            String address = addr_fld.getText().isEmpty() ? "null" : addr_fld.getText();
            String state = state_fld.getText().isEmpty() ? "null" : state_fld.getText();
            String city = city_fld.getText().isEmpty() ? "null" : city_fld.getText();
            String telephone = telephone_fld.getText().isEmpty() ? "null" : telephone_fld.getText();
            driver.insertRecord(Id, firstName, lastName, initial, address, state, city, telephone);
        });

        clear_btn.setOnAction(e -> {
            id_fld.setText("");
            fname_fld.setText("");
            lname_fld.setText("");
            mInitial_fld.setText("");
            addr_fld.setText("");
            state_fld.setText("");
            city_fld.setText("");
            telephone_fld.setText("");
            error_lbl.setText("");
            success_lbl.setText("");
        });

        view_btn.setOnAction(e -> {
            String id = id_fld.getText().isEmpty() ? null : id_fld.getText();
            String[] elements = driver.viewRecord(id);
            if (elements[0] != null) {
                for (String element : elements) {
                    System.out.print(element + " ");
                }
                success_lbl.setText("RECORD FOUND");
            } else {
                error_lbl.setText("NOT FOUND");
                System.out.println("No record found");
            }

        });

        update_btn.setOnAction(e -> {
            String id = id_fld.getText().isEmpty() ? null : id_fld.getText();
            String lastName = lname_fld.getText().isEmpty() ? null : lname_fld.getText();
            String firstName = fname_fld.getText().isEmpty() ? null : fname_fld.getText();
            String initial = mInitial_fld.getText().isEmpty() ? null : mInitial_fld.getText();
            String address = addr_fld.getText().isEmpty() ? null : addr_fld.getText();
            String state = state_fld.getText().isEmpty() ? null : state_fld.getText();
            String city = city_fld.getText().isEmpty() ? null : city_fld.getText();
            String telephone = telephone_fld.getText().isEmpty() ? null : telephone_fld.getText();

            if (firstName != null && !firstName.isEmpty()) {
                String insertRecordSQL = "INSERT INTO Staff " +
                        "(ID_number, lastname, firstname, mi, address, city, state, telephone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)" +
                        "ON CONFLICT(ID_number) DO UPDATE SET " + "firstname = excluded.firstname";
                driver.updateRecord(insertRecordSQL, id, lastName, firstName, initial, address, city, state, telephone);
            }
            if (lastName != null && !lastName.isEmpty()) {
                String insertRecordSQL = "INSERT INTO Staff " +
                        "(ID_number, lastname, firstname, mi, address, city, state, telephone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)" +
                        "ON CONFLICT(ID_number) DO UPDATE SET " + "lastname = excluded.lastname";
                driver.updateRecord(insertRecordSQL, id, lastName, firstName, initial, address, city, state, telephone);
            }
            if (initial != null && !initial.isEmpty()) {
                String insertRecordSQL = "INSERT INTO Staff " +
                        "(ID_number, lastname, firstname, mi, address, city, state, telephone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)" +
                        "ON CONFLICT(ID_number) DO UPDATE SET " + "initial = excluded.initial";
                driver.updateRecord(insertRecordSQL, id, lastName, firstName, initial, address, city, state, telephone);
            }
            if (address != null && !address.isEmpty()) {
                String insertRecordSQL = "INSERT INTO Staff " +
                        "(ID_number, lastname, firstname, mi, address, city, state, telephone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)" +
                        "ON CONFLICT(ID_number) DO UPDATE SET " + "address = excluded.address";
                driver.updateRecord(insertRecordSQL, id, lastName, firstName, initial, address, city, state, telephone);
            }
            if (state != null && !state.isEmpty()) {
                String insertRecordSQL = "INSERT INTO Staff " +
                        "(ID_number, lastname, firstname, mi, address, city, state, telephone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)" +
                        "ON CONFLICT(ID_number) DO UPDATE SET " + "state = excluded.state";
                driver.updateRecord(insertRecordSQL, id, lastName, firstName, initial, address, city, state, telephone);
            }
            if (city != null && !city.isEmpty()) {
                String insertRecordSQL = "INSERT INTO Staff " +
                        "(ID_number, lastname, firstname, mi, address, city, state, telephone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)" +
                        "ON CONFLICT(ID_number) DO UPDATE SET " + "city = excluded.city";
                driver.updateRecord(insertRecordSQL, id, lastName, firstName, initial, address, city, state, telephone);
            }
            if (telephone != null && !telephone.isEmpty()) {
                String insertRecordSQL = "INSERT INTO Staff " +
                        "(ID_number, lastname, firstname, mi, address, city, state, telephone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)" +
                        "ON CONFLICT(ID_number) DO UPDATE SET " + "telephone = excluded.telephone";
                driver.updateRecord(insertRecordSQL, id, lastName, firstName, initial, address, city, state, telephone);
            }
        });
    }
}
