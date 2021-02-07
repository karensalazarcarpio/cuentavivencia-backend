package bo.gob.senasir.cuentavivencia.model;

import bo.gob.senasir.cuentavivencia.vo.CuentaVivenciaAux;
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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
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
 * @author Pedrito
 */
@Entity
@Table(name = "\"CuentaVivencia\"", catalog = "\"Plataforma\"", schema = "\"Servicios\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaVivencia.findAll", query = "SELECT c FROM CuentaVivencia c")
    , @NamedQuery(name = "CuentaVivencia.findByIdCuentaVivencia", query = "SELECT c FROM CuentaVivencia c WHERE c.idCuentaVivencia = :idCuentaVivencia")
    , @NamedQuery(name = "CuentaVivencia.findByIdPersonaTitular", query = "SELECT c FROM CuentaVivencia c WHERE c.idPersonaTitular = :idPersonaTitular")
    , @NamedQuery(name = "CuentaVivencia.findByIdPersonaDH", query = "SELECT c FROM CuentaVivencia c WHERE c.idPersonaDH = :idPersonaDH")
    , @NamedQuery(name = "CuentaVivencia.findByFechaRegistro", query = "SELECT c FROM CuentaVivencia c WHERE c.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "CuentaVivencia.findByIdArchivoAnversoCI", query = "SELECT c FROM CuentaVivencia c WHERE c.idArchivoAnversoCI = :idArchivoAnversoCI")
    , @NamedQuery(name = "CuentaVivencia.findByIdArchivoReversoCI", query = "SELECT c FROM CuentaVivencia c WHERE c.idArchivoReversoCI = :idArchivoReversoCI")
    , @NamedQuery(name = "CuentaVivencia.findByGeoLatitud", query = "SELECT c FROM CuentaVivencia c WHERE c.geoLatitud = :geoLatitud")
    , @NamedQuery(name = "CuentaVivencia.findByOrigen", query = "SELECT c FROM CuentaVivencia c WHERE c.origen = :origen")
    , @NamedQuery(name = "CuentaVivencia.findByIdUsuario", query = "SELECT c FROM CuentaVivencia c WHERE c.idUsuario = :idUsuario")
    , @NamedQuery(name = "CuentaVivencia.findByGeoLongitud", query = "SELECT c FROM CuentaVivencia c WHERE c.geoLongitud = :geoLongitud")
    , @NamedQuery(name = "CuentaVivencia.findByIdArchivoVideo", query = "SELECT c FROM CuentaVivencia c WHERE c.idArchivoVideo = :idArchivoVideo")})
@NamedNativeQueries({
    @NamedNativeQuery(name = "CuentaVivencia.obtCuentaVivenciaPorPersona", query
            = "SELECT a.\"idCuentaVivencia\" "
            + "  FROM \"Servicios\".\"CuentaVivencia\" a "
            + " WHERE a.\"idPersonaTitular\" = :idPersonaTitular "
            + " AND CAST(COALESCE (a.\"idPersonaDH\",-1) AS BIGINT) = COALESCE(CAST(CAST(:idPersonaDH AS TEXT) AS BIGINT),-1)",
            resultClass = CuentaVivenciaAux.class)
})
public class CuentaVivencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "\"idCuentaVivencia\"", nullable = false)
    private Long idCuentaVivencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"idPersonaTitular\"", nullable = false)
    private Long idPersonaTitular;
    @Column(name = "\"idPersonaDH\"")
    private Long idPersonaDH;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"fechaRegistro\"", nullable = false)    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"idArchivoAnversoCI\"", nullable = false)
    private long idArchivoAnversoCI;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"idArchivoReversoCI\"", nullable = false)
    private long idArchivoReversoCI;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "\"geoLatitud\"", nullable = false, length = 255)
    private String geoLatitud;
    @Size(max = 20)
    @Column(name = "origen", length = 20)
    private String origen;
    @Column(name = "\"idUsuario\"")
    private BigInteger idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "\"geoLongitud\"", nullable = false, length = 255)
    private String geoLongitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"idArchivoVideo\"", nullable = false)
    private long idArchivoVideo;
    @Size(max = 20)
    @Column(name = "\"telefonoContacto\"", length = 20)
    private String telefonoContacto;
    @Size(max = 100)
    @Column(name = "\"correoContacto\"", length = 100)
    private String correoContacto;
    @JoinColumn(name = "\"idCuentaVivenciaDetInicial\"", referencedColumnName = "\"idCuentaVivenciaDet\"")
    @ManyToOne(fetch = FetchType.LAZY)
    private CuentaVivenciaDetalle idCuentaVivenciaDetInicial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCuentaVivencia", fetch = FetchType.LAZY)
    private List<CuentaVivenciaDetalle> cuentaVivenciaDetalleList;

    public CuentaVivencia() {
    }

    public CuentaVivencia(Long idCuentaVivencia) {
        this.idCuentaVivencia = idCuentaVivencia;
    }

    public CuentaVivencia(Long idCuentaVivencia, long idPersonaTitular, Date fechaRegistro, long idArchivoAnversoCI, long idArchivoReversoCI, String geoLatitud, String geoLongitud, long idArchivoVideo) {
        this.idCuentaVivencia = idCuentaVivencia;
        this.idPersonaTitular = idPersonaTitular;
        this.fechaRegistro = fechaRegistro;
        this.idArchivoAnversoCI = idArchivoAnversoCI;
        this.idArchivoReversoCI = idArchivoReversoCI;
        this.geoLatitud = geoLatitud;
        this.geoLongitud = geoLongitud;
        this.idArchivoVideo = idArchivoVideo;
    }

    public Long getIdCuentaVivencia() {
        return idCuentaVivencia;
    }

    public void setIdCuentaVivencia(Long idCuentaVivencia) {
        this.idCuentaVivencia = idCuentaVivencia;
    }

    public Long getIdPersonaTitular() {
        return idPersonaTitular;
    }

    public void setIdPersonaTitular(Long idPersonaTitular) {
        this.idPersonaTitular = idPersonaTitular;
    }

    public Long getIdPersonaDH() {
        return idPersonaDH;
    }

    public void setIdPersonaDH(Long idPersonaDH) {
        this.idPersonaDH = idPersonaDH;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public long getIdArchivoAnversoCI() {
        return idArchivoAnversoCI;
    }

    public void setIdArchivoAnversoCI(long idArchivoAnversoCI) {
        this.idArchivoAnversoCI = idArchivoAnversoCI;
    }

    public long getIdArchivoReversoCI() {
        return idArchivoReversoCI;
    }

    public void setIdArchivoReversoCI(long idArchivoReversoCI) {
        this.idArchivoReversoCI = idArchivoReversoCI;
    }

    public String getGeoLatitud() {
        return geoLatitud;
    }

    public void setGeoLatitud(String geoLatitud) {
        this.geoLatitud = geoLatitud;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public BigInteger getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigInteger idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getGeoLongitud() {
        return geoLongitud;
    }

    public void setGeoLongitud(String geoLongitud) {
        this.geoLongitud = geoLongitud;
    }

    public long getIdArchivoVideo() {
        return idArchivoVideo;
    }

    public void setIdArchivoVideo(long idArchivoVideo) {
        this.idArchivoVideo = idArchivoVideo;
    }

    public CuentaVivenciaDetalle getIdCuentaVivenciaDetInicial() {
        return idCuentaVivenciaDetInicial;
    }

    public void setIdCuentaVivenciaDetInicial(CuentaVivenciaDetalle idCuentaVivenciaDetInicial) {
        this.idCuentaVivenciaDetInicial = idCuentaVivenciaDetInicial;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

    @XmlTransient
    public List<CuentaVivenciaDetalle> getCuentaVivenciaDetalleList() {
        return cuentaVivenciaDetalleList;
    }

    public void setCuentaVivenciaDetalleList(List<CuentaVivenciaDetalle> cuentaVivenciaDetalleList) {
        this.cuentaVivenciaDetalleList = cuentaVivenciaDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuentaVivencia != null ? idCuentaVivencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaVivencia)) {
            return false;
        }
        CuentaVivencia other = (CuentaVivencia) object;
        if ((this.idCuentaVivencia == null && other.idCuentaVivencia != null) || (this.idCuentaVivencia != null && !this.idCuentaVivencia.equals(other.idCuentaVivencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.gob.senasir.cuentavivencia.model.CuentaVivencia[ idCuentaVivencia=" + idCuentaVivencia + " ]";
    }

}
