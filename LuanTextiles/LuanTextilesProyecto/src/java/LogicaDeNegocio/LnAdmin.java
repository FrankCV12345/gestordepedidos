/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDeNegocio;
import Datos.ADOAdmin;
import Entidades.EntidadAdministrador;
import Entidades.EntidadUsuario;
import java.util.List;
/**
 *
 * @author SARA
 */
public class LnAdmin {

    public LnAdmin() {
    }
    ADOAdmin lnadmin = new ADOAdmin();

    private ADOAdmin getLnadmin() {
        return lnadmin;
    }
    
    public EntidadAdministrador BuscarAdmin(String  nomUsuario, String contrasenia){
        return this.getLnadmin().BuscarAdmin(nomUsuario, contrasenia);
    }
    public boolean RegistrarUsario(EntidadUsuario nvoUsuario){
      return this.getLnadmin().RegistrarUsuario(nvoUsuario);
    }
    public boolean BuscaNomUsu(String nomUsu){
       return this.getLnadmin().BuscaNomUsu(nomUsu);
    }
    public EntidadUsuario BuscaUsuario( int  id_usu){
       return this.getLnadmin().BuscarUsuario(id_usu);
    }
    public boolean ModificaUsuario(int idUsu, int def , String campos ){
     return this.getLnadmin().ModificaUsuario(idUsu,def, campos);
    }
    public List<EntidadUsuario> ListarUsuarios(){
    return this.getLnadmin().ListarUsuarios();
    }
    public boolean EliminarUser( int idUser){
     return this.getLnadmin().EliminaUser(idUser);
    }
}
