/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlVistaHome;

import BeanPrincipal.BeanPrincipal;
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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

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
    
    @Inject 
    ControlHome ctrlhome;
    @Inject
    BeanPrincipal bnp;
    
   public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Evento> getEventosFiltrados() {
        return eventosFiltrados;
    }

    public void setEventosFiltrados(List<Evento> eventosFiltrados) {
        this.eventosFiltrados = eventosFiltrados;
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
       
        
        //Se deben añadir los eventos que se van a buscar para testear la aplicación
        
    }
    
    public String comprobacion(String evento,String ubicacion,String categoria,Date fecha) throws ParseException{
      eventos = new ArrayList<Evento>();
      eventosFiltrados = new ArrayList<Evento>();
      bnp = new BeanPrincipal();
      eventos = bnp.getEventos();
      
       boolean encontrado = false;
       int tam = eventos.size();
       int i= 0;
       
       while(i<tam && !encontrado){
           
           if(eventos.get(i).getNombre().equalsIgnoreCase(this.evento) && this.evento!=null){
               //El nombre coincide con uno o muchos eventos, lo añadimos al la lista de filtrados
               eventosFiltrados.add(eventos.get(i));
               encontrado = true;
           }else if(eventos.get(i).getUbicacion().equalsIgnoreCase(this.ubicacion)){
               //La ubicacion coincide,  comprobamos la categoria
               if(eventos.get(i).getCategoria().equalsIgnoreCase(this.categoria)){
                   //La categoria coincide, comprobamos la fecha
                   if(eventos.get(i).getFecha_inicio().equals(this.fecha)){
                       //Coinciden las tres condiciones del filtro, entonces añadimos a la lista de filtrados
                       eventosFiltrados.add(eventos.get(i));
                
                   }
               }
               
           }
           
           i++;
           
       }
       
       eventosFiltrados.add(eventos.get(i-1));
       bnp.setEventosFiltrados(eventosFiltrados);
       
       if(eventosFiltrados.isEmpty()){
            System.out.println("No hay filtro");
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error No hay coincidencias", "Error no hay coincidencias"));
            return null;
       }else{
            return ctrlhome.home();
       }
      
    }
    
}
