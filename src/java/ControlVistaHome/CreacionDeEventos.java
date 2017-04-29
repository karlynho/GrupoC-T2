/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlVistaHome;

import com.uma.diariosur.modelo.Evento;
import com.uma.diariosur.modelo.Usuario;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;




/**
 *
 * @author steven
 */
@Named(value = "creacionDeEventos")
@SessionScoped
public class CreacionDeEventos implements Serializable{
    private List<Evento>eventos;
    private int dia;
    private int mes;
    private int año;
    private List<Usuario> usuarios;

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    public List<Evento> crearEventos() throws ParseException{
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = (Date)formatter.parse("12/05/2017");
        
        eventos = new ArrayList<Evento>();
        eventos.add(new Evento("Red Hot Chili Peppers","coachella","Musical",date, date, 210.00, "Malaga"));
        eventos.add(new Evento("Uni vs RMB","baloncesto","Deportivo",date, date, 210.00, "Malaga"));
        eventos.add(new Evento("Offspring","concierto","Musical",date,date, 210.00, "Malaga"));
        
        return eventos;
    }
    
    public List<Usuario> listaUsuario() throws ParseException{
         DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = (Date)formatter.parse("12/05/2017");
        
         usuarios = new ArrayList<>();
        Usuario user = new Usuario();
        user.setNombre("Carlos");
        user.setApellidos("Moreno");
        user.setEmail("carlos_@hotmail.com");
        user.setNick("Karlynho");
        user.setFecha_nacimiento(date);
        user.setPassword("1234");
        usuarios.add(user);
        
        return usuarios;
    }
    
    /**
     * Creates a new instance of CreacionDeEventos
     */
    public CreacionDeEventos() {
    }
    
}
