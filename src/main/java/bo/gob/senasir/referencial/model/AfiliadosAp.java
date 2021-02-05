/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.referencial.model;

import bo.gob.senasir.referencial.vo.VistaPersonaPrestacionVo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
@Table(name = "AFILIADOS_AP", catalog = "Plataforma", schema = "Referencial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AfiliadosAp.findAll", query = "SELECT a FROM AfiliadosAp a")
    , @NamedQuery(name = "AfiliadosAp.findByCodAfp", query = "SELECT a FROM AfiliadosAp a WHERE a.codAfp = :codAfp")
    , @NamedQuery(name = "AfiliadosAp.findByNua", query = "SELECT a FROM AfiliadosAp a WHERE a.nua = :nua")
    , @NamedQuery(name = "AfiliadosAp.findByFecNacimiento", query = "SELECT a FROM AfiliadosAp a WHERE a.fecNacimiento = :fecNacimiento")
    , @NamedQuery(name = "AfiliadosAp.findByTipIdentificacion", query = "SELECT a FROM AfiliadosAp a WHERE a.tipIdentificacion = :tipIdentificacion")
    , @NamedQuery(name = "AfiliadosAp.findByNumIdentificacion", query = "SELECT a FROM AfiliadosAp a WHERE a.numIdentificacion = :numIdentificacion")
    , @NamedQuery(name = "AfiliadosAp.findByPrimerApellido", query = "SELECT a FROM AfiliadosAp a WHERE a.primerApellido = :primerApellido")
    , @NamedQuery(name = "AfiliadosAp.findBySegundoApellido", query = "SELECT a FROM AfiliadosAp a WHERE a.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "AfiliadosAp.findByPrimerNombre", query = "SELECT a FROM AfiliadosAp a WHERE a.primerNombre = :primerNombre")
    , @NamedQuery(name = "AfiliadosAp.findBySegundoNombre", query = "SELECT a FROM AfiliadosAp a WHERE a.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "AfiliadosAp.findByApellidoConyugue", query = "SELECT a FROM AfiliadosAp a WHERE a.apellidoConyugue = :apellidoConyugue")
    , @NamedQuery(name = "AfiliadosAp.findByFechaCreacion", query = "SELECT a FROM AfiliadosAp a WHERE a.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "AfiliadosAp.findByComplemento", query = "SELECT a FROM AfiliadosAp a WHERE a.complemento = :complemento")})



@NamedNativeQueries({
        @NamedNativeQuery(name = "AfiliadosAp.obtAfiliado", query
            = "select 0 \"idPersona\", " 
            + "COALESCE(ap.\"PRIMER_NOMBRE\",'') ||' '|| COALESCE(ap.\"SEGUNDO_NOMBRE\",'') ||' '|| COALESCE(ap.\"PRIMER_APELLIDO\",'') ||' '|| COALESCE(ap.\"SEGUNDO_APELLIDO\",'') nombrecompleto, " 
            + "ap.\"NUM_IDENTIFICACION\" cedula, " 
            + "COALESCE(ap.\"PRIMER_NOMBRE\",'') ||' '|| COALESCE(ap.\"SEGUNDO_NOMBRE\",'') nombres, " 
            + "ap.\"PRIMER_APELLIDO\" paterno, " 
            + "ap.\"SEGUNDO_APELLIDO\" materno " 
            + "from \"Referencial\".\"AFILIADOS_AP\" ap " 
            + "where ap.\"NUM_IDENTIFICACION\"=:cedula and COALESCE(ap.\"COMPLEMENTO\",'')= COALESCE(:complemento,'') " 
            + "AND 1= CASE WHEN (ap.\"NUM_IDENTIFICACION\"~ '^\\d+(\\.\\d+)?$') = 't' then 1 else 0 end  ",

            resultClass = VistaPersonaPrestacionVo.class)
 
})
public class AfiliadosAp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    
    @Size(min = 1, max = 50)
    @Column(name = "COD_AFP")
    private String codAfp;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NUA")
    private String nua;
    @Column(name = "FEC_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecNacimiento;
    @Size(max = 50)
    @Column(name = "TIP_IDENTIFICACION")
    private String tipIdentificacion;
    @Size(max = 50)
    @Column(name = "NUM_IDENTIFICACION")
    private String numIdentificacion;
    @Size(max = 50)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Size(max = 50)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Size(max = 50)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Size(max = 50)
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Size(max = 50)
    @Column(name = "APELLIDO_CONYUGUE")
    private String apellidoConyugue;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Size(max = 5)
    @Column(name = "COMPLEMENTO")
    private String complemento;

    public AfiliadosAp() {
    }

   
    
    public AfiliadosAp(String nua) {
        this.nua = nua;
    }

    public AfiliadosAp(String nua, String codAfp) {
        this.nua = nua;
        this.codAfp = codAfp;
    }

    public String getCodAfp() {
        return codAfp;
    }

    public void setCodAfp(String codAfp) {
        this.codAfp = codAfp;
    }

    public String getNua() {
        return nua;
    }

    public void setNua(String nua) {
        this.nua = nua;
    }

    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public String getTipIdentificacion() {
        return tipIdentificacion;
    }

    public void setTipIdentificacion(String tipIdentificacion) {
        this.tipIdentificacion = tipIdentificacion;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
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

    public String getApellidoConyugue() {
        return apellidoConyugue;
    }

    public void setApellidoConyugue(String apellidoConyugue) {
        this.apellidoConyugue = apellidoConyugue;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nua != null ? nua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AfiliadosAp)) {
            return false;
        }
        AfiliadosAp other = (AfiliadosAp) object;
        if ((this.nua == null && other.nua != null) || (this.nua != null && !this.nua.equals(other.nua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.gob.senasir.referencial.model.AfiliadosAp[ nua=" + nua + " ]";
    }
    
}
