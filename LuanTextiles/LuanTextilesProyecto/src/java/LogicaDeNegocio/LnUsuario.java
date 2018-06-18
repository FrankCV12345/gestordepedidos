/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDeNegocio;
import Datos.ADOUsuario;
import Entidades.EntidadUsuario;
/**
 *
 * @author SARA
 */
public class LnUsuario {
    ADOUsuario DatosUsuario = new ADOUsuario();

    public LnUsuario() {
    }

    public ADOUsuario getDatosUsuario(){
        return DatosUsuario;
    }        
    public EntidadUsuario Autentificar(String Usuario, String Password){     
             /*for(EntidadUsuario usu:DatosUsuario.lst){          
                if(Usuario.equals(usu.getUsuario())  && usu.getPassword().equals(Password)){
                    return true;
                       }
              }
             return false;*/
            return this.getDatosUsuario().Busca_usuario(Usuario, Password);
             
    }
    public EntidadUsuario Autenti(String usu,String cont){     
             /*for(EntidadUsuario usu:DatosUsuario.lst){          
                if(Usuario.equals(usu.getUsuario())  && usu.getPassword().equals(Password)){
                    return true;
                       }
              }
             return false;*/
            return this.getDatosUsuario().Busca_usu(usu,cont);
             
    }
}
