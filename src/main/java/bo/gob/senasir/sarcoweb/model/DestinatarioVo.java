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
public class DestinatarioVo implements Serializable{
    @Id
    @Column(name = "iddestinatario")
    private Long iddestinatario;
    @Column(name = "nombre")
    private String nombre;

    public Long getIddestinatario() {
        return iddestinatario;
    }

    public void setIddestinatario(Long iddestinatario) {
        this.iddestinatario = iddestinatario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
