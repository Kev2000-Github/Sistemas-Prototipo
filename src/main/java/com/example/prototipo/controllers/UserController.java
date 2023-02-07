package com.example.prototipo.controllers;

import com.example.prototipo.SampleData;
import com.example.prototipo.SceneController;
import com.example.prototipo.models.Product;
import com.example.prototipo.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    private SceneController control = new SceneController();
    @FXML
    private TableColumn<?, ?> codeColumn;

    @FXML
    private Button createButton;

    @FXML
    private Button editButton;

    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<?, ?> typeColumn;

    @FXML
    private TableColumn<?, ?> usernameColumn;

    @Override
    public void initialize(URL location, ResourceBundle rb){
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("userType"));
        table.setItems(getUsers());

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelect, newSelect) -> {
            if(newSelect != null) {
                editButton.setDisable(false);
            }
            else {
                editButton.setDisable(true);
            }
        });
    }

    public ObservableList<User> getUsers() {
        SampleData data = new SampleData();
        ObservableList<User> users = FXCollections.observableArrayList(data.getUsers());
        return users;
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        control.toHome(event);
    }

    @FXML
    void handleCreate(ActionEvent event) throws IOException {
        User user = null;
        String dialogTitle = "";

        if(event.getSource().equals(editButton)){
            dialogTitle = "Actualizar Usuario";
            user = table.getSelectionModel().getSelectedItem();
        }
        else if(event.getSource().equals(createButton)){
            dialogTitle = "Crear Usuario";
            user = new User();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("userEditor.fxml"));
        Parent productDialogPane = fxmlLoader.load();
        UserEditorController userEditorController = fxmlLoader.getController();
        userEditorController.setUser(user);

        final Stage userEditorModal = new Stage();
        userEditorModal.initModality(Modality.APPLICATION_MODAL);
        Scene dialogScene = new Scene(productDialogPane);
        userEditorModal.setScene(dialogScene);
        userEditorModal.setTitle(dialogTitle);
        userEditorModal.show();
    }
}
