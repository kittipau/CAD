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
    private String adminPass;
    private String adminNombre;

    public Configuracion() {
    }

    public Configuracion(Integer configID, Date fechaLimita, String adminPass, String adminNombre) {
        this.configID = configID;
        this.fechaLimita = fechaLimita;
        this.adminPass = adminPass;
        this.adminNombre = adminNombre;
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

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    public String getAdminNombre() {
        return adminNombre;
    }

    public void setAdminNombre(String adminNombre) {
        this.adminNombre = adminNombre;
    }

    @Override
    public String toString() {
        return "Configuracion{" + "fechaLimita=" + fechaLimita + ", adminPass=" + adminPass + ", adminNombre=" + adminNombre + '}';
    }
    
}
