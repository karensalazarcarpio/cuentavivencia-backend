/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.controllers;

import bo.gob.senasir.sarcoweb.services.DocumentoService;
import bo.gob.senasir.sarcoweb.util.FechasUtil;
import bo.gob.senasir.sarcoweb.util.MostrarMensajeError;
import bo.gob.senasir.sarcoweb.vo.SarcoWebVo;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author KSalazar
 */
@Path("v1/documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    private void validarGuardarDocumento(SarcoWebVo sarcoWebVo) {
        Date fechaActualDate = new Date();

        sarcoWebVo.setFechaDocumentoDate(FechasUtil.getFechaFormato(sarcoWebVo.getFechaDocumento(), "yyyy-MM-dd", "documento"));

        if (sarcoWebVo.getFechaDocumentoDate().compareTo(fechaActualDate) > 0) {
            MostrarMensajeError.enviarError("La fecha del documento no puede ser mayor a la fecha actual", "La fecha ingresada es menor a la fecha actual", "Cambiar la fecha del documento");
            //MostrarMensajeError.enviarError(sarcoWebVo.getFechaDocumentoDate().toString(),fechaActualDate.toString() , "Cambiar la fecha del documento");
        }

        if (sarcoWebVo.getReferencia() == null || sarcoWebVo.getReferencia().trim().equals("")) {
            MostrarMensajeError.enviarError("La referencia del documento no es válida.", "La referencia no puede ser vacio o nula", "Digitar nuevamente la referencia.");
        }
        if (sarcoWebVo.getIdInstitucion() == null || sarcoWebVo.getReferencia().trim().equals("")) {
            MostrarMensajeError.enviarError("La Institucion/Empresa no es válida.", "La institución y/o empresa no puede ser vacio o nula", "Digitar nuevamente la institución y/o empresa.");
        }

        if (sarcoWebVo.getIdDestinatario() == null || sarcoWebVo.getIdDestinatario().equals(0)) {
            MostrarMensajeError.enviarError("El destinatario no es válido.", "El IdDestinatario no puede ser vacio o nula", "Digitar nuevamente los datos del remitente");
        }
        if (sarcoWebVo.getIdRegional() == null || sarcoWebVo.getIdRegional().equals(0)) {
            MostrarMensajeError.enviarError("La regional no es válido.", "El IdRegional no puede ser vacio o nula", "Digitar nuevamente de la regional");
        }
        if (sarcoWebVo.getIdDestinatario() == null || sarcoWebVo.getIdDestinatario()== 0) {
            MostrarMensajeError.enviarError("El IdDestinatario no es vàlido.", "El IdDestinatario no puede ser vacio o nula o diferente de una o dos", "Digitar nuevamente el destinatario");
        }
        
        if (!((sarcoWebVo.getIdDestinatario() == 1) || (sarcoWebVo.getIdDestinatario() == 2))) {
            MostrarMensajeError.enviarError("El IdDestinatario puede ser Correspondencia o Fiscalizacion.", "El IdDestinatario tiene que se 1 o 2", "Revisar nuevamente el destinatario");
        }
        
        
    }

    @Path("adjunta")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String uploadFile(
            @FormDataParam("file") FormDataBodyPart files,
            @FormDataParam("data") FormDataBodyPart data
    ) {
        data.setMediaType(MediaType.APPLICATION_JSON_TYPE);
        SarcoWebVo sarcoWebVo = data.getValueAs(SarcoWebVo.class);

        validarGuardarDocumento(sarcoWebVo);
        documentoService.guardarDocumentoYOtros(sarcoWebVo, files);
        return "OK";
    }
}
