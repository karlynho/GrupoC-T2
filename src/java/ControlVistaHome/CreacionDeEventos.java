/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlVistaHome;

import com.uma.diariosur.modelo.Evento;
import com.uma.diariosur.modelo.Valoracion;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;




/**
 *
 * @author steven
 */
@Named(value = "creacionDeEventos")
@SessionScoped
public class CreacionDeEventos implements Serializable{
    private List<Evento>eventos;
    private int dia;
    private int mes;
    private int año;
    private List<Valoracion> valoracion = new ArrayList<Valoracion>();

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    public List<Evento> crearEventos() throws ParseException{
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = (Date)formatter.parse("12/05/2017");
        
        eventos = new ArrayList<Evento>();
        eventos.add(new Evento(1234,"Red Hot Chili Peppers","coachella","Musical",date, date, 210.00, "Malaga",valoracion));
        eventos.add(new Evento(1235,"Uni vs RMB","baloncesto","Deportivo",date, date, 210.00, "Malaga",valoracion));
        eventos.add(new Evento(1236,"Offspring","concierto","Musical",date,date, 210.00, "Malaga",valoracion));
        
        return eventos;
    }
    
    public Evento principal(){
        return eventos.get(0);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public List<Valoracion> getValoracion() {
        return valoracion;
    }

    public void setValoracion(List<Valoracion> valoracion) {
        this.valoracion = valoracion;
    }
    
    
    /**
     * Creates a new instance of CreacionDeEventos
     */
    public CreacionDeEventos() {
    }
    
}
