/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.services.impl;

import bo.gob.senasir.sarcoweb.model.Referenciaremitente;
import bo.gob.senasir.sarcoweb.repositories.ReferenciaRemitenteRepository;
import bo.gob.senasir.sarcoweb.services.ReferenciaRemitenteService;
import bo.gob.senasir.sarcoweb.vo.SarcoWebVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author KAREN
 */
@Service("referenciaRemitenteService")
@Transactional(readOnly = true)
public class ReferenciaRemitenteServiceImpl implements ReferenciaRemitenteService {

    @Autowired
    private ReferenciaRemitenteRepository referenciaRemitenteRepository;

    @Transactional
    public Long guardarReferenciaRemitente(SarcoWebVo sarcoWebVo) {

        Referenciaremitente referenciaRemitente = new Referenciaremitente();

        referenciaRemitente.setPaterno(sarcoWebVo.getPaterno());
        referenciaRemitente.setMaterno(sarcoWebVo.getMaterno());
        referenciaRemitente.setNombres(sarcoWebVo.getNombres());
        referenciaRemitente.setCedula(sarcoWebVo.getCedula());
        referenciaRemitente.setTelefono(sarcoWebVo.getTelefono());
        referenciaRemitente.setDireccion(sarcoWebVo.getDireccion());
        referenciaRemitente.setParentesco(sarcoWebVo.getParentesco());
        referenciaRemitente.setCargo(sarcoWebVo.getCargo());

        referenciaRemitente = this.referenciaRemitenteRepository.save(referenciaRemitente);
        return referenciaRemitente.getIdreferenciaremitente();
    }

    public String obtenerInteresadoRemitente(SarcoWebVo sarcoWebVo) {

        String interesadoRemitente;
        interesadoRemitente = sarcoWebVo.getNombres() + " " + sarcoWebVo.getPaterno() + " " + sarcoWebVo.getMaterno();
        return interesadoRemitente;
    }

}
