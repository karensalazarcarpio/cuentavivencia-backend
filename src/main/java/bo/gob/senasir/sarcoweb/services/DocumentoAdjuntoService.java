/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.services;

import bo.gob.senasir.sarcoweb.model.Documentoadjunto;
import bo.gob.senasir.sarcoweb.vo.DocumentoAdjuntoVo;
import bo.gob.senasir.sarcoweb.vo.SarcoWebVo;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;

/**
 *
 * @author KAREN
 */
public interface DocumentoAdjuntoService {

    public Documentoadjunto guardarDocumentoAdjunto(DocumentoAdjuntoVo documentoAdjuntoVo);

    public void guardarListaDocumentosAdjuntos(SarcoWebVo sarcoWebVo, FormDataBodyPart files);
}
