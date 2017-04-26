/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlVistaHome;

import javax.enterprise.context.ApplicationScoped;
import com.uma.diariosur.modelo.Evento;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;




/**
 *
 * @author steven
 */
@Named(value = "beanPrincipal")
@ApplicationScoped
public class BeanPrincipal implements Serializable{
    private  List<Evento>eventos;
    private List<Evento>eventosFiltrados;
    private Boolean control = false;

    public Boolean getControl() {
        return control;
    }

    public void setControl(Boolean control) {
        this.control = control;
    }

    public BeanPrincipal getBnp() {
        return bnp;
    }

    public void setBnp(BeanPrincipal bnp) {
        this.bnp = bnp;
    }
     

    @Inject 
     ControlHome ctrlHome;
     BeanPrincipal bnp;
               
      public List<Evento> getEventosFiltrados() {
        return eventosFiltrados;
    }

    public void setEventosFiltrados(List<Evento> eventosFiltrados) {
        this.eventosFiltrados = eventosFiltrados;
    }

    public ControlHome getCtrlHome() {
        return ctrlHome;
    }

    public void setCtrlHome(ControlHome ctrlHome) {
        this.ctrlHome = ctrlHome;
    } 
      
    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    //modificamos bnp con un valor de cero o uno comprobamos si entramos o no y luego realizamos el cambio de vitsas si la variable filtro esta a true
    public List<Evento> crearEventos() throws ParseException{
        
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = (Date)formatter.parse("12/05/2017");
        
        eventos = new ArrayList<Evento>();
        eventos.add(new Evento("Red Hot Chili Peppers","coachella","Musical",date, date, 210.00, "Malaga"));
        eventos.add(new Evento("Uni vs RMB","baloncesto","Deportivo",date, date, 210.00, "Malaga"));
        eventos.add(new Evento("Offspring","concierto","Musical",date,date, 210.00, "Malaga"));
        
        
        if(control){
            //Se han filtrado los eventos
            control = false;
            return eventosFiltrados;
        }else{
             return eventos;
        }
        
    }
    
    
   
    public BeanPrincipal() throws ParseException{
        
        
        
       
    }
    
     
}
