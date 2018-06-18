/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author SARA
 */
public class BDconexion {
    public static  Connection cnx = null;
    public static String msg ="";

    public BDconexion() {
    }
    
    public static String conectar(){  
    try{   
        /*pro.agrega(entipro);*/
        Class.forName("oracle.jdbc.OracleDriver");
       cnx= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","adminFCV","entrada38");
      msg="conectado";
       } 
    catch(SQLException e){
     msg = e.getMessage();
       }
    catch(ClassNotFoundException e){
    msg = e.getMessage();
       }
    return msg;
    }
    
    public static boolean estaconectado(){
    
        if (cnx!=null){
        return true;
        }
        else{
         return false;
        }
    }
    
    public static int EnviarActualizacion(String cons){
       try {
          return ejecutarActualizacion(cnx.prepareStatement(cons));
           }
       catch (SQLException e){
          msg="Error al ejecutar consulta : " + e.getMessage();
           }
         return 0;
           } 
    
    
    public static int ejecutarActualizacion(PreparedStatement sp){
        
     try{
         return sp.executeUpdate();
     }catch(SQLException e){
         msg ="eror al jecutar consulta"+ e.getMessage();
     }
     return 0;
    }
    
}
