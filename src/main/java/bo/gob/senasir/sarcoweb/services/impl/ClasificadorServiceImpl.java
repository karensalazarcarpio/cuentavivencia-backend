/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.services.impl;

import bo.gob.senasir.sarcoweb.model.Clasificador;
import bo.gob.senasir.sarcoweb.repositories.ClasificadorRepository;
import bo.gob.senasir.sarcoweb.services.ClasificadorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author KSalazar
 */
@Service("clasificadorService")
@Transactional(readOnly=true)
public class ClasificadorServiceImpl implements ClasificadorService {

    @Autowired
    private ClasificadorRepository clasificadorRepository;

    public List<Clasificador> getClasificadores() {
        return clasificadorRepository.getClasificadores();
    }

}
