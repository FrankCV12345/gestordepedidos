/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Entidades.EntidadPedidoHijo;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author SARA
 */
public class AdoPedidoHijo {
    private static  List<EntidadPedidoHijo> listaPedidosHijo = new ArrayList<EntidadPedidoHijo>();

    public AdoPedidoHijo() {
    }
    public boolean Registrar(EntidadPedidoHijo pedidohijo){
    listaPedidosHijo.add(pedidohijo);
    return true;
    } 
    public List<EntidadPedidoHijo> ObtenerLista(){
     return listaPedidosHijo;
    }
   
}
