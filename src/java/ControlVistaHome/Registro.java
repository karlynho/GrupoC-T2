/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlVistaHome;


import BeanPrincipal.BeanPrincipal;

import com.uma.diariosur.modelo.Usuario;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author francis
 */
@Named(value = "registro")
@RequestScoped
public class Registro {
    private Usuario usuario;
    private String contraseña;
    private String nombre;
    private String apellidos;
    private String Nick;
    private String email;
    private String repas;
    
    private Pattern pattern;
    
    public String getRepas() {
        return repas;
    }

    public void setRepas(String repas) {
        this.repas = repas;
    }

  
  
    @Inject
    BeanPrincipal bnp;
    
    public String registrarUsuario(){
         usuario = new Usuario();
         System.out.println("Entra en funcion");
        if(this.nombre.isEmpty()){
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" ,"El campo nombre no puede estar vacio");
             FacesContext.getCurrentInstance().addMessage("registro:nombre", message);
             return null;
        }else{
            usuario.setNombre(nombre);
        }
        
        if(this.apellidos.isEmpty()){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" ,"El campo apellido no puede estar vacio");
            FacesContext.getCurrentInstance().addMessage("registro:apellidos", message);
            return null;
        }else{
            usuario.setApellidos(apellidos);
        }
        
        if(this.email.isEmpty()){
           FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , "El email no puede estar vacio");
           FacesContext.getCurrentInstance().addMessage("registro:email", message);
           return null;
       }else{
            pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
           Matcher mather = pattern.matcher(email);
           if (mather.find() == true) {
              usuario.setEmail(email);
           } else {
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , "El email no tiene la estructura adecuada");
             FacesContext.getCurrentInstance().addMessage("registro:email", message);
             return null;
            }
       }
        
        
        if(this.Nick.isEmpty()){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" ,"El campo Nombre de Usuario no puede estar vacio");
            FacesContext.getCurrentInstance().addMessage("registro:nick", message);
            return null;
        }else{
            usuario.setNick(Nick);
        }
         
        if(this.contraseña.isEmpty()){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , "La contraseña no puede estar vacia");
            FacesContext.getCurrentInstance().addMessage("registro:pass", message);
            return null;
        }else if(this.repas.isEmpty()){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , "Debe repetir la contraseña");
            FacesContext.getCurrentInstance().addMessage("registro:repass", message);
            return null;
        }else if(this.contraseña.equals(this.repas)){
               usuario.setPassword(contraseña);
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , "Las contraseña no coinciden");
            FacesContext.getCurrentInstance().addMessage("registro:repass", message);
            return null;       
               
            }
               
            bnp.añadirUsuario(usuario);
             return "Login.xhtml";   
        }
        
       
       
    

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNick() {
        return Nick;
    }

    public void setNick(String Nick) {
        this.Nick = Nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    public String login(){
        return "Login.xhtml";
    }
    
    public Usuario getUsusario() {
        return usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public BeanPrincipal getBnp() {
        return bnp;
    }

    public void setBnp(BeanPrincipal bnp) {
        this.bnp = bnp;
    }

 

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    


    

}
