package com.example.prototipo.controllers;

import com.example.prototipo.SampleData;
import com.example.prototipo.SceneController;
import com.example.prototipo.models.InvoiceItem;
import com.example.prototipo.models.Product;
import com.example.prototipo.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaleController implements Initializable {

    final int numCols = 4 ;
    final int numRows = 4 ;

    private ObservableList<Product> products;
    private ObservableList<InvoiceItem> invoiceItems;
    private SceneController control = new SceneController();
    @FXML
    private Pane catalogPane;
    @FXML
    private Button clearButton;

    private GridPane gridCatalog;

    @FXML
    private ListView<InvoiceItem> invoiceList;

    @FXML
    private TableColumn<?, ?> price;

    @FXML
    private TableColumn<?, ?> product;

    @FXML
    private Button sellButton;

    @FXML
    private Label lblTotal;

    @FXML
    private TextField searchBar;

    @Override
    public void initialize(URL location, ResourceBundle rb){
        invoiceItems = FXCollections.observableArrayList();
        products = getProducts();
        initGridCatalog();
        setGridData();
        invoiceList.setCellFactory(param -> new ListCell<InvoiceItem>() {
            @Override
            protected void updateItem(InvoiceItem item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    String text = item.getName() + " X " + item.getQuantity();
                    text += "     " + (int)(item.getPrice() * item.getQuantity());
                    setText(text);
                }
            }
        });
        invoiceList.setItems(invoiceItems);
    }

    private void initGridCatalog(){
        gridCatalog = new GridPane();
        gridCatalog.setPrefHeight(472);
        gridCatalog.setPrefWidth(600);
        gridCatalog.setLayoutX(14);
        gridCatalog.setLayoutY(50);
        catalogPane.getChildren().add(gridCatalog);
        gridCatalog.setHgap(10);
        gridCatalog.setVgap(20);
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            gridCatalog.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            gridCatalog.getRowConstraints().add(rowConst);
        }
    }

    private void setGridData() {
        int count = 0;
        for(int i = 0; i < numCols; i++){
            for(int j = 0; j < numRows; j++){
                if(count >= products.size()) return;
                //VBOX
                VBox vbox = new VBox();
                vbox.setBackground(Background.fill(Paint.valueOf("#484848")));
                vbox.setAlignment(Pos.TOP_CENTER);
                vbox.getStyleClass().add("item");
                vbox.setId(Integer.toString(count));
                vbox.setOnMouseClicked((MouseEvent event) -> {
                    Node source = (Node)event.getSource();
                    int id = Integer.parseInt(source.getId());
                    Product selectedProduct = products.get(id);
                    InvoiceItem invoiceItem = new InvoiceItem();
                    invoiceItem.setCode(selectedProduct.getCodigo());
                    invoiceItem.setName(selectedProduct.getNombre());
                    invoiceItem.setPrice(selectedProduct.getPrecio());
                    invoiceItem.setQuantity(1);
                    boolean isNew = true;
                    for(int v = 0; v < invoiceItems.size(); v++){
                        if(invoiceItems.get(v).getCode() == invoiceItem.getCode()){
                            int prevQuantity = invoiceItems.get(v).getQuantity();
                            invoiceItems.get(v).setQuantity(prevQuantity + 1);
                            isNew = false;
                            break;
                        }
                    }
                    if(isNew) invoiceItems.add(invoiceItem);
                    invoiceList.refresh();
                    float total = 0;
                    for(InvoiceItem item : invoiceItems){
                        total += item.getQuantity() * item.getPrice();
                    }
                    lblTotal.setText(Float.toString(total));
                    if(invoiceItems.size() > 0) changeButtonDisabled(false);
                });
                //LABEL
                Label lblProduct = new Label();
                lblProduct.setText(products.get(count).getNombre());
                lblProduct.setLayoutY(2);
                lblProduct.setTextFill(Paint.valueOf("#fff"));
                vbox.getChildren().add(lblProduct);
                //IMAGEVIEW
                ImageView img = products.get(count).getFoto();
                img.setFitHeight(80);
                img.setFitWidth(80);
                vbox.getChildren().add(img);
                //ADD VBOX TO GRID
                gridCatalog.add(vbox, j, i);
                count++;
            }
        }
    }
    public ObservableList<Product> getProducts() {
        SampleData data = new SampleData();
        ObservableList<Product> products = FXCollections.observableArrayList(data.getProducts());
        return products;
    }

    @FXML
    void onClearHandle(ActionEvent event) {
        invoiceItems.clear();
        lblTotal.setText("0.00");
        invoiceList.refresh();
        changeButtonDisabled(true);
    }

    @FXML
    void onSellHandle(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("soldMessage.fxml"));
        Parent soldMessageDialogPane = fxmlLoader.load();

        final Stage soldMessageModal = new Stage();
        soldMessageModal.initStyle(StageStyle.DECORATED);
        soldMessageModal.initModality(Modality.APPLICATION_MODAL);
        Scene dialogScene = new Scene(soldMessageDialogPane);
        soldMessageModal.setScene(dialogScene);
        soldMessageModal.show();
        invoiceItems.clear();
        lblTotal.setText("0.00");
        invoiceList.refresh();
        changeButtonDisabled(true);
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
    protected void handleSearchItem(MouseEvent event) {
        /*
        String searchTerm = searchBar.getText();
        if(searchTerm == "") return;
        SampleData data = new SampleData();
        List<Product> newProducts = data.getProducts();
        Pattern pattern = Pattern.compile(searchTerm, Pattern.CASE_INSENSITIVE);
        newProducts.removeIf(product -> {
            Matcher matcher = pattern.matcher(product.getNombre());
            return !matcher.find();
        });
        System.out.println(newProducts.size());
        products = FXCollections.observableArrayList(newProducts);
        setGridData();

         */
    }

    private void changeButtonDisabled(boolean state){
        sellButton.setDisable(state);
        clearButton.setDisable(state);
    }
}
