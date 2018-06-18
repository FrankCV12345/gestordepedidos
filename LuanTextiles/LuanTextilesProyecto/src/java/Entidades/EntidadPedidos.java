/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;
import java.util.Date;
/**
 *
 * @author SARA
 */
public class EntidadPedidos {
    private String nombreCliente;
    private int IdPedido;
    private static int IdPedidoSgt = 1;
    private double total;    
    private Date fechaIngreso ;

    public EntidadPedidos(String nombreCliente, double total) {
        this.nombreCliente = nombreCliente;
        this.IdPedido = IdPedidoSgt;
        IdPedidoSgt++;
        Date fechaIngresopedido  = new Date();
        this.fechaIngreso = fechaIngresopedido;
        this.total = total;
    }

    public EntidadPedidos() {
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getIdPedido() {
        return IdPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    
    
    
    
}
