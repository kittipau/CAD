/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadmuseo;

/**
 *
 * @author pulpracticas.VSTI
 */
public class Usuario {
    private Integer usuarioID;
    private String user;
    private String mail;
    private String contra;
    private Diseno diseño;

    public Usuario() {
    }

    public Usuario(Integer usuarioID, String user, String mail, String contra, Diseno diseño) {
        this.usuarioID = usuarioID;
        this.user = user;
        this.mail = mail;
        this.contra = contra;
        this.diseño = diseño;
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

    public Diseno getDiseño() {
        return diseño;
    }

    public void setDiseño(Diseno diseño) {
        this.diseño = diseño;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuarioID=" + usuarioID + ", user=" + user + ", mail=" + mail + ", contra=" + contra + ", dise\u00f1o=" + diseño + '}';
    }
    
    
   
    
}
