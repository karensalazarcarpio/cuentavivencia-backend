/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "referenciaremitente", catalog = "Plataforma", schema = "\"SarcoWeb\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referenciaremitente.findAll", query = "SELECT r FROM Referenciaremitente r")
    , @NamedQuery(name = "Referenciaremitente.findByIdreferenciaremitente", query = "SELECT r FROM Referenciaremitente r WHERE r.idreferenciaremitente = :idreferenciaremitente")
    , @NamedQuery(name = "Referenciaremitente.findByPaterno", query = "SELECT r FROM Referenciaremitente r WHERE r.paterno = :paterno")
    , @NamedQuery(name = "Referenciaremitente.findByMaterno", query = "SELECT r FROM Referenciaremitente r WHERE r.materno = :materno")
    , @NamedQuery(name = "Referenciaremitente.findByNombres", query = "SELECT r FROM Referenciaremitente r WHERE r.nombres = :nombres")
    , @NamedQuery(name = "Referenciaremitente.findByCedula", query = "SELECT r FROM Referenciaremitente r WHERE r.cedula = :cedula")
    , @NamedQuery(name = "Referenciaremitente.findByTelefono", query = "SELECT r FROM Referenciaremitente r WHERE r.telefono = :telefono")
    , @NamedQuery(name = "Referenciaremitente.findByDireccion", query = "SELECT r FROM Referenciaremitente r WHERE r.direccion = :direccion")
    , @NamedQuery(name = "Referenciaremitente.findByParentesco", query = "SELECT r FROM Referenciaremitente r WHERE r.parentesco = :parentesco")
    , @NamedQuery(name = "Referenciaremitente.findByCargo", query = "SELECT r FROM Referenciaremitente r WHERE r.cargo = :cargo")
    , @NamedQuery(name = "Referenciaremitente.findByComplemento", query = "SELECT r FROM Referenciaremitente r WHERE r.complemento = :complemento")})
public class Referenciaremitente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreferenciaremitente")
    private Long idreferenciaremitente;
    @Size(max = 50)
    @Column(name = "paterno")
    private String paterno;
    @Size(max = 50)
    @Column(name = "materno")
    private String materno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 20)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 50)
    @Column(name = "parentesco")
    private String parentesco;
    @Size(max = 50)
    @Column(name = "cargo")
    private String cargo;
    @Size(max = 5)
    @Column(name = "complemento")
    private String complemento;
    @OneToMany(mappedBy = "idreferenciaremitente", fetch = FetchType.LAZY)
    private List<Remitente> remitenteList;

    public Referenciaremitente() {
    }

    public Referenciaremitente(Long idreferenciaremitente) {
        this.idreferenciaremitente = idreferenciaremitente;
    }

    public Referenciaremitente(Long idreferenciaremitente, String nombres, String telefono) {
        this.idreferenciaremitente = idreferenciaremitente;
        this.nombres = nombres;
        this.telefono = telefono;
    }

    public Long getIdreferenciaremitente() {
        return idreferenciaremitente;
    }

    public void setIdreferenciaremitente(Long idreferenciaremitente) {
        this.idreferenciaremitente = idreferenciaremitente;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @XmlTransient
    public List<Remitente> getRemitenteList() {
        return remitenteList;
    }

    public void setRemitenteList(List<Remitente> remitenteList) {
        this.remitenteList = remitenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreferenciaremitente != null ? idreferenciaremitente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referenciaremitente)) {
            return false;
        }
        Referenciaremitente other = (Referenciaremitente) object;
        if ((this.idreferenciaremitente == null && other.idreferenciaremitente != null) || (this.idreferenciaremitente != null && !this.idreferenciaremitente.equals(other.idreferenciaremitente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.gob.senasir.sarcoweb.model.Referenciaremitente[ idreferenciaremitente=" + idreferenciaremitente + " ]";
    }
    
}
