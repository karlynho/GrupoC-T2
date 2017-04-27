/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uma.diariosur.evento;

import ControlVistaHome.ControlHome;
import ControlVistaHome.CreacionDeEventos;
import com.uma.diariosur.modelo.Evento;
import java.io.Serializable;
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
public class BeanEvento   implements Serializable {

    /**
     * Creates a new instance of BeanEvento
     */
    public BeanEvento() {
    }
    
    @Inject
    CreacionDeEventos ctreve;
    public Evento verEvento(){
        return ctreve.principal();
    }

    public CreacionDeEventos getCtreve() {
        return ctreve;
    }

    public void setCtreve(CreacionDeEventos ctreve) {
        this.ctreve = ctreve;
    }
    
}
