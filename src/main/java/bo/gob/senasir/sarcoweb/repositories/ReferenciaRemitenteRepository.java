/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bo.gob.senasir.sarcoweb.model.Referenciaremitente;
/**
 *
 * @author KSalazar
 */
@Repository
public interface ReferenciaRemitenteRepository extends JpaRepository<Referenciaremitente, Long>{
    
}
