/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDeNegocio;
import Datos.AdoPedido;
import Entidades.EntidadPedidos;
import java.util.List;
/**
 *
 * @author SARA
 */
public class LNPedido {
    private  AdoPedido daope = new AdoPedido();
    
 public LNPedido() {
    }
 
    private AdoPedido getDao(){
    return daope;
    }
    
    public boolean Registrar(EntidadPedidos pedido){
        if(pedido != null){
         return this.getDao().Registrar(pedido);
        }else{
         return false;
        }
    }
    public boolean Eliminar(int ID){
          if( ID > 0){
        return this.getDao().Eliminar(ID);
          }else{
           return false;
          }
    }
    
    public List<EntidadPedidos> listaPedidos( int ID){
           if( ID > 0){
      return this.getDao().ListarPedidos(ID);
           }else{
             return null;
           }
    }
    public List<EntidadPedidos>ListaTodosLosPedidos(){
      return this.getDao().ListarTodosPedidos();
    }
    public boolean ModificaNomPedidoPadre(String NuevoNombre, int ID){
         if(NuevoNombre != null && ID > 0 ){
      return this.getDao().ModificaPedidosPadre(NuevoNombre, ID);
         }else{
          return false;
         }
    }
    public boolean ModificarEstado(String NuevoEstado, int ID){
        if(ID > 0 &&  NuevoEstado.equals("0") || NuevoEstado.equals("1") ){
      return this.getDao().ModificaEstadoPedidosPadre(NuevoEstado, ID);
        }else{
         return false;
        }
    }
    
}
