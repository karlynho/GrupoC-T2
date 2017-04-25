/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlVistaHome;


import com.uma.diariosur.modelo.Usuario;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author steven
 */
@Named(value = "login")
@RequestScoped
public class Login {

    private String usuario;
    private String contrasenia;
    private List<Usuario> usuarios;
    
    
    //@Inject 
   // private ControlHome ctrhome;
   // private BeanPrincipal bnp;
    
    
    /**
     * Creates a new instance of Login
     */
    public Login() {
    }
    
}
