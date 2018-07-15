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
        if(peididohijo != null){
      return this.getAdopedidohijo().registrar(peididohijo);
        } else{
           return false;
        }
    }
    
    public int UltimoId(){
      return this.getAdopedidohijo().UltimoId();
    }
    public List<EntidadPedidoHijo> ListaPedidoHijo( int IDPadre){
        if( IDPadre > 0 ){
     return this.getAdopedidohijo().ListaPedidosHijo(IDPadre);
        } else{
            return null;
        }
    }
    public boolean ModificaPedidoHijo(int IDPedidoHijo , int def,String campos ){
         if(IDPedidoHijo > 0 && def >=0 && campos != null){
     return this.getAdopedidohijo().ModificaPedidoHijo(IDPedidoHijo, def, campos);
         }else{
            return false;
         }
     
    }
  
    
}
