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
public class EntidadUsuario {
    private String usuario;
    private String password;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String puesto;
    private Integer id;
    private int idAdmin;
    private String estado;
    

    public EntidadUsuario() {
    }

    public EntidadUsuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public EntidadUsuario(String usuario, String password, String nombres, String apellidos, String telefono, String puesto, int idAdmin) {
        this.usuario = usuario;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.puesto = puesto;
        this.idAdmin = idAdmin;
    }
     
   
  
     
    public EntidadUsuario(String usuario, String password, String nombres, String apellidos, String telefono, String puesto, Integer id) {
        this.usuario = usuario;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.puesto = puesto;
        this.id = id;
    }
    
    public EntidadUsuario(String usuario, String password, String nombres, String apellidos) {
        this.usuario = usuario;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    
    
}
