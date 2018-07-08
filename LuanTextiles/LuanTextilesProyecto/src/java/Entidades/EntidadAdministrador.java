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
public class EntidadAdministrador {
   private int IDadmin;
   private String nombres,apellidos;
   private String nivel,telefono,NomUsuario,contrasenia;

    public EntidadAdministrador(int IDadmin, String nombres, String apellidos, String nivel, String telefono, String NomUsuario, String contrasenia) {
        this.IDadmin = IDadmin;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nivel = nivel;
        this.telefono = telefono;
        this.NomUsuario = NomUsuario;
        this.contrasenia = contrasenia;
    }

    public EntidadAdministrador() {
    }

    public EntidadAdministrador(String nombres, String telefono, String NomUsuario, String contrasenia) {
        this.nombres = nombres;
        this.telefono = telefono;
        this.NomUsuario = NomUsuario;
        this.contrasenia = contrasenia;
    }
    

    public int getIDadmin() {
        return IDadmin;
    }
    public void setIDadmin(int IDadmin) {
        this.IDadmin = IDadmin;
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNomUsuario() {
        return NomUsuario;
    }

    public void setNomUsuario(String NomUsuario) {
        this.NomUsuario = NomUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
   
   
   
    
}
