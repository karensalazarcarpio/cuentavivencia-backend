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
import bo.gob.senasir.cuentavivencia.vo.CuentaVivenciaAux;
import java.math.BigInteger;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

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
    public String crea(
            @FormDataParam("anversoCI") FormDataBodyPart anversoCI,
            @FormDataParam("reversoCI") FormDataBodyPart reversoCI,
            @FormDataParam("video") FormDataBodyPart video,
            @FormDataParam("geoLatitud") String geoLatitud,
            @FormDataParam("geoLongitud") String geoLongitud,
            @FormDataParam("idPersonaDH") Long idPersonaDH,
            @FormDataParam("idPersonaTitular") Long idPersonaTitular,
            @FormDataParam("idUsuario") BigInteger idUsuario,
            @FormDataParam("origen") String origen,
            @FormDataParam("token") String token,
            @FormDataParam("margenInferior") Double margenInferior,
            @FormDataParam("margenSuperior") Double margenSuperior,
            @FormDataParam("telefonoContacto") String telefonoContacto,
            @FormDataParam("correoContacto") String correoContacto
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
        cuentaVivenciaVo.setTelefonoContacto(telefonoContacto);
        cuentaVivenciaVo.setCorreoContacto(correoContacto);

        validarVivencia(cuentaVivenciaVo);
        cuentaVivenciaService.guardarCuentaVivencia(cuentaVivenciaVo, anversoCI, reversoCI, video);

        return "OK";
    }

    @Path("obtvivenciaxpersona")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public CuentaVivenciaAux obtCuentaVivenciaPorPersona(
            @QueryParam("idPersonaTitular") Long idPersonaTitular,
            @QueryParam("idPersonaDH") Long idPersonaDH) {
        return this.cuentaVivenciaService.obtCuentaVivenciaPorPersona(idPersonaTitular, idPersonaDH);
    }
}
