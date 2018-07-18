/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Entidades.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import static Datos.BDconexion.cnx;
import static Datos.BDconexion.msg;
import java.sql.CallableStatement;
import oracle.jdbc.internal.OracleTypes;
/**
 *
 * @author SARA
 */
public class ADOAdmin {

    public ADOAdmin() {
    }
    public EntidadAdministrador BuscarAdmin(String nomAdmin , String contasenia){
     EntidadAdministrador admin = null ;
     String consulta = "select  * from administradores where nom_usuario = ? and contrasenia = ?";
     try{
         if(!BDconexion.estaconectado()){
            BDconexion.conectar();
         }
         PreparedStatement psmt = cnx.prepareStatement(consulta);
          psmt.setString(1, nomAdmin);
          psmt.setString(2, contasenia);
          ResultSet rs = psmt.executeQuery();
          while(rs.next()){
              admin = new EntidadAdministrador();
              admin.setNomUsuario(rs.getString("nom_usuario"));
              admin.setNombres(rs.getString("nombres"));
              admin.setApellidos(rs.getString("apellidos"));
              admin.setIDadmin(rs.getInt("idadministrador"));
              admin.setNivel(rs.getString("nivel"));
              admin.setTelefono(rs.getString("telefono"));
          }
      }catch(SQLException e){
          msg =" no se pudo ejecutar "+e.getMessage();
       }
      return admin;
    }
    
    public boolean RegistrarUsuario(EntidadUsuario nvoUsuario){
      String consulta = "insert into usuario values(id_usuario.nextval,?,?,?,?,?,?,'0',?)";
      int resultado = 0;
      try{
          if(!BDconexion.estaconectado()){
              BDconexion.conectar();
          }
          PreparedStatement psmt = cnx.prepareStatement(consulta);
          psmt.setString(1,nvoUsuario.getNombres());
          psmt.setString(2,nvoUsuario.getApellidos());
          psmt.setString(3,nvoUsuario.getPuesto());
          psmt.setString(4,nvoUsuario.getTelefono());
          psmt.setString(5,nvoUsuario.getUsuario());
          psmt.setString(6,nvoUsuario.getPassword());
          psmt.setInt(7,nvoUsuario.getIdAdmin());
          resultado =  psmt.executeUpdate();
          msg="si se registro";
          
          
       }catch(SQLException e){
           msg="no se ejecuto "+e.getMessage();
       }
      return (resultado!=0)?true:false;
    }
    public boolean BuscaNomUsu(String nomUsu){
        String consulta ="select nom_usuario from usuario where nom_usuario ='"+nomUsu+"'";
        boolean indicador = false;
        try{
            if(!BDconexion.estaconectado()){
              BDconexion.conectar();
            }
            
         PreparedStatement psmt = cnx.prepareStatement(consulta);
            /*psmt.setString(1,nomUsu);*/
         ResultSet rs = psmt.executeQuery();
          while(rs.next()){
           indicador = true;
           msg ="si se encontro registros";
          }
          
        }catch(SQLException e){
         msg ="no se ejecuto";
        }
      return  indicador;
    }
    
    public EntidadUsuario BuscarUsuario( int idUsuario){
         String consulta ="select * from usuario where id_usuario = ?";
         EntidadUsuario usu = null;
         try{
             if(!BDconexion.estaconectado()){
                 BDconexion.conectar();
                 }
                 PreparedStatement psmt = cnx.prepareStatement(consulta);
                 psmt.setInt(1, idUsuario);
                  ResultSet rs = psmt.executeQuery();
                  
                  while(rs.next()){
                    usu = new EntidadUsuario();
                    usu.setNombres(rs.getString("nombres"));
                    usu.setApellidos(rs.getString("apellidos"));
                    usu.setId(rs.getInt("id_usuario"));
                    usu.setPuesto(rs.getString("puesto"));
                    usu.setUsuario(rs.getString("nom_usuario"));
                    usu.setTelefono(rs.getString("telefono"));
                    usu.setEstado(rs.getString("estado"));
                    usu.setIdAdmin(rs.getInt("idadministrador"));
                    usu.setPassword(rs.getString("contrasenia"));
                  }
             
         }catch(SQLException e){
           msg="no se pudo ejecutar "+e;
         }
        return usu;
    
    }
    
    public boolean ModificaUsuario(int ID_usu , int def,String campos ){
         String consulta ="";
         int resultado = 0;
         
         switch(def){
             case 0: 
                     consulta =" update usuario set nombres =?  where id_usuario = ?";
                     break;
             case 1: 
                     consulta =" update usuario set apellidos =?  where id_usuario = ?";
                    
                     break;
             case 2: 
                    consulta =" update usuario set nom_usuario =?  where id_usuario = ?";
                   
                     break;
             case 3: 
                     consulta =" update usuario set puesto =?  where id_usuario = ?";
                     break;
             case 4: 
                     consulta =" update usuario set telefono =?  where id_usuario = ?";
                     break;
             case 5: 
                     consulta =" update usuario set estado =?  where id_usuario = ?";
                     break;
             case 6: 
                     consulta =" update usuario set contrasenia =?  where id_usuario = ?";
                     break;
             default: msg="no se ingresó nigun def";break;
         }
          try{
             if(!BDconexion.estaconectado()){
                  BDconexion.conectar();
              }
             PreparedStatement psmt = cnx.prepareStatement(consulta);
                  psmt.setString(1, campos);
                  psmt.setInt(2, ID_usu);
                  resultado  =  psmt.executeUpdate();
               
           }catch(SQLException e){
              msg =" no se pudo";
           }
       
        return (resultado!=0)?true:false;
     }
    
      public List<EntidadUsuario> ListarUsuarios(){
    List<EntidadUsuario> ListaUsuarios= new ArrayList<EntidadUsuario>();
    EntidadUsuario usuario;
   
       String consulta ="select * from usuario order by id_usuario";
      
        try{
            if(!BDconexion.estaconectado()){
                BDconexion.conectar();
            }
            PreparedStatement psmt = cnx.prepareStatement(consulta);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
             usuario = new EntidadUsuario();
             usuario.setId(rs.getInt("id_usuario"));
             usuario.setNombres(rs.getString("nombres"));
             usuario.setApellidos(rs.getString("apellidos"));
             usuario.setPuesto(rs.getString("puesto"));
             usuario.setTelefono(rs.getString("telefono"));
             usuario.setUsuario(rs.getString("nom_usuario"));
             usuario.setEstado(rs.getString("estado"));
             usuario.setIdAdmin(rs.getInt("idadministrador"));
             ListaUsuarios.add(usuario);
            }
            msg="Se ha listado los productos";
         }catch(SQLException e){
         msg="Error al intentar listar pedidos: " + e.getMessage();
         }
       return ListaUsuarios;
   
   }
      
    public boolean EliminaUser( int idUser){
     String consulta ="update  usuario set estado = '1'  where id_usuario = ?";
     int result = 0;
     try{
        if(!BDconexion.estaconectado()){
            BDconexion.conectar();
        } 
        PreparedStatement psmt = cnx.prepareStatement(consulta);
        psmt.setInt(1, idUser);
        result = psmt.executeUpdate();
     }catch(SQLException e){
         msg ="no se pudo ejecutar"+e;
     }
            return (result!=0)?true:false;
    }
    public List<EntidadListaVentasUsuario> ListaVentasPorUsuario( int id_user){
      String consulta ="{call Prc_ListaVentasPorUsuario(?,?) }";
      List<EntidadListaVentasUsuario> listaVentas = new ArrayList<EntidadListaVentasUsuario>();
      EntidadListaVentasUsuario ventas ;
      try{
       if(!BDconexion.estaconectado()){
           BDconexion.conectar();
         }
       CallableStatement cst = cnx.prepareCall(consulta);
       cst.setInt(1, id_user);
       cst.registerOutParameter(2, OracleTypes.CURSOR);
       
       cst.execute();
       ResultSet rs = (ResultSet) cst.getObject(2);
       while(rs.next()){
         ventas = new EntidadListaVentasUsuario();
         ventas.setId_padre(rs.getInt("id_pedidos_padre"));
         ventas.setCategoria(rs.getString("categoria"));
         ventas.setUnidades(rs.getInt("unidades"));
         ventas.setPrecio_unitario(rs.getDouble("precio_unitario"));
         ventas.setDetalle(rs.getString("detalle"));
         ventas.setSubTotal(rs.getDouble("sub_total"));
         listaVentas.add(ventas);
         msg="si";
       }
       
      }catch(SQLException e){
          msg="no se pudo ejecutar "+e;
      }
      return listaVentas;
    }
    public List<EntidadVentasPorFecha> ListaPorfecha( String fecha){
      String consulta ="{call Prc_ListaTotalVentas(?,?)}";
        List<EntidadVentasPorFecha> lstvent = new ArrayList<EntidadVentasPorFecha> ();
        EntidadVentasPorFecha vta;
        try{
            if(!BDconexion.estaconectado()){
                BDconexion.conectar();
            }
            CallableStatement cst = cnx.prepareCall(consulta);
            cst.setString(1, fecha);
            cst.registerOutParameter(2,OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet) cst.getObject(2);
            while(rs.next()){
                vta= new EntidadVentasPorFecha();
                vta.setIdpadre(rs.getInt("id_pedidos_padre"));
             vta.setCategoria(rs.getString("categoria"));
             vta.setUnidades(rs.getInt("unidades"));
             vta.setPrecio_unitario(rs.getDouble("precio_unitario"));
             vta.setFecha_entrega(rs.getString("fecha_entrega"));
             vta.setDetalle(rs.getString("detalle"));
             vta.setEstado(rs.getString("estado"));
             vta.setSubTotal(rs.getDouble("sub_total"));
             lstvent.add(vta);
            }
        }catch(SQLException e){
          msg=" no se ejecuto "+e;
        }
     return lstvent;
    }
     public List<EntidadVentasPorFecha> ListaPorEstado(){
      String consulta ="select * from peidos_hijo where estado = '0'";
        List<EntidadVentasPorFecha> lstvent = new ArrayList<EntidadVentasPorFecha> ();
        EntidadVentasPorFecha vta;
        try{
            if(!BDconexion.estaconectado()){
                BDconexion.conectar();
            }
            PreparedStatement psmt = cnx.prepareStatement(consulta);
           
            ResultSet rs =  psmt.executeQuery();
            while(rs.next()){
                vta= new EntidadVentasPorFecha();
                vta.setIdpadre(rs.getInt("id_pedidos_padre"));
             vta.setCategoria(rs.getString("categoria"));
             vta.setUnidades(rs.getInt("unidades"));
             vta.setPrecio_unitario(rs.getDouble("precio_unitario"));
             vta.setFecha_entrega(rs.getString("fecha_entrega"));
             vta.setDetalle(rs.getString("detalle"));
             vta.setEstado(rs.getString("estado"));
             vta.setSubTotal(rs.getDouble("sub_total"));
             lstvent.add(vta);
            }
        }catch(SQLException e){
          msg=" no se ejecuto "+e;
        }
     return lstvent;
    }
   
    
}
