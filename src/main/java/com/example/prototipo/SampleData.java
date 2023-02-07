package com.example.prototipo;

import com.example.prototipo.models.Product;
import com.example.prototipo.models.ReportInventory;
import com.example.prototipo.models.ReportSales;
import com.example.prototipo.models.User;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SampleData {

    public Image getImage(String path){
        return new Image(getClass().getResourceAsStream(path));
    }
    public List<Product> getProducts(){
        List<Product> products = new ArrayList<Product>();
        ImageView defaultImage = new ImageView(getImage("Images/cake.png"));
        products.add(new Product("Z1","pelota",new ImageView(getImage("Images/pelota.jpg")),"pelota de beisbol",12));
        products.add(new Product("Z2","plato",new ImageView(getImage("Images/plato.jpg")),"plato de la dinastia ming",5));
        products.add(new Product("Z3","Vino",new ImageView(getImage("Images/vino.jpg")),"Vino de la Monarquia Francesa",8));
        products.add(new Product("Z4","Polistation",new ImageView(getImage("Images/polistation.jpg")),"La decepcion navideña de muchas juventudes",30));
        products.add(new Product("Z5","Brocha",new ImageView(getImage("Images/brocha.jpg")),"Brocha de 3 pulgadas zebra",2));
        products.add(new Product("Z6","Mouse Ryzen",new ImageView(getImage("Images/mouse.jpg")),"Mouse gamer ryzen con luces RGB",30));
        products.add(new Product("Z7","Termo tuHogar",new ImageView(getImage("Images/termo.jpg")),"Termo multi-terreno",10));
        products.add(new Product("Z8","Camisa Naruto",new ImageView(getImage("Images/camisa.jpg")),"Camiseta de naruto",10));
        products.add(new Product("Z9","Bombillo LED",new ImageView(getImage("Images/bombillo.jpg")),"Bombillo LED 10w",30));
        products.add(new Product("Z10","GTA5",new ImageView(getImage("Images/gtav.jpg")),"Gran hitazo de Rockstar",30));
        products.add(new Product("Z11","Malta",new ImageView(getImage("Images/malta.jpeg")),"Divina bebida de los Dioses",1));
        products.add(new Product("Z12","Pepsi",new ImageView(getImage("Images/pesi.jpg")),"Imitacion de Cocacola",2));
        products.add(new Product("Z13","Harina Pan",new ImageView(getImage("Images/harina.jpg")),"Necesidad basica de la vida",5));
        products.add(new Product("Z14","PC",new ImageView(getImage("Images/pc.jpg")),"Computadora Gamer I9 32GB",900));
        products.add(new Product("Z15","Celular",new ImageView(getImage("Images/celular.jpg")),"Celular Xiaomi Calidad precio",300));
        products.add(new Product("Z16","Perfume",new ImageView(getImage("Images/perfume.jpg")),"Olvidona, perfume ideal para tus ocasiones especiales",30));
        products.add(new Product("Z17","Mantequilla",new ImageView(getImage("Images/mavesa.png")),"Mantequilla Mavesa",10));

        return products;
    }

    public Date getDate(String dateStr) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
    }

    public List<ReportSales> getSaleReport() throws ParseException {
        List<ReportSales> reportSales = new ArrayList<ReportSales>();
        reportSales.add(new ReportSales(getDate("31/12/2022"), "Z1", "Juan", 40));
        reportSales.add(new ReportSales(getDate("21/11/2022"), "Z2", "James", 20));
        reportSales.add(new ReportSales(getDate("14/11/2022"), "Z3", "Damian", 60));
        reportSales.add(new ReportSales(getDate("13/12/2022"), "Z4", "Dan", 10));
        reportSales.add(new ReportSales(getDate("18/12/2022"), "Z5", "Juan", 40));
        reportSales.add(new ReportSales(getDate("19/12/2022"), "Z6", "Plan", 40));
        reportSales.add(new ReportSales(getDate("16/09/2022"), "Z7", "Cliente", 40));
        reportSales.add(new ReportSales(getDate("17/12/2022"), "Z8", "Cliente", 70));
        reportSales.add(new ReportSales(getDate("16/09/2022"), "Z9", "Cliente", 60));
        reportSales.add(new ReportSales(getDate("12/12/2022"), "Z10", "Cliente", 10));
        reportSales.add(new ReportSales(getDate("02/10/2022"), "Z11", "Cliente", 15));
        reportSales.add(new ReportSales(getDate("06/10/2022"), "Z12", "Cliente", 17));
        reportSales.add(new ReportSales(getDate("22/01/2023"), "Z13", "Cliente", 34));
        reportSales.add(new ReportSales(getDate("25/01/2023"), "Z14", "Cliente", 95));
        reportSales.add(new ReportSales(getDate("24/01/2023"), "Z15", "Cliente", 64));
        return reportSales;
    }

    public List<ReportInventory> getInventoryReports() throws ParseException {
        List<ReportInventory> reportSales = new ArrayList<ReportInventory>();
        reportSales.add(new ReportInventory(getDate("31/08/2022"), "Z1", "pelota", -5, 20));
        reportSales.add(new ReportInventory(getDate("18/09/2022"), "Z2", "plato", -2, 80));
        reportSales.add(new ReportInventory(getDate("15/08/2022"), "Z3", "Vino", -3, 35));
        reportSales.add(new ReportInventory(getDate("14/06/2022"), "Z4", "Polistation", -7, 5));
        reportSales.add(new ReportInventory(getDate("08/05/2022"), "Z8", "Camisa Naruto", -7, 1));
        reportSales.add(new ReportInventory(getDate("09/07/2022"), "Z1", "pelota", -3, 17));
        reportSales.add(new ReportInventory(getDate("25/08/2022"), "Z2", "plato", -50, 30));
        reportSales.add(new ReportInventory(getDate("30/09/2022"), "Z2", "plato", 9, 39));
        reportSales.add(new ReportInventory(getDate("17/09/2022"), "Z3", "Vino", -6, 29));
        reportSales.add(new ReportInventory(getDate("19/11/2022"), "Z3", "Vino", 2, 31));
        reportSales.add(new ReportInventory(getDate("22/11/2022"), "Z5", "Brocha", 2, 12));
        reportSales.add(new ReportInventory(getDate("21/01/2023"), "Z5", "Brocha", -8, 10));
        reportSales.add(new ReportInventory(getDate("02/01/2023"), "Z6", "Mouse Ryzen", -1, 9));
        reportSales.add(new ReportInventory(getDate("06/01/2023"), "Z7", "Termo tuHogar", -9, 7));
        return reportSales;
    }

    public List<User> getUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User("Z1","admin","phantasm","1234"));
        users.add(new User("Z2","operador","richie","1234"));
        users.add(new User("Z3","inventario","deibys","1234"));
        users.add(new User("Z4","operador","emanuel","1234"));
        users.add(new User("Z5","operador","gabriel","1234"));
        users.add(new User("Z6","operador","kevin","1234"));
        users.add(new User("Z27","inventario","sam","1234"));

        return users;
    }
}
