/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.repositories;
import bo.gob.senasir.referencial.vo.VistaPersonaPrestacionVo;
import bo.gob.senasir.referencial.model.AfiliadosAp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




/**
 *
 * @author KSalazar
 */
@Repository
public interface AfiliadosApRepository extends JpaRepository<AfiliadosAp, Long>{
    List<VistaPersonaPrestacionVo> obtAfiliado(
            @Param("cedula") String cedula,
            @Param("complemento") String complemento

    );
}
