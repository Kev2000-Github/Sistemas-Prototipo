package com.example.prototipo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private void switchScene(ActionEvent event, String resourcePath) throws IOException {
        root = FXMLLoader.load(getClass().getResource(resourcePath));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toLogin(ActionEvent event) throws IOException {
        switchScene(event, "login.fxml");
    }

    public void toHome(ActionEvent event) throws IOException {
        switchScene(event, "home.fxml");
    }

    public void toInventory(ActionEvent event) throws IOException {
        switchScene(event, "inventory.fxml");
    }

    public void toSale(ActionEvent event) throws IOException {
        switchScene(event, "sale.fxml");
    }

    public void toReport(ActionEvent event) throws IOException {
        switchScene(event, "report.fxml");
    }

    public void toUser(ActionEvent event) throws IOException {
        switchScene(event, "user.fxml");
    }
}
