/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlVistaHome;

import com.uma.diariosur.modelo.Evento;
import java.text.ParseException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author steven
 */
@Named(value = "vistaEventos")
@ViewScoped
public class VistaEventos implements Serializable {

    private List<Evento>eventos;
    
     @Inject
     private CreacionDeEventos creacion;
     
     @PostConstruct
     public void init() {
       
        try {
            eventos = creacion.crearEventos();
        } catch (ParseException ex) {
            Logger.getLogger(VistaEventos.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
     
    
    
    /**
     * Creates a new instance of VistaEventos
     */
    public VistaEventos(){
       
    }
    
}
