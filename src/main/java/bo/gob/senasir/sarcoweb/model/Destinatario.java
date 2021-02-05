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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery; 
import javax.persistence.NamedNativeQueries; 
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author KSalazar
 */
@Entity
@Table(name = "destinatario", catalog = "Plataforma", schema = "\"SarcoWeb\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destinatario.findAll", query = "SELECT d FROM Destinatario d")
    , @NamedQuery(name = "Destinatario.findByIddestinatario", query = "SELECT d FROM Destinatario d WHERE d.iddestinatario = :iddestinatario")
    , @NamedQuery(name = "Destinatario.findByNombre", query = "SELECT d FROM Destinatario d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Destinatario.findByArea", query = "SELECT d FROM Destinatario d WHERE d.area = :area")
    , @NamedQuery(name = "Destinatario.findByCorreo", query = "SELECT d FROM Destinatario d WHERE d.correo = :correo")})
@NamedNativeQueries({
    @NamedNativeQuery(name = "Destinatario.obtDestinatario", query
            = "select a.iddestinatario,a.nombre "
            + "from \"SarcoWeb\".Destinatario a "
            + "where a.idtipo = 3238 ",
            resultClass = DestinatarioVo.class)
})


public class Destinatario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddestinatario")
    private Long iddestinatario;
    //@Basic(optional = false)
    //@NotNull
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "area")
    private int area;
    //@Basic(optional = false)
    //@NotNull
    @Size(max = 50)
    @Column(name = "correo")
    private String correo;
    @OneToMany(mappedBy = "iddestinatario", fetch = FetchType.LAZY)
    private List<Documento> documentoList;
    @JoinColumn(name = "idtipo", referencedColumnName = "iddetalleclasificador")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Detalleclasificador idtipo;

    public Destinatario() {
    }

    public Destinatario(Long iddestinatario) {
        this.iddestinatario = iddestinatario;
    }

    public Destinatario(Long iddestinatario, String nombre, int area, String correo) {
        this.iddestinatario = iddestinatario;
        this.nombre = nombre;
        this.area = area;
        this.correo = correo;
    }

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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    public Detalleclasificador getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Detalleclasificador idtipo) {
        this.idtipo = idtipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddestinatario != null ? iddestinatario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destinatario)) {
            return false;
        }
        Destinatario other = (Destinatario) object;
        if ((this.iddestinatario == null && other.iddestinatario != null) || (this.iddestinatario != null && !this.iddestinatario.equals(other.iddestinatario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.gob.senasir.sarcoweb.model.Destinatario[ iddestinatario=" + iddestinatario + " ]";
    }
    
}
