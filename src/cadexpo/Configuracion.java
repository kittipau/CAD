/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadexpo;

import java.sql.Date;

/**
 *
 * @author pulpracticas.VSTI
 */
public class Configuracion {
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
