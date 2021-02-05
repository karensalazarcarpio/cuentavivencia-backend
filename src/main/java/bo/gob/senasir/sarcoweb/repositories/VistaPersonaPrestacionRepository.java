/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.repositories;


import bo.gob.senasir.referencial.model.VistaPersonaPrestacion;
import bo.gob.senasir.referencial.vo.VistaPersonaPrestacionVo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KSalazar
 */
@Repository
public interface VistaPersonaPrestacionRepository extends JpaRepository<VistaPersonaPrestacion, Long> {
    List<VistaPersonaPrestacionVo> obtAsegurado(
            @Param("cedula") String cedula,
            @Param("complemento") String complemento
            
    );
}
