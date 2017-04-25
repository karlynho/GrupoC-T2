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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Named;




/**
 *
 * @author steven
 */
@Named(value = "beanPrincipal")
@ApplicationScoped
public class BeanPrincipal implements Serializable{
    private static List<Evento>eventos;
      private List<Evento>eventosFiltrados;
      private boolean filtrados=false;

    @Inject 
     ControlHome ctrlHome;
           
    
    
  
      
      
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
    
    
    
    //VISUALIZACION DE CREACION DE EVENTOS
      public List<Evento> verEventos() throws ParseException{
          if(filtrados){
              //VEMOS EVENTOD FILTRADOS
              return eventosFiltrados;
          }else{
             //VEMOS TODOS LOS EVENTOS
              return eventos;
          }

    }
    
    public BeanPrincipal() throws ParseException{
        
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = (Date)formatter.parse("12/05/2017");
        
        eventos = new ArrayList<Evento>();
        eventos.add(new Evento("Red Hot Chili Peppers","coachella","Musical",date, date, 210.00, "Malaga"));
        eventos.add(new Evento("Uni vs RMB","baloncesto","Deportivo",date, date, 210.00, "Malaga"));
        eventos.add(new Evento("Offspring","concierto","Musical",date,date, 210.00, "Malaga"));
        
       
    }
    

    
    
    //COMPROBACION DE EVENTOS FILTRADOS
     public String comprobacion(String evento,String ubicacion,String categoria,String fecha){
      
        boolean encontrado = false;
       int tam = eventos.size();
       int i= 0;
       
       while(i<tam && !encontrado){
           
           if(eventos.get(i).getNombre().equalsIgnoreCase(evento) && evento!=null){
               //El nombre coincide con uno o muchos eventos, lo añadimos al la lista de filtrados
               eventosFiltrados.add(eventos.get(i));
               encontrado = true;
               filtrados=true;
           }else if(eventos.get(i).getUbicacion().equalsIgnoreCase(ubicacion)){
               //La ubicacion coincide,  comprobamos la categoria
               if(eventos.get(i).getCategoria().equalsIgnoreCase(categoria)){
                   //La categoria coincide, comprobamos la fecha
                   if(eventos.get(i).getFecha_inicio().equals(fecha)){
                       //Coinciden las tres condiciones del filtro, entonces añadimos a la lista de filtrados
                       eventosFiltrados.add(eventos.get(i));
                       filtrados=true;
                   }
               }
               
           }
           
           i++;
           
       }
       return ctrlHome.home();
       
}
     
}
