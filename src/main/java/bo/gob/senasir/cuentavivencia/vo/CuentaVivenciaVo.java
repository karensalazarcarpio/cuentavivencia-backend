package bo.gob.senasir.cuentavivencia.vo;

import java.math.BigInteger;

/**
 *
 * @author KSalazar
 */
public class CuentaVivenciaVo {

    private String geoLatitud;
    private String geoLongitud;
    private Long idPersonaDH;
    private Long idPersonaTitular;
    private Long idCuentaVivencia;
    private BigInteger idUsuario;
    private String origen;
    private String token;
    private String correoContacto;
    private String telefonoContacto;
    private Double margenInferior;
    private Double margenSuperior;
    private Long idArchivoSelphi;
    private Long idArchivoVideo;
    private Long idArchivoAnversoCI;
    private Long idArchivoReversoCI;

    public String getGeoLatitud() {
        return geoLatitud;
    }

    public void setGeoLatitud(String geoLatitud) {
        this.geoLatitud = geoLatitud;
    }

    public String getGeoLongitud() {
        return geoLongitud;
    }

    public void setGeoLongitud(String geoLongitud) {
        this.geoLongitud = geoLongitud;
    }

    public Long getIdPersonaDH() {
        return idPersonaDH;
    }

    public void setIdPersonaDH(Long idPersonaDH) {
        this.idPersonaDH = idPersonaDH;
    }

    public Long getIdPersonaTitular() {
        return idPersonaTitular;
    }

    public void setIdPersonaTitular(Long idPersonaTitular) {
        this.idPersonaTitular = idPersonaTitular;
    }

    public Long getIdCuentaVivencia() {
        return idCuentaVivencia;
    }

    public void setIdCuentaVivencia(Long idCuentaVivencia) {
        this.idCuentaVivencia = idCuentaVivencia;
    }

    public BigInteger getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigInteger idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public Double getMargenInferior() {
        return margenInferior;
    }

    public void setMargenInferior(Double margenInferior) {
        this.margenInferior = margenInferior;
    }

    public Double getMargenSuperior() {
        return margenSuperior;
    }

    public void setMargenSuperior(Double margenSuperior) {
        this.margenSuperior = margenSuperior;
    }

    public Long getIdArchivoSelphi() {
        return idArchivoSelphi;
    }

    public void setIdArchivoSelphi(Long idArchivoSelphi) {
        this.idArchivoSelphi = idArchivoSelphi;
    }

    public Long getIdArchivoVideo() {
        return idArchivoVideo;
    }

    public void setIdArchivoVideo(Long idArchivoVideo) {
        this.idArchivoVideo = idArchivoVideo;
    }

    public Long getIdArchivoAnversoCI() {
        return idArchivoAnversoCI;
    }

    public void setIdArchivoAnversoCI(Long idArchivoAnversoCI) {
        this.idArchivoAnversoCI = idArchivoAnversoCI;
    }

    public Long getIdArchivoReversoCI() {
        return idArchivoReversoCI;
    }

    public void setIdArchivoReversoCI(Long idArchivoReversoCI) {
        this.idArchivoReversoCI = idArchivoReversoCI;
    }

    @Override
    public String toString() {
        return "CuentaVivenciaVo{" + "geoLatitud=" + geoLatitud + ", geoLongitud=" + geoLongitud + ", idPersonaDH=" + idPersonaDH + ", idPersonaTitular=" + idPersonaTitular + ", idCuentaVivencia=" + idCuentaVivencia + ", idUsuario=" + idUsuario + ", origen=" + origen + ", token=" + token + ", margenInferior=" + margenInferior + ", margenSuperior=" + margenSuperior + ", idArchivoSelphi=" + idArchivoSelphi + ", idArchivoVideo=" + idArchivoVideo + ", idArchivoAnversoCI=" + idArchivoAnversoCI + ", idArchivoReversoCI=" + idArchivoReversoCI + '}';
    }

}
