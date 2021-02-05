/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.referencial.model;

import bo.gob.senasir.referencial.vo.VistaPersonaPrestacionVo;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author KSalazar
 */
@Entity
@Table(name = "VistaTramitePlataforma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VistaTramitePlataforma.findAll", query = "SELECT v FROM VistaTramitePlataforma v")
    , @NamedQuery(name = "VistaTramitePlataforma.findByNup", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.nup = :nup")
    , @NamedQuery(name = "VistaTramitePlataforma.findByCua", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.cua = :cua")
    , @NamedQuery(name = "VistaTramitePlataforma.findByMatricula", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.matricula = :matricula")
    , @NamedQuery(name = "VistaTramitePlataforma.findByNub", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.nub = :nub")
    , @NamedQuery(name = "VistaTramitePlataforma.findByNumeroDocumento", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "VistaTramitePlataforma.findByComplementoSEGIP", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.complementoSEGIP = :complementoSEGIP")
    , @NamedQuery(name = "VistaTramitePlataforma.findByPrimerNombre", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.primerNombre = :primerNombre")
    , @NamedQuery(name = "VistaTramitePlataforma.findBySegundoNombre", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "VistaTramitePlataforma.findByPrimerApellido", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.primerApellido = :primerApellido")
    , @NamedQuery(name = "VistaTramitePlataforma.findBySegundoApellido", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "VistaTramitePlataforma.findByApellidoCasada", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.apellidoCasada = :apellidoCasada")
    , @NamedQuery(name = "VistaTramitePlataforma.findByFechaNacimiento", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "VistaTramitePlataforma.findByFechaFallecimiento", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.fechaFallecimiento = :fechaFallecimiento")
    , @NamedQuery(name = "VistaTramitePlataforma.findByCorreoElectronico", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.correoElectronico = :correoElectronico")
    , @NamedQuery(name = "VistaTramitePlataforma.findByCelular", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.celular = :celular")
    , @NamedQuery(name = "VistaTramitePlataforma.findByIdDocumento", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.idDocumento = :idDocumento")
    , @NamedQuery(name = "VistaTramitePlataforma.findByDocumento", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.documento = :documento")
    , @NamedQuery(name = "VistaTramitePlataforma.findByIdEntidadGestora", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.idEntidadGestora = :idEntidadGestora")
    , @NamedQuery(name = "VistaTramitePlataforma.findByEntidadGestora", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.entidadGestora = :entidadGestora")
    , @NamedQuery(name = "VistaTramitePlataforma.findByIdSexo", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.idSexo = :idSexo")
    , @NamedQuery(name = "VistaTramitePlataforma.findBySexo", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.sexo = :sexo")
    , @NamedQuery(name = "VistaTramitePlataforma.findByIdDocExpedicion", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.idDocExpedicion = :idDocExpedicion")
    , @NamedQuery(name = "VistaTramitePlataforma.findByDocExpedicion", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.docExpedicion = :docExpedicion")
    , @NamedQuery(name = "VistaTramitePlataforma.findByIdLocalidad", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.idLocalidad = :idLocalidad")
    , @NamedQuery(name = "VistaTramitePlataforma.findByNombreLocalidad", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.nombreLocalidad = :nombreLocalidad")
    , @NamedQuery(name = "VistaTramitePlataforma.findByIdGrupoBeneficio", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.idGrupoBeneficio = :idGrupoBeneficio")
    , @NamedQuery(name = "VistaTramitePlataforma.findByIdBeneficio", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.idBeneficio = :idBeneficio")
    , @NamedQuery(name = "VistaTramitePlataforma.findByIdSubBeneficio", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.idSubBeneficio = :idSubBeneficio")
    , @NamedQuery(name = "VistaTramitePlataforma.findByNombreSubBeneficio", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.nombreSubBeneficio = :nombreSubBeneficio")
    , @NamedQuery(name = "VistaTramitePlataforma.findByCodSector", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.codSector = :codSector")
    , @NamedQuery(name = "VistaTramitePlataforma.findBySector", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.sector = :sector")
    , @NamedQuery(name = "VistaTramitePlataforma.findByIdTipoTramite", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.idTipoTramite = :idTipoTramite")
    , @NamedQuery(name = "VistaTramitePlataforma.findByTipoTramite", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.tipoTramite = :tipoTramite")
    , @NamedQuery(name = "VistaTramitePlataforma.findByIdOficinaNotificacion", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.idOficinaNotificacion = :idOficinaNotificacion")
    , @NamedQuery(name = "VistaTramitePlataforma.findByOficinaNotificacion", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.oficinaNotificacion = :oficinaNotificacion")
    , @NamedQuery(name = "VistaTramitePlataforma.findByIdTramite", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.idTramite = :idTramite")
    , @NamedQuery(name = "VistaTramitePlataforma.findByIdEstadoTramite", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.idEstadoTramite = :idEstadoTramite")
    , @NamedQuery(name = "VistaTramitePlataforma.findByIdEstadoObjetoProceso", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.idEstadoObjetoProceso = :idEstadoObjetoProceso")
    , @NamedQuery(name = "VistaTramitePlataforma.findByDescripcionEstadoObjeto", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.descripcionEstadoObjeto = :descripcionEstadoObjeto")
    , @NamedQuery(name = "VistaTramitePlataforma.findByFechaInicioTramite", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.fechaInicioTramite = :fechaInicioTramite")
    , @NamedQuery(name = "VistaTramitePlataforma.findByIdOrigen", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.idOrigen = :idOrigen")
    , @NamedQuery(name = "VistaTramitePlataforma.findByNumeroTramiteCrenta", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.numeroTramiteCrenta = :numeroTramiteCrenta")
    , @NamedQuery(name = "VistaTramitePlataforma.findByTipoRelacion", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.tipoRelacion = :tipoRelacion")
    , @NamedQuery(name = "VistaTramitePlataforma.findByIdClaseRenta", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.idClaseRenta = :idClaseRenta")
    , @NamedQuery(name = "VistaTramitePlataforma.findByClaseRenta", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.claseRenta = :claseRenta")
    , @NamedQuery(name = "VistaTramitePlataforma.findByIdAreaDestino", query = "SELECT v FROM VistaTramitePlataforma v WHERE v.idAreaDestino = :idAreaDestino")})

public class VistaTramitePlataforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUP")
    private long nup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUA")
    private long cua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Matricula")
    private String matricula;
    @Column(name = "NUB")
    private BigInteger nub;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NumeroDocumento")
    private String numeroDocumento;
    @Size(max = 5)
    @Column(name = "ComplementoSEGIP")
    private String complementoSEGIP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PrimerNombre")
    private String primerNombre;
    @Size(max = 50)
    @Column(name = "SegundoNombre")
    private String segundoNombre;
    @Size(max = 50)
    @Column(name = "PrimerApellido")
    private String primerApellido;
    @Size(max = 50)
    @Column(name = "SegundoApellido")
    private String segundoApellido;
    @Size(max = 50)
    @Column(name = "ApellidoCasada")
    private String apellidoCasada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "FechaFallecimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaFallecimiento;
    @Size(max = 50)
    @Column(name = "CorreoElectronico")
    private String correoElectronico;
    @Size(max = 15)
    @Column(name = "Celular")
    private String celular;
    @Column(name = "idDocumento")
    private Integer idDocumento;
    @Size(max = 500)
    @Column(name = "Documento")
    private String documento;
    @Column(name = "IdEntidadGestora")
    private Integer idEntidadGestora;
    @Size(max = 500)
    @Column(name = "EntidadGestora")
    private String entidadGestora;
    @Column(name = "IdSexo")
    private Integer idSexo;
    @Size(max = 500)
    @Column(name = "Sexo")
    private String sexo;
    @Column(name = "IdDocExpedicion")
    private Integer idDocExpedicion;
    @Size(max = 500)
    @Column(name = "DocExpedicion")
    private String docExpedicion;
    @Column(name = "IdLocalidad")
    private Integer idLocalidad;
    @Size(max = 50)
    @Column(name = "NombreLocalidad")
    private String nombreLocalidad;
    @Column(name = "IdGrupoBeneficio")
    private Integer idGrupoBeneficio;
    @Column(name = "IdBeneficio")
    private Integer idBeneficio;
    @Column(name = "IdSubBeneficio")
    private Integer idSubBeneficio;
    @Size(max = 50)
    @Column(name = "NombreSubBeneficio")
    private String nombreSubBeneficio;
    @Size(max = 2)
    @Column(name = "codSector")
    private String codSector;
    @Size(max = 20)
    @Column(name = "Sector")
    private String sector;
    @Column(name = "IdTipoTramite")
    private Integer idTipoTramite;
    @Size(max = 500)
    @Column(name = "TipoTramite")
    private String tipoTramite;
    @Column(name = "IdOficinaNotificacion")
    private Integer idOficinaNotificacion;
    @Size(max = 50)
    @Column(name = "OficinaNotificacion")
    private String oficinaNotificacion;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdTramite")
    private Long idTramite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdEstadoTramite")
    private int idEstadoTramite;
    @Column(name = "IdEstadoObjetoProceso")
    private Integer idEstadoObjetoProceso;
    @Size(max = 100)
    @Column(name = "DescripcionEstadoObjeto")
    private String descripcionEstadoObjeto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaInicioTramite")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicioTramite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdOrigen")
    private int idOrigen;
    @Size(max = 30)
    @Column(name = "NumeroTramiteCrenta")
    private String numeroTramiteCrenta;
    @Size(max = 500)
    @Column(name = "tipoRelacion")
    private String tipoRelacion;
    @Column(name = "IdClaseRenta")
    private Integer idClaseRenta;
    @Size(max = 500)
    @Column(name = "ClaseRenta")
    private String claseRenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdAreaDestino")
    private int idAreaDestino;

    public VistaTramitePlataforma() {
    }

    public VistaTramitePlataforma(Long idTramite) {
        this.idTramite = idTramite;
    }

    public VistaTramitePlataforma(Long idTramite, long nup, long cua, String matricula, String numeroDocumento, String primerNombre, Date fechaNacimiento, int idEstadoTramite, Date fechaInicioTramite, int idOrigen, int idAreaDestino) {
        this.idTramite = idTramite;
        this.nup = nup;
        this.cua = cua;
        this.matricula = matricula;
        this.numeroDocumento = numeroDocumento;
        this.primerNombre = primerNombre;
        this.fechaNacimiento = fechaNacimiento;
        this.idEstadoTramite = idEstadoTramite;
        this.fechaInicioTramite = fechaInicioTramite;
        this.idOrigen = idOrigen;
        this.idAreaDestino = idAreaDestino;
    }

    public long getNup() {
        return nup;
    }

    public void setNup(long nup) {
        this.nup = nup;
    }

    public long getCua() {
        return cua;
    }

    public void setCua(long cua) {
        this.cua = cua;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public BigInteger getNub() {
        return nub;
    }

    public void setNub(BigInteger nub) {
        this.nub = nub;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getComplementoSEGIP() {
        return complementoSEGIP;
    }

    public void setComplementoSEGIP(String complementoSEGIP) {
        this.complementoSEGIP = complementoSEGIP;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getApellidoCasada() {
        return apellidoCasada;
    }

    public void setApellidoCasada(String apellidoCasada) {
        this.apellidoCasada = apellidoCasada;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Date fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getIdEntidadGestora() {
        return idEntidadGestora;
    }

    public void setIdEntidadGestora(Integer idEntidadGestora) {
        this.idEntidadGestora = idEntidadGestora;
    }

    public String getEntidadGestora() {
        return entidadGestora;
    }

    public void setEntidadGestora(String entidadGestora) {
        this.entidadGestora = entidadGestora;
    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getIdDocExpedicion() {
        return idDocExpedicion;
    }

    public void setIdDocExpedicion(Integer idDocExpedicion) {
        this.idDocExpedicion = idDocExpedicion;
    }

    public String getDocExpedicion() {
        return docExpedicion;
    }

    public void setDocExpedicion(String docExpedicion) {
        this.docExpedicion = docExpedicion;
    }

    public Integer getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }

    public Integer getIdGrupoBeneficio() {
        return idGrupoBeneficio;
    }

    public void setIdGrupoBeneficio(Integer idGrupoBeneficio) {
        this.idGrupoBeneficio = idGrupoBeneficio;
    }

    public Integer getIdBeneficio() {
        return idBeneficio;
    }

    public void setIdBeneficio(Integer idBeneficio) {
        this.idBeneficio = idBeneficio;
    }

    public Integer getIdSubBeneficio() {
        return idSubBeneficio;
    }

    public void setIdSubBeneficio(Integer idSubBeneficio) {
        this.idSubBeneficio = idSubBeneficio;
    }

    public String getNombreSubBeneficio() {
        return nombreSubBeneficio;
    }

    public void setNombreSubBeneficio(String nombreSubBeneficio) {
        this.nombreSubBeneficio = nombreSubBeneficio;
    }

    public String getCodSector() {
        return codSector;
    }

    public void setCodSector(String codSector) {
        this.codSector = codSector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Integer getIdTipoTramite() {
        return idTipoTramite;
    }

    public void setIdTipoTramite(Integer idTipoTramite) {
        this.idTipoTramite = idTipoTramite;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public Integer getIdOficinaNotificacion() {
        return idOficinaNotificacion;
    }

    public void setIdOficinaNotificacion(Integer idOficinaNotificacion) {
        this.idOficinaNotificacion = idOficinaNotificacion;
    }

    public String getOficinaNotificacion() {
        return oficinaNotificacion;
    }

    public void setOficinaNotificacion(String oficinaNotificacion) {
        this.oficinaNotificacion = oficinaNotificacion;
    }

    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }

    public int getIdEstadoTramite() {
        return idEstadoTramite;
    }

    public void setIdEstadoTramite(int idEstadoTramite) {
        this.idEstadoTramite = idEstadoTramite;
    }

    public Integer getIdEstadoObjetoProceso() {
        return idEstadoObjetoProceso;
    }

    public void setIdEstadoObjetoProceso(Integer idEstadoObjetoProceso) {
        this.idEstadoObjetoProceso = idEstadoObjetoProceso;
    }

    public String getDescripcionEstadoObjeto() {
        return descripcionEstadoObjeto;
    }

    public void setDescripcionEstadoObjeto(String descripcionEstadoObjeto) {
        this.descripcionEstadoObjeto = descripcionEstadoObjeto;
    }

    public Date getFechaInicioTramite() {
        return fechaInicioTramite;
    }

    public void setFechaInicioTramite(Date fechaInicioTramite) {
        this.fechaInicioTramite = fechaInicioTramite;
    }

    public int getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(int idOrigen) {
        this.idOrigen = idOrigen;
    }

    public String getNumeroTramiteCrenta() {
        return numeroTramiteCrenta;
    }

    public void setNumeroTramiteCrenta(String numeroTramiteCrenta) {
        this.numeroTramiteCrenta = numeroTramiteCrenta;
    }

    public String getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }

    public Integer getIdClaseRenta() {
        return idClaseRenta;
    }

    public void setIdClaseRenta(Integer idClaseRenta) {
        this.idClaseRenta = idClaseRenta;
    }

    public String getClaseRenta() {
        return claseRenta;
    }

    public void setClaseRenta(String claseRenta) {
        this.claseRenta = claseRenta;
    }

    public int getIdAreaDestino() {
        return idAreaDestino;
    }

    public void setIdAreaDestino(int idAreaDestino) {
        this.idAreaDestino = idAreaDestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTramite != null ? idTramite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VistaTramitePlataforma)) {
            return false;
        }
        VistaTramitePlataforma other = (VistaTramitePlataforma) object;
        if ((this.idTramite == null && other.idTramite != null) || (this.idTramite != null && !this.idTramite.equals(other.idTramite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.gob.senasir.referencial.model.VistaTramitePlataforma[ idTramite=" + idTramite + " ]";
    }
    
}
