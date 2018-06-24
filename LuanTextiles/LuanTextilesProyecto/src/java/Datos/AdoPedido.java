/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Entidades.EntidadPedidos;
import Datos.BDconexion;
import static Datos.BDconexion.cnx;
import static Datos.BDconexion.msg;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
/**
 *
 * @author SARA
 */
public class AdoPedido {
    private static List<EntidadPedidos> ListaLibro = new ArrayList<EntidadPedidos>();

    public AdoPedido() {
    }

   
    
    public boolean Registrar(EntidadPedidos pedido){
    /*ListaLibro.add(pedido);
        return true;*/
     String consulta  ="insert into pedidos_padre values(id_pedido.nextval,?,sysdate,?)";
     int resultado =0;
       try{
       
        if(!BDconexion.estaconectado()){
            BDconexion.conectar();
         }
        PreparedStatement psmt = cnx.prepareStatement(consulta);
         psmt.setInt(1,pedido.getIdUsuario());
         psmt.setString(2,pedido.getNombreCliente());
         resultado = psmt.executeUpdate();
         msg ="se registro correctamente";
 
       }catch( SQLException e){
          msg ="se registro correctamente"+e.getMessage();
        }
       
      return (resultado!=0)?true:false;
    }
    
    
    public List<EntidadPedidos> obtenerLista(){
     return ListaLibro;
    }
}
