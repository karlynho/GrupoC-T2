/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uma.diariosur.rellenarformulario;

import com.uma.diariosur.modelo.Imagen;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
/**
 *
 * @author Carlos
 */
@Named(value = "rellenarFormulario")
@RequestScoped
public class RellenarFormulario {

    private String nombre;
    private String categoria;
    private String descripcion;
    private String hora_inicio;
    private Integer dia_inicio;
    private Integer dia_fin;
    private Integer hora_fin;
    private String mes_inicio;
    private String mes_fin;
    private Integer anio;
    private Imagen img;
    private String ubicacion;
    private Double precio;
    
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

    public Integer getDia_inicio() {
        return dia_inicio;
    }

    public Integer getDia_fin() {
        return dia_fin;
    }

    public String getMes_fin() {
        return mes_fin;
    }

    public void setMes_fin(String mes_fin) {
        this.mes_fin = mes_fin;
    }

    public void setDia_fin(Integer dia_fin) {
        this.dia_fin = dia_fin;
    }

    public Integer getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Integer hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    
    public void setDia_inicio(Integer dia_inicio) {
        this.dia_inicio = dia_inicio;
    }

    public String getMes_inicio() {
        return mes_inicio;
    }

    public void setMes_inicio(String mes_inicio) {
        this.mes_inicio = mes_inicio;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    

    public Imagen getImg() {
        return img;
    }

    public void setImg(Imagen img) {
        this.img = img;
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
     */
    public RellenarFormulario() {
    }
    
    
    public String enviar(){
        return null;
    }
}
