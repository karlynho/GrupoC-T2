/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlVistaHome;

import com.uma.diariosur.modelo.Evento;
import javax.inject.Named;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author steven
 */
@Named(value = "controlBusquedaEvento")
@RequestScoped
public class ControlBusquedaEvento implements Serializable {
 
    private String evento;
    private String ubicacion;
    private String categoria;
    private Date fecha;

    
    private List<Evento>eventos;
    private List<Evento>eventosFiltrados;
    
    
   
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public void setEvento(String evento){
        this.evento=evento;
    }
    
    public String getEvento(){
        return evento;
    }
    
    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }
    
    public String getUbicacion(){
        return ubicacion;
    }
    
    
    public ControlBusquedaEvento() throws ParseException {
        eventos = new ArrayList<Evento>();
        
        //Se deben añadir los eventos que se van a buscar para testear la aplicación
        eventos = new ArrayList<>();
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date date = (Date)formatter.parse("12/05/17");
        eventos.add(new Evento("Red Hot Chili Peppers","coachella","Conciertos",date, date, 210.00, "Malaga"));
        eventos.add(new Evento("Uni vs RMB","baloncesto","Deportivo",date, date, 210.00, "Malaga"));
        eventos.add(new Evento("Offspring","concierto","Conciertos",date,date, 210.00, "Malaga"));
    }
    
    public String comprobación(){
       boolean encontrado = false;
       int tam = eventos.size();
       int i= 0;
       
       while(i<tam || !encontrado){
           if(eventos.get(i).getNombre().equalsIgnoreCase(this.evento)){
               //El nombre coincide con uno o muchos eventos, lo añadimos al la lista de filtrados
               eventosFiltrados.add(eventos.get(i));
           }else if(eventos.get(i).getUbicacion().equalsIgnoreCase(this.ubicacion)){
               //La ubicacion coincide,  comprobamos la categoria
               if(eventos.get(i).getCategoria().equalsIgnoreCase(this.categoria)){
                   //La categoria coincide, comprobamos la fecha
                   if((eventos.get(i).getFecha_inicio().after(this.fecha)&& eventos.get(i).getFecha_final().before(this.fecha)) || 
                      eventos.get(i).getFecha_inicio().equals(this.fecha)){
                       //Coinciden las tres condiciones del filtro, entonces añadimos a la lista de filtrados
                       eventosFiltrados.add(eventos.get(i));
                   }
               }
               
           }
           i++;
           
       }
       return "ControlHomeFiltro.xhtml";
    }
    
}
