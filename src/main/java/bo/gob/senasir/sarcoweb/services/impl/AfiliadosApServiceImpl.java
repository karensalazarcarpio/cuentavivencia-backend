/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.services.impl;

import bo.gob.senasir.referencial.vo.VistaPersonaPrestacionVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import bo.gob.senasir.sarcoweb.repositories.AfiliadosApRepository;
import bo.gob.senasir.sarcoweb.services.AfiliadosApService;

/**
 *
 * @author KSalazar
 */
@Service("afiliadosApService")
@Transactional(readOnly = true)
public class AfiliadosApServiceImpl implements AfiliadosApService{
    @Autowired
    private AfiliadosApRepository afiliadosApRepository;
    public List<VistaPersonaPrestacionVo> obtAfiliado (String cedula, String complemento){
        return afiliadosApRepository.obtAfiliado(cedula,complemento);
    }
    
}
