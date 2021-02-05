/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author KSalazar
 */
@Entity
@Table(name = "documento", catalog = "Plataforma", schema = "\"SarcoWeb\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d")
    , @NamedQuery(name = "Documento.findByIddocumento", query = "SELECT d FROM Documento d WHERE d.iddocumento = :iddocumento")
    , @NamedQuery(name = "Documento.findByCorrelativo", query = "SELECT d FROM Documento d WHERE d.correlativo = :correlativo")
    , @NamedQuery(name = "Documento.findByFecha", query = "SELECT d FROM Documento d WHERE d.fecha = :fecha")
    , @NamedQuery(name = "Documento.findByFechadoc", query = "SELECT d FROM Documento d WHERE d.fechadoc = :fechadoc")
    , @NamedQuery(name = "Documento.findByCitedoc", query = "SELECT d FROM Documento d WHERE d.citedoc = :citedoc")
    , @NamedQuery(name = "Documento.findByReferenciadoc", query = "SELECT d FROM Documento d WHERE d.referenciadoc = :referenciadoc")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "iddocumento")
    private Long iddocumento;
    @Column(name = "correlativo")
    private BigInteger correlativo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechadoc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadoc;
    //@Basic(optional = false)
    //@NotNull
    @Size(max = 100)
    @Column(name = "citedoc")
    private String citedoc;
    @Basic(optional = false)
    @NotNull
    @Size(max = 200)
    @Column(name = "referenciadoc")
    private String referenciadoc;
    @OneToMany(mappedBy = "iddocumento", fetch = FetchType.LAZY)
    private List<Documentoadjunto> documentoadjuntoList;
    @OneToMany(mappedBy = "iddocumento", fetch = FetchType.LAZY)
    private List<Seguimiento> seguimientoList;
    @JoinColumn(name = "iddestinatario", referencedColumnName = "iddestinatario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Destinatario iddestinatario;
    @JoinColumn(name = "idempresa", referencedColumnName = "iddetalleclasificador")
    @ManyToOne(fetch = FetchType.LAZY)
    private Detalleclasificador idempresa;
    @JoinColumn(name = "idestado", referencedColumnName = "iddetalleclasificador")
    @ManyToOne(fetch = FetchType.LAZY)
    private Detalleclasificador idestado;
    @JoinColumn(name = "idregional", referencedColumnName = "iddetalleclasificador")
    @ManyToOne(fetch = FetchType.LAZY)
    private Detalleclasificador idregional;
    @JoinColumn(name = "idtipodoc", referencedColumnName = "iddetalleclasificador")
    @ManyToOne(fetch = FetchType.LAZY)
    private Detalleclasificador idtipodoc;
    @JoinColumn(name = "idremitente", referencedColumnName = "idremitente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Remitente idremitente;

    public Documento() {
    }

    public Documento(Long iddocumento) {
        this.iddocumento = iddocumento;
    }

    public Documento(Long iddocumento, BigInteger correlativo, Date fecha, Date fechadoc, String referenciadoc) {
        this.iddocumento = iddocumento;
        this.correlativo = correlativo;
        this.fecha = fecha;
        this.fechadoc = fechadoc;
        this.referenciadoc = referenciadoc;
    }

    public Long getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(Long iddocumento) {
        this.iddocumento = iddocumento;
    }

    public BigInteger getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(BigInteger correlativo) {
        this.correlativo = correlativo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechadoc() {
        return fechadoc;
    }

    public void setFechadoc(Date fechadoc) {
        this.fechadoc = fechadoc;
    }

    public String getCitedoc() {
        return citedoc;
    }

    public void setCitedoc(String citedoc) {
        this.citedoc = citedoc;
    }

    public String getReferenciadoc() {
        return referenciadoc;
    }

    public void setReferenciadoc(String referenciadoc) {
        this.referenciadoc = referenciadoc;
    }

    @XmlTransient
    public List<Documentoadjunto> getDocumentoadjuntoList() {
        return documentoadjuntoList;
    }

    public void setDocumentoadjuntoList(List<Documentoadjunto> documentoadjuntoList) {
        this.documentoadjuntoList = documentoadjuntoList;
    }

    @XmlTransient
    public List<Seguimiento> getSeguimientoList() {
        return seguimientoList;
    }

    public void setSeguimientoList(List<Seguimiento> seguimientoList) {
        this.seguimientoList = seguimientoList;
    }

    public Destinatario getIddestinatario() {
        return iddestinatario;
    }

    public void setIddestinatario(Destinatario iddestinatario) {
        this.iddestinatario = iddestinatario;
    }

    public Detalleclasificador getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Detalleclasificador idempresa) {
        this.idempresa = idempresa;
    }

    public Detalleclasificador getIdestado() {
        return idestado;
    }

    public void setIdestado(Detalleclasificador idestado) {
        this.idestado = idestado;
    }

    public Detalleclasificador getIdregional() {
        return idregional;
    }

    public void setIdregional(Detalleclasificador idregional) {
        this.idregional = idregional;
    }

    public Detalleclasificador getIdtipodoc() {
        return idtipodoc;
    }

    public void setIdtipodoc(Detalleclasificador idtipodoc) {
        this.idtipodoc = idtipodoc;
    }

    public Remitente getIdremitente() {
        return idremitente;
    }

    public void setIdremitente(Remitente idremitente) {
        this.idremitente = idremitente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddocumento != null ? iddocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.iddocumento == null && other.iddocumento != null) || (this.iddocumento != null && !this.iddocumento.equals(other.iddocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.gob.senasir.sarcoweb.model.Documento[ iddocumento=" + iddocumento + " ]";
    }
    
}
