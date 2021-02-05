/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.services;

import bo.gob.senasir.sarcoweb.vo.SarcoWebVo;

/**
 *
 * @author KSalazar
 */
public interface ReferenciaRemitenteService {

    public Long guardarReferenciaRemitente(SarcoWebVo sarcoWebVo);
    public String obtenerInteresadoRemitente(SarcoWebVo sarcoWebVo);
}
