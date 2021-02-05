/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author KSalaxar
 */
@Entity
@Table(name = "clasificador", catalog = "Plataforma", schema = "\"SarcoWeb\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clasificador.findAll", query = "SELECT c FROM Clasificador c")
    , @NamedQuery(name = "Clasificador.findByIdclasificador", query = "SELECT c FROM Clasificador c WHERE c.idclasificador = :idclasificador")
    , @NamedQuery(name = "Clasificador.findByDescripcion", query = "SELECT c FROM Clasificador c WHERE c.descripcion = :descripcion")})
public class Clasificador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclasificador")
    private Long idclasificador;
    //@Basic(optional = false)
    //@NotNull
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idclasificador", fetch = FetchType.LAZY)
    private List<Detalleclasificador> detalleclasificadorList;

    public Clasificador() {
    }

    public Clasificador(Long idclasificador) {
        this.idclasificador = idclasificador;
    }

    public Clasificador(Long idclasificador, String descripcion) {
        this.idclasificador = idclasificador;
        this.descripcion = descripcion;
    }

    public Long getIdclasificador() {
        return idclasificador;
    }

    public void setIdclasificador(Long idclasificador) {
        this.idclasificador = idclasificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Detalleclasificador> getDetalleclasificadorList() {
        return detalleclasificadorList;
    }

    public void setDetalleclasificadorList(List<Detalleclasificador> detalleclasificadorList) {
        this.detalleclasificadorList = detalleclasificadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclasificador != null ? idclasificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clasificador)) {
            return false;
        }
        Clasificador other = (Clasificador) object;
        if ((this.idclasificador == null && other.idclasificador != null) || (this.idclasificador != null && !this.idclasificador.equals(other.idclasificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.gob.senasir.sarcoweb.model.Clasificador[ idclasificador=" + idclasificador + " ]";
    }
    
}
