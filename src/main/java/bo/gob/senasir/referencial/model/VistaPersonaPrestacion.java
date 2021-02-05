/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.referencial.model;

import bo.gob.senasir.referencial.vo.VistaPersonaPrestacionVo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KSalazar
 */
@Entity
@Table(name = "VistaPersonaPrestacion", catalog = "Plataforma", schema = "Referencial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VistaPersonaPrestacion.findAll", query = "SELECT v FROM VistaPersonaPrestacion v")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByTipo", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.tipo = :tipo")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByPrestacion", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.prestacion = :prestacion")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByNupTitular", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.vistaPersonaPrestacionPK.nupTitular = :nupTitular")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByNupDH", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.vistaPersonaPrestacionPK.nupDH = :nupDH")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByMatricula", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.matricula = :matricula")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByApPaterno", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.apPaterno = :apPaterno")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByApMaterno", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.apMaterno = :apMaterno")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByApCasada", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.apCasada = :apCasada")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByPNombre", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.pNombre = :pNombre")
    , @NamedQuery(name = "VistaPersonaPrestacion.findBySNombre", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.sNombre = :sNombre")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByNombreCompleto", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.nombreCompleto = :nombreCompleto")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByNumeroDocumento", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByCodTipoDocumento", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.codTipoDocumento = :codTipoDocumento")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByTipoDocumento", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByCodigoComplementoCarnet", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.codigoComplementoCarnet = :codigoComplementoCarnet")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByCodExpedido", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.codExpedido = :codExpedido")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByExpedido", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.expedido = :expedido")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByNroIdentificacionExpedido", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.nroIdentificacionExpedido = :nroIdentificacionExpedido")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByCodSexo", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.codSexo = :codSexo")
    , @NamedQuery(name = "VistaPersonaPrestacion.findBySexo", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.sexo = :sexo")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByCodEstadoCivil", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.codEstadoCivil = :codEstadoCivil")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByEstadoCivil", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.estadoCivil = :estadoCivil")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByFechaNacimiento", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByFechaFallecimiento", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.fechaFallecimiento = :fechaFallecimiento")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByCelular", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.celular = :celular")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByCorreo", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.correo = :correo")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByCodBeneficioOtorgado", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.codBeneficioOtorgado = :codBeneficioOtorgado")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByBeneficioOtorgado", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.beneficioOtorgado = :beneficioOtorgado")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByCodEstadoBeneficio", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.codEstadoBeneficio = :codEstadoBeneficio")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByEstadoBeneficio", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.estadoBeneficio = :estadoBeneficio")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByCodSector", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.codSector = :codSector")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByPorcentaje", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.porcentaje = :porcentaje")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByIdBeneficioAsegurado", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.idBeneficioAsegurado = :idBeneficioAsegurado")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByIdRegional", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.idRegional = :idRegional")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByRegional", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.regional = :regional")
    , @NamedQuery(name = "VistaPersonaPrestacion.findBySector", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.sector = :sector")
    , @NamedQuery(name = "VistaPersonaPrestacion.findByMatriculaCausante", query = "SELECT v FROM VistaPersonaPrestacion v WHERE v.matriculaCausante = :matriculaCausante")})

@NamedNativeQueries({
    @NamedNativeQuery(name = "VistaPersonaPrestacion.obtAsegurado", query
            = "select vwper.\"NupTitular\" idPersona, "
            + "COALESCE(vwper.\"PNombre\",'') ||' '|| COALESCE(vwper.\"SNombre\",'') ||' '|| COALESCE(vwper.\"ApPaterno\",'') ||' '|| COALESCE(vwper.\"ApMaterno\",'') nombreCompleto, "
            + "vwper.\"NumeroDocumento\" || ' ' || COALESCE(vwper.\"CodigoComplementoCarnet\",'') cedula, "
            + "COALESCE(vwper.\"ApPaterno\",'') paterno, "
            + "COALESCE(vwper.\"ApMaterno\",'') materno, "
            + "COALESCE(vwper.\"PNombre\",'') ||' '|| COALESCE(vwper.\"SNombre\",'') nombres "
            + "from \"Referencial\".\"VistaPersonaPrestacion\" vwper "
            + "inner join \"Referencial\".\"VistaTramitePlataforma\" vwtra "
            + "on vwper.\"NupTitular\"=vwtra.\"NUP\" and vwper.\"NupDH\" ='0' "
            + "where vwper.\"NumeroDocumento\"=:cedula and COALESCE(vwper.\"CodigoComplementoCarnet\",'') = COALESCE(:complemento,'') "
            + "union "
            + "select  vwper.\"NupDH\" idPersona, "
            + "COALESCE(vwper.\"PNombre\",'') ||' '|| COALESCE(vwper.\"SNombre\",'') ||' '|| COALESCE(vwper.\"ApPaterno\",'') ||' '|| COALESCE(vwper.\"ApMaterno\",'') nombreCompleto, "
            + "vwper.\"NumeroDocumento\" || ' ' || COALESCE(vwper.\"CodigoComplementoCarnet\",'') cedula, "
            + "COALESCE(vwper.\"ApPaterno\",'') paterno, "
            + "COALESCE(vwper.\"ApMaterno\",'') materno, "
            + "COALESCE(vwper.\"PNombre\",'') ||' '|| COALESCE(vwper.\"SNombre\",'') nombres "
            + "from \"Referencial\".\"VistaPersonaPrestacion\" vwper "
            + "inner join \"Referencial\".\"VistaTramitePlataforma\" vwtra "
            + "on vwper.\"NupTitular\"=vwtra.\"NUP\" and vwper.\"NupDH\" !='0' "
            + "where vwper.\"NumeroDocumento\"=:cedula and COALESCE(vwper.\"CodigoComplementoCarnet\",'') = COALESCE(:complemento,'') "
            + "union "
            + "select vwtra.\"NUP\" idPersona, "
            + "COALESCE(vwtra.\"PrimerNombre\",'') ||' '|| COALESCE(vwtra.\"SegundoNombre\",'') ||' '|| COALESCE(vwtra.\"PrimerApellido\",'') ||' '|| COALESCE(vwtra.\"SegundoApellido\",'') nombreCompleto, "
            + "vwtra.\"NumeroDocumento\" || ' ' || COALESCE(vwtra.\"ComplementoSEGIP\",'') cedula, "
            + "COALESCE(vwtra.\"PrimerApellido\",'') paterno, "
            + "COALESCE(vwtra.\"SegundoApellido\",'') paterno, "
            + "COALESCE(vwtra.\"PrimerNombre\",'') ||' '|| COALESCE(vwtra.\"SegundoNombre\",'') nombres "
            + "from \"Referencial\".\"VistaTramitePlataforma\" vwtra "
            + "where vwtra.\"NumeroDocumento\"=:cedula and COALESCE(vwtra.\"ComplementoSEGIP\",'') = COALESCE(:complemento,'') ",
            
            resultClass = VistaPersonaPrestacionVo.class)
 
})

public class VistaPersonaPrestacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VistaPersonaPrestacionPK vistaPersonaPrestacionPK;
    @Size(max = 15)
    @Column(name = "Tipo", length = 15)
    private String tipo;
    @Size(max = 28)
    @Column(name = "Prestacion", length = 28)
    private String prestacion;
    @Size(max = 10)
    @Column(name = "Matricula", length = 10)
    private String matricula;
    @Size(max = 50)
    @Column(name = "ApPaterno", length = 50)
    private String apPaterno;
    @Size(max = 50)
    @Column(name = "ApMaterno", length = 50)
    private String apMaterno;
    @Size(max = 50)
    @Column(name = "ApCasada", length = 50)
    private String apCasada;
    @Size(max = 50)
    @Column(name = "PNombre", length = 50)
    private String pNombre;
    @Size(max = 50)
    @Column(name = "SNombre", length = 50)
    private String sNombre;
    @Size(max = 203)
    @Column(name = "NombreCompleto", length = 203)
    private String nombreCompleto;
    @Size(max = 20)
    @Column(name = "NumeroDocumento", length = 20)
    private String numeroDocumento;
    @Column(name = "CodTipoDocumento")
    private Integer codTipoDocumento;
    @Size(max = 500)
    @Column(name = "TipoDocumento", length = 500)
    private String tipoDocumento;
    @Size(max = 5)
    @Column(name = "CodigoComplementoCarnet", length = 5)
    private String codigoComplementoCarnet;
    @Column(name = "CodExpedido")
    private Integer codExpedido;
    @Size(max = 20)
    @Column(name = "Expedido", length = 20)
    private String expedido;
    @Size(max = 32)
    @Column(name = "NroIdentificacionExpedido", length = 32)
    private String nroIdentificacionExpedido;
    @Column(name = "CodSexo")
    private Integer codSexo;
    @Size(max = 500)
    @Column(name = "Sexo", length = 500)
    private String sexo;
    @Column(name = "CodEstadoCivil")
    private Integer codEstadoCivil;
    @Size(max = 500)
    @Column(name = "EstadoCivil", length = 500)
    private String estadoCivil;
    @Size(max = 10)
    @Column(name = "FechaNacimiento", length = 10)
    private String fechaNacimiento;
    @Size(max = 10)
    @Column(name = "FechaFallecimiento", length = 10)
    private String fechaFallecimiento;
    @Size(max = 15)
    @Column(name = "Celular", length = 15)
    private String celular;
    @Size(max = 50)
    @Column(name = "Correo", length = 50)
    private String correo;
    @Column(name = "CodBeneficioOtorgado")
    private Integer codBeneficioOtorgado;
    @Size(max = 50)
    @Column(name = "BeneficioOtorgado", length = 50)
    private String beneficioOtorgado;
    @Column(name = "CodEstadoBeneficio")
    private BigInteger codEstadoBeneficio;
    @Size(max = 500)
    @Column(name = "EstadoBeneficio", length = 500)
    private String estadoBeneficio;
    @Column(name = "CodSector")
    private Integer codSector;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Porcentaje", precision = 10, scale = 2)
    private BigDecimal porcentaje;
    @Column(name = "IdBeneficioAsegurado")
    private BigInteger idBeneficioAsegurado;
    @Column(name = "IdRegional")
    private Integer idRegional;
    @Size(max = 50)
    @Column(name = "Regional", length = 50)
    private String regional;
    @Size(max = 20)
    @Column(name = "Sector", length = 20)
    private String sector;
    @Size(max = 10)
    @Column(name = "MatriculaCausante", length = 10)
    private String matriculaCausante;

    public VistaPersonaPrestacion() {
    }

    public VistaPersonaPrestacion(VistaPersonaPrestacionPK vistaPersonaPrestacionPK) {
        this.vistaPersonaPrestacionPK = vistaPersonaPrestacionPK;
    }

    public VistaPersonaPrestacion(long nupTitular, long nupDH) {
        this.vistaPersonaPrestacionPK = new VistaPersonaPrestacionPK(nupTitular, nupDH);
    }

    public VistaPersonaPrestacionPK getVistaPersonaPrestacionPK() {
        return vistaPersonaPrestacionPK;
    }

    public void setVistaPersonaPrestacionPK(VistaPersonaPrestacionPK vistaPersonaPrestacionPK) {
        this.vistaPersonaPrestacionPK = vistaPersonaPrestacionPK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrestacion() {
        return prestacion;
    }

    public void setPrestacion(String prestacion) {
        this.prestacion = prestacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getApCasada() {
        return apCasada;
    }

    public void setApCasada(String apCasada) {
        this.apCasada = apCasada;
    }

    public String getPNombre() {
        return pNombre;
    }

    public void setPNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public String getSNombre() {
        return sNombre;
    }

    public void setSNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setCodTipoDocumento(Integer codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCodigoComplementoCarnet() {
        return codigoComplementoCarnet;
    }

    public void setCodigoComplementoCarnet(String codigoComplementoCarnet) {
        this.codigoComplementoCarnet = codigoComplementoCarnet;
    }

    public Integer getCodExpedido() {
        return codExpedido;
    }

    public void setCodExpedido(Integer codExpedido) {
        this.codExpedido = codExpedido;
    }

    public String getExpedido() {
        return expedido;
    }

    public void setExpedido(String expedido) {
        this.expedido = expedido;
    }

    public String getNroIdentificacionExpedido() {
        return nroIdentificacionExpedido;
    }

    public void setNroIdentificacionExpedido(String nroIdentificacionExpedido) {
        this.nroIdentificacionExpedido = nroIdentificacionExpedido;
    }

    public Integer getCodSexo() {
        return codSexo;
    }

    public void setCodSexo(Integer codSexo) {
        this.codSexo = codSexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getCodEstadoCivil() {
        return codEstadoCivil;
    }

    public void setCodEstadoCivil(Integer codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(String fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getCodBeneficioOtorgado() {
        return codBeneficioOtorgado;
    }

    public void setCodBeneficioOtorgado(Integer codBeneficioOtorgado) {
        this.codBeneficioOtorgado = codBeneficioOtorgado;
    }

    public String getBeneficioOtorgado() {
        return beneficioOtorgado;
    }

    public void setBeneficioOtorgado(String beneficioOtorgado) {
        this.beneficioOtorgado = beneficioOtorgado;
    }

    public BigInteger getCodEstadoBeneficio() {
        return codEstadoBeneficio;
    }

    public void setCodEstadoBeneficio(BigInteger codEstadoBeneficio) {
        this.codEstadoBeneficio = codEstadoBeneficio;
    }

    public String getEstadoBeneficio() {
        return estadoBeneficio;
    }

    public void setEstadoBeneficio(String estadoBeneficio) {
        this.estadoBeneficio = estadoBeneficio;
    }

    public Integer getCodSector() {
        return codSector;
    }

    public void setCodSector(Integer codSector) {
        this.codSector = codSector;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public BigInteger getIdBeneficioAsegurado() {
        return idBeneficioAsegurado;
    }

    public void setIdBeneficioAsegurado(BigInteger idBeneficioAsegurado) {
        this.idBeneficioAsegurado = idBeneficioAsegurado;
    }

    public Integer getIdRegional() {
        return idRegional;
    }

    public void setIdRegional(Integer idRegional) {
        this.idRegional = idRegional;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getMatriculaCausante() {
        return matriculaCausante;
    }

    public void setMatriculaCausante(String matriculaCausante) {
        this.matriculaCausante = matriculaCausante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vistaPersonaPrestacionPK != null ? vistaPersonaPrestacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VistaPersonaPrestacion)) {
            return false;
        }
        VistaPersonaPrestacion other = (VistaPersonaPrestacion) object;
        if ((this.vistaPersonaPrestacionPK == null && other.vistaPersonaPrestacionPK != null) || (this.vistaPersonaPrestacionPK != null && !this.vistaPersonaPrestacionPK.equals(other.vistaPersonaPrestacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.gob.senasir.referencial.model.VistaPersonaPrestacion[ vistaPersonaPrestacionPK=" + vistaPersonaPrestacionPK + " ]";
    }
    
}
