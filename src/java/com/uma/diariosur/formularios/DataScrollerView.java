package com.uma.diariosur.formularios;

import BeanPrincipal.BeanPrincipal;
import ControlVistaHome.ControlHome;
import com.uma.diariosur.modelo.Evento;
import com.uma.diariosur.modelo.Formulario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
 
  
@ManagedBean
@ViewScoped

public class DataScrollerView implements Serializable {
      
    @Inject
    private BeanPrincipal bp;
    @Inject
    private ControlHome ctrlhome;

    public ControlHome getCtrlhome() {
        return ctrlhome;
    }

    public void setCtrlhome(ControlHome ctrlhome) {
        this.ctrlhome = ctrlhome;
    }
  
    public DataScrollerView() {
        
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
        e.setImagen(f.getImg());
        e.setPeriodista(ctrlhome.getPeriodista());
        
        bp.addEvent(e);
        
        System.out.println("Creado evento del formulario" + f.getNombre());
        bp.eliminarForm(f);
        
        
       return "formularios.xhtml"; 
    }
    
    public String rechazar(Formulario f){
       
        System.out.println("Eliminado formulario" + f.getNombre());
        bp.eliminarForm(f);
        return "formularios.xhtml"; 
    }
    
}
