package com.example.prototipo.controllers;

import com.example.prototipo.models.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ProductEditorController {
    private Product product;
    @FXML
    private TextField codeField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;

    public void setProduct(Product product){
        this.product = product;
        codeField.setText(product.getCodigo());
        descriptionField.setText(product.getDescripcion());
        nameField.setText(product.getNombre());
        priceField.setText(Float.toString(product.getPrecio()));
    }
    @FXML
    void handleFile(ActionEvent event) {

    }
    @FXML
    void handleSave(ActionEvent event) {

    }
}
