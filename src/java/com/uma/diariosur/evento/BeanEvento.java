/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uma.diariosur.evento;

import BeanPrincipal.BeanPrincipal;
import ControlVistaHome.ControlHome;
import ControlVistaHome.CreacionDeEventos;
import com.uma.diariosur.modelo.Evento;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Sergio
 */
@Named(value = "beanEvento")
@SessionScoped
public class BeanEvento implements Serializable {

    
   private Evento eventos;
    @Inject
    BeanPrincipal ctreve;
    
    public Evento verEvento(){
        System.out.print("HOLAAAa");
        return ctreve.getEventos().get(0);
    }

    public Evento getEventos() {
        return eventos;
    }

    public void setEventos(Evento eventos) {
        this.eventos = eventos;
    }

    public BeanPrincipal getCtreve() {
        return ctreve;
    }

    public void setCtreve(BeanPrincipal ctreve) {
        this.ctreve = ctreve;
    }
    
    /**
     * Creates a new instance of BeanEvento
     */
    public BeanEvento() {
    }
}
