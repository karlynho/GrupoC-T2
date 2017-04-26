/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPrincipal;

import com.uma.diariosur.modelo.Evento;
import com.uma.diariosur.modelo.Formulario;
import com.uma.diariosur.modelo.Imagen;
import com.uma.diariosur.modelo.Usuario;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author Carlos
 */
@Named(value = "beanPrincipal")
@ManagedBean(eager=true)
@ApplicationScoped


public class BeanPrincipal implements Serializable{
      private List<Evento>eventos;
      private List<Formulario> formularios;
      private List<Imagen> imagenes;

    public List<Formulario> getFormularios() {
        return formularios;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public void setFormularios(List<Formulario> formularios) {
        this.formularios = formularios;
    }

      
    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
  
    public BeanPrincipal() throws ParseException{
        
        imagenes = new ArrayList<>();
        Imagen i1 = new Imagen();
        i1.setTipo(".jpg");
        i1.setEnlace("resources\\Malaga-RMD.jpg");
        
        Imagen i2 = new Imagen();
        i2.setTipo(".jpg");
        i2.setEnlace("resources\\Offspring.jpg");
        
        Imagen i3 = new Imagen();
        i3.setTipo(".jpg");
        i3.setEnlace("resources\\Red Hot Chili Peppers.jpg");
        
        Imagen i4 = new Imagen();
        i4.setTipo(".jpg");
        i4.setEnlace("resources\\Uni vs RMB.jpg");
        
        
        Imagen i5 = new Imagen();
        i5.setEnlace("JasonDerulo.jpg");
        
        
        Imagen i6 = new Imagen();
        i6.setEnlace("cuadros_exposicion.jpg");
        
        Imagen i7 = new Imagen();
        i7.setEnlace("lebarbe1.jpg");
       
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = (Date)formatter.parse("12/05/2017");
        
        eventos = new ArrayList<>();
        eventos.add(new Evento("Red Hot Chili Peppers","coachella","Musical",date, date, 210.00, "Malaga",i1));
        eventos.add(new Evento("Uni vs RMB","baloncesto","Deportivo",date, date, 210.00, "Malaga",i2));
        eventos.add(new Evento("Offspring","concierto","Musical",date,date, 210.00, "Malaga",i3));
        
        Usuario usuario = new Usuario();
        usuario.setNick("karlynho");
        
        formularios = new ArrayList<>();
        Formulario f = new Formulario();
            f.setNombre("Jason Derulo Starlite");
            f.setDescripcion("Jason Derulo, considerado como una de las mejores voces de la ú"
                    + "ltima década, se subirá al escenario de Starlite el jueves 24 de agosto y"
                    + " pondrá a bailar al público de la cantera con su ritmo inconfundible. "
                    + "Este concierto es el único que tiene confirmado por el momento en España. Cantante,"
                    + " compositor y bailarín Derulo presentará en Starlite su nuevo disco del que ya hemos "
                    + "podido escuchar el primer single “Swalla”");
            f.setCategoria("Concierto");
            f.setFecha_inicio(new Date());
            f.setFecha_fin(new Date());
            f.setUbicacion("Marbella (Malaga)");
            f.setPrecio(70.00);
            f.setFecha_subida(new Date());
            f.setEstado("pendiente");
            f.setUsuario(usuario);
            f.setImg(i5);
            i5.setF(f);
            formularios.add(f);
        
            
            
        Formulario f1 = new Formulario();
            f1.setNombre("Seurat´s Circus Sideshow");
            f1.setDescripcion("Una exhibición temática dedicada a la obra neo impresionista del pintor francés Georges Seurat."
                    + " Más de cien pinturas, dibujos, impresiones e ilustraciones relacionadas "
                    + "con esta obra exhibida por primera vez en París en 1888 serán puestas en exhibición. ");
            f1.setCategoria("Exposicion");
            f1.setFecha_inicio(new Date());
            f1.setFecha_fin(new Date());
            f1.setUbicacion("Marbella (Malaga)");
            f1.setPrecio(10.00);
            f1.setFecha_subida(new Date());
            f1.setEstado("pendiente");
            f1.setUsuario(usuario);
            f1.setImg(i6);
            i6.setF(f1);
            formularios.add(f1);
            
        Formulario f2 = new Formulario();
            f2.setNombre("Mohas´s Moet");
            f2.setDescripcion("Una exhibición temática dedicada a la shisha neo impresionista del pintor Moha."
                    + " Más de 123 tabacos, dibujos, impresiones e ilustraciones relacionadas "
                    + "con esta obra exhibida por primera vez en Marbella en 2088 serán puestas en exhibición. ");
            f2.setCategoria("Exposicion");
            f2.setFecha_inicio(new Date());
            f2.setFecha_fin(new Date());
            f2.setUbicacion("Marbella (Malaga)");
            f2.setPrecio(10.00);
            f2.setFecha_subida(new Date());
            f2.setEstado("pendiente");
            f2.setUsuario(usuario);
            f2.setImg(i7);
            i7.setF(f2);
            formularios.add(f2);
        
        
        imagenes.add(i1);
        imagenes.add(i2);
        imagenes.add(i3);
        imagenes.add(i4);
        imagenes.add(i5);
        imagenes.add(i6);
        imagenes.add(i7);
    }

    public void eliminarForm(Formulario f) {
        formularios.remove(f);
    }
    
    public void addEvent(Evento e){
        eventos.add(e);
    }
    
    public void addForm(Formulario f){
        formularios.add(f);
    }
    
    public void addImage(Imagen i){
        imagenes.add(i);
    }
    
    public void deleteImage(Imagen i){
        imagenes.remove(i);
    }
}
