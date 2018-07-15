/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Entidades.*;
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
   
    public AdoPedido() {
    }

   
    
    public boolean Registrar(EntidadPedidos pedido){
     String consulta  ="insert into pedidos_padre values(id_pedido.nextval,?,sysdate,?,'0')";
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
    
    
   public boolean Eliminar( int ID){
    String consulta ="delete from pedidos_padre where id_pedidos_padre=?";
    String consulta_hijo ="delete from peidos_hijo where id_pedidos_padre=?";
    int resultado =0;
    int resultado_hijo = 0;
     try{
      if(!BDconexion.estaconectado()){
         BDconexion.conectar();
         }
      PreparedStatement psmt_hijo = cnx.prepareStatement(consulta_hijo);
      PreparedStatement psmt = cnx.prepareStatement(consulta);
      psmt.setInt(1, ID);
      psmt_hijo.setInt(1, ID);
      resultado_hijo= psmt_hijo.executeUpdate();
      resultado =psmt.executeUpdate();
      }catch( SQLException e ){
      
           msg=" no se logro ejecutar la sentencia SQL"+e;
      }
     if(resultado !=0 && resultado_hijo!=0 ){
          return true;
     }
     else{
        return false;
     }
   }
   
   public List<EntidadPedidos> ListarPedidos( int ID){
    List<EntidadPedidos> ListaPedido= new ArrayList<EntidadPedidos>();
    EntidadPedidos p;
   
       String consulta ="select * from pedidos_padre where id_pedidos_padre = ?";
      
        try{
            if(!BDconexion.estaconectado()){
                BDconexion.conectar();
            }
            PreparedStatement psmt = cnx.prepareStatement(consulta);
            psmt.setInt(1, ID);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
             p = new EntidadPedidos();
             p.setIdPedido(rs.getInt("id_pedidos_padre"));
             p.setIdUsuario(rs.getInt("id_usuario"));
             p.setFechaIngreso(rs.getString("fecha_registro"));
             p.setNombreCliente(rs.getString("nom_cliente"));
             p.setEstado(rs.getString("estado"));
             ListaPedido.add(p);
            }
            msg="Se ha listado los productos";
         }catch(SQLException e){
         msg="Error al intentar listar pedidos: " + e.getMessage();
         }
       return ListaPedido;
   
   }
   
   public List<EntidadPedidos> ListarTodosPedidos(){
    List<EntidadPedidos> ListaPedido= new ArrayList<EntidadPedidos>();
    EntidadPedidos p;
   
       String consulta ="select * from pedidos_padre order by id_pedidos_padre";
      
        try{
            if(!BDconexion.estaconectado()){
                BDconexion.conectar();
            }
            PreparedStatement psmt = cnx.prepareStatement(consulta);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
             p = new EntidadPedidos();
             p.setIdPedido(rs.getInt("id_pedidos_padre"));
             p.setIdUsuario(rs.getInt("id_usuario"));
             p.setFechaIngreso(rs.getString("fecha_registro"));
             p.setNombreCliente(rs.getString("nom_cliente"));
             p.setEstado(rs.getString("estado"));
             ListaPedido.add(p);
            }
            msg="Se ha listado los productos";
         }catch(SQLException e){
         msg="Error al intentar listar pedidos: " + e.getMessage();
         }
       return ListaPedido;
   
   }
    public boolean ModificaPedidosPadre( String NuevoNombre, int ID ){
        String consulta ="update pedidos_padre  set nom_cliente =?  where id_pedidos_padre = ?";
        int resultado = 0;
        try{
          if(!BDconexion.estaconectado()){
            BDconexion.conectar();
           }
          PreparedStatement psmt = cnx.prepareStatement(consulta);
          psmt.setString(1, NuevoNombre);
          psmt.setInt(2, ID);
          resultado  =  psmt.executeUpdate();
           msg ="si se modifico";
        }catch(SQLException e){
             msg="Error al intentar modificar pedido " + e.getMessage();
        }
        
        return (resultado!=0)?true:false;
     }
    public boolean ModificaEstadoPedidosPadre( String NuevoEstado, int ID ){
        String consulta ="update pedidos_padre  set estado =?  where id_pedidos_padre = ?";
        int resultado = 0;
        try{
          if(!BDconexion.estaconectado()){
            BDconexion.conectar();
           }
          PreparedStatement psmt = cnx.prepareStatement(consulta);
          psmt.setString(1, NuevoEstado);
          psmt.setInt(2, ID);
          resultado  =  psmt.executeUpdate();
           msg ="si se modifico";
        }catch(SQLException e){
             msg="Error al intentar modificar pedido " + e.getMessage();
        }
        
        return (resultado!=0)?true:false;
     }
   
   
}
