module com.github.austinfsse.sdev200.patwo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.github.austinfsse.sdev200.patwo to javafx.fxml;
    exports com.github.austinfsse.sdev200.patwo;
}