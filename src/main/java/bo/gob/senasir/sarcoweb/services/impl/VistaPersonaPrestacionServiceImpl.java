/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.services.impl;

import bo.gob.senasir.referencial.vo.VistaPersonaPrestacionVo;
import bo.gob.senasir.sarcoweb.repositories.VistaPersonaPrestacionRepository;
import bo.gob.senasir.sarcoweb.services.VistaPersonaPrestacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author KSalazar
 */
@Service("vistaPersonaPrestacion")
@Transactional(readOnly = true)
public class VistaPersonaPrestacionServiceImpl implements VistaPersonaPrestacionService{
    @Autowired
    private VistaPersonaPrestacionRepository vistaPersonaPrestacionRepository;
    public List<VistaPersonaPrestacionVo> obtAsegurado (String cedula, String complemento){
        return vistaPersonaPrestacionRepository.obtAsegurado(cedula,complemento);
    }
    
}
