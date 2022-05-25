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
    private static final long serialVersionUID = 8799656478674716638L; 

    private Integer participanteID;
    private String nombreDiseno;
    private String descripcionDiseno;
    private String nombreDisenador;
    private String desripcionDisenador;
    private Image imagenDisenador;
    private Image imagenDiseno;

    @Override
    public String toString() {
        return "Participante{" + "participanteID=" + participanteID + ", nombreDiseno=" + nombreDiseno + ", descripcionDiseno=" + descripcionDiseno + ", nombreDisenador=" + nombreDisenador + ", desripcionDisenador=" + desripcionDisenador + ", imagenDisenador=" + imagenDisenador + ", imagenDiseno=" + imagenDiseno + '}';
    }
    

    public Participante() {
    }
    

    public Integer getParticipanteID() {
        return participanteID;
    }

    public void setParticipanteID(Integer participanteID) {
        this.participanteID = participanteID;
    }

    public String getNombreDiseno() {
        return nombreDiseno;
    }

    public void setNombreDiseno(String nombreDiseno) {
        this.nombreDiseno = nombreDiseno;
    }

    public String getDescripcionDiseno() {
        return descripcionDiseno;
    }

    public void setDescripcionDiseno(String descripcionDiseno) {
        this.descripcionDiseno = descripcionDiseno;
    }

    public String getNombreDisenador() {
        return nombreDisenador;
    }

    public void setNombreDisenador(String nombreDisenador) {
        this.nombreDisenador = nombreDisenador;
    }

    public String getDesripcionDisenador() {
        return desripcionDisenador;
    }

    public void setDesripcionDisenador(String desripcionDisenador) {
        this.desripcionDisenador = desripcionDisenador;
    }

    public Image getImagenDisenador() {
        return imagenDisenador;
    }

    public void setImagenDisenador(Image imagenDisenador) {
        this.imagenDisenador = imagenDisenador;
    }

    public Image getImagenDiseno() {
        return imagenDiseno;
    }

    public void setImagenDiseno(Image imagenDiseno) {
        this.imagenDiseno = imagenDiseno;
    }
       
}
