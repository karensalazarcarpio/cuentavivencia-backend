package bo.gob.senasir.cuentavivencia.repositories;

import bo.gob.senasir.cuentavivencia.model.CuentaVivencia;
import bo.gob.senasir.cuentavivencia.vo.CuentaVivenciaAux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KSalazar
 */
@Repository
public interface CuentaVivenciaRepository extends JpaRepository<CuentaVivencia, Long> {

    public CuentaVivenciaAux obtCuentaVivenciaPorPersona(
            @Param("idPersonaTitular") Long idPersonaTitular,
            @Param("idPersonaDH") Long idPersonaDH
    );
}
