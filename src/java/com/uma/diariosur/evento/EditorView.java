/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uma.diariosur.evento;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author Sergio
 */
@ManagedBean
public class EditorView {
     
    private String text;
     
 
    public String getText() {
        return text;
    }
 
    public void setText(String text) {
        this.text = text;
        
    }
 
    
}
