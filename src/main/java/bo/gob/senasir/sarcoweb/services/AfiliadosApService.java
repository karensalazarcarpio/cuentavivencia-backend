/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.services;

import bo.gob.senasir.referencial.vo.VistaPersonaPrestacionVo;
import java.util.List;

/**
 *
 * @author KSalazar
 */
public interface AfiliadosApService {
    public List<VistaPersonaPrestacionVo> obtAfiliado(String cedula, String complemento);
}
