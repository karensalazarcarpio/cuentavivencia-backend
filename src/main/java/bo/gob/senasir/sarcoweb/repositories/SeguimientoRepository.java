/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.repositories;

import bo.gob.senasir.sarcoweb.model.Seguimiento;
import bo.gob.senasir.sarcoweb.vo.SeguimientoVo;
import bo.gob.senasir.sarcoweb.vo.ConvierteBaseVo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KSalazar
 */
@Repository
public interface SeguimientoRepository extends JpaRepository<Seguimiento, Long> {

    List<SeguimientoVo> obtSeguimientoPorHojaRuta(
            @Param("hojarutaSeleccionado") Integer hojarutaSeleccionado,
            @Param("gestionSeleccionado") Integer gestionSeleccionado
    );

    List<SeguimientoVo> obtSeguimientoPorCodigoSeguridad(
            @Param("codigoseguridadSeleccionado") String codigoseguridadSeleccionado,
            @Param("gestionSeleccionado") Integer gestionSeleccionado
    );

    ConvierteBaseVo convierteACodigoSeguridad(
            @Param("hojarutaSeleccionado") Integer hojarutaSeleccionado,
            @Param("gestionSeleccionado") Integer gestionSeleccionado
    );

}
