/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uma.diariosur.megusta;

import BeanPrincipal.BeanPrincipal;
import com.uma.diariosur.modelo.Evento;
import com.uma.diariosur.modelo.Usuario;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Carmen
 */
@Named(value = "megusta")
@SessionScoped

public class Megusta implements Serializable{

    /**
     * Creates a new instance of Megusta
     */
    
    @Inject
    private BeanPrincipal bp;
    
    private List<Evento>megusta;
    private int dia;
    private int mes;
    private int año;
    
  

    public List<Evento> getMegusta() {
        return megusta;
    }

    public void setMegusta(List<Evento> eventos) {
        this.megusta = eventos;
    }
    
    public List<Evento> crearMegusta() throws ParseException{
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = (Date)formatter.parse("12/05/2017");
        
        megusta = new ArrayList<Evento>();
        megusta.add(new Evento("Red Hot Chili Peppers","coachella","Musical",date, date, 210.00, "Malaga"));
        megusta.add(new Evento("Uni vs RMB","baloncesto","Deportivo",date, date, 210.00, "Malaga"));
        megusta.add(new Evento("Offspring","concierto","Musical",date,date, 210.00, "Malaga"));
        
        return megusta;
    }
    
    
    
    public String megusta(){
        
        
        
        
        return "Megusta.xhtml";
        
        
    }
  
    
    
   
    
    public Megusta() {
  
    }
    
}
