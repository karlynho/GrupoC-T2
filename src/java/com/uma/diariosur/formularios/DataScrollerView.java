package com.uma.diariosur.formularios;

import BeanPrincipal.BeanPrincipal;
import com.uma.diariosur.modelo.Evento;
import com.uma.diariosur.modelo.Formulario;
import java.io.Serializable;
import java.text.ParseException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
 
  
@ManagedBean
@ViewScoped
public class DataScrollerView implements Serializable {
      
    @Inject
    private BeanPrincipal bp;
    
  
    public DataScrollerView() throws ParseException{
        
    }

    public BeanPrincipal getBp() {
        return bp;
    }

    public void setBp(BeanPrincipal bp) {
        this.bp = bp;
    }
    
    public String home() {
        return "PaginaHome.xhtml";
    }
    
    public String validar(Formulario f){
        
        Evento e = new Evento ();
        e.setNombre(f.getNombre());
        e.setDescripcion(f.getDescripcion());
        e.setCategoria(f.getCategoria());
        e.setFecha_inicio(f.getFecha_inicio());
        e.setFecha_final(f.getFecha_fin());
        e.setUbicacion(f.getUbicacion());
        e.setPrecio(f.getPrecio());
        
        bp.addEvent(e);
        bp.eliminarForm(f);
        
        
       return "formularios.xhtml"; 
    }
    
    public String rechazar(Formulario f){
        bp.eliminarForm(f);
        return null;
    }
    
}
