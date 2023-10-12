module com.example.javafxapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    exports com.example.javafxapp.controllers to javafx.fxml;
    opens com.example.javafxapp.controllers to javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.javafxapp to javafx.fxml;
    exports com.example.javafxapp;
}