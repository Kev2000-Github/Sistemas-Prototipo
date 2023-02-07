package com.example.prototipo.models;

import java.util.Date;

public class ReportInventory {
    private Date creadoEn;
    private String codigo;
    private String nombre;
    private int movimiento;
    private int cantidad;

    public ReportInventory() {
    }

    public ReportInventory(Date creadoEn, String codigo, String nombre, int movimiento, int cantidad) {
        this.creadoEn = creadoEn;
        this.codigo = codigo;
        this.nombre = nombre;
        this.movimiento = movimiento;
        this.cantidad = cantidad;
    }

    public Date getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(int movimiento) {
        this.movimiento = movimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
