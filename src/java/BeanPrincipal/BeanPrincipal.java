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
import com.uma.diariosur.modelo.Valoracion;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
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
      private Evento eventoV;
      private List<Evento> validos = new ArrayList<Evento>();
      private List<Valoracion> valoracion = new ArrayList<Valoracion>();
      

    public List<Evento> getValidos() {
        return validos;
    }

    public void setValidos(List<Evento> validos) {
        this.validos = validos;
    }
      
    public List<Formulario> getFormularios() {
        return formularios;
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
        Usuario usuario = new Usuario();
        usuario.setNick("karlynho");
        usuario.setNombre("Carlos");
        
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy",new Locale("es","ES"));
        Date date = (Date)formatter.parse("12/05/2017");
        Evento e1,e2,e3,e4,e5,e6,e7;
        e1 = new Evento(1234,"Red Hot Chili Peppers","coachella","Musical",date, date, 210.00, "Malaga",valoracion);
        e2 =new Evento(1235,"Uni vs RMB","baloncesto","Deportivo",date, date, 210.00, "Malaga",valoracion);
        e3 = new Evento(1236,"Offspring","concierto","Musical",date,date, 210.00, "Malaga",valoracion);
        e4 = new Evento(1237,"Melendi","concierto","Musical",date,date,30.00,"Malaga",valoracion);
        e5 = new Evento(1238,"Dani Martin","concierto","Musical",date,date,40.00,"Malaga",valoracion);
        e6 = new Evento(1239,"Leiva","concierto","Musical",date,date,35.00,"Malaga",valoracion);
        eventos = new ArrayList<>();
        eventos.add(e1);
        eventos.add(e2);
        eventos.add(e3);
        eventos.add(e4);
        eventos.add(e5);
        eventos.add(e6);
        
        Valoracion v1= new Valoracion(1234,"Me ha parecido muy bueno", 3,usuario, e1);
        Valoracion v2= new Valoracion(1235,"Ha sido muy bueno", 5,usuario, e1);
        Valoracion v3= new Valoracion(1236,"Me ha encantado", 4,usuario, e1);
        Valoracion v4= new Valoracion(1237,"Podia haber esado algo mejor", 2,usuario, e1);
        Valoracion v5= new Valoracion(1234,null, 3,usuario, e1);
        List<Valoracion> v = new ArrayList();
        v.add(v1);
        v.add(v2);
        v.add(v3);
        v.add(v4);
        e1.setValoraciones(v);
        
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
            formularios.add(f1);
            
        Formulario f2 = new Formulario();
            f2.setNombre("Mohas´s Circus Sideshow");
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
            formularios.add(f2);
        
        
       
    }

    public Integer media(){
        int i= 0;
        Iterator<Valoracion> it = eventoV.getValoraciones().iterator();
        Valoracion val = new Valoracion();
        while(it.hasNext()){
            val = it.next();
            i = i+ val.getPuntuacion();
        }
        return i / eventoV.getValoraciones().size();
    }
            
    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public Evento getEventoV() {
        return eventoV;
    }

    public void setEventoV(Evento eventoV) {
        this.eventoV = eventoV;
    }
    
    public void verEvento(Evento e){
        eventoV = e;
    }

    public Evento principal(){
        return eventos.get(0);
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

    public List<Valoracion> getValoracion() {
        return valoracion;
    }

    public void setValoracion(List<Valoracion> valoracion) {
        this.valoracion = valoracion;
    }
    
    
}
