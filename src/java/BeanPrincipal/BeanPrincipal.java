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
      private List<Usuario> usuarios;
      private Usuario usuario;
      private List<Evento> megusta;

    public List<Evento> getMegusta() {
        return megusta;
    }

    public void setMegusta(List<Evento> megusta) {
        this.megusta = megusta;
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
        
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy",new Locale("es","ES"));
        Date date = (Date)formatter.parse("12/05/2017");
        
        eventos = new ArrayList<>();
        eventos.add(new Evento("Red Hot Chili Peppers","coachella","Musical",date, date, 210.00, "Malaga"));
        eventos.add(new Evento("Uni vs RMB","baloncesto","Deportivo",date, date, 210.00, "Malaga"));
        eventos.add(new Evento("Offspring","concierto","Musical",date,date, 210.00, "Malaga"));
        eventos.add(new Evento("Melendi","concierto","Musical",date,date,30.00,"Malaga"));
        eventos.add(new Evento("Dani Martin","concierto","Musical",date,date,40.00,"Malaga"));
        eventos.add(new Evento("Leiva","concierto","Musical",date,date,35.00,"Malaga"));
        
        usuarios = new ArrayList<>();
        Usuario user = new Usuario();
        user.setNombre("Carlos");
        user.setApellidos("Moreno");
        user.setEmail("carlos_@hotmail.com");
        user.setNick("Karlynho");
        user.setFecha_nacimiento(date);
        user.setPassword("1234");
        usuarios.add(user);
        
        
        megusta = new ArrayList<Evento>();
        megusta.add(new Evento("Red Hot Chili Peppers","coachella","Musical",date, date, 210.00, "Malaga"));
        megusta.add(new Evento("Uni vs RMB","baloncesto","Deportivo",date, date, 210.00, "Malaga"));
        megusta.add(new Evento("Offspring","concierto","Musical",date,date, 210.00, "Malaga"));
        
        
        
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public void eliminarMegusta(Evento e){
        int i = 0;
        
        int aux=0;
        
        boolean encontrado = false;
        while (i<megusta.size() && !encontrado){
            if(megusta.get(i).getNombre().equalsIgnoreCase(e.getNombre())){
                encontrado = true;
                aux = i;
                
            }
            i++;
        }
        
        megusta.remove(aux);
        
      
    }
    
    public void addMegusta(Evento e){
        megusta.add(e);
    }
    
    public Usuario user(){
        return this.usuario;
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
  
}