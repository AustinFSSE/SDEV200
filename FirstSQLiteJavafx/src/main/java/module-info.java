module org.example.firstsqlitejavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.firstsqlitejavafx to javafx.fxml;
    exports org.example.firstsqlitejavafx;
}