/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDeNegocio;
import Datos.AdoPedidoHijo;
import Entidades.EntidadPedidoHijo;
import java.util.List;
/**
 *
 * @author SARA
 */
public class LnPedidoHijo {
    
    private AdoPedidoHijo adopedidohijo = new AdoPedidoHijo();

    public LnPedidoHijo() {
    }

    public AdoPedidoHijo getAdopedidohijo() {
        return adopedidohijo;
    }
    
    public boolean Registrar(EntidadPedidoHijo  peididohijo){
      return this.getAdopedidohijo().Registrar(peididohijo);
    }
    
    public List<EntidadPedidoHijo> obtenerLista(){
     return this.getAdopedidohijo().ObtenerLista();
    }
    
}
