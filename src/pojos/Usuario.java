/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.io.Serializable;

/**
 *
 * @author pulpracticas.VSTI
 */
public class Usuario implements Serializable{
    private Integer usuarioID;
    private String user;
    private String mail;
    private String contra;
    private Participante participante;

    public Usuario() {
    }

    public Usuario(Integer usuarioID, String user, String mail, String contra, Participante diseño) {
        this.usuarioID = usuarioID;
        this.user = user;
        this.mail = mail;
        this.contra = contra;
        this.participante = diseño;
    }

    public Integer getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Integer usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Participante getDiseño() {
        return participante;
    }

    public void setDiseño(Participante diseño) {
        this.participante = diseño;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuarioID=" + usuarioID + ", user=" + user + ", mail=" + mail + ", contra=" + contra + ", dise\u00f1o=" + participante + '}';
    }
    
    
   
    
}
