package com.example.prototipo.models;

import java.util.Date;

public class ReportSales {
    private Date creadoEn;
    private String codigo;
    private String cliente;
    private float monto;

    public ReportSales() {
    }

    public ReportSales(Date creadoEn, String codigo, String cliente, float monto) {
        this.creadoEn = creadoEn;
        this.codigo = codigo;
        this.cliente = cliente;
        this.monto = monto;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
}
