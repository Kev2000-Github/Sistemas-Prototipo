package com.example.prototipo.controllers;

import com.example.prototipo.SceneController;
import com.example.prototipo.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private SceneController control = new SceneController();
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;
    @FXML
    private Button helpButton;

    @Override
    public void initialize(URL location, ResourceBundle rb){
        Tooltip helpTip = new Tooltip("Bienvenido al prototipo de Ankara System! \nDado que es una version temprana del sistema, \nvamos a proporcionar las credenciales de acceso");
        helpTip.setShowDelay(Duration.seconds(0));
        helpButton.setTooltip(helpTip);
        Tooltip credentialsTip = new Tooltip("entrar como admin: admin\nentrar como encargado de inventario: inventario\nentrar como operador: operador");
        credentialsTip.setShowDelay(Duration.seconds(0.05));
        usernameField.setTooltip(credentialsTip);
        passwordField.setTooltip(credentialsTip);
    }

    @FXML
    protected void onLogin(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        if(username.equals("admin") && password.equals("admin")){
            User user = new User("admin",username);
            stage.setUserData(user);
            control.toHome(event);
        }
        else if(username.equals("inventario") && password.equals("inventario")){
            User user = new User("inventario",username);
            stage.setUserData(user);
            control.toInventory(event);
        }
        else if(username.equals("operador") && password.equals("operador")){
            User user = new User("operador",username);
            stage.setUserData(user);
            control.toSale(event);
        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("errorLoginMessage.fxml"));
            Parent errorCredentialsDialogPane = fxmlLoader.load();

            final Stage warnMessageModal = new Stage();
            warnMessageModal.initStyle(StageStyle.DECORATED);
            warnMessageModal.initModality(Modality.APPLICATION_MODAL);
            Scene dialogScene = new Scene(errorCredentialsDialogPane);
            warnMessageModal.setScene(dialogScene);
            warnMessageModal.show();
        }
    }

}
