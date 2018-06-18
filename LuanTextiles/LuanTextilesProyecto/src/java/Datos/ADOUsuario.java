/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Entidades.EntidadUsuario;
import java.util.List;
import java.util.ArrayList;
import Datos.BDconexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import static Datos.BDconexion.cnx;
import static Datos.BDconexion.msg;
/**
 *
 * @author SARA
 */
public class ADOUsuario {  
    /*public List<EntidadUsuario> lst;
    public ADOUsuario () {
    lst=new ArrayList<EntidadUsuario>();
    lst.add(new EntidadUsuario("FrankCV","12345","Frank","Campos Vilchez"));
    lst.add(new EntidadUsuario("JuanL","12345","Juan","Lopez Rojas"));
    lst.add(new EntidadUsuario("RonaldI","12345","Ronald","Inchica Sifuentes"));
    }*/
    
    public ADOUsuario(){
    }

    public EntidadUsuario Busca_usuario(String usuario, String contrasenia) {
        EntidadUsuario entusuario = null;
        String consulta  ="select nom_usuario,contrasenia from usuario where nom_usuario = ? and contrasenia = ?";
        try{
            if(!BDconexion.estaconectado()){
                BDconexion.conectar();
            }
            PreparedStatement psmt = cnx.prepareStatement(consulta);
            psmt.setString(1,usuario);
            psmt.setString(2,contrasenia);
            ResultSet rs = psmt.executeQuery();           
                while(rs.next()){
                    entusuario= new EntidadUsuario();
                    entusuario.setUsuario(rs.getString("nom_usuario"));
                    entusuario.setPassword(rs.getString("contrasenia"));
                }
            
            
        }catch(SQLException e){
            msg = " error al buscar un registro con el usuario "+ usuario;
        }
        return entusuario;
    }
     ;
    public EntidadUsuario Busca_usu(String usu,String cont) {
       /*String usu="frankcv";
       String cont="entrada3";*/
        EntidadUsuario entusuario = null;
        String consulta  ="select nom_usuario,contrasenia from usuario where nom_usuario ='"+usu+"' and contrasenia ='"+cont+"'";
        try{
            if(!BDconexion.estaconectado()){
                BDconexion.conectar();
            }
            PreparedStatement psmt = cnx.prepareStatement(consulta);
            /*psmt.setString(1,usu);
            psmt.setString(2,cont);*/
            ResultSet rs = psmt.executeQuery();
            
                
                while(rs.next()){
                    entusuario= new EntidadUsuario();
                    entusuario.setUsuario(rs.getString("nom_usuario"));
                    entusuario.setPassword(rs.getString("contrasenia"));
                }
              msg =""+entusuario.getUsuario();
         
            
        }catch(SQLException e){
            msg = " error al buscar un registro con el usuario "+e;
        }
        return entusuario;
    }
}
