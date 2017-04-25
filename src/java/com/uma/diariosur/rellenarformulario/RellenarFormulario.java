/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uma.diariosur.rellenarformulario;

import com.uma.diariosur.modelo.Evento;
import com.uma.diariosur.modelo.Formulario;
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
            FacesContext.getCurrentInstance().addMessage("myform:img", message);
            try {
                save();
            } catch (IOException ex) {
                Logger.getLogger(RellenarFormulario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private String sacar_ext(String s){
        
        int index = s.lastIndexOf('.');
            
        if (index == -1) {
                  return "";
            } else {
                  return s.substring(index + 1);
            }
        
    }
    
    public void save() throws IOException {
        String ext = sacar_ext(img.getFileName());
        String aux2 = this.nombre.concat(".");
        String filename = aux2.concat(ext);
        InputStream input = img.getInputstream();
        OutputStream output = new FileOutputStream(new File("C:\\Users\\Carlos\\Desktop\\Informatica", filename));

        try {
            IOUtils.copy(input, output);
        } finally {
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(output);
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
     
        if(this.nombre.isEmpty()){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , "Por favor introduzca un nombre");
            FacesContext.getCurrentInstance().addMessage("myform:nombre", message);
            return null;
        }
         
         
        boolean encontrado = false;
        int i=0;
        
        while (i<eventos.size() && !encontrado){
            if (eventos.get(i).getNombre().equalsIgnoreCase(this.nombre)){
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
            
            if (this.nombre.isEmpty()|| this.descripcion.isEmpty() || this.categoria.isEmpty() || this.fecha_inicio==null || this.fecha_fin==null || this.ubicacion.isEmpty() || this.precio==null || this.img.getFileName().isEmpty()){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Faltan atributos por introducir!"));
                return "rellenar_formulario.xhtml";
            }
        
        
//       /// Aqui iria comprobación de si es un usuario o un periodista
        
//       // SI ES UN USUARIO SE CREA UN FORMULARIO

            else{
                System.out.print("OOOOOK");
                Formulario form = new Formulario(nombre,descripcion,categoria,fecha_inicio,fecha_fin,ubicacion,precio,"pendiente",new Date(),u);
                // Evento ev = new Evento(nombre, descripcion, categoria, fecha_inicio, fecha_fin, precio, ubicacion);
                return "PaginaHome.xhtml";
            }
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
        
        while (i<eventos.size() && !encontrado){
            if (eventos.get(i).getNombre().equalsIgnoreCase(this.nombre)){
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
