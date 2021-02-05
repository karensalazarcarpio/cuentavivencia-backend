/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.services.impl;

import bo.gob.senasir.sarcoweb.constantes.DetalleClasificadorConstantes;
import bo.gob.senasir.sarcoweb.model.Destinatario;
import bo.gob.senasir.sarcoweb.model.Detalleclasificador;
import bo.gob.senasir.sarcoweb.model.Documento;
import bo.gob.senasir.sarcoweb.model.Documentoadjunto;
import bo.gob.senasir.sarcoweb.model.Referenciaremitente;
import bo.gob.senasir.sarcoweb.model.Remitente;

import bo.gob.senasir.sarcoweb.repositories.DocumentoRepository;
import bo.gob.senasir.sarcoweb.services.DocumentoAdjuntoService;
import bo.gob.senasir.sarcoweb.services.DocumentoService;
import bo.gob.senasir.sarcoweb.services.ReferenciaRemitenteService;
import bo.gob.senasir.sarcoweb.services.RemitenteService;
import bo.gob.senasir.sarcoweb.services.SeguimientoService;
import bo.gob.senasir.sarcoweb.vo.SarcoWebVo;
import java.util.Date;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author KSalazar
 */
@Service("documentoService")
@Transactional(readOnly = true)
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;
    @Autowired
    private ReferenciaRemitenteService referenciaRemitenteService;
    @Autowired
    private RemitenteService remitenteService;
    @Autowired
    private DocumentoAdjuntoService documentoAdjuntoService;
    @Autowired
    private SeguimientoService seguimientoService;

    @Transactional
    public Long guardarDocumento(SarcoWebVo sarcoWebVo) {

        Documento documento = new Documento();

        documento.setCitedoc(sarcoWebVo.getCite());
        if (sarcoWebVo.getIdTipoDocumento() != null) {
            documento.setIdtipodoc(new Detalleclasificador(sarcoWebVo.getIdTipoDocumento()));
        }
        if (sarcoWebVo.getIdRegional() != null) {
            documento.setIdregional(new Detalleclasificador(sarcoWebVo.getIdRegional()));
        }
        if (sarcoWebVo.getIdInstitucion() != null) {
            documento.setIdempresa(new Detalleclasificador(sarcoWebVo.getIdInstitucion()));
        }
        documento.setFecha(new Date());
        //TODO GUARDAR FECHA

        documento.setFechadoc(sarcoWebVo.getFechaDocumentoDate());
        //documento.setFechadoc(new Date());
        documento.setIddestinatario(new Destinatario(sarcoWebVo.getIdDestinatario()));
        //TODO BORRAR CAMPO DE BASE Y ENTITY idDocumentoAdjunto 
        documento.setIdestado(new Detalleclasificador(DetalleClasificadorConstantes.ID_ESTADO_INICIADO));
        documento.setIdremitente(new Remitente(sarcoWebVo.getIdRemitente()));
        documento.setReferenciadoc(sarcoWebVo.getReferencia());
        documento = this.documentoRepository.save(documento);
        return documento.getIddocumento();
    }

    @Transactional
    public Long guardarDocumentoYOtros(SarcoWebVo sarcoWebVo, FormDataBodyPart files) {
        //guardar referencia remitente
        Long idReferenciaRemitente = this.referenciaRemitenteService.guardarReferenciaRemitente(sarcoWebVo);
        sarcoWebVo.setInteresadoRemitente(this.referenciaRemitenteService.obtenerInteresadoRemitente(sarcoWebVo));
        sarcoWebVo.setIdReferenciaRemitente(idReferenciaRemitente);
        //guardar remitente
        Long idRemitente = this.remitenteService.guardarRemitente(sarcoWebVo);
        sarcoWebVo.setIdRemitente(idRemitente);
        //guardar documento
        Long idDocumento = this.guardarDocumento(sarcoWebVo);
        sarcoWebVo.setIdDocumento(idDocumento);
        //guardar documentos adjuntos
        this.documentoAdjuntoService.guardarListaDocumentosAdjuntos(sarcoWebVo, files);
        //guardar seguimiento
        this.seguimientoService.guardarSeguimiento(sarcoWebVo);
        
        return idDocumento;
    }

}
