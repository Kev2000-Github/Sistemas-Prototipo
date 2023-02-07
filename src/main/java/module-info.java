module com.example.prototipo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires de.jensd.fx.glyphs.fontawesome;

    opens com.example.prototipo to javafx.fxml;
    exports com.example.prototipo;
    exports com.example.prototipo.controllers;
    exports com.example.prototipo.models;
    exports com.example.prototipo.utils;
    opens com.example.prototipo.controllers to javafx.fxml;
}