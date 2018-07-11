/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author SARA
 */
public class EntidadListaVentasUsuario {
    private int id_padre,unidades;
    private Double precio_unitario,subTotal;
    private String categoria,detalle;

    public EntidadListaVentasUsuario(int id_padre, int unidades, Double precio_unitario, Double subTotal, String categoria, String detalle) {
        this.id_padre = id_padre;
        this.unidades = unidades;
        this.precio_unitario = precio_unitario;
        this.subTotal = subTotal;
        this.categoria = categoria;
        this.detalle = detalle;
    }

    public EntidadListaVentasUsuario() {
    }
    

    public int getId_padre() {
        return id_padre;
    }

    public void setId_padre(int id_padre) {
        this.id_padre = id_padre;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
}
