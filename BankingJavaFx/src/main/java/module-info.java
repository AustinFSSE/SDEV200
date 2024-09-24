module org.example.bankingjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.xerial.sqlitejdbc;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires jdk.jfr;


    opens org.example.bankingjavafx to javafx.fxml;
    exports org.example.bankingjavafx;
    exports org.example.bankingjavafx.Controllers;
    exports org.example.bankingjavafx.Controllers.admin;
    exports org.example.bankingjavafx.Controllers.Client;
    exports org.example.bankingjavafx.Models;
    exports org.example.bankingjavafx.Views;
}