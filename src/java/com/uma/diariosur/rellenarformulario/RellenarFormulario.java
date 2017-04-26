/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uma.diariosur.rellenarformulario;

import BeanPrincipal.BeanPrincipal;
import com.uma.diariosur.modelo.Evento;
import com.uma.diariosur.modelo.Formulario;
import com.uma.diariosur.modelo.Imagen;
import com.uma.diariosur.modelo.Usuario;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
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
    
    
    private String aux_ext;
    private Usuario u;
    private String img_aux;
    
    @Inject
    private BeanPrincipal bn;
    
    
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
     
    private String sacar_ext(String s){
        
        int index = s.lastIndexOf('.');
            
        if (index == -1) {
                  return "";
            } else {
                  return s.substring(index + 1);
            }
        
    }
    
    public boolean save() throws IOException {
        
        boolean res = true;
        
        if(img.getFileName().isEmpty()) {
            res = false;
        }
        else{
            String ext = sacar_ext(img.getFileName());
            String aux2 = this.nombre.concat(".");
            String filename = aux2.concat(ext);
            img_aux = filename;
            InputStream input = img.getInputstream();
            OutputStream output = new FileOutputStream(new File("C:\\Users\\Carlos\\Documents\\NetBeansProjects\\DiarioSur-T2\\web\\resources", filename));
            aux_ext = ext;
        
        try {
            IOUtils.copy(input, output);
        } finally {
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(output);
        }
        }
        
        return res;
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
        
    }
    
    
    public String enviar() throws IOException{
     
        if(this.nombre.isEmpty()){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , "Por favor introduzca un nombre");
            FacesContext.getCurrentInstance().addMessage("myform:nombre", message);
            return null;
        }
         
         
        boolean encontrado = false;
        int i=0;
        
        while (i<bn.getEventos().size() && !encontrado){
            if (bn.getEventos().get(i).getNombre().equalsIgnoreCase(this.nombre)){
                encontrado = true;
            }
            i++;
        }
        
        if (encontrado){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , "El evento ya esta en el sistema");
            FacesContext.getCurrentInstance().addMessage("myform:nombre", message);
            return null;
        }
        else{
            
            if (this.nombre.isEmpty()|| this.descripcion.isEmpty() || this.categoria.isEmpty() || this.fecha_inicio==null || this.fecha_fin==null || this.ubicacion.isEmpty() || this.precio==null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Faltan atributos por introducir!"));
                return null;
            }
            
          
            if(!save()){
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","la imagen no se subio correctamente");
                FacesContext.getCurrentInstance().addMessage("myform:img", message);
                return null;
             }
                
                
                
//       /// Aqui iria comprobación de si es un usuario o un periodista
        
//       // SI ES UN USUARIO SE CREA UN FORMULARIO
                
                
                    System.out.print("OOOOOK");
                    
                    // Creacion de la imagen
                    
                    Imagen im = new Imagen();
                    im.setEnlace(img_aux);
                    im.setTipo(aux_ext);
                    
                   
                    Formulario form = new Formulario();
                    form.setNombre(nombre);
                    form.setDescripcion(descripcion);
                    form.setCategoria(categoria);
                    form.setUbicacion(ubicacion);
                    form.setPrecio(precio);
                    form.setFecha_inicio(fecha_inicio);
                    form.setFecha_fin(fecha_fin);
                    form.setUsuario(u);
                    form.setEstado("pendiente");
                    form.setFecha_subida(new Date());
                    form.setImg(im);
                    
                    
                    Evento ev = new Evento(nombre, descripcion, categoria, fecha_inicio, fecha_fin, precio, ubicacion,im);
                    
                    im.setEvento(ev);
                    
                    im.setF(form);
                    form.setImg(im);
                    ev.setImagen(im);
                    
                    bn.addForm(form);
                    
                    bn.addImage(im);
                    bn.addEvent(ev);
                    
                    System.out.print("Longitud de Array Principal eventos" + bn.getEventos().size());
                    System.out.print("Longitud de Array Principal formularios" + bn.getFormularios().size());
                    return "formularios.xhtml";
        }
    }
   
     public String comprobar(){
         
        if(this.nombre.isEmpty()){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , "Por favor introduzca un nombre");
            FacesContext.getCurrentInstance().addMessage("myform:nombre", message);
            return null;
        }
         
         
        boolean encontrado = false;
        int i=0;
        
        while (i<bn.getEventos().size() && !encontrado){
            if (bn.getEventos().get(i).getNombre().equalsIgnoreCase(this.nombre)){
                encontrado = true;
            }
            i++;
        }
        
        if (encontrado){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , "El evento ya esta en el sistema");
            FacesContext.getCurrentInstance().addMessage("myform:nombre", message);
            return null;
        }
        else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "" , "El evento no esta en el sistema");
            FacesContext.getCurrentInstance().addMessage("myform:nombre", message);
            return null;
        }
        
     }
     
    public String home() {
        return "PaginaHome.xhtml";
    }
    
}
