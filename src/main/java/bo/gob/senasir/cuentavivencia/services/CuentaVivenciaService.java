/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.cuentavivencia.services;

import bo.gob.senasir.cuentavivencia.vo.CuentaVivenciaAux;
import bo.gob.senasir.cuentavivencia.vo.CuentaVivenciaVo;
import java.math.BigInteger;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;

/**
 *
 * @author KSalazar
 */
public interface CuentaVivenciaService {

    public void guardarCuentaVivencia(CuentaVivenciaVo cuentaVivenciaVo,
            FormDataBodyPart anversoCI, FormDataBodyPart reversoCI, FormDataBodyPart video);

    public void actualizarCuentaVigenciaDetInicial(Long idCuentaVivencia, Long idCuentaVivenciaDetInicial);

    public CuentaVivenciaAux obtCuentaVivenciaPorPersona(Long idPersonaTitular, Long idPersonaDH);
}
