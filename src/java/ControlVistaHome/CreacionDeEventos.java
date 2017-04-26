/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlVistaHome;

import com.uma.diariosur.modelo.Evento;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import javax.inject.Named;




/**
 *
 * @author steven
 */
@Named(value = "creacionDeEventos")
@SessionScoped
public class CreacionDeEventos implements Serializable{
    private List<Evento>eventos;
    private List<Evento>eventosFiltrados;
    private boolean filtrado = false;
    
    @Inject 
    BeanPrincipal bnp;
    ControlHome ctrlhome;
    
    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
   //modificamos bnp con un valor de cero o uno comprobamos si entramos o no y luego realizamos el cambio de vitsas si la variable filtro esta a true
    public List<Evento> crearEventos() throws ParseException{
        bnp = new BeanPrincipal();
        return bnp.getEventos();
        
    }
    
    public String comprobacion(String evento,String ubicacion,String categoria,Date fecha) throws ParseException{
      eventos = bnp.getEventos();
      eventosFiltrados = new ArrayList<Evento>();
        
       boolean encontrado = false;
       int tam = eventos.size();
       int i= 0;
       
       while(i<tam && !encontrado){
           
           if(eventos.get(i).getNombre().equalsIgnoreCase(evento) && evento!=null){
               //El nombre coincide con uno o muchos eventos, lo añadimos al la lista de filtrados
               eventosFiltrados.add(eventos.get(i));
               encontrado = true;
           }else if(eventos.get(i).getUbicacion().equalsIgnoreCase(ubicacion)){
               //La ubicacion coincide,  comprobamos la categoria
               if(eventos.get(i).getCategoria().equalsIgnoreCase(categoria)){
                   //La categoria coincide, comprobamos la fecha
                   if(eventos.get(i).getFecha_inicio().equals(fecha)){
                       //Coinciden las tres condiciones del filtro, entonces añadimos a la lista de filtrados
                       eventosFiltrados.add(eventos.get(i));
                
                   }
               }
               
           }
           
           i++;
       }
       
       
       if(eventosFiltrados.isEmpty()){
            System.out.println("No hay filtro");
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error No hay coincidencias", "Error no hay coincidencias"));
            return null;
       }else{
           System.out.println("Si hay filtro");
            bnp.setEventosFiltrados(eventosFiltrados);
            bnp.setControl(true);
            return "PaginaHome.xhtml";
       }
       
 
    }
 
    /**
     * Creates a new instance of CreacionDeEventos
     */
    public CreacionDeEventos() {
    }
    
    
    
}
