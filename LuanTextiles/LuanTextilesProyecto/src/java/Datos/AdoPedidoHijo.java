/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Entidades.EntidadPedidoHijo;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import static Datos.BDconexion.cnx;
import static Datos.BDconexion.msg;
/**
 *
 * @author SARA
 */
public class AdoPedidoHijo {
    private static  List<EntidadPedidoHijo> listaPedidosHijo = new ArrayList<EntidadPedidoHijo>();

    public AdoPedidoHijo() {
    }
    public  boolean registrar(EntidadPedidoHijo p){
        String consulta = "insert into peidos_hijo values(id_pedido_hijo.nextval,?,?,?,?,?,?,?)";
        int resultado = 0;
        try{
            if(!BDconexion.estaconectado()){
                BDconexion.conectar();
            }
            PreparedStatement psmt = cnx.prepareStatement(consulta);
            psmt.setInt(1,p.getId_pedidos_padre());
            psmt.setString(2,p.getCategoria());
            psmt.setInt(3,p.getUnidades());
            psmt.setDouble(4,p.getPreciounitario());
            psmt.setString(5,p.getFecha_entrega());
            psmt.setString(6,p.getDetalles());
            psmt.setDouble(7,p.getSubtotal());
            resultado =psmt.executeUpdate();
            msg ="registro correctamente ";
         
        }catch(SQLException e){
            msg="no se pudo registrar"+e;
         
        }
    return (resultado!=0)?true:false;
    }
   public int UltimoId(){
     String consulta ="select max(id_pedidos_padre) as ulimoid from pedidos_padre";
     int  ID =0;
      try{
          if(!BDconexion.estaconectado()){
              BDconexion.conectar();
          }
          PreparedStatement psmt = cnx.prepareStatement(consulta);
          ResultSet rs =psmt.executeQuery();
          while (rs.next()){
           ID = rs.getInt("ulimoid");
          }
      }catch(SQLException e){
       msg ="no se pudo buscar el id";
      }
     return ID;
   }
   
     public List<EntidadPedidoHijo> ListaPedidosHijo( int IDPadre){
     List<EntidadPedidoHijo> ListaPedidoHijo= new ArrayList<EntidadPedidoHijo>();
     EntidadPedidoHijo PH;
      String consulta="select  * from peidos_hijo where id_pedidos_padre =?";
       try{
         if(!BDconexion.estaconectado()){
             BDconexion.conectar();
         }
         PreparedStatement psmt = cnx.prepareStatement(consulta);
         psmt.setInt(1, IDPadre);
         ResultSet rs = psmt.executeQuery();
         while(rs.next()){
            PH = new EntidadPedidoHijo();
            PH.setId_pedidos_hijo(rs.getInt("id_pedidos_hijo"));
            PH.setId_pedidos_padre(rs.getInt("id_pedidos_padre"));
            PH.setCategoria(rs.getString("categoria"));
            PH.setUnidades(rs.getInt("unidades"));
            PH.setPreciounitario(rs.getInt("precio_unitario"));
            PH.setFecha_entrega(rs.getString("fecha_entrega"));
            PH.setDetalles(rs.getString("detalle"));
            PH.setSubtotal(rs.getInt("Sub_total"));
           ListaPedidoHijo.add(PH);
         }
       }catch(SQLException e){
       
        }
     
     return ListaPedidoHijo;
   }
   
}
