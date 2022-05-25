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
    private static final long serialVersionUID = 8799656478674716638L;
    private Integer configID;
    private Date fechaLimita;


    public Configuracion() {
    }

    public Configuracion(Integer configID, Date fechaLimita, String adminPass, String adminNombre) {
        this.configID = configID;
        this.fechaLimita = fechaLimita;

    }

    public Integer getConfigID() {
        return configID;
    }

    public void setConfigID(Integer configID) {
        this.configID = configID;
    }



    public Date getFechaLimita() {
        return fechaLimita;
    }

    public void setFechaLimita(Date fechaLimita) {
        this.fechaLimita = fechaLimita;
    }


    @Override
    public String toString() {
        return "Configuracion{" + "fechaLimita=" + fechaLimita+ "}";
    }
    
}
