module com.github.austinfsse.sdev.paone {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.github.austinfsse.sdev200.paone to javafx.fxml;
    exports com.github.austinfsse.sdev200.paone;
}