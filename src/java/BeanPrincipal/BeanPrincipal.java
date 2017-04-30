/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPrincipal;

import ControlVistaHome.ControlHome;
import com.uma.diariosur.modelo.Evento;
import com.uma.diariosur.modelo.Formulario;
import com.uma.diariosur.modelo.Imagen;
import com.uma.diariosur.modelo.Megusta;
import com.uma.diariosur.modelo.Periodista;
import com.uma.diariosur.modelo.Usuario;
import com.uma.diariosur.modelo.Valoracion;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Carlos
 */
@ManagedBean(eager=true)
@Named(value = "beanPrincipal")
@ApplicationScoped


public class BeanPrincipal implements Serializable{
    
    @Inject
    private ControlHome ch;
      private List<Evento>eventos;
      private List<Formulario> formularios;
      private List<Imagen> imagenes;

    private List<Evento>eventosFiltrados;
    private List<Usuario> usuarios;
    private List<Periodista> periodistas;
    private List<Megusta> megusta;
    private Usuario usuario;

    private Evento eventoV;
     private List<Evento> validos = new ArrayList<Evento>();
      private List<Valoracion> valoracion = new ArrayList<Valoracion>();
  
      public List<Valoracion> getValoracion() {
        return valoracion;
    }

    public void setValoracion(List<Valoracion> valoracion) {
        this.valoracion = valoracion;
    }
  public Evento getEventoV() {
        return eventoV;
    }

    public void setEventoV(Evento eventoV) {
        this.eventoV = eventoV;
    }

    public List<Evento> getValidos() {
        return validos;
    }

    public void setValidos(List<Evento> validos) {
        this.validos = validos;
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
    public List<Megusta> getMegusta() {
        return megusta;
    }

    public void setMegusta(List<Megusta> megusta) {
        this.megusta = megusta;
    }



    public List<Periodista> getPeriodistas() {
        return periodistas;
    }

    public void setPeriodistas(List<Periodista> periodistas) {
        this.periodistas = periodistas;
    }

    @Inject 
    ControlHome ctrlHome;
    
    public List<Evento> getEventosFiltrados() {
        return eventosFiltrados;
    }

    public void setEventosFiltrados(List<Evento> eventosFiltrados) {
        this.eventosFiltrados = eventosFiltrados;
    }

    public ControlHome getCtrlHome() {
        return ctrlHome;
    }

    public void setCtrlHome(ControlHome ctrlHome) {
        this.ctrlHome = ctrlHome;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

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

     public Usuario user(){
        return this.usuario;
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
        Date fecha= (Date)formatter.parse("12/05/1993");
        
        
       usuarios = new ArrayList<>();
       Usuario u = new Usuario();
       u.setNombre("Carlos");
       u.setApellidos("Velazquez");
       u.setPassword("buenooo");
       u.setNick("karlynho");
       u.setEmail("carlospuli@gmail,com");
       u.setFecha_nacimiento(fecha);
       usuarios.add(u);
       
       Usuario u1 = new Usuario();
       u1.setNombre("Carmen");
       u1.setApellidos("Moreno");
       u1.setPassword("hola");
       u1.setNick("CarmenB");
       u1.setEmail("carmen_06_95@hotmail.com");
       u1.setFecha_nacimiento(fecha);
       usuarios.add(u1);
       
       
       
       
       periodistas = new ArrayList<>();
       
       Periodista p = new Periodista();
       p.setNombre("Steven");
       p.setApellidos("Montoya");
       p.setPassword("contrasenia");
       p.setEmail("smv@gmail.com");
       p.setId(123456);
       periodistas.add(p);
        
        
        
        

       
       
       
        imagenes = new ArrayList<>();
        Imagen i1 = new Imagen();
        i1.setTipo(".jpg");
        i1.setEnlace("Malaga-RMD.jpg");
        
        Imagen i2 = new Imagen();
        i2.setTipo(".jpg");
        i2.setEnlace("Offspring.jpg");
        
        Imagen i3 = new Imagen();
        i3.setTipo(".jpg");
        i3.setEnlace("Red Hot Chili Peppers.jpg");
        
        Imagen i4 = new Imagen();
        i4.setTipo(".jpg");
        i4.setEnlace("Uni vs RMB.jpg");
        
        
        Imagen i5 = new Imagen();
        i5.setEnlace("JasonDerulo.jpg");
        
        
        Imagen i6 = new Imagen();
        i6.setEnlace("cuadros_exposicion.jpg");
        
        Imagen i7 = new Imagen();
        i7.setEnlace("lebarbe1.jpg");
       
        Imagen i8 = new Imagen();
        i8.setEnlace("Melendi.jpg");
        
        Imagen i9 = new Imagen();
        i9.setEnlace("Dani Martin.jpg");
        
        Imagen i10 = new Imagen();
        i9.setEnlace("Leiva.jpg");
        
        eventos = new ArrayList<>();
        Evento e1 = new Evento();
        e1.setNombre("Red Hot Chili Peppers");
        e1.setCategoria("Conciertos");
        e1.setDescripcion("coachella");
        e1.setFecha_inicio(date);
        e1.setFecha_final(date);
        e1.setPeriodista(p);
        e1.setPrecio(34.00);
        e1.setUbicacion("Malaga");
        e1.setImagen(i3);
        i3.setEvento(e1);
        
        Evento e2 = new Evento();
        e2.setNombre("Uni vs RMB");
        e2.setCategoria("Deportivo");
        e2.setDescripcion("baloncesto");
        e2.setFecha_inicio(date);
        e2.setFecha_final(date);
        e2.setPeriodista(p);
        e2.setPrecio(34.00);
        e2.setUbicacion("Malaga");
        e2.setImagen(i4);
        i4.setEvento(e2);
        
        Evento e3 = new Evento();
        e3.setNombre("Offspring");
        e3.setCategoria("Conciertos");
        e3.setDescripcion("musicaaal");
        e3.setFecha_inicio(date);
        e3.setFecha_final(date);
        e3.setPeriodista(p);
        e3.setPrecio(324.00);
        e3.setUbicacion("Malaga");
        e3.setImagen(i2);
        i2.setEvento(e3);
      
        eventos.add(e1);
        eventos.add(e2);
        eventos.add(e3);
       
        Evento e4 = new Evento();
        e4.setNombre("Melendi");
        e4.setCategoria("Conciertos");
        e4.setDescripcion("musical");
        e4.setFecha_inicio(date);
        e4.setFecha_final(date);
        e4.setPeriodista(p);
        e4.setPrecio(34.00);
        e4.setUbicacion("Malaga");
        e4.setImagen(i8);
        i8.setEvento(e4);
        
     
        Evento e5 = new Evento();
        e5.setNombre("Dani Martin");
        e5.setCategoria("Conciertos");
        e5.setDescripcion("coachella");
        e5.setFecha_inicio(date);
        e5.setFecha_final(date);
        e5.setPeriodista(p);
        e5.setPrecio(34.00);
        e5.setUbicacion("Malaga");
        i9.setEvento(e5);
        e5.setImagen(i9);
        
      Evento e6 = new Evento();
        e6.setNombre("Leiva");
        e6.setCategoria("Conciertos");
        e6.setDescripcion("coachella");
        e6.setFecha_inicio(date);
        e6.setFecha_final(date);
        e6.setPeriodista(p);
        e6.setPrecio(34.00);
        e6.setUbicacion("Malaga");
      
        i10.setEvento(e6);
        e6.setImagen(i10);
       
        eventos.add(e4);
        eventos.add(e5);
        eventos.add(e6);
        
        Valoracion v1= new Valoracion(1234,"Me ha parecido muy bueno", 3,u, e1);
        Valoracion v2= new Valoracion(1235,"Ha sido muy bueno", 5,u, e1);
        Valoracion v3= new Valoracion(1236,"Me ha encantado", 4,u, e1);
        Valoracion v4= new Valoracion(1237,"Podia haber esado algo mejor", 2,u, e1);
       
        List<Valoracion> v = new ArrayList();
        v.add(v1);
        v.add(v2);
        v.add(v3);
        v.add(v4);
        e1.setValoraciones(v);
      
      
      
        
        megusta = new ArrayList<Megusta>();
        Megusta m1 = new Megusta();
       
        m1.setUsuario(u);
        m1.setEvento(e1);
        Megusta m2 = new Megusta();
       
        m2.setUsuario(u);
        m2.setEvento(e3);
        Megusta m3 = new Megusta();
        m3.setUsuario(u);
        m3.setEvento(e2);
       
         megusta.add(m1);
         megusta.add(m3);
         megusta.add(m2);
        
        u.setMegusta(megusta);
        
        Megusta m4 = new Megusta();
       
        m4.setUsuario(u1);
        m4.setEvento(e1);
        megusta.add(m4);
        u1.setMegusta(megusta);
        
        
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
            f.setUsuario(u);
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
            f1.setUsuario(u);
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
            f2.setUsuario(u);
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
        imagenes.add(i8);
        imagenes.add(i9);
        imagenes.add(i10);
    }

    public void eliminarForm(Formulario f) {
       
        int i = 0;
        int aux=0;
        boolean encontrado = false;
        while (i<formularios.size() && !encontrado){
            if(formularios.get(i).getNombre().equalsIgnoreCase(f.getNombre())){
                encontrado = true;
                aux = i;
                
            }
            i++;
        }
        
        formularios.remove(aux);
      
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
    
    public void añadirUsuario(Usuario u){
        usuarios.add(u);
    }
    
    public void deleteImage(Imagen i){
        imagenes.remove(i);
    }
    
     public void eliminarMegusta(Megusta e){
        int i = 0;
        
        int aux=0;
        
        boolean encontrado = false;
        while (i<megusta.size() && !encontrado){
            if(megusta.get(i).getEvento().getNombre().equalsIgnoreCase(e.getEvento().getNombre())){
                encontrado = true;
                aux = i;
                
            }
            i++;
        }
        
        megusta.remove(aux);
        
      
    }
    
    public void addMegusta(Megusta e){
        megusta.add(e);

    }
  
    public List<Megusta> mismegusta(){
        
        List<Megusta> lista = new ArrayList<Megusta>();
        int i=0;
        while(i< megusta.size()){
           if(megusta.get(i).getUsuario().getNombre().equals(ch.getUsuario().getNombre())){
               lista.add(megusta.get(i));
               
           } 
           i++;
        }
        return lista;
    }
    
    public void intercambiar(String password){
        
        ch.getUsuario().setPassword(password);
    }
    
    public void cambio(String correo){
        ch.getUsuario().setEmail(correo);
        
    }
    
}
