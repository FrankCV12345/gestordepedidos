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

    public ADOUsuario(){
    }
    public EntidadUsuario Busca_usu(String usu,String cont) {
      
        EntidadUsuario entusuario= null;
        String consulta  ="select * from usuario where nom_usuario ='"+usu+"' and contrasenia ='"+cont+"'";
        try{
            if(!BDconexion.estaconectado()){
                BDconexion.conectar();
            }
            PreparedStatement psmt = cnx.prepareStatement(consulta);
           
            ResultSet rs = psmt.executeQuery(); 
     
                  while(rs.next()){                   
                    entusuario= new EntidadUsuario();
                    entusuario.setId(rs.getInt("id_usuario"));
                    entusuario.setNombres(rs.getString("nombres"));
                    entusuario.setApellidos(rs.getString("apellidos"));
                    entusuario.setPuesto(rs.getString("puesto"));
                    entusuario.setTelefono(rs.getString("telefono"));
                    entusuario.setUsuario(rs.getString("nom_usuario"));
                    entusuario.setPassword(rs.getString("contrasenia")); 
                    entusuario.setEstado(rs.getString("estado"));
                    
                  }
        }catch(SQLException e){
            msg = " error al buscar un registro con el usuario "+e;
        }
        return entusuario;
    }
}
