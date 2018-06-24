/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;
import java.sql.Date;
/**
 *
 * @author SARA
 */
public class EntidadPedidos {
    private String nombreCliente;
    private int IdPedido,idUsuario;
   /* private static int IdPedidoSgt = 1;*/   
    private Date fechaIngreso ;
    

    /*public EntidadPedidos(String nombreCliente, double total) {
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

    
    */

    public EntidadPedidos(String nombreCliente, int IdPedido, int idUsuario, Date fechaIngreso) {
        this.nombreCliente = nombreCliente;
        this.IdPedido = IdPedido;
        this.idUsuario = idUsuario;
        this.fechaIngreso = fechaIngreso;
    }

    public EntidadPedidos(String nombreCliente, int idUsuario, Date fechaIngreso) {
        this.nombreCliente = nombreCliente;
        this.idUsuario = idUsuario;
        this.fechaIngreso = fechaIngreso;
    }

    public EntidadPedidos(String nombreCliente, int idUsuario) {
        this.nombreCliente = nombreCliente;
        this.idUsuario = idUsuario;
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

    public void setIdPedido(int IdPedido) {
        this.IdPedido = IdPedido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    
    
}
