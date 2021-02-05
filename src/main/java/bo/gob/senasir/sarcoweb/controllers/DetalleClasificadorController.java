package bo.gob.senasir.sarcoweb.controllers;

import bo.gob.senasir.sarcoweb.services.DetalleclasificadorService;
import bo.gob.senasir.sarcoweb.model.DetalleclasificadorVo;
import bo.gob.senasir.sarcoweb.util.MostrarMensajeError;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author KSalazar
 */
@Path("v1/detalleclasificadores")
//@RestController
//@RequestMapping("/v1/clasificadores")
public class DetalleClasificadorController {

    @Autowired
    private DetalleclasificadorService detalleclasificadorService;

    private static final Long CLASIFICADOR_ORIGEN = 1l;
    private static final Long CLASIFICADOR_INSTITUCION = 2l;
    private static final Long CLASIFICADOR_REGIONAL = 4l;
    private static final Long CLASIFICADOR_TIPODOCUMENTO = 5l;
    private static final Long CLASIFICADOR_TIPOADJUNTO = 6l;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("registrosarco")
    public HashMap<String, Object> obtClasificadoresRegistroSarco() {
//         
        HashMap<String, Object> respuesta = new HashMap<String, Object>();
        respuesta.put("origen", detalleclasificadorService.obtDetallePorClasificador(CLASIFICADOR_ORIGEN));
        respuesta.put("regional", detalleclasificadorService.obtDetallePorClasificador(CLASIFICADOR_REGIONAL));
        respuesta.put("tipoDocumento", detalleclasificadorService.obtDetallePorClasificador(CLASIFICADOR_TIPODOCUMENTO));
        respuesta.put("tipoAdjunto", detalleclasificadorService.obtDetallePorClasificador(CLASIFICADOR_TIPOADJUNTO));
        return respuesta;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("poridpadre")
    public List<DetalleclasificadorVo> obtDetalleClasificadorPorPadre(
            @QueryParam("idPadre") Long idPadre) {
        //validarObtDetalleClasificadorPorPadre(idPadre);
        return detalleclasificadorService.obtDetalleClasificadorPorPadre(idPadre);
    }

    private void validarObtDetalleClasificadorPorPadre(Long idPadre) {
        if (idPadre == null) {
            MostrarMensajeError.enviarError(
                    "Es necesario enviar el origen del clasificador",
                    "El origen enviado es nulo o vacío",
                    "Revise los parámetros enviados");
        }
    }

}
