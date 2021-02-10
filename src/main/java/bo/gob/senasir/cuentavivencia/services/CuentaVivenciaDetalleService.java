/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.cuentavivencia.services;

import bo.gob.senasir.cuentavivencia.vo.CuentaVivenciaDetalleAux;
import bo.gob.senasir.cuentavivencia.vo.CuentaVivenciaVo;
import java.util.List;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;

/**
 *
 * @author KSalazar
 */
public interface CuentaVivenciaDetalleService {

    public void guardarCuentaVivenciaDetalles(CuentaVivenciaVo cuentaVivenciaVo, FormDataBodyPart selphi, FormDataBodyPart video);

    public List<CuentaVivenciaDetalleAux> obtRegistrosPorCuentaVivencia(Long idCuentaVivencia);
}
