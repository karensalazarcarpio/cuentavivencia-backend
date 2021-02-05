/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.repositories;


import bo.gob.senasir.sarcoweb.model.Destinatario;
import bo.gob.senasir.sarcoweb.model.DestinatarioVo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KSalazar
 */
@Repository
public interface DestinatarioRepository extends JpaRepository<Destinatario, Long>{
    
    List<DestinatarioVo> obtDestinatario();
}
