/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uma.diariosur.evento;
import BeanPrincipal.BeanPrincipal;
import ControlVistaHome.ControlHome;
import javax.inject.Named;
import com.uma.diariosur.modelo.Valoracion;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

    public  String guardarComentario() {
        Valoracion var =new Valoracion(7777,text, ratinguser, ctrh.getUsuario(),ctreve.getEventoV());
        ctreve.getEventoV().getValoraciones().add(var);
        return null;
    }

    public String ponerPuntuacion() {
        List<Valoracion> total = ctreve.getEventoV().getValoraciones();
        Iterator<Valoracion> it = total.iterator();
        Valoracion var = new Valoracion();
        int i = 0;
        boolean tiene = false;
        while (it.hasNext()) { //Recorro la lista de vaoraciones de ese evento
            var = it.next();
            if (var.getUsuario().getNombre().equals(ctrh.getUsuario().getNombre())) { //Compruebo las que tiene el usuario actual
                var.setPuntuacion(rating2); //Las voy cambiando toddas por la vaoracion nueva
                tiene = true;
            }
            //donde secoje el usuario actual
        }
        if (!tiene) {
            Valoracion va = new Valoracion(7777, null,rating2, ctrh.getUsuario(), ctreve.getEventoV());
            ctreve.getEventoV().getValoraciones().add(va);
        }
        
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
    
    
    
    /**
     * Creates a new instance of ControlHome
     */
    public PruebaBean() {
        
    }
    
}
