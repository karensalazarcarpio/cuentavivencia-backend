package bo.gob.senasir.cuentavivencia.controllers;

import bo.gob.senasir.cuentavivencia.services.CuentaVivenciaDetalleService;
import bo.gob.senasir.cuentavivencia.vo.CuentaVivenciaVo;
import java.math.BigInteger;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Pedrito
 */
@Path("v1/cuentavivenciadetalle")
public class CuentaVivenciaDetalleController {

    @Autowired
    private CuentaVivenciaDetalleService cuentaVivenciaDetalleService;

    private void validarVivencia(CuentaVivenciaVo cuentaVivenciaVo) {
        //TODO
    }

    @Path("crea")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String uploadFile(
            @FormDataParam("selphi") FormDataBodyPart selphi,
            @FormDataParam("video") FormDataBodyPart video,
            @FormDataParam("idCuentaVivencia") Long idCuentaVivencia,
            @FormDataParam("idUsuario") BigInteger idUsuario,
            @FormDataParam("origen") String origen,
            @FormDataParam("token") String token,
            @FormDataParam("margenInferior") Double margenInferior,
            @FormDataParam("margenSuperior") Double margenSuperior
    ) {
        CuentaVivenciaVo cuentaVivenciaVo = new CuentaVivenciaVo();
        cuentaVivenciaVo.setIdCuentaVivencia(idCuentaVivencia);
        cuentaVivenciaVo.setIdUsuario(idUsuario);
        cuentaVivenciaVo.setOrigen(origen);
        cuentaVivenciaVo.setToken(token);
        cuentaVivenciaVo.setMargenInferior(margenInferior);
        cuentaVivenciaVo.setMargenSuperior(margenSuperior);

        validarVivencia(cuentaVivenciaVo);
        cuentaVivenciaDetalleService.guardarCuentaVivenciaDetalles(cuentaVivenciaVo, selphi, video);
        return "OK";
    }
}
