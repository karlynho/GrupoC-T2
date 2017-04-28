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
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;




/**
 *
 * @author steven
 */
@Named(value = "beanPrincipal")
@SessionScoped
public class BeanPrincipal implements Serializable{
    
    private  List<Evento>eventos;
    private List<Evento>eventosFiltrados;
    private Boolean control = false;
    private String Usuario = "Carlos";
    private String Nombre = "Carlos Dominguez";
    private String Correo = "carlos_@hotmail.com";
    private String fecha_nacimiento = "03/02/1991";
    private String contraseña;
    private String contraseñanueva;
    private String contraseñanueva1;
    private List<String> idiomas;
    private String[] selectedIdioma;

    
    @PostConstruct
    public void idioma() {
        
        idiomas = new ArrayList<String>();
        idiomas.add("Español");
        idiomas.add("Inglés");
        idiomas.add("Alemán");
        idiomas.add("Francés");
        
    }

    public String[] getSelectedIdioma() {
        return selectedIdioma;
    }

    public void setSelectedIdioma(String[] selectedIdioma) {
        this.selectedIdioma = selectedIdioma;
    }
    
    
    
    
    public String getContraseñanueva1() {
        return contraseñanueva1;
    }

    public void setContraseñanueva1(String contraseñanueva1) {
        this.contraseñanueva1 = contraseñanueva1;
    }
    
    

    public String getContraseñanueva() {
        return contraseñanueva;
    }

    public void setContraseñanueva(String contraseñanueva) {
        this.contraseñanueva = contraseñanueva;
    }
    
    

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    
    
    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
            
    
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
    

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
    
     public String home() {
        return "PaginaHome.xhtml";
    }
      
     
}