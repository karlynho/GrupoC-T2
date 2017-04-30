/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlVistaHome;
import BeanPrincipal.BeanPrincipal;
import com.uma.diariosur.modelo.Evento;
import com.uma.diariosur.modelo.Periodista;
import javax.inject.Named;
import com.uma.diariosur.modelo.Usuario;
import com.uma.diariosur.modelo.Valoracion;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
/**
 *
 * @author steven
 */
@Named(value = "controlHome")
@SessionScoped


public class ControlHome implements Serializable{
    @Inject
    private BeanPrincipal bnp;
    @Inject
    private BeanPrincipal ctreve;
    private Usuario usuario;
    private Periodista periodista;
    private List<Valoracion> val = new ArrayList<Valoracion>();
    
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
    public String verEvento(Evento e){   
       int i = 0;
       int j= 0;
       bnp.setEventoV(e);
       Evento ev = new Evento();
        ev=bnp.getEventoV();
        List<Evento> validos = new ArrayList<Evento>();
        List<Evento> Novalidos = new ArrayList<Evento>();
       for (Evento ee : bnp.getEventos()) {
           if(ee.getCategoria().equals(ev.getCategoria()) && (!Objects.equals(ev.getId(), ee.getId()))){
               validos.add(ee);
               i++;
           }else{
               if(!Objects.equals(ev.getId(), ee.getId())){
               Novalidos.add(ee);
           }
               
           }
           
       }
       //Para que en Recomendados siempre tenga al menos 7
       while(i<7 && !Novalidos.isEmpty()){
           validos.add(Novalidos.get(0));
           Novalidos.remove(0);
           
       }
       bnp.setValidos(validos);
       return "vistaEvento.xhtml";
    }
    public List<Valoracion> comentarios() {
        List<Valoracion> buenas = new ArrayList();
        val = ctreve.getEventoV().getValoraciones();
        Iterator<Valoracion> it = val.iterator();
        Valoracion v = new Valoracion();
        while(it.hasNext()){
            v = it.next();
            if(!(v.getComentario() == null)){
                buenas.add(v);
            }
        }
        return buenas;
    }
    
    /**
     * Creates a new instance of ControlHome
     */
    public ControlHome() {
        
    }
    
}
