/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.util;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author Pedrito
 */
public class MostrarMensajeError {

    public static void enviarError(String mensaje, String causa, String accion) {
        SarcoWebError sarcoWebError = new SarcoWebError();

        sarcoWebError.setMensaje(mensaje);
        sarcoWebError.setCausa(causa);
        sarcoWebError.setAccion(accion);

        List<SarcoWebError> errores = new ArrayList<SarcoWebError>();
        errores.add(sarcoWebError);

        enviarListaErrores(errores);
    }

    public static void enviarListaErrores(List<SarcoWebError> errores) {
        SarcoWebListaError sarcoWebListaError = new SarcoWebListaError();
        sarcoWebListaError.setErrores(errores);
        
        throw new WebApplicationException(
                Response.status(
                        Response.Status.INTERNAL_SERVER_ERROR).entity(
                                sarcoWebListaError).build());
    }
}
