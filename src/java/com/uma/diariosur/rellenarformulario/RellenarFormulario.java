/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uma.diariosur.rellenarformulario;

import com.uma.diariosur.modelo.Evento;
import com.uma.diariosur.modelo.Formulario;
import com.uma.diariosur.modelo.Usuario;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author Carlos
 */
@ManagedBean
@Named(value = "rellenarFormulario")
@RequestScoped
public class RellenarFormulario implements Serializable{

    private String nombre;
    private String categoria;
    private String descripcion;
    private Date fecha_inicio;
    private Date fecha_fin;
    private UploadedFile img;
    private String ubicacion;
    private Double precio;
    
    private List<Evento> eventos;
    private Usuario u;
    
    
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
    
    public UploadedFile getImg() {
        return img;
    }

    public void setImg(UploadedFile img) {
        this.img = img;
    }
    
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
    
    
    public void upload() {
        if(img != null) {
            FacesMessage message = new FacesMessage("Succesful", img.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
     public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    /**
     * Creates a new instance of RellenarFormulario
     * @throws java.text.ParseException
     */
    public RellenarFormulario() throws ParseException {
        
        eventos = new ArrayList<>();
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date date = (Date)formatter.parse("05/15/11");
        Evento e1 = new Evento();
        e1.setNombre("Starlite");
        e1.setDescripcion("pijos");
        e1.setCategoria("conciertos");
        e1.setFecha_final(date);
        e1.setFecha_inicio(date);
        e1.setUbicacion("la mina");
        e1.setPrecio(20.99);
        
        eventos.add(e1);
    }
    
    
    public String enviar(){
        
        upload();
        
        if (nombre==null || descripcion==null || categoria==null || fecha_inicio==null || fecha_fin==null || ubicacion==null || precio==null || img == null){
            System.err.print("error");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Faltan atributos por introducir!"));
            return "rellenar_formulario.xhtml";
        }
        
        
//       /// Aqui iria comprobación de si es un usuario o un periodista
        
//       // SI ES UN USUARIO SE CREA UN FORMULARIO

        
         Formulario form = new Formulario(nombre,descripcion,categoria,fecha_inicio,fecha_fin,ubicacion,precio,"pendiente",new Date(),u);
         // Evento ev = new Evento(nombre, descripcion, categoria, fecha_inicio, fecha_fin, precio, ubicacion);
         return "PaginaHome.xhtml";
        
        
    }
   
     public String comprobar(){
         
        boolean encontrado = false;
        int i=0;
        System.out.print(eventos.size());
        while (i<eventos.size() && !encontrado){
            if (eventos.get(i).getNombre().equalsIgnoreCase(this.nombre)){
                encontrado = true;
            }
            i++;
        }
        
        if (encontrado){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , "El evento ya esta en el sistema");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }
        else{
            return "rellenar_formulario.xhtml";
        }
        
     }
     
    public String home() {
        return "PaginaHome.xhtml";
    }
    
}
