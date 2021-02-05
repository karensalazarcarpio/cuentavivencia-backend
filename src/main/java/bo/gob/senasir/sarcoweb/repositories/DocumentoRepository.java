/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.repositories;

import bo.gob.senasir.sarcoweb.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KSalazar
 */
@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

}
