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
    private String fechaIngreso ;
    private  String  estado;

    
    public EntidadPedidos(String nombreCliente, int IdPedido, int idUsuario, String fechaIngreso, String estado) {
        this.nombreCliente = nombreCliente;
        this.IdPedido = IdPedido;
        this.idUsuario = idUsuario;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
    }
    

    public EntidadPedidos(String nombreCliente, int IdPedido, int idUsuario, String fechaIngreso) {
        this.nombreCliente = nombreCliente;
        this.IdPedido = IdPedido;
        this.idUsuario = idUsuario;
        this.fechaIngreso = fechaIngreso;
    }

    public EntidadPedidos(String nombreCliente, int idUsuario, String fechaIngreso) {
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
    
     public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
