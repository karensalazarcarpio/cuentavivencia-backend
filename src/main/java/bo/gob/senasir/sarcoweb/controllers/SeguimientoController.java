/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.controllers;

import bo.gob.senasir.sarcoweb.services.SeguimientoService;
import bo.gob.senasir.sarcoweb.util.MostrarMensajeError;
import bo.gob.senasir.sarcoweb.vo.SeguimientoVo;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author KSalazar
 */
@Path("v1/seguimiento")
public class SeguimientoController {

    @Autowired
    private SeguimientoService seguimientoService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("porhojaruta")
    public List<SeguimientoVo> obtSeguimientoPorHojaRuta(
            @QueryParam("hojarutaSeleccionado") Integer hojarutaSeleccionado,
            @QueryParam("gestionSeleccionado") Integer gestionSeleccionado) {
        return seguimientoService.obtSeguimientoPorHojaRuta(hojarutaSeleccionado, gestionSeleccionado);
    }

    @Path("porcodigoseguridad")
    public List<SeguimientoVo> obtSeguimientoPorCodigoSeguridad(
            @QueryParam("codigoseguridadSeleccionado") String codigoseguridadSeleccionado,
            @QueryParam("gestionSeleccionado") Integer gestionSeleccionado) {
        return seguimientoService.obtSeguimientoPorCodigoSeguridad(codigoseguridadSeleccionado, gestionSeleccionado);
    }

    public static boolean validarRecaptcha(String token) {
        String urlreal = "https://www.google.com/recaptcha/api/siteverify";
        Unirest.setTimeouts(10000, 1800000);
        HttpResponse<JsonNode> asJson = null;
        try {
            asJson = Unirest.post(urlreal).header("User-Agent",
                    "Apache-HttpClient/4.1.1 (java 1.5)").header("Connection",
                            "Keep-Alive").field("secret",
                            "6LdG5ssZAAAAAO91tiyrIYra9isaRwdhqqa7aS6g").field("response",
                            token).asJson();
        } catch (UnirestException ex) {
            MostrarMensajeError.enviarError(
                    "Error al consultar token google",
                    "",
                    "");
        }
        return asJson.getBody().getObject().getBoolean("success");
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("busqueda")
    public List<SeguimientoVo> busquedaSeguimiento(
            @QueryParam("codigoseguridadSeleccionado") String codigoseguridadSeleccionado,
            @QueryParam("gestionSeleccionado") Integer gestionSeleccionado,
            @QueryParam("token") String token) {
        /*
        if (token == null || token.trim().equals("")) {

            MostrarMensajeError.enviarError(
                    "El token es invalido",
                    "El token enviado es nulo o vacío",
                    "El token es incorrecto");

        }*/
        Integer codigoBusqueda;
        List<SeguimientoVo> lista = null;

        //if (!validarRecaptcha(token)) {
        //    return lista;
        //}
        //if (codigoseguridadSeleccionado == null || codigoseguridadSeleccionado.trim().equals("")) {
        //    MostrarMensajeError.enviarError(
        //            "Es necesario enviar el código de seguridad",
        //            "El Código de Seguridad enviado es nulo o vacío",
        //            "Revise los parámetros enviados");
        //}

        try {
            codigoBusqueda = Integer.parseInt(codigoseguridadSeleccionado);
        } catch (NumberFormatException e) {
            codigoBusqueda = null;
        }

        if (codigoBusqueda == null) {
            lista = seguimientoService.obtSeguimientoPorCodigoSeguridad(
                    codigoseguridadSeleccionado, gestionSeleccionado);
        } else {
            lista = seguimientoService.obtSeguimientoPorHojaRuta(
                    codigoBusqueda, gestionSeleccionado);
        }
        return lista;

    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("listaGestiones")
    public List<Integer> obtenerGestion() {
        List<Integer> listaGestion = new ArrayList<Integer>();
        Calendar calendar = Calendar.getInstance();
        Integer gestionActual = calendar.get(Calendar.YEAR);
        for (int i = 2020; i <= gestionActual; i++) {
            listaGestion.add(i);
        }
        return listaGestion;
    }

}
