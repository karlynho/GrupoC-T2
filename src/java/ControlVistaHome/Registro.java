/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlVistaHome;


import BeanPrincipal.BeanPrincipal;

import com.uma.diariosur.modelo.Usuario;
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
         
        if(nombre.isEmpty() && apellidos.isEmpty() && Nick.isEmpty()){
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , "Los campos nombre, apellidos y Nick  deben estar rellenados");
             FacesContext.getCurrentInstance().addMessage("nombre:principal", message);
            
        }else{
            usuario.setNombre(nombre);
            usuario.setApellidos(apellidos);
        }
        
        if(!contraseña.equalsIgnoreCase(repas)){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , "Las contraseñas no coinciden");
            FacesContext.getCurrentInstance().addMessage("apellidos:principal", message);
        }else{
            usuario.setPassword(contraseña);
        }
        
       
       
       
  
        
        usuario.setEmail(email);
        
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
