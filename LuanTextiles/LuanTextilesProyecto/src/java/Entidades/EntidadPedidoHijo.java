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
public class EntidadPedidoHijo extends EntidadPedidos {
    private String categoria;
    private int unidades;
    private double preciounitario;
    private String fecha;
    private String detalles;
    private double subtotal;

    public EntidadPedidoHijo(String categoria, int unidades, double preciounitario, String fecha, String detalles, double subtotal) {
        super();
        this.categoria = categoria;
        this.unidades = unidades;
        this.preciounitario = preciounitario;
        this.fecha = fecha;
        this.detalles = detalles;
        this.subtotal = subtotal;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(double preciounitario) {
        this.preciounitario = preciounitario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
}
