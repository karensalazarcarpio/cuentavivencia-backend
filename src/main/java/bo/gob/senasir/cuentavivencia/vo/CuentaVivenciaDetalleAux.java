package bo.gob.senasir.cuentavivencia.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author KSalazar
 */
@Entity
public class CuentaVivenciaDetalleAux implements Serializable {

    @Id
    @Column(name = "\"idCuentaVivenciaDet\"")
    private Long idCuentaVivenciaDet;
    @Column(name = "\"fechaRegistro\"")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private Date fechaRegistro;
    @Column(name = "\"fechaInicio\"")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date fechaInicio;
    @Column(name = "\"fechaFin\"")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date fechaFin;
    @Column(name = "\"descEstado\"")
    private String descEstado;

    public Long getIdCuentaVivenciaDet() {
        return idCuentaVivenciaDet;
    }

    public void setIdCuentaVivenciaDet(Long idCuentaVivenciaDet) {
        this.idCuentaVivenciaDet = idCuentaVivenciaDet;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescEstado() {
        return descEstado;
    }

    public void setDescEstado(String descEstado) {
        this.descEstado = descEstado;
    }

}
