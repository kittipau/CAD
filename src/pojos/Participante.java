/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.awt.Image;
import java.io.Serializable;

/**
 *
 * @author pulpracticas.VSTI
 */
public class Participante implements Serializable {
    private static final long serialVersionUID = 8799656478674716635L;
    private Integer participanteID;
    private String nombreDiseno;
    private String descripcionDiseno;
    private String nombreDisenador;
    private String pais;
    private byte[] imagenDisenador;
    private byte[] imagenDiseno;

    public Participante(String nombreDiseno, String descripcionDiseno, String nombreDisenador, String pais, byte[] imagenDisenador, byte[] imagenDiseno) {
        this.nombreDiseno = nombreDiseno;
        this.descripcionDiseno = descripcionDiseno;
        this.nombreDisenador = nombreDisenador;
        this.pais = pais;
        this.imagenDisenador = imagenDisenador;
        this.imagenDiseno = imagenDiseno;
    }

    public byte[] getImagenDisenador() {
        return this.imagenDisenador;
    }

    public void setImagenDisenador(byte[] imagenDisenador) {
        this.imagenDisenador = imagenDisenador;
    }

    public byte[] getImagenDiseno() {
        return this.imagenDiseno;
    }

    public void setImagenDiseno(byte[] imagenDiseno) {
        this.imagenDiseno = imagenDiseno;
    }

    public Participante() {
    }

    public Integer getParticipanteID() {
        return this.participanteID;
    }

    public void setParticipanteID(Integer participanteID) {
        this.participanteID = participanteID;
    }

    public String getNombreDiseno() {
        return this.nombreDiseno;
    }

    public void setNombreDiseno(String nombreDiseno) {
        this.nombreDiseno = nombreDiseno;
    }

    public String getDescripcionDiseno() {
        return this.descripcionDiseno;
    }

    public void setDescripcionDiseno(String descripcionDiseno) {
        this.descripcionDiseno = descripcionDiseno;
    }

    public String getNombreDisenador() {
        return this.nombreDisenador;
    }

    public void setNombreDisenador(String nombreDisenador) {
        this.nombreDisenador = nombreDisenador;
    }

    public String getPaisDisenador() {
        return this.pais;
    }

    public void setPaisDisenador(String pais) {
        this.pais = pais;
    }
}