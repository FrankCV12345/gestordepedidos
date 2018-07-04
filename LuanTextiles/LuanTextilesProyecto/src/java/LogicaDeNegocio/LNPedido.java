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
         return this.getDao().Registrar(pedido);
    }
    public boolean Eliminar(int ID){
        return this.getDao().Eliminar(ID);
    }
    
    public List<EntidadPedidos> listaPedidos( int ID){
      return this.getDao().ListarPedidos(ID);
    }
    public List<EntidadPedidos>ListaTodosLosPedidos(){
      return this.getDao().ListarTodosPedidos();
    }
    public boolean ModificaNomPedidoPadre(String NuevoNombre, int ID){
      return this.getDao().ModificaPedidosPadre(NuevoNombre, ID);
    }
    
}
