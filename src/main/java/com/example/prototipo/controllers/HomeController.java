package com.example.prototipo.controllers;

import com.example.prototipo.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.controlsfx.control.action.Action;

import java.io.IOException;

public class HomeController {
    private SceneController control = new SceneController();
    @FXML
    protected void goBack(ActionEvent event) throws IOException {
        control.toLogin(event);
    }
    @FXML
    protected void goSales(ActionEvent event) throws IOException {
        control.toSale(event);
    }
    @FXML
    protected void goInventory(ActionEvent event) throws IOException {
        control.toInventory(event);
    }
    @FXML
    protected void goUsers(ActionEvent event) throws IOException {
        control.toUser(event);
    }
    @FXML
    protected void goReport(ActionEvent event) throws IOException {
        control.toReport(event);
    }
}
