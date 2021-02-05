/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.services.impl;

import bo.gob.senasir.sarcoweb.constantes.DetalleClasificadorConstantes;
import static bo.gob.senasir.sarcoweb.constantes.DetalleClasificadorConstantes.ID_AREA_SEGUIMIENTO_CORRESPONDENCIA;
import static bo.gob.senasir.sarcoweb.constantes.DetalleClasificadorConstantes.ID_AREA_SEGUIMIENTO_FISCALIZACION;
import bo.gob.senasir.sarcoweb.model.Detalleclasificador;
import bo.gob.senasir.sarcoweb.model.Documento;
import bo.gob.senasir.sarcoweb.model.Seguimiento;
import bo.gob.senasir.sarcoweb.repositories.SeguimientoRepository;
import bo.gob.senasir.sarcoweb.services.SeguimientoService;
import bo.gob.senasir.sarcoweb.vo.SarcoWebVo;
import bo.gob.senasir.sarcoweb.vo.ConvierteBaseVo;
import bo.gob.senasir.sarcoweb.vo.SeguimientoVo;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author KAREN
 */
@Service("seguimientoService")
@Transactional(readOnly = true)
public class SeguimientoServiceImpl implements SeguimientoService {

    @Autowired
    private SeguimientoRepository seguimientoRepository;

    @Transactional
    public void guardarSeguimiento(SarcoWebVo sarcoWebVo) {
        String descripcionHojaRuta;
        Seguimiento seguimiento = new Seguimiento();
        seguimiento.setMensaje("Registrado por la aplicacion SarcoWeb.");
        seguimiento.setFechaingreso(new Date());
        seguimiento.setFecharegistro(new Date());
        //seguimiento.setIdarea(new Detalleclasificador(sarcoWebVo.getIdDestinatario()));
        
        if(sarcoWebVo.getIdDestinatario()== 1){
            seguimiento.setIdarea(new Detalleclasificador(ID_AREA_SEGUIMIENTO_CORRESPONDENCIA));
        } else if(sarcoWebVo.getIdDestinatario()== 2){
            seguimiento.setIdarea(new Detalleclasificador(ID_AREA_SEGUIMIENTO_FISCALIZACION));
        }
        seguimiento.setIddocumento(new Documento(sarcoWebVo.getIdDocumento()));
        seguimiento.setIdestado(new Detalleclasificador(DetalleClasificadorConstantes.ID_ESTADO_SEGUIMIENTO_REGISTRADO));
        seguimiento.setRegistroactivo(1);
        descripcionHojaRuta = sarcoWebVo.getCite() + "|" + sarcoWebVo.getInteresadoRemitente() + "|" + sarcoWebVo.getReferencia();
        seguimiento.setDescripcionhojaruta(descripcionHojaRuta);
        this.seguimientoRepository.save(seguimiento);
    }

    public List<SeguimientoVo> obtSeguimientoPorHojaRuta(Integer hojarutaSeleccionado, Integer gestionSeleccionado) {

        ConvierteBaseVo codigoEncriptado = this.convierteACodigoSeguridad(
                hojarutaSeleccionado, gestionSeleccionado);
        return seguimientoRepository.obtSeguimientoPorCodigoSeguridad(codigoEncriptado.getCodigoSeguridad(), gestionSeleccionado);

    }

    public List<SeguimientoVo> obtSeguimientoPorCodigoSeguridad(String codigoseguridadSeleccionado, Integer gestionSeleccionado) {
        return seguimientoRepository.obtSeguimientoPorCodigoSeguridad(codigoseguridadSeleccionado, gestionSeleccionado);

    }

    public ConvierteBaseVo convierteACodigoSeguridad(Integer hojarutaSeleccionado, Integer gestionSeleccionado) {
        return seguimientoRepository.convierteACodigoSeguridad(hojarutaSeleccionado, gestionSeleccionado);
    }

}
