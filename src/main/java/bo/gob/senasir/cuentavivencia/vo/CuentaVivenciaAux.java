package bo.gob.senasir.cuentavivencia.vo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author KSalazar
 */
@Entity
public class CuentaVivenciaAux implements Serializable {

    @Id
    @Column(name = "\"idCuentaVivencia\"")
    private Long idCuentaVivencia;

    public Long getIdCuentaVivencia() {
        return idCuentaVivencia;
    }

    public void setIdCuentaVivencia(Long idCuentaVivencia) {
        this.idCuentaVivencia = idCuentaVivencia;
    }

}
