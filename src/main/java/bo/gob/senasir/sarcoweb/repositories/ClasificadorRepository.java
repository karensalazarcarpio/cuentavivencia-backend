/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.repositories;

import bo.gob.senasir.sarcoweb.model.Clasificador;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KSalazar
 */
@Repository
public interface ClasificadorRepository extends JpaRepository<Clasificador, Long> {

    @Query("select a from Clasificador a")
    List<Clasificador> getClasificadores();
}
