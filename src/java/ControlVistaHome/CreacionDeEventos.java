
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlVistaHome;

import BeanPrincipal.BeanPrincipal;
import com.uma.diariosur.modelo.Evento;
import com.uma.diariosur.modelo.Valoracion;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import javax.inject.Named;

/**
 *
 * @author steven
 */
@Named(value = "creacionDeEventos")
@ViewScoped


public class CreacionDeEventos implements Serializable {

    private List<Evento> eventos;
    private List<Evento> eventosFiltrados;
    private Date fechaVacia;

    public Date getFechaVacia() {
        return fechaVacia;
    }

    public void setFechaVacia(Date fechaVacia) {
        this.fechaVacia = fechaVacia;
    }

    @Inject
    BeanPrincipal bnp;
    @Inject
    ControlHome ctrlhome;


    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public String comprobacion(String evento, String ubicacion, String categoria, Date fecha) throws ParseException {

        eventos = new ArrayList<>();

        eventos = bnp.getEventos();
        eventosFiltrados = new ArrayList<Evento>();

        boolean encontrado = false;
        int tam = eventos.size();
        int i = 0;
        int valor = 0;
        int dia = 0;
        int mes = 0;
        int año=0;
        
        if(fecha==null){
            valor =1;
                    
        } else{
             dia = fecha.getDay();
             mes = fecha.getMonth();
             año = fecha.getYear();
        }

        
        
        
        while (i < tam && !encontrado) {
            if (eventos.get(i).getNombre().equalsIgnoreCase(evento) && evento != null) {
                System.out.println("Se ha recogido el nombre");
                //El nombre coincide con uno o muchos eventos, lo añadimos al la lista de filtrados
                eventosFiltrados.add(eventos.get(i));
                encontrado = true;
            } else if (eventos.get(i).getUbicacion().equalsIgnoreCase(ubicacion) || (eventos.get(i).getUbicacion().toUpperCase().contains(ubicacion.toUpperCase()))) {
                System.out.println("No ha recogido el nombre");
                //La ubicacion coincide,  comprobamos la categoria
                if (eventos.get(i).getCategoria().equalsIgnoreCase(categoria)) {
                    //La categoria coincide, comprobamos la fecha
                    if (eventos.get(i).getFecha_inicio().getDay()==dia && eventos.get(i).getFecha_inicio().getMonth()==mes && 
                            eventos.get(i).getFecha_inicio().getYear()==año && valor==0) {
                        //Coinciden las tres condiciones del filtro, entonces añadimos a la lista de filtrados
                        eventosFiltrados.add(eventos.get(i));

                    }
                }

            }

            i++;
        }

        if (eventosFiltrados.isEmpty()) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error" , "No hay coincidencias con el filtro");
            FacesContext.getCurrentInstance().addMessage("controlHome:principal", message);
            return null;
        } else {
            System.out.println("Si hay filtro");
            bnp.setEventosFiltrados(eventosFiltrados);
            return "PaginaHome.xhtml";
        }

    }
    

    /*
    public String comprobacion2(String evento, String ubicacion, String categoria, Date fecha) throws ParseException {

        eventos = new ArrayList<>();
        eventos = bnp.getEventos();
        eventosFiltrados = new ArrayList<Evento>();
      

        boolean encontrado = false;
        int tam = eventos.size();
        int i = 0;

        if (ubicacion.equalsIgnoreCase(" ") && categoria.equalsIgnoreCase(" ") && fecha != null) {
            while (i < tam) {

                if (eventos.get(i).getFecha_inicio().equals(fecha)) {
                    System.out.println("Entra en filtrar fecha");
                    //Coinciden las tres condiciones del filtro, entonces añadimos a la lista de filtrados
                    eventosFiltrados.add(eventos.get(i));
                }
                i++;
            }

        } else if (ubicacion.equalsIgnoreCase(" ") && !categoria.equalsIgnoreCase(" ") && fecha==null) {
            while (i < tam) {
                System.out.println("Entra en filtrar categoria: "+categoria+ eventos.get(i).getCategoria());
                if (eventos.get(i).getCategoria().equalsIgnoreCase(categoria)) {
                    System.out.println(eventos.get(i).getCategoria()+" Es igual"+ categoria);
                    eventosFiltrados.add(eventos.get(i));
                }
                i++;
            }
        } else if (!ubicacion.equalsIgnoreCase(" ") && categoria.equalsIgnoreCase(" ") && fecha == null) {
            while (i < tam) {
                if (eventos.get(i).getUbicacion().equalsIgnoreCase(ubicacion)) {
                    eventosFiltrados.add(eventos.get(i));
                }

                i++;
            }

        } else if (!ubicacion.equalsIgnoreCase(" ") && categoria.equalsIgnoreCase(" ") && fecha != null) {
            while (i < tam) {
                if (eventos.get(i).getUbicacion().equalsIgnoreCase(ubicacion)) {
                    if (eventos.get(i).getFecha_inicio().equals(fecha)) {
                        eventosFiltrados.add(eventos.get(i));
                    }
                }
                i++;
            }
        } else if (!ubicacion.equalsIgnoreCase(" ") && !categoria.equalsIgnoreCase(" ") && fecha == null) {
            while (i < tam) {

                if (eventos.get(i).getUbicacion().equalsIgnoreCase(ubicacion)) {
                    if (eventos.get(i).getCategoria().equals(categoria)) {
                        eventosFiltrados.add(eventos.get(i));

                    }
                }

                i++;
            }
        } else if (ubicacion.equalsIgnoreCase(" ") && !categoria.equalsIgnoreCase(" ") && fecha != null) {
            while (i < tam) {
                if (eventos.get(i).getUbicacion().equalsIgnoreCase(categoria)) {
                    if (eventos.get(i).getFecha_inicio().equals(fecha)) {
                        eventosFiltrados.add(eventos.get(i));
                    }
                }

                i++;
            }

        } else if (!ubicacion.equalsIgnoreCase(" ") && !categoria.equalsIgnoreCase(" ") && fecha != null) {
            while (i < tam) {
                if (eventos.get(i).getUbicacion().equalsIgnoreCase(ubicacion)) {
                    if (eventos.get(i).getCategoria().equals(categoria)) {
                        if (eventos.get(i).getFecha_inicio().equals(fecha)) {
                            eventosFiltrados.add(eventos.get(i));
                        }
                    }
                }

                i++;
            }

        }
    
        if (eventosFiltrados.isEmpty()) {
            System.out.println("No hay filtro");
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error No hay coincidencias", "Error no hay coincidencias"));
            return null;
        } else {
            System.out.println("Si hay filtro");
            bnp.setEventosFiltrados(eventosFiltrados);
            System.out.println("Eventos que hay en filtrados : "+ eventosFiltrados.toString());
            return "PaginaHome.xhtml";
        }

        
    }

    
    

    */


    /**
     * Creates a new instance of CreacionDeEventos
     */
    public CreacionDeEventos() {
    }


}


