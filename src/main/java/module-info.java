module com.example.loginsystemdb {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens com.example.loginsystemdb to javafx.fxml;
    exports com.example.loginsystemdb;
}