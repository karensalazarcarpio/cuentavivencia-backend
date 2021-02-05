/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.services.impl;

import bo.gob.senasir.sarcoweb.model.Destinatario;
import bo.gob.senasir.sarcoweb.model.DestinatarioVo;
import bo.gob.senasir.sarcoweb.repositories.DestinatarioRepository;
import bo.gob.senasir.sarcoweb.services.DestinatarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author KSalazar
 */
@Service("destinatarioService")
@Transactional(readOnly=true)
public class DestinatarioServiceImpl implements DestinatarioService{
    @Autowired
    private DestinatarioRepository destinatarioRepository;
    
    public List<DestinatarioVo> obtDestinatario(){
        return destinatarioRepository.obtDestinatario();
    }
    
}
