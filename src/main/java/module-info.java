module com.example.loginscriptjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.loginscriptjavafx to javafx.fxml;
    exports com.example.loginscriptjavafx;
}