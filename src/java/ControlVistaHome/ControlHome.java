/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlVistaHome;
import com.uma.diariosur.modelo.Periodista;
import javax.inject.Named;
import com.uma.diariosur.modelo.Usuario;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
/**
 *
 * @author steven
 */
@Named(value = "controlHome")
@SessionScoped
public class ControlHome implements Serializable{

    private Usuario usuario;
    private Periodista periodista;
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public Usuario getUsuario(){
        return usuario;
    }
    
    public void setPeriodista(Periodista periodista){
        this.periodista = periodista;
    }
    
    public Periodista getPeriodista(){
        return periodista;
    }
    
    public String home(){
        if(this.usuario == null){
            if(this.periodista==null){
                //No hay usuario Logueado, por tanto mostramos pagina principal
                return "PaginaHome.xhtml";
            }else{
                //Identificado como Periodista
                return "PaginaHomePeriodista.xhtml";
            }
        }else{
            //Identificado como Usuario Normal
            return "PaginaHomeUsuarioNormal.xhtml";
        }
    }
    
    public String login(){
        if(this.usuario == null){
            if(this.periodista == null){
                //No hay usuario, por tanto redirigimos a pagina Login
                return "Login.xhtml";
            }else{
                return "PaginaHomePeriodista.xhtml";
            }
        }else{
                return "PaginaHomeUsuarioNormal.xhtml";
        }
    }
    
    public String registro(){
        return "Registro.xhtml";
    }
    public String logout(){
        //Cerramos la sesion
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        periodista = null;
        usuario = null;
        return "login.xhtml";
    }
    
    public String perfil(){
        return "ajustes.xhtml";
    }
    
    public String filtroEvento(){
        return "ControlHomeFiltro.xhtml";
    }
    
    /**
     * Creates a new instance of ControlHome
     */
    public ControlHome() {
        
    }
    
}
