/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.repositories;

import bo.gob.senasir.sarcoweb.model.Detalleclasificador;
import bo.gob.senasir.sarcoweb.model.DetalleclasificadorVo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author KSalazar
 */
@Repository
public interface DetalleclasificadorRepository extends JpaRepository<Detalleclasificador, Long> {

    List<DetalleclasificadorVo> obtDetallePorClasificador(
            @Param("idClasificador") Long idClasificador);

    List<DetalleclasificadorVo> obtDetalleClasificadorPorPadre(
            @Param("idPadre") Long idPadre);

}
