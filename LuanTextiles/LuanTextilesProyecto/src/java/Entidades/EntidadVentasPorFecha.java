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
public class EntidadVentasPorFecha {
    private int idpadre,unidades;
    private String categoria,fecha_entrega,detalle,estado;
    private double precio_unitario,subTotal;

    public EntidadVentasPorFecha() {
    }

    public EntidadVentasPorFecha(int idpadre, int unidades, String categoria, String fecha_entrega, String detalle, String estado, double precio_unitario, double subTotal) {
        this.idpadre = idpadre;
        this.unidades = unidades;
        this.categoria = categoria;
        this.fecha_entrega = fecha_entrega;
        this.detalle = detalle;
        this.estado = estado;
        this.precio_unitario = precio_unitario;
        this.subTotal = subTotal;
    }

    public int getIdpadre() {
        return idpadre;
    }

    public void setIdpadre(int idpadre) {
        this.idpadre = idpadre;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    
    
}
