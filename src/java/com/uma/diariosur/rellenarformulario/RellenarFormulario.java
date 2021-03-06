/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uma.diariosur.rellenarformulario;

import BeanPrincipal.BeanPrincipal;
import ControlVistaHome.ControlHome;
import com.uma.diariosur.modelo.Evento;
import com.uma.diariosur.modelo.Formulario;
import com.uma.diariosur.modelo.Imagen;
import com.uma.diariosur.modelo.Usuario;
import com.uma.diariosur.modelo.Valoracion;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.text.SimpleDateFormat;
import com.uma.diariosur.modelo.Megusta;
import java.util.List;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
/**
 *
 * @author Carlos
 */
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
    
    @Inject 
    private ControlHome ctrlhome;

    public ControlHome getCtrlhome() {
        return ctrlhome;
    }

    public void setCtrlhome(ControlHome ctrlhome) {
        this.ctrlhome = ctrlhome;
    }

    public BeanPrincipal getBn() {
        return bn;
    }

    public void setBn(BeanPrincipal bn) {
        this.bn = bn;
    }
    private String aux_ext;
    private String img_aux;
    
    @Inject
    private BeanPrincipal bn;
    
    
    public UploadedFile getImg() {
        return img;
    }

    public void setImg(UploadedFile img) {
        this.img = img;
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

            
            String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
            String path_aux = path.substring(0, path.lastIndexOf("build"));
            
            

            OutputStream output = new FileOutputStream(new File(path_aux.concat("web//resources"), filename));
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
    
 
    public RellenarFormulario()  {
        
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
            
            if(this.fecha_inicio.after(fecha_fin)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Introduzca fechas de inicio y fin reales (fecha inicio antes que fecha fin!!"));
                return null;
            }
            
            if(!save()){
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","la imagen no se subio correctamente");
                FacesContext.getCurrentInstance().addMessage("myform:img", message);
                return null;
             }
                
             
                    // Creacion de la imagen
                    
                    Imagen im = new Imagen();
                    im.setEnlace(img_aux);
                    im.setTipo(aux_ext);
                    
                   
                    if(ctrlhome.getUsuario()!=null){
                        Formulario form = new Formulario();
                        form.setNombre(nombre);
                        form.setDescripcion(descripcion);
                        form.setCategoria(categoria);
                        form.setUbicacion(ubicacion);
                        form.setPrecio(precio);
                        form.setFecha_inicio(fecha_inicio);
                        form.setFecha_fin(fecha_fin);
                        form.setUsuario(ctrlhome.getUsuario());
                        form.setEstado("pendiente");
                        form.setFecha_subida(new Date());
                        form.setImg(im);
                        im.setF(form);
                        form.setImg(im);
                        bn.addForm(form);
                    }
                    
                    if(ctrlhome.getPeriodista()!=null){
                        Evento ev = new Evento(nombre, descripcion, categoria, fecha_inicio, fecha_fin, precio, ubicacion,im,ctrlhome.getPeriodista());
                        List<Valoracion> v_vacia = new ArrayList();
                        im.setEvento(ev);
                        List<Megusta> m_gusta = new ArrayList();
                        ev.setMeGusta(m_gusta);
                        ev.setImagen(im);
                        ev.setValoraciones(v_vacia);
                        bn.addEvent(ev);
                    }
                    
                    bn.addImage(im);
           
                return "PaginaHome.xhtml";
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
