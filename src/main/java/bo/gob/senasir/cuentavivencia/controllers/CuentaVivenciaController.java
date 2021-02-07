package bo.gob.senasir.cuentavivencia.controllers;

import bo.gob.senasir.cuentavivencia.vo.CuentaVivenciaVo;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import bo.gob.senasir.cuentavivencia.services.CuentaVivenciaService;
import java.math.BigInteger;

/**
 *
 * @author KSalazar
 */
@Path("v1/cuentavivencia")
public class CuentaVivenciaController {

    @Autowired
    private CuentaVivenciaService cuentaVivenciaService;

    private void validarVivencia(CuentaVivenciaVo cuentaVivenciaVo) {
        //TODO
    }

    @Path("crea")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String uploadFile2(
            @FormDataParam("anversoCI") FormDataBodyPart anversoCI,
            @FormDataParam("reversoCI") FormDataBodyPart reversoCI,
            @FormDataParam("video") FormDataBodyPart video,
            @FormDataParam("geoLatitud") String geoLatitud,
            @FormDataParam("geoLongitud") String geoLongitud,
            @FormDataParam("idPersonaDH") BigInteger idPersonaDH,
            @FormDataParam("idPersonaTitular") Long idPersonaTitular,
            @FormDataParam("idUsuario") BigInteger idUsuario,
            @FormDataParam("origen") String origen,
            @FormDataParam("token") String token,
            @FormDataParam("margenInferior") Double margenInferior,
            @FormDataParam("margenSuperior") Double margenSuperior
    ) {
        CuentaVivenciaVo cuentaVivenciaVo = new CuentaVivenciaVo();
        cuentaVivenciaVo.setGeoLatitud(geoLatitud);
        cuentaVivenciaVo.setGeoLongitud(geoLongitud);
        cuentaVivenciaVo.setIdPersonaDH(idPersonaDH);
        cuentaVivenciaVo.setIdPersonaTitular(idPersonaTitular);
        cuentaVivenciaVo.setIdUsuario(idUsuario);
        cuentaVivenciaVo.setOrigen(origen);
        cuentaVivenciaVo.setToken(token);
        cuentaVivenciaVo.setMargenInferior(margenInferior);
        cuentaVivenciaVo.setMargenSuperior(margenSuperior);

        validarVivencia(cuentaVivenciaVo);
        cuentaVivenciaService.guardarCuentaVivencia(cuentaVivenciaVo, anversoCI, reversoCI, video);

        return "OK";
    }
}
