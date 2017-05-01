/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensaje;

import ControlVistaHome.ControlHome;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Carmen
 */
@Named(value = "email")
@SessionScoped
public class Email implements Serializable{
    
    @Inject
    private ControlHome ch;
    
    public void mandarCorreo() throws UnsupportedEncodingException, MessagingException
    {
        String correoEnvia = "cbelenmg.6@gmail.com";
        String claveCorreo = "etsiinformatica6";
        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.user", correoEnvia);
        prop.put("mail.password", claveCorreo);
        
        Session ses = Session.getInstance(prop, null);
        
        try{
            
            MimeMessage mime = new MimeMessage(ses);
            
            mime.setFrom(new InternetAddress(correoEnvia, "Dato Java"));
            
            InternetAddress internetAddresses = new InternetAddress(ch.getUsuario().getEmail());
            mime.setRecipient(Message.RecipientType.TO, internetAddresses);
            
            mime.setSubject("Dato Java enviando correo");
            
            MimeBodyPart mib = new MimeBodyPart();
            mib.setText("Siguiendo el Tutorial");
            
            Multipart multi = new MimeMultipart();
            multi.addBodyPart(mib);
            
            mime.setContent(multi);
            
            Transport transport = ses.getTransport("smtp");
            transport.connect(correoEnvia, claveCorreo);
            transport.sendMessage(mime, mime.getAllRecipients());
            transport.close();
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    
    /**
     * Creates a new instance of Email
     */
    public Email() {
    }
    
}
