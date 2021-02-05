/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.services;

import bo.gob.senasir.sarcoweb.vo.ConvierteBaseVo;
import bo.gob.senasir.sarcoweb.vo.SarcoWebVo;
import bo.gob.senasir.sarcoweb.vo.SeguimientoVo;
import java.util.List;

/**
 *
 * @author KAREN
 */
public interface SeguimientoService {

    public void guardarSeguimiento(SarcoWebVo sarcoWebVo);
    public List<SeguimientoVo> obtSeguimientoPorHojaRuta (Integer hojarutaSeleccionado, Integer gestionSeleccionado);
    public List<SeguimientoVo> obtSeguimientoPorCodigoSeguridad (String codigoseguridadSeleccionado, Integer gestionSeleccionado);
    public ConvierteBaseVo convierteACodigoSeguridad (Integer hojarutaSeleccionado, Integer gestionSeleccionado);
}
