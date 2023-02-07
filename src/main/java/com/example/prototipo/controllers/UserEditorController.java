package com.example.prototipo.controllers;

import com.example.prototipo.models.Product;
import com.example.prototipo.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserEditorController implements Initializable {
    private User user;
    @FXML
    private TextField codeField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private ComboBox<String> typeCombo;

    public ObservableList<String> getUserTypes() {
        ArrayList<String> userTypes = new ArrayList<String>();
        userTypes.add("admin");
        userTypes.add("inventario");
        userTypes.add("operador");
        ObservableList<String> observableUserTypes = FXCollections.observableArrayList(userTypes);
        return observableUserTypes;
    }
    @FXML
    void handleSave(ActionEvent event) {

    }

    public void setUser(User user){
        this.user = user;
        codeField.setText(user.getCodigo());
        usernameField.setText(user.getUsername());
        typeCombo.setValue(user.getUserType());
    }

    @Override
    public void initialize(URL location, ResourceBundle rb){
        typeCombo.setItems(getUserTypes());
    }
}
