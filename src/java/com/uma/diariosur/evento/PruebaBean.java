/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uma.diariosur.evento;
import BeanPrincipal.BeanPrincipal;
import ControlVistaHome.ControlHome;
import com.uma.diariosur.modelo.Evento;
import com.uma.diariosur.modelo.Megusta;
import javax.inject.Named;
import com.uma.diariosur.modelo.Valoracion;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.RateEvent;
/**
 *
 * @author steven
 */
@Named(value = "pruebaBean")
@SessionScoped


public class PruebaBean implements Serializable{
    @Inject
    private BeanPrincipal ctreve;
    @Inject
    private ControlHome ctrh;
    private List<Valoracion> val = new ArrayList<Valoracion>();
    private Integer rating2; 
    private Integer ratinguser;
    private String text;
    

    public BeanPrincipal getCtreve() {
        return ctreve;
    }

    public void setCtreve(BeanPrincipal ctreve) {
        this.ctreve = ctreve;
    }

    public List<Valoracion> getVal() {
        return val;
    }

    public void setVal(List<Valoracion> val) {
        this.val = val;
    }

    public ControlHome getCtrh() {
        return ctrh;
    }

    public void setCtrh(ControlHome ctrh) {
        this.ctrh = ctrh;
    }
    
    
    public List<Valoracion> comentarios() {
        List<Valoracion> buenas = new ArrayList();
        val = ctreve.getEventoV().getValoraciones();
        Iterator<Valoracion> it = val.iterator();
        Valoracion v = new Valoracion();
        while (it.hasNext()) {
            v = it.next();
            if (!(v.getComentario() == null)) {
                buenas.add(v);
            }
        }
        return buenas;
    }

    public String guardarComentario() {
        
        if(this.ratinguser==null){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , "Por favor introduzca una puntuacion");
            FacesContext.getCurrentInstance().addMessage("val:p", message);
            return null;
        }
        
        if(text.isEmpty()){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , "Por favor introduzca un texto");
            FacesContext.getCurrentInstance().addMessage("val:c", message);
            return null;
        }
        
        Valoracion var =new Valoracion(7777,text, ratinguser, ctrh.getUsuario(),ctreve.getEventoV());
        ctreve.getEventoV().getValoraciones().add(var);
        return null;
    }

     
    public void onrate(RateEvent rateEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:" + ((Integer) rateEvent.getRating()).intValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
 
    
 
    public Integer getRating2() {
        return rating2;
    }
 
    public void setRating2(Integer rating2) {
        this.rating2 = rating2;
    }

    public Integer getRatinguser() {
        return ratinguser;
    }

    public void setRatinguser(Integer ratinguser) {
        this.ratinguser = ratinguser;
    }
    
   
     
 
    public String getText() {
        return text;
    }
 
    public void setText(String text) {
        this.text = text;
        
    }
    
    public String MeGusta(Evento eve){
        Megusta mg = new Megusta();
        boolean encontrado = false;
        for(Megusta m: ctrh.getUsuario().getMegusta()){
            if(m.getUsuario().getNick().equals(ctrh.getUsuario().getNick())){
                if(m.getEvento().getNombre().equals(eve.getNombre())){
                     encontrado=true;
                 }
            }
            
        }
  
     if(!encontrado){
          Megusta me = new Megusta();
            me.setEvento(eve);
            me.setUsuario(ctrh.getUsuario());
        ctreve.addMegusta(me);
        return "vistaEvento.xhtml";
     }   
       return "vistaEvento.xhtml";
    }
    
    
    /**
     * Creates a new instance of ControlHome
     */
    public PruebaBean() {
        
    }
    
}
