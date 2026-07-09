package com.shopeasy.tienda.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Compra {

    private int numero;
    private LocalDateTime fecha;
    private double total;
    private String estado;
    private List<CarritoItem> productos;

    public Compra() {
    }

    public Compra(int numero, LocalDateTime fecha, double total, String estado, List<CarritoItem> productos) {
        this.numero = numero;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
        this.productos = productos;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public double getTotal() {
        return total;
    }

    public String getEstado() {
        return estado;
    }

    public List<CarritoItem> getProductos() {
        return productos;
    }
}