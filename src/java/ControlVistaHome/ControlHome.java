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
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
/**
 *
 * @author steven
 */
@Named(value = "controlHome")
@SessionScoped
public class ControlHome implements Serializable{

    private Usuario usuario;
    private Periodista periodista;
    private String evento;
    private String ubicacion;
    private String categoria;
    private Date fecha;

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    private List<Evento>eventos;

    
    @Inject 
    BeanPrincipal bnp;

    public BeanPrincipal getBnp() {
        return bnp;
    }

    public void setBnp(BeanPrincipal bnp) {
        this.bnp = bnp;
       
    }
    
    
    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
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
                return "PaginaHome.xhtml";
            }
        }else{
            //Identificado como Usuario Normal
            return "PaginaHome.xhtml";
        }

    }
    
    public String login(){
        if(this.usuario == null){
            if(this.periodista == null){
                //No hay usuario, por tanto redirigimos a pagina Login
                return "Login.xhtml";
            }else{
                return "PaginaHome.xhtml";
            }
        }else{
                return "PaginaHome.xhtml";
        }
    }
    
    public String verEvento(){
        return "VerEvento.xhtml";
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
        return "Login.xhtml";
    }
    
    public String perfil(){
        return "ajustes.xhtml";
    }
    
    
    public String RevisarEvento(){
        return "formularios.xhtml";
    }
    
    public String accederEvento(){
        return "rellenar_formulario.xhtml";
    }
    
    
    /**
     * Creates a new instance of ControlHome
     */
    public ControlHome() {
       
        
        
    }
  
    
}
