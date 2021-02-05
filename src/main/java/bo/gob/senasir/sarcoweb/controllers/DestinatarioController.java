/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.controllers;

import bo.gob.senasir.sarcoweb.model.DestinatarioVo;
import bo.gob.senasir.sarcoweb.services.DestinatarioService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author KSalazar
 */

@Path("v1/destinatarios")
public class DestinatarioController {
    @Autowired
    private DestinatarioService destinatarioService;
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("listadestinatarios")
    public List<DestinatarioVo> obtDestinatario(){
        return destinatarioService.obtDestinatario();
    }
}
