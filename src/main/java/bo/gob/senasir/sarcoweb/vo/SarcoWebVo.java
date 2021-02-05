package bo.gob.senasir.sarcoweb.vo;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 *
 * @author KSalazar
 */
public class SarcoWebVo {

    //Documento
    private Long idDocumento;
    private Long iddestinatario;
    private String fechaDocumento;
    private Date fechaDocumentoDate;
    private String cite;
    private String referencia;
    private Long idDestinatario;
    private Long idRegional;
    private Long idTipoDocumento;
    private Long idOrigen;
    private Long idInstitucion;//IdEmpresa

    //private String referencia;
    //ReferenciaRemitente
    private Long idReferenciaRemitente;
    private String paterno;
    private String materno;
    private String nombres;
    private String cedula;
    private String telefono;
    private String direccion;
    private String parentesco;
    private String cargo;
    //Remitente
    private Long idRemitente;
    private String correo;
    private BigInteger idPersona;
    //DocumentoAdjunto
    private Long idTipoAdjunto;
    private String descripcion;
    private String esFirmaDigital;//S/N
    private String ruta;
    private String extension;
    private Boolean firmaDigital;
    private String crc;
    private String interesadoRemitente;
    
    public String getInteresadoRemitente() {
        return interesadoRemitente;
    }

    public void setInteresadoRemitente(String interesadoRemitente) {
        this.interesadoRemitente = interesadoRemitente;
    }
    

    private List<DocumentoAdjuntoVo> listaDocumentosAdjuntos;

    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Long getIddestinatario() {
        return iddestinatario;
    }

    public void setIddestinatario(Long iddestinatario) {
        this.iddestinatario = iddestinatario;
    }

    public Date getFechaDocumentoDate() {
        return fechaDocumentoDate;
    }

    public void setFechaDocumentoDate(Date fechaDocumentoDate) {
        this.fechaDocumentoDate = fechaDocumentoDate;
    }

    public Long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Long getIdRegional() {
        return idRegional;
    }

    public void setIdRegional(Long idRegional) {
        this.idRegional = idRegional;
    }

    public Long getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(Long idOrigen) {
        this.idOrigen = idOrigen;
    }

    public Long getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Long idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getCite() {
        return cite;
    }

    public void setCite(String cite) {
        this.cite = cite;
    }

    public String getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(String fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Long getIdRemitente() {
        return idRemitente;
    }

    public void setIdRemitente(Long idRemitente) {
        this.idRemitente = idRemitente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(Long idDestinatario) {
        this.idDestinatario = idDestinatario;
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

    public BigInteger getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(BigInteger idPersona) {
        this.idPersona = idPersona;
    }

    public Long getIdTipoAdjunto() {
        return idTipoAdjunto;
    }

    public void setIdTipoAdjunto(Long idTipoAdjunto) {
        this.idTipoAdjunto = idTipoAdjunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEsFirmaDigital() {
        return esFirmaDigital;
    }

    public void setEsFirmaDigital(String esFirmaDigital) {
        this.esFirmaDigital = esFirmaDigital;
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

    public Boolean getFirmaDigital() {
        return firmaDigital;
    }

    public void setFirmaDigital(Boolean firmaDigital) {
        this.firmaDigital = firmaDigital;
    }

    public String getCrc() {
        return crc;
    }

    public void setCrc(String crc) {
        this.crc = crc;
    }

    public Long getIdReferenciaRemitente() {
        return idReferenciaRemitente;
    }

    public void setIdReferenciaRemitente(Long idReferenciaRemitente) {
        this.idReferenciaRemitente = idReferenciaRemitente;
    }

    public List<DocumentoAdjuntoVo> getListaDocumentosAdjuntos() {
        return listaDocumentosAdjuntos;
    }

    public void setListaDocumentosAdjuntos(List<DocumentoAdjuntoVo> listaDocumentosAdjuntos) {
        this.listaDocumentosAdjuntos = listaDocumentosAdjuntos;
    }

}
