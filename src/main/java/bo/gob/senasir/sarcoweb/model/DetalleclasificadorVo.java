/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author KSalazar
 */
@Entity
public class DetalleclasificadorVo implements Serializable {

    @Id
    @Column(name = "iddetalleclasificador")
    private Long iddetalleclasificador;
    @Column(name = "nombre")
    private String nombre;

    public Long getIddetalleclasificador() {
        return iddetalleclasificador;
    }

    public void setIddetalleclasificador(Long iddetalleclasificador) {
        this.iddetalleclasificador = iddetalleclasificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
