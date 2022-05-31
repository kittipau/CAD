/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author pulpracticas.VSTI
 */
public class Configuracion implements Serializable {
    private static final long serialVersionUID = 8799656478674716636L;
    private Integer configID;
    private Date fechaLimite;


    public Configuracion() {
    }

    public Configuracion(Integer configID, Date fechaLimite, String adminPass, String adminNombre) {
        this.configID = configID;
        this.fechaLimite = fechaLimite;

    }

    public Integer getConfigID() {
        return configID;
    }

    public void setConfigID(Integer configID) {
        this.configID = configID;
    }



    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }


    @Override
    public String toString() {
        return "Configuracion{" + "fechaLimita=" + fechaLimite+ "}";
    }
    
}
