/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDeNegocio;
import Datos.ADOAdmin;
import Entidades.*;
import Entidades.EntidadUsuario;
import java.util.List;
/**
 *
 * @author SARA
 */
public class LnAdmin {
    public static String rpta =" fuera del metodo";
    public LnAdmin() {
    }
    ADOAdmin lnadmin = new ADOAdmin();

    private ADOAdmin getLnadmin() {
        return lnadmin;
    }
    
    public EntidadAdministrador BuscarAdmin(String  nomUsuario, String contrasenia){
        if(nomUsuario!=null && contrasenia !=null ){
        return this.getLnadmin().BuscarAdmin(nomUsuario, contrasenia);
        }else{
        EntidadAdministrador adm = null;
         return adm;
        }
    }
    public boolean RegistrarUsario(EntidadUsuario nvoUsuario){
        if(nvoUsuario != null){
      return this.getLnadmin().RegistrarUsuario(nvoUsuario);
        }else{
         return false;
        }
    }
    public boolean BuscaNomUsu(String nomUsu){
        if( nomUsu != null ){
       return this.getLnadmin().BuscaNomUsu(nomUsu);
        }else{
         return false;
         }
    }
    public EntidadUsuario BuscaUsuario( int  id_usu){
        if(id_usu > 0){
       return this.getLnadmin().BuscarUsuario(id_usu);
        }else{
        return null;
        }
    }
    public boolean ModificaUsuario(int idUsu, int def , String campos ){
        if(idUsu > 0 || def >=0 || campos != null){
     return this.getLnadmin().ModificaUsuario(idUsu,def, campos);
        } else{
            return false;
           }
    }
    public List<EntidadUsuario> ListarUsuarios(){
    return this.getLnadmin().ListarUsuarios();
    }
    public boolean EliminarUser( int idUser){
        
        if( idUser > 0 ){
            rpta ="se inhabilito user";
     return this.getLnadmin().EliminaUser(idUser);
        
        }else{
         return false;
        }
    }
    public  List<EntidadListaVentasUsuario> ListaVentasPorUsuario(int id_usuario){
                 if( id_usuario > 0 ){      
      return this.getLnadmin().ListaVentasPorUsuario(id_usuario);
                 }else{
                     List<EntidadListaVentasUsuario> lst = null;
                  return lst;
                 }
    }
    public  List<EntidadVentasPorFecha> ListaVentasPorFecha(String fecha){
        if(fecha != null){
      return this.getLnadmin().ListaPorfecha(fecha);
        }else{
          return null;
        }
    }
}
