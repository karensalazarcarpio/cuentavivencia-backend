package bo.gob.senasir.sarcoweb.controllers;

import bo.gob.senasir.sarcoweb.model.Clasificador;
import bo.gob.senasir.sarcoweb.services.ClasificadorService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KAREN
 */
@Path("v1/clasificadores")
//@RestController
//@RequestMapping("/v1/clasificadores")
public class ClasificadorResource {

    @Autowired
    private ClasificadorService clasificadorService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    //@RequestMapping(value = "/lista", method = RequestMethod.GET)
    public List<Clasificador> getClasificadores() {
        return clasificadorService.getClasificadores();
    }
}
