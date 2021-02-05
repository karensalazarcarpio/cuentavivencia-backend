/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.model;

import bo.gob.senasir.sarcoweb.vo.ConvierteBaseVo;
import bo.gob.senasir.sarcoweb.vo.SeguimientoVo; 
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KSalazae
 */
@Entity
@Table(name = "seguimiento", catalog = "Plataforma", schema = "\"SarcoWeb\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimiento.findAll", query = "SELECT s FROM Seguimiento s")
    , @NamedQuery(name = "Seguimiento.findByIdseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.idseguimiento = :idseguimiento")
    , @NamedQuery(name = "Seguimiento.findByFechaingreso", query = "SELECT s FROM Seguimiento s WHERE s.fechaingreso = :fechaingreso")
    , @NamedQuery(name = "Seguimiento.findByMensaje", query = "SELECT s FROM Seguimiento s WHERE s.mensaje = :mensaje")
    , @NamedQuery(name = "Seguimiento.findByHojaruta", query = "SELECT s FROM Seguimiento s WHERE s.hojaruta = :hojaruta")
    , @NamedQuery(name = "Seguimiento.findByGestion", query = "SELECT s FROM Seguimiento s WHERE s.gestion = :gestion")
    , @NamedQuery(name = "Seguimiento.findByFecharegistro", query = "SELECT s FROM Seguimiento s WHERE s.fecharegistro = :fecharegistro")
    , @NamedQuery(name = "Seguimiento.findByUsuarioregistro", query = "SELECT s FROM Seguimiento s WHERE s.usuarioregistro = :usuarioregistro")
    , @NamedQuery(name = "Seguimiento.findByDescripcionhojaruta", query = "SELECT s FROM Seguimiento s WHERE s.descripcionhojaruta = :descripcionhojaruta")
    , @NamedQuery(name = "Seguimiento.findByCodigoseguridad", query = "SELECT s FROM Seguimiento s WHERE s.codigoseguridad = :codigoseguridad")
    , @NamedQuery(name = "Seguimiento.findByRegistroactivo", query = "SELECT s FROM Seguimiento s WHERE s.registroactivo = :registroactivo")})

@NamedNativeQueries({
    @NamedNativeQuery(name = "Seguimiento.obtSeguimientoPorHojaRuta", query
            ="select seg.idseguimiento, det.nombre area, seg.mensaje, seg.fechaingreso , est.nombre estado, seg.descripcionhojaruta "
            +"from \"SarcoWeb\".\"seguimiento\" seg " 
            +"inner join \"SarcoWeb\".\"detalleclasificador\" det "
            +"on det.iddetalleclasificador=seg.idarea and det.estado=1 "
            +"left join \"SarcoWeb\".\"detalleclasificador\" est "
            +"on est.iddetalleclasificador=seg.idestado and est.estado=1 "
            +"where seg.registroactivo=1 and seg.codigoseguridad= (\"SarcoWeb\".get_decimal_a_base(:gestionSeleccionado, 19))||(\"SarcoWeb\".get_decimal_a_base(:hojarutaSeleccionado, 19)) ",
            resultClass = SeguimientoVo.class),
    @NamedNativeQuery(name = "Seguimiento.obtSeguimientoPorCodigoSeguridad", query
           ="select seg.idseguimiento, det.nombre area, seg.mensaje, seg.fechaingreso , est.nombre estado, seg.descripcionhojaruta "
            +"from \"SarcoWeb\".\"seguimiento\" seg " 
            +"inner join \"SarcoWeb\".\"detalleclasificador\" det "
            +"on det.iddetalleclasificador=seg.idarea and det.estado=1 "
            +"left join \"SarcoWeb\".\"detalleclasificador\" est "
            +"on est.iddetalleclasificador=seg.idestado and est.estado=1 "
            +"where seg.registroactivo=1 and seg.codigoseguridad=:codigoseguridadSeleccionado and seg.gestion=:gestionSeleccionado ",
            resultClass = SeguimientoVo.class),
    @NamedNativeQuery(name = "Seguimiento.convierteACodigoSeguridad", query
           ="select (\"SarcoWeb\".get_decimal_a_base(:gestionSeleccionado, 19))||(\"SarcoWeb\".get_decimal_a_base(:hojarutaSeleccionado, 19)) codigoSeguridad ",
            resultClass = ConvierteBaseVo.class)
})

public class Seguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idseguimiento")
    private Long idseguimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingreso;
    @Size(max = 500)
    @Column(name = "mensaje")
    private String mensaje;
    @Column(name = "hojaruta")
    private BigInteger hojaruta;
    @Column(name = "gestion")
    private BigInteger gestion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    @Column(name = "usuarioregistro")
    private BigInteger usuarioregistro;
    @Size(max = 500)
    @Column(name = "descripcionhojaruta")
    private String descripcionhojaruta;
    @Basic(optional = false)
    @Size(min = 1, max = 500)
    @Column(name = "codigoseguridad")
    private String codigoseguridad;
    @Column(name = "registroactivo")
    private Integer registroactivo;
    @JoinColumn(name = "idarea", referencedColumnName = "iddetalleclasificador")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Detalleclasificador idarea;
    @JoinColumn(name = "idestado", referencedColumnName = "iddetalleclasificador")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Detalleclasificador idestado;
    @JoinColumn(name = "iddocumento", referencedColumnName = "iddocumento")
    @ManyToOne(fetch = FetchType.LAZY)
    private Documento iddocumento;

    public Seguimiento() {
    }

    public Seguimiento(Long idseguimiento) {
        this.idseguimiento = idseguimiento;
    }

    public Seguimiento(Long idseguimiento, Date fechaingreso, Date fecharegistro, String codigoseguridad) {
        this.idseguimiento = idseguimiento;
        this.fechaingreso = fechaingreso;
        this.fecharegistro = fecharegistro;
        this.codigoseguridad = codigoseguridad;
    }

    public Long getIdseguimiento() {
        return idseguimiento;
    }

    public void setIdseguimiento(Long idseguimiento) {
        this.idseguimiento = idseguimiento;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public BigInteger getHojaruta() {
        return hojaruta;
    }

    public void setHojaruta(BigInteger hojaruta) {
        this.hojaruta = hojaruta;
    }

    public BigInteger getGestion() {
        return gestion;
    }

    public void setGestion(BigInteger gestion) {
        this.gestion = gestion;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public BigInteger getUsuarioregistro() {
        return usuarioregistro;
    }

    public void setUsuarioregistro(BigInteger usuarioregistro) {
        this.usuarioregistro = usuarioregistro;
    }

    public String getDescripcionhojaruta() {
        return descripcionhojaruta;
    }

    public void setDescripcionhojaruta(String descripcionhojaruta) {
        this.descripcionhojaruta = descripcionhojaruta;
    }

    public String getCodigoseguridad() {
        return codigoseguridad;
    }

    public void setCodigoseguridad(String codigoseguridad) {
        this.codigoseguridad = codigoseguridad;
    }

    public Integer getRegistroactivo() {
        return registroactivo;
    }

    public void setRegistroactivo(Integer registroactivo) {
        this.registroactivo = registroactivo;
    }

    public Detalleclasificador getIdarea() {
        return idarea;
    }

    public void setIdarea(Detalleclasificador idarea) {
        this.idarea = idarea;
    }

    public Detalleclasificador getIdestado() {
        return idestado;
    }

    public void setIdestado(Detalleclasificador idestado) {
        this.idestado = idestado;
    }

    public Documento getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(Documento iddocumento) {
        this.iddocumento = iddocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idseguimiento != null ? idseguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.idseguimiento == null && other.idseguimiento != null) || (this.idseguimiento != null && !this.idseguimiento.equals(other.idseguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.gob.senasir.sarcoweb.model.Seguimiento[ idseguimiento=" + idseguimiento + " ]";
    }
    
}
