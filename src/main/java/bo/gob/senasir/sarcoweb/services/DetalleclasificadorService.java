/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.services;

import bo.gob.senasir.sarcoweb.model.DetalleclasificadorVo;
import java.util.List;

/**
 *
 * @author KSalazar
 */
public interface DetalleclasificadorService {

    public List<DetalleclasificadorVo> obtDetallePorClasificador(Long idClasificador);

    public List<DetalleclasificadorVo> obtDetalleClasificadorPorPadre(Long idClasificador);
}
