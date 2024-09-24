module org.example.thirdassignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.thirdassignment to javafx.fxml;
    exports org.example.thirdassignment;
}