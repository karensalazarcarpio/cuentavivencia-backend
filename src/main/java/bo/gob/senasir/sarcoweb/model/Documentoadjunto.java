/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List; 
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KSalazar
 */
@Entity
@Table(name = "documentoadjunto", catalog = "Plataforma", schema = "\"SarcoWeb\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentoadjunto.findAll", query = "SELECT d FROM Documentoadjunto d")
    , @NamedQuery(name = "Documentoadjunto.findByIddocumentoadjunto", query = "SELECT d FROM Documentoadjunto d WHERE d.iddocumentoadjunto = :iddocumentoadjunto")
    , @NamedQuery(name = "Documentoadjunto.findByDescripcion", query = "SELECT d FROM Documentoadjunto d WHERE d.descripcion = :descripcion")
    , @NamedQuery(name = "Documentoadjunto.findByRuta", query = "SELECT d FROM Documentoadjunto d WHERE d.ruta = :ruta")
    , @NamedQuery(name = "Documentoadjunto.findByExtension", query = "SELECT d FROM Documentoadjunto d WHERE d.extension = :extension")
    , @NamedQuery(name = "Documentoadjunto.findByFirmadigital", query = "SELECT d FROM Documentoadjunto d WHERE d.firmadigital = :firmadigital")
    , @NamedQuery(name = "Documentoadjunto.findByCrc", query = "SELECT d FROM Documentoadjunto d WHERE d.crc = :crc")
    , @NamedQuery(name = "Documentoadjunto.findByNombrearchivo", query = "SELECT d FROM Documentoadjunto d WHERE d.nombrearchivo = :nombrearchivo")})
public class Documentoadjunto implements Serializable {

    //@Basic(optional = false)
    @NotNull
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;

    private static final long serialVersionUID = 1L;
    @Id
    //@Basic(optional = false)
    //@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "iddocumentoadjunto")
    private Long iddocumentoadjunto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ruta")
    private String ruta;
    @Size(max = 50)
    @Column(name = "extension")
    private String extension;
    @Column(name = "firmadigital")
    private Boolean firmadigital;
    @Size(max = 50)
    @Column(name = "crc")
    private String crc;
    @Size(max = 100)
    @Column(name = "nombrearchivo")
    private String nombrearchivo;
    @JoinColumn(name = "idtipoadjunto", referencedColumnName = "iddetalleclasificador")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Detalleclasificador idtipoadjunto;
    @JoinColumn(name = "iddocumento", referencedColumnName = "iddocumento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Documento iddocumento;
    
    //private List<Documento> documentoList;
    public Documentoadjunto() {
    }

    public Documentoadjunto(Long iddocumentoadjunto) {
        this.iddocumentoadjunto = iddocumentoadjunto;
    }

    public Documentoadjunto(Long iddocumentoadjunto, String descripcion, String ruta) {
        this.iddocumentoadjunto = iddocumentoadjunto;
        this.descripcion = descripcion;
        this.ruta = ruta;
    }

    public Long getIddocumentoadjunto() {
        return iddocumentoadjunto;
    }

    public void setIddocumentoadjunto(Long iddocumentoadjunto) {
        this.iddocumentoadjunto = iddocumentoadjunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Boolean getFirmadigital() {
        return firmadigital;
    }

    public void setFirmadigital(Boolean firmadigital) {
        this.firmadigital = firmadigital;
    }

    public String getCrc() {
        return crc;
    }

    public void setCrc(String crc) {
        this.crc = crc;
    }

    public String getNombrearchivo() {
        return nombrearchivo;
    }

    public void setNombrearchivo(String nombrearchivo) {
        this.nombrearchivo = nombrearchivo;
    }

    public Detalleclasificador getIdtipoadjunto() {
        return idtipoadjunto;
    }

    public void setIdtipoadjunto(Detalleclasificador idtipoadjunto) {
        this.idtipoadjunto = idtipoadjunto;
    }

    public Documento getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(Documento iddocumento) {
        this.iddocumento = iddocumento;
    }
    

    /*public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddocumentoadjunto != null ? iddocumentoadjunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentoadjunto)) {
            return false;
        }
        Documentoadjunto other = (Documentoadjunto) object;
        if ((this.iddocumentoadjunto == null && other.iddocumentoadjunto != null) || (this.iddocumentoadjunto != null && !this.iddocumentoadjunto.equals(other.iddocumentoadjunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.gob.senasir.sarcoweb.model.Documentoadjunto[ iddocumentoadjunto=" + iddocumentoadjunto + " ]";
    }

    
    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
    
}
