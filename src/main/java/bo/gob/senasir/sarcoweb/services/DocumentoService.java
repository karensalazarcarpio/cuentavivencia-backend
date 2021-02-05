/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.services;

import bo.gob.senasir.sarcoweb.vo.SarcoWebVo;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;

/**
 *
 * @author KSalazar
 */
public interface DocumentoService {

    public Long guardarDocumento(SarcoWebVo sarcoWebVo);

    public Long guardarDocumentoYOtros(SarcoWebVo sarcoWebVo, FormDataBodyPart files);
}
