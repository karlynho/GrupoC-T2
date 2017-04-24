package com.uma.diariosur.formularios;

import com.uma.diariosur.modelo.Evento;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

  
  
@ManagedBean(name = "countryService")
@ApplicationScoped
public class CountryService {
 
      
    public List<Evento> createCountries() {
         
        List<Evento> list = new ArrayList<Evento>();
         
        
            Evento c = new Evento();
            c.setNombre("prueba");
            c.setDescripcion("pruebaaaaaaaaaaaaaaaa");
            c.setCategoria("concierto");
            c.setFecha_inicio(new Date());
            c.setFecha_final(new Date());
            c.setUbicacion("cuenca");
            c.setPrecio(20.00);
              
            list.add(c);
 
                 
        return list;
    }
        
}
