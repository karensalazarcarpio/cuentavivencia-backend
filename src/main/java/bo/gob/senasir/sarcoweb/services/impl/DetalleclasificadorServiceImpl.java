/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.services.impl;

import bo.gob.senasir.sarcoweb.model.Detalleclasificador;
import bo.gob.senasir.sarcoweb.repositories.DetalleclasificadorRepository;
import bo.gob.senasir.sarcoweb.services.DetalleclasificadorService;
import bo.gob.senasir.sarcoweb.model.DetalleclasificadorVo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author KSalazar
 */
@Service("detalleclasificadorService")
@Transactional(readOnly = true)
public class DetalleclasificadorServiceImpl implements DetalleclasificadorService {

    @Autowired
    private DetalleclasificadorRepository detalleclasificadorRepository;

    public List<DetalleclasificadorVo> obtDetallePorClasificador(Long idClasificador) {
        return detalleclasificadorRepository.obtDetallePorClasificador(idClasificador);
    }

    public List<DetalleclasificadorVo> obtDetalleClasificadorPorPadre(Long idPadre) {
        return detalleclasificadorRepository.obtDetalleClasificadorPorPadre(idPadre);
    }
}
