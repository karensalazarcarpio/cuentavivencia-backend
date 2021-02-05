/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.model;

import java.io.Serializable;
import java.math.BigInteger;
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
 * @author KSalazar
 */
@Entity
@Table(name = "remitente", catalog = "Plataforma", schema = "\"SarcoWeb\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Remitente.findAll", query = "SELECT r FROM Remitente r")
    , @NamedQuery(name = "Remitente.findByIdremitente", query = "SELECT r FROM Remitente r WHERE r.idremitente = :idremitente")
    , @NamedQuery(name = "Remitente.findByIdpersona", query = "SELECT r FROM Remitente r WHERE r.idpersona = :idpersona")
    , @NamedQuery(name = "Remitente.findByCorreo", query = "SELECT r FROM Remitente r WHERE r.correo = :correo")})
public class Remitente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idremitente")
    private Long idremitente;
    @Column(name = "idpersona")
    private BigInteger idpersona;
    //@Basic(optional = false)
    //@NotNull
    @Size(max = 50)
    @Column(name = "correo")
    private String correo;
    @OneToMany(mappedBy = "idremitente", fetch = FetchType.LAZY)
    private List<Documento> documentoList;
    @JoinColumn(name = "idreferenciaremitente", referencedColumnName = "idreferenciaremitente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Referenciaremitente idreferenciaremitente;

    public Remitente() {
    }

    public Remitente(Long idremitente) {
        this.idremitente = idremitente;
    }

    public Remitente(Long idremitente, String correo) {
        this.idremitente = idremitente;
        this.correo = correo;
    }

    public Long getIdremitente() {
        return idremitente;
    }

    public void setIdremitente(Long idremitente) {
        this.idremitente = idremitente;
    }

    public BigInteger getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(BigInteger idpersona) {
        this.idpersona = idpersona;
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

    public Referenciaremitente getIdreferenciaremitente() {
        return idreferenciaremitente;
    }

    public void setIdreferenciaremitente(Referenciaremitente idreferenciaremitente) {
        this.idreferenciaremitente = idreferenciaremitente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idremitente != null ? idremitente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remitente)) {
            return false;
        }
        Remitente other = (Remitente) object;
        if ((this.idremitente == null && other.idremitente != null) || (this.idremitente != null && !this.idremitente.equals(other.idremitente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.gob.senasir.sarcoweb.model.Remitente[ idremitente=" + idremitente + " ]";
    }
    
}
