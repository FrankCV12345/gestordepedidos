/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Entidades.EntidadPedidos;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author SARA
 */
public class AdoPedido {
    private static List<EntidadPedidos> ListaLibro = new ArrayList<EntidadPedidos>();

    public AdoPedido() {
    }

   
    
    public boolean Registrar(EntidadPedidos pedido){
    ListaLibro.add(pedido);
        return true;
    }
    public List<EntidadPedidos> obtenerLista(){
     return ListaLibro;
    }
}
