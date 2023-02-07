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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {
    @FXML
    private TableView<Product> table;
    private SceneController control = new SceneController();

    @FXML
    private TableColumn<Product, String> codeColumn;

    @FXML
    private TableColumn<Product, String> descriptionColumn;

    @FXML
    private TableColumn<Product, String> nameColumn;

    @FXML
    private TableColumn<Product, String> photoColumn;

    @FXML
    private TableColumn<Product, String> priceColumn;

    @FXML
    private Button createButton;

    @FXML
    private Button editButton;

    @Override
    public void initialize(URL location, ResourceBundle rb){
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("precio"));
        photoColumn.setCellValueFactory(new PropertyValueFactory<>("foto"));
        table.setItems(getProducts());

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelect, newSelect) -> {
            if(newSelect != null) {
                editButton.setDisable(false);
            }
            else {
                editButton.setDisable(true);
            }
        });
    }

    public ObservableList<Product> getProducts() {
        SampleData data = new SampleData();
        ObservableList<Product> products = FXCollections.observableArrayList(data.getProducts());
        return products;
    }
    @FXML
    protected void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        User user = (User)stage.getUserData();
        if(user.getUserType().equals("admin")){
            control.toHome(event);
        }
        else {
            control.toLogin(event);
        }
    }

    @FXML
    protected void handleCreate(ActionEvent event) throws IOException {
        Product product = null;
        String dialogTitle = "";

        if(event.getSource().equals(editButton)){
            dialogTitle = "Actualizar Producto";
            product = table.getSelectionModel().getSelectedItem();
        }
        else if(event.getSource().equals(createButton)){
            dialogTitle = "Crear Producto";
            product = new Product();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("productEditor.fxml"));
        Parent productDialogPane = fxmlLoader.load();
        ProductEditorController productEditorController = fxmlLoader.getController();
        productEditorController.setProduct(product);

        final Stage productEditorModal = new Stage();
        productEditorModal.initModality(Modality.APPLICATION_MODAL);
        Scene dialogScene = new Scene(productDialogPane);
        productEditorModal.setScene(dialogScene);
        productEditorModal.setTitle(dialogTitle);
        productEditorModal.show();
    }
}
