package com.github.austinfsse.sdev200.paone;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Staffing implements Initializable {

    // Creates a DatabaseDriver instance to handle database interactions
    DatabaseDriver driver = new DatabaseDriver();

    // FXML fields for buttons, text fields, and labels used in the interface
    public Button view_btn, insert_btn, update_btn, clear_btn;
    public TextField id_fld, lname_fld, mInitial_fld, fname_fld, addr_fld, state_fld, city_fld, telephone_fld;
    public Label error_lbl, success_lbl;

    // Method that is called automatically when the class is loaded to initialize components
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Event handler for the insert button
        insert_btn.setOnAction(e -> {
            driver.createTable(); // Create the table if it doesn't exist
            // Gather input from text fields, assigning "null" if the field is empty
            String Id = id_fld.getText().isEmpty() ? "null" : id_fld.getText();
            String firstName = fname_fld.getText().isEmpty() ? "null" : fname_fld.getText();
            String lastName = lname_fld.getText().isEmpty() ? "null" : lname_fld.getText();
            String initial = mInitial_fld.getText().isEmpty() ? "null" : mInitial_fld.getText();
            String address = addr_fld.getText().isEmpty() ? "null" : addr_fld.getText();
            String state = state_fld.getText().isEmpty() ? "null" : state_fld.getText();
            String city = city_fld.getText().isEmpty() ? "null" : city_fld.getText();
            String telephone = telephone_fld.getText().isEmpty() ? "null" : telephone_fld.getText();
            // Insert the record using the driver object
            driver.insertRecord(Id, firstName, lastName, initial, address, state, city, telephone);
        });

        // Event handler for the clear button, clears all text fields and labels
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

        // Event handler for the view button, retrieves and displays a record based on ID
        view_btn.setOnAction(e -> {
            String id = id_fld.getText().isEmpty() ? null : id_fld.getText();
            String[] elements = driver.viewRecord(id); // Retrieve the record
            if (elements[0] != null) {
                for (String element : elements) {
                    System.out.print(element + "\n"); // Print each field of the record
                }
                success_lbl.setText("RECORD FOUND");
            } else {
                error_lbl.setText("NOT FOUND");
                System.out.println("No record found");
            }
        });

        // Event handler for the update button, updates record fields individually
        update_btn.setOnAction(e -> {
            // Fetch the input from fields, assigning null if a field is empty
            String id = id_fld.getText().isEmpty() ? null : id_fld.getText();
            String lastName = lname_fld.getText().isEmpty() ? null : lname_fld.getText();
            String firstName = fname_fld.getText().isEmpty() ? null : fname_fld.getText();
            String mi = mInitial_fld.getText().isEmpty() ? null : mInitial_fld.getText();
            String address = addr_fld.getText().isEmpty() ? null : addr_fld.getText();
            String state = state_fld.getText().isEmpty() ? null : state_fld.getText();
            String city = city_fld.getText().isEmpty() ? null : city_fld.getText();
            String telephone = telephone_fld.getText().isEmpty() ? null : telephone_fld.getText();

            // Update the firstname if it was entered
            if (firstName != null && !firstName.isEmpty()) {
                String insertRecordSQL = "INSERT INTO staff " +
                        "(ID_number, lastname, firstname, mi, address, city, state, telephone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)" +
                        "ON CONFLICT(ID_number) DO UPDATE SET firstname = excluded.firstname";
                driver.updateRecord(insertRecordSQL, id, lastName, firstName, mi, address, city, state, telephone);
            }
            // Similarly update other fields if they are entered
            if (lastName != null && !lastName.isEmpty()) {
                String insertRecordSQL = "INSERT INTO staff " +
                        "(ID_number, lastname, firstname, mi, address, city, state, telephone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)" +
                        "ON CONFLICT(ID_number) DO UPDATE SET lastname = excluded.lastname";
                driver.updateRecord(insertRecordSQL, id, lastName, firstName, mi, address, city, state, telephone);
            }
            // Repeat for middle initial, address, state, city, and telephone
            if (mi != null && !mi.isEmpty()) {
                String insertRecordSQL = "INSERT INTO staff " +
                        "(ID_number, lastname, firstname, mi, address, city, state, telephone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)" +
                        "ON CONFLICT(ID_number) DO UPDATE SET mi = excluded.mi";
                driver.updateRecord(insertRecordSQL, id, lastName, firstName, mi, address, city, state, telephone);
            }
            if (address != null && !address.isEmpty()) {
                String insertRecordSQL = "INSERT INTO staff " +
                        "(ID_number, lastname, firstname, mi, address, city, state, telephone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)" +
                        "ON CONFLICT(ID_number) DO UPDATE SET address = excluded.address";
                driver.updateRecord(insertRecordSQL, id, lastName, firstName, mi, address, city, state, telephone);
            }
            if (state != null && !state.isEmpty()) {
                String insertRecordSQL = "INSERT INTO staff " +
                        "(ID_number, lastname, firstname, mi, address, city, state, telephone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)" +
                        "ON CONFLICT(ID_number) DO UPDATE SET state = excluded.state";
                driver.updateRecord(insertRecordSQL, id, lastName, firstName, mi, address, city, state, telephone);
            }
            if (city != null && !city.isEmpty()) {
                String insertRecordSQL = "INSERT INTO staff " +
                        "(ID_number, lastname, firstname, mi, address, city, state, telephone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)" +
                        "ON CONFLICT(ID_number) DO UPDATE SET city = excluded.city";
                driver.updateRecord(insertRecordSQL, id, lastName, firstName, mi, address, city, state, telephone);
            }
            if (telephone != null && !telephone.isEmpty()) {
                String insertRecordSQL = "INSERT INTO staff " +
                        "(ID_number, lastname, firstname, mi, address, city, state, telephone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)" +
                        "ON CONFLICT(ID_number) DO UPDATE SET telephone = excluded.telephone";
                driver.updateRecord(insertRecordSQL, id, lastName, firstName, mi, address, city, state, telephone);
            }
        });
    }
}
