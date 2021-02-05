/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.model;

import java.io.Serializable;
import java.util.Collection; 
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
import javax.persistence.NamedNativeQueries; 
import javax.persistence.NamedNativeQuery; 
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
@Table(name = "detalleclasificador", catalog = "Plataforma", schema = "\"SarcoWeb\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleclasificador.findAll", query = "SELECT d FROM Detalleclasificador d")
    , @NamedQuery(name = "Detalleclasificador.findByIddetalleclasificador", query = "SELECT d FROM Detalleclasificador d WHERE d.iddetalleclasificador = :iddetalleclasificador")
    , @NamedQuery(name = "Detalleclasificador.findByCodigo", query = "SELECT d FROM Detalleclasificador d WHERE d.codigo = :codigo")
    , @NamedQuery(name = "Detalleclasificador.findByNombre", query = "SELECT d FROM Detalleclasificador d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Detalleclasificador.findByAbreviacion", query = "SELECT d FROM Detalleclasificador d WHERE d.abreviacion = :abreviacion")
    , @NamedQuery(name = "Detalleclasificador.findByEstado", query = "SELECT d FROM Detalleclasificador d WHERE d.estado = :estado")})
@NamedNativeQueries({
    @NamedNativeQuery(name = "Detalleclasificador.obtDetallePorClasificador", query
            = "select a.iddetalleclasificador,a.nombre "
            + "from \"SarcoWeb\".Detalleclasificador a "
            + "where a.idclasificador = :idClasificador "
            //+ "and (CAST(:tipoOrigen AS TEXT) IS NULL or abreviacion = CAST(:tipoOrigen AS TEXT)) "
            + "and a.estado = 1",
            resultClass = DetalleclasificadorVo.class)
    ,
    @NamedNativeQuery(name = "Detalleclasificador.obtDetalleClasificadorPorPadre", query
            = "select a.iddetalleclasificador,a.nombre "
            + "from \"SarcoWeb\".Detalleclasificador a "
            + "where a.idpadre = :idPadre "
            + "and a.estado = 1",
            resultClass = DetalleclasificadorVo.class)
})
public class Detalleclasificador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetalleclasificador")
    private Long iddetalleclasificador;
    @Size(max = 10)
    @Column(name = "codigo")
    private String codigo;
    //@Basic(optional = false)
    //@NotNull
    @Size(max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "abreviacion")
    private String abreviacion;
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "estado")
    private int estado;
    @OneToMany(mappedBy = "idtipoadjunto", fetch = FetchType.LAZY)
    private List<Documentoadjunto> documentoadjuntoList;
    @OneToMany(mappedBy = "idarea", fetch = FetchType.LAZY)
    private List<Seguimiento> seguimientoList;
    @OneToMany(mappedBy = "idestado", fetch = FetchType.LAZY)
    private List<Seguimiento> seguimientoList1;
    @OneToMany(mappedBy = "idempresa", fetch = FetchType.LAZY)
    private List<Documento> documentoList;
    @OneToMany(mappedBy = "idestado", fetch = FetchType.LAZY)
    private List<Documento> documentoList1;
    @OneToMany(mappedBy = "idregional", fetch = FetchType.LAZY)
    private List<Documento> documentoList2;
    @OneToMany(mappedBy = "idtipodoc", fetch = FetchType.LAZY)
    private List<Documento> documentoList3;
    @JoinColumn(name = "idclasificador", referencedColumnName = "idclasificador")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clasificador idclasificador;
    @OneToMany(mappedBy = "idpadre", fetch = FetchType.LAZY)
    private List<Detalleclasificador> detalleclasificadorList;
    @JoinColumn(name = "idpadre", referencedColumnName = "iddetalleclasificador")
    @ManyToOne(fetch = FetchType.LAZY)
    private Detalleclasificador idpadre;
    @OneToMany(mappedBy = "idtipo", fetch = FetchType.LAZY)
    private List<Destinatario> destinatarioList;

    public Detalleclasificador() {
    }

    public Detalleclasificador(Long iddetalleclasificador) {
        this.iddetalleclasificador = iddetalleclasificador;
    }

    public Detalleclasificador(Long iddetalleclasificador, String nombre, int estado) {
        this.iddetalleclasificador = iddetalleclasificador;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIddetalleclasificador() {
        return iddetalleclasificador;
    }

    public void setIddetalleclasificador(Long iddetalleclasificador) {
        this.iddetalleclasificador = iddetalleclasificador;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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

    @XmlTransient
    public List<Seguimiento> getSeguimientoList1() {
        return seguimientoList1;
    }

    public void setSeguimientoList1(List<Seguimiento> seguimientoList1) {
        this.seguimientoList1 = seguimientoList1;
    }

    @XmlTransient
    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    @XmlTransient
    public List<Documento> getDocumentoList1() {
        return documentoList1;
    }

    public void setDocumentoList1(List<Documento> documentoList1) {
        this.documentoList1 = documentoList1;
    }

    @XmlTransient
    public List<Documento> getDocumentoList2() {
        return documentoList2;
    }

    public void setDocumentoList2(List<Documento> documentoList2) {
        this.documentoList2 = documentoList2;
    }

    @XmlTransient
    public List<Documento> getDocumentoList3() {
        return documentoList3;
    }

    public void setDocumentoList3(List<Documento> documentoList3) {
        this.documentoList3 = documentoList3;
    }

    public Clasificador getIdclasificador() {
        return idclasificador;
    }

    public void setIdclasificador(Clasificador idclasificador) {
        this.idclasificador = idclasificador;
    }

    @XmlTransient
    public List<Detalleclasificador> getDetalleclasificadorList() {
        return detalleclasificadorList;
    }

    public void setDetalleclasificadorList(List<Detalleclasificador> detalleclasificadorList) {
        this.detalleclasificadorList = detalleclasificadorList;
    }

    public Detalleclasificador getIdpadre() {
        return idpadre;
    }

    public void setIdpadre(Detalleclasificador idpadre) {
        this.idpadre = idpadre;
    }

    @XmlTransient
    public List<Destinatario> getDestinatarioList() {
        return destinatarioList;
    }

    public void setDestinatarioList(List<Destinatario> destinatarioList) {
        this.destinatarioList = destinatarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleclasificador != null ? iddetalleclasificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleclasificador)) {
            return false;
        }
        Detalleclasificador other = (Detalleclasificador) object;
        if ((this.iddetalleclasificador == null && other.iddetalleclasificador != null) || (this.iddetalleclasificador != null && !this.iddetalleclasificador.equals(other.iddetalleclasificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.gob.senasir.sarcoweb.model.Detalleclasificador[ iddetalleclasificador=" + iddetalleclasificador + " ]";
    }
    
}
