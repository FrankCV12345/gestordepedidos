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
public class EntidadPedidoHijo {
    private String categoria;
    private int unidades,id_pedidos_padre,id_pedidos_hijo;
    private double preciounitario;
    private String fecha_entrega;
    private String detalles;
    private double subtotal;
      
    public EntidadPedidoHijo() {
    }

    public EntidadPedidoHijo(String categoria, int unidades, int id_pedidos_padre, double preciounitario, String fecha_entrega, String detalles, double subtotal) {
        this.categoria = categoria;
        this.unidades = unidades;
        this.id_pedidos_padre = id_pedidos_padre;
        this.preciounitario = preciounitario;
        this.fecha_entrega = fecha_entrega;
        this.detalles = detalles;
        this.subtotal = subtotal;
    }
    
    
    public EntidadPedidoHijo(String categoria, int unidades, double preciounitario, String detalles, double subtotal) {
        this.categoria = categoria;
        this.unidades = unidades;
        this.preciounitario = preciounitario;
        this.detalles = detalles;
        this.subtotal = subtotal;
    }
    
    public EntidadPedidoHijo(String categoria, int unidades, int id_pedidos_padre, int id_pedidos_hijo, double preciounitario, String fecha_entrega, String detalles, double subtotal) {
        this.categoria = categoria;
        this.unidades = unidades;
        this.id_pedidos_padre = id_pedidos_padre;
        this.id_pedidos_hijo = id_pedidos_hijo;
        this.preciounitario = preciounitario;
        this.fecha_entrega = fecha_entrega;
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

    public int getId_pedidos_padre() {
        return id_pedidos_padre;
    }

    public void setId_pedidos_padre(int id_pedidos_padre) {
        this.id_pedidos_padre = id_pedidos_padre;
    }

    public int getId_pedidos_hijo() {
        return id_pedidos_hijo;
    }

    public void setId_pedidos_hijo(int id_pedidos_hijo) {
        this.id_pedidos_hijo = id_pedidos_hijo;
    }

    public double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(double preciounitario) {
        this.preciounitario = preciounitario;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
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
