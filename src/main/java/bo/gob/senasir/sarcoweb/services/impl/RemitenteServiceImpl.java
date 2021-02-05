/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.services.impl;

import bo.gob.senasir.sarcoweb.model.Referenciaremitente;
import bo.gob.senasir.sarcoweb.model.Remitente;
import bo.gob.senasir.sarcoweb.services.RemitenteService;
import bo.gob.senasir.sarcoweb.repositories.RemitenteRepository;
import bo.gob.senasir.sarcoweb.vo.SarcoWebVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author KAREN
 */
@Service("remitenteService")
@Transactional(readOnly = true)
public class RemitenteServiceImpl implements RemitenteService {
    
    @Autowired
    private RemitenteRepository remitenteRepository;

    @Transactional
    public Long guardarRemitente(SarcoWebVo sarcoWebVo) {
        Remitente remitente = new Remitente();
        remitente.setIdpersona(sarcoWebVo.getIdPersona());
        remitente.setCorreo(sarcoWebVo.getCorreo());
        remitente.setIdreferenciaremitente(
                new Referenciaremitente(sarcoWebVo.getIdReferenciaRemitente()));
        
        remitente = this.remitenteRepository.save(remitente);
        return remitente.getIdremitente();
    }
    
}
