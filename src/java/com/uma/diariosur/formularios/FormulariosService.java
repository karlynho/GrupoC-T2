package com.uma.diariosur.formularios;


import com.uma.diariosur.modelo.Formulario;
import com.uma.diariosur.modelo.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

  
  
@ManagedBean(name = "formularioService")
@ApplicationScoped
public class FormulariosService {
 
      
    public List<Formulario> createForms() {
         
        List<Formulario> list = new ArrayList<Formulario>();
         
        Usuario usuario = new Usuario();
        usuario.setNick("karlynho");
        
            Formulario f = new Formulario();
            f.setNombre("Jason Derulo Starlite");
            f.setDescripcion("El rapero estadounidense vuelve a España este verano");
            f.setCategoria("Concierto");
            f.setFecha_inicio(new Date());
            f.setFecha_fin(new Date());
            f.setUbicacion("Marbella (Malaga)");
            f.setPrecio(70.00);
            f.setFecha_subida(new Date());
            f.setEstado("pendiente");
            f.setUsuario(usuario);
            list.add(f);
            
            Formulario f1 = new Formulario();
            f1.setNombre("Exposicion cuadros");
            f1.setDescripcion("El rapero estadounidense vuelve a España este verano");
            f1.setCategoria("Concierto");
            f1.setFecha_inicio(new Date());
            f1.setFecha_fin(new Date());
            f1.setUbicacion("Marbella (Malaga)");
            f1.setPrecio(70.00);
            f1.setFecha_subida(new Date());
            f1.setEstado("pendiente");
            f1.setUsuario(usuario);
            list.add(f1);
 
                 
        return list;
    }
        
}
