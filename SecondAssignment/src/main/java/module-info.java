module org.example.secondassignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.secondassignment to javafx.fxml;
    exports org.example.secondassignment;
}