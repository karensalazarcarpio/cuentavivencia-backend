/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.controllers;

import bo.gob.senasir.referencial.vo.VistaPersonaPrestacionVo;
import bo.gob.senasir.sarcoweb.services.VistaPersonaPrestacionService;
import java.util.List;
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
@Path("v1/vistapersonaprestacion")
public class VistaPersonaPrestacionController {
    @Autowired
    private VistaPersonaPrestacionService vistaPersonaPrestacionService;
    @GET//
    @Produces({MediaType.APPLICATION_JSON})
    @Path("porcedulacomplemento")
    public List<VistaPersonaPrestacionVo> obtAsegurado(
        @QueryParam("cedula") String cedula,
        @QueryParam("complemento") String complemento){
        return vistaPersonaPrestacionService.obtAsegurado(cedula, complemento);
    }
    
}
