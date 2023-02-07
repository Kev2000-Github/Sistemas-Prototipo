package com.example.prototipo.controllers;

import com.example.prototipo.SampleData;
import com.example.prototipo.SceneController;
import com.example.prototipo.models.Product;
import com.example.prototipo.models.ReportInventory;
import com.example.prototipo.models.ReportSales;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class ReportController implements Initializable {
    //Atributes from Sales Report
    private ObservableList<ReportSales> reportSales;
    private ObservableList<ReportInventory> reportInventories;
    private SceneController control = new SceneController();
    @FXML
    private GridPane pnInventario;

    @FXML
    private GridPane pnVentas;
    @FXML
    private TableView<ReportInventory> inventoryTable;
    @FXML
    private TableView<ReportSales> saleTable;
    @FXML
    private TableColumn<?, ?> saleCliente;

    @FXML
    private TableColumn<?, ?> saleCodigo;

    @FXML
    private TableColumn<ReportSales, Date> saleFecha;

    @FXML
    private TableColumn<ReportSales, Date> saleHora;

    @FXML
    private TableColumn<?, ?> saleMonto;
    @FXML
    private DatePicker saleFrom;
    @FXML
    private DatePicker saleTo;
    @FXML
    private TableColumn<?, ?> inventoryCantidad;

    @FXML
    private TableColumn<?, ?> inventoryCodigo;

    @FXML
    private TableColumn<ReportInventory, Date> inventoryFecha;

    @FXML
    private DatePicker inventoryFrom;

    @FXML
    private TableColumn<?, ?> inventoryMovimiento;

    @FXML
    private TableColumn<?, ?> inventoryNombre;

    @FXML
    private DatePicker inventoryTo;

    @Override
    public void initialize(URL location, ResourceBundle rb){
        try {
            //REPORT SALES TABLE
            reportSales = getReportSales();
            saleCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
            saleFecha.setCellValueFactory(new PropertyValueFactory<>("creadoEn"));
            saleFecha.setCellFactory(column -> {
                TableCell<ReportSales, Date> cell = new TableCell<ReportSales, Date>() {
                    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    @Override
                    protected void updateItem(Date item, boolean isEmpty) {
                        super.updateItem(item, isEmpty);
                        if(isEmpty) setText(null);
                        else setText(format.format(item));
                    }
                };
                return cell;
            });
            saleHora.setCellFactory(column -> {
                TableCell<ReportSales, Date> cell = new TableCell<ReportSales, Date>() {
                    private SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
                    @Override
                    protected void updateItem(Date item, boolean isEmpty) {
                        super.updateItem(item, isEmpty);
                        if(isEmpty) setText(null);
                        else setText(format.format(item));
                    }
                };
                return cell;
            });
            saleHora.setCellValueFactory(new PropertyValueFactory<>("creadoEn"));
            saleCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
            saleMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
            saleTable.setItems(reportSales);

            //REPORT INVENTORY TABLE
            reportInventories = getReportInventories();
            inventoryCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
            inventoryFecha.setCellValueFactory(new PropertyValueFactory<>("creadoEn"));
            inventoryFecha.setCellFactory(column -> {
                TableCell<ReportInventory, Date> cell = new TableCell<ReportInventory, Date>() {
                    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    @Override
                    protected void updateItem(Date item, boolean isEmpty) {
                        super.updateItem(item, isEmpty);
                        if(isEmpty) setText(null);
                        else setText(format.format(item));
                    }
                };
                return cell;
            });
            inventoryNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            inventoryMovimiento.setCellValueFactory(new PropertyValueFactory<>("movimiento"));
            inventoryCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
            inventoryTable.setItems(reportInventories);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<ReportSales> getReportSales() throws ParseException {
        SampleData data = new SampleData();
        ObservableList<ReportSales> reportSales = FXCollections.observableArrayList(data.getSaleReport());
        return reportSales;
    }
    public ObservableList<ReportInventory> getReportInventories() throws ParseException {
        SampleData data = new SampleData();
        ObservableList<ReportInventory> reportInventories = FXCollections.observableArrayList(data.getInventoryReports());
        return reportInventories;
    }
    @FXML
    protected void goBack(ActionEvent event) throws IOException {
        control.toHome(event);
    }
    @FXML
    protected void toReportVenta(ActionEvent event) throws IOException {
        pnVentas.toFront();
    }
    @FXML
    protected void toReportInventario(ActionEvent event) throws IOException {
        pnInventario.toFront();
    }

    @FXML
    void onEditDate(ActionEvent event) throws ParseException {
        LocalDate from = saleFrom.getValue();
        LocalDate to = saleTo.getValue();
        if(from != null && to != null){
            ArrayList<ReportSales> newReports = new ArrayList<>();
            SampleData data = new SampleData();
            for(ReportSales element : data.getSaleReport()){
                Instant createdAt =  element.getCreadoEn().toInstant();
                Instant fromInstant = from.atStartOfDay(ZoneId.systemDefault()).toInstant();
                Instant toInstant = to.atStartOfDay(ZoneId.systemDefault()).toInstant();
                boolean withinRange = createdAt.isAfter(fromInstant) && createdAt.isBefore(toInstant);
                if(withinRange){
                    newReports.add(element);
                }
            }
            reportSales.setAll(FXCollections.observableArrayList(newReports));
        }
    }

    @FXML
    void onEditDateInventory(ActionEvent event) throws ParseException {
        LocalDate from = inventoryFrom.getValue();
        LocalDate to = inventoryTo.getValue();
        if(from != null && to != null){
            ArrayList<ReportInventory> newReports = new ArrayList<>();
            SampleData data = new SampleData();
            for(ReportInventory element : data.getInventoryReports()){
                Instant createdAt =  element.getCreadoEn().toInstant();
                Instant fromInstant = from.atStartOfDay(ZoneId.systemDefault()).toInstant();
                Instant toInstant = to.atStartOfDay(ZoneId.systemDefault()).toInstant();
                boolean withinRange = createdAt.isAfter(fromInstant) && createdAt.isBefore(toInstant);
                if(withinRange){
                    newReports.add(element);
                }
            }
            reportInventories.setAll(FXCollections.observableArrayList(newReports));
        }
    }
}
