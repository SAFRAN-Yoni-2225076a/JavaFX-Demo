module com.example.tp1_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.tp1_javafx to javafx.fxml;
    exports com.example.tp1_javafx;
    exports com.example.partie1;
    exports com.example.partie2;
}