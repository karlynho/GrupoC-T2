/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uma.diariosur.evento;

import BeanPrincipal.BeanPrincipal;
import ControlVistaHome.ControlHome;
import com.uma.diariosur.modelo.Evento;
import com.uma.diariosur.modelo.Valoracion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Sergio
 */
@Named(value = "eventoBean")
@SessionScoped

public class EventoBean implements Serializable{

    private Evento eve;
    @Inject
    private BeanPrincipal ctreve;
    @Inject
    private ControlVistaHome.ControlHome ctrh;
    private Valoracion valoracion;
    private List<Valoracion> val = new ArrayList<Valoracion>();

    public Evento getEve() {
        return eve;
    }

    public void setEve(Evento eve) {
        this.eve = eve;
    }

    public BeanPrincipal getCtreve() {
        return ctreve;
    }

    public void setCtreve(BeanPrincipal ctreve) {
        this.ctreve = ctreve;
    }

    public ControlHome getCtrh() {
        return ctrh;
    }

    public void setCtrh(ControlHome ctrh) {
        this.ctrh = ctrh;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }

    public List<Valoracion> getVal() {
        return val;
    }

    public void setVal(List<Valoracion> val) {
        this.val = val;
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

    public void guardarComentario() {

    }

    public void ponerPuntuacion(Integer v) {
        List<Valoracion> total = ctreve.getEventoV().getValoraciones();
        Iterator<Valoracion> it = total.iterator();
        Valoracion var = new Valoracion();
        int i = 0;
        boolean tiene = false;
        while (it.hasNext()) { //Recorro la lista de vaoraciones de ese evento
            var = it.next();
            if (var.getUsuario().getNombre().equals(ctrh.getUsuario().getNombre())) { //Compruebo las que tiene el usuario actual
                var.setPuntuacion(v); //Las voy cambiando toddas por la vaoracion nueva
                tiene = true;
            }
            //donde secoje el usuario actual
        }
        if (!tiene) {
            Valoracion va = new Valoracion(7777, null, v, ctrh.getUsuario(), ctreve.getEventoV());

        }
    }

    /**
     * Creates a new instance of EventoBean
     */
    public EventoBean() {
    }

}
