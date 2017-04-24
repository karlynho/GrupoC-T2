package com.uma.diariosur.formularios;

import com.uma.diariosur.modelo.Evento;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
 
  
@ManagedBean
@ViewScoped
public class DataScrollerView implements Serializable {
      
    private List<Evento> eventos;
          
    @ManagedProperty("#{countryService}")
    private CountryService service;
      
    @PostConstruct
    public void init() {
        eventos = service.createCountries();
    }
  
    public List<Evento> getEventos() {
        return eventos;
    }
  
    public void setService(CountryService service) {
        this.service = service;
    }
}
