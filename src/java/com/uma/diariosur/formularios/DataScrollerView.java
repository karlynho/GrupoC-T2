package com.uma.diariosur.formularios;

import com.uma.diariosur.modelo.Evento;
import com.uma.diariosur.modelo.Formulario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
 
  
@ManagedBean
@ViewScoped
public class DataScrollerView implements Serializable {
      
    private List<Formulario> formularios;
    
    
    @ManagedProperty("#{formularioService}")
    private FormulariosService service;
      
    @PostConstruct
    public void init() {
        formularios = service.createForms();
    }
  
    public List<Formulario> getFormularios() {
        return formularios;
    }
  
    public void setService(FormulariosService service) {
        this.service = service;
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
        
        rechazar(f);
        
       return "formularios.xhtml"; 
    }
    
    public String rechazar(Formulario f){
        formularios.remove(f);
        System.out.println(formularios.size());
        return null;
    }
    
}
