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
    
  
    @Inject
    BeanPrincipal bnp;
    
    public String registrarUsuario(){
        usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellidos("Velazquez");
        usuario.setPassword(contraseña);
        usuario.setNick("karlynho");
        usuario.setEmail("carlospuli@gmail,com");
        
        bnp.añadirUsuario(usuario);
        return "Login.xhtml";
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
