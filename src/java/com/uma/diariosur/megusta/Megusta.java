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
    
  
   
    
    public String noMegusta(Evento e){
        
        bp.eliminarMegusta(e);
        return "Megusta.xhtml";
        
        
    }
  
    
   
    
    public Megusta() {
  
    }
    
}
