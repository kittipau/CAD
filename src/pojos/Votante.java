/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

/**
 *
 * @author pulpracticas.VSTI
 */
public class Votante {

    private static final long serialVersionUID = 8799656478674716631L;
    private Integer votanteID;
    private String nombre;
    private String apellido;
    private String mail;
    private Participante participante;

    public Integer getVotanteID() {
        return votanteID;
    }

    public void setVotanteID(Integer votanteID) {
        this.votanteID = votanteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    @Override
    public String toString() {
        return "Votante{" + "votanteID=" + votanteID + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", participante=" + participante + '}';
    }

    public Votante() {
    }

}
