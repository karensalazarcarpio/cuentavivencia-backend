package bo.gob.senasir.cuentavivencia.services.impl;

import bo.gob.senasir.cuentavivencia.constantes.CuentaVivenciaConstantes;
import bo.gob.senasir.cuentavivencia.model.CuentaVivencia;
import bo.gob.senasir.cuentavivencia.model.CuentaVivenciaDetalle;
import bo.gob.senasir.cuentavivencia.repositories.CuentaVivenciaRepository;
import bo.gob.senasir.cuentavivencia.vo.CuentaVivenciaVo;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import bo.gob.senasir.cuentavivencia.services.CuentaVivenciaService;
import bo.gob.senasir.seguridad.model.Archivosadjuntos;
import bo.gob.senasir.seguridad.services.ArchivosadjuntosService;
import bo.gob.senasir.seguridad.vo.SeguridadVo;
import java.io.InputStream;
import org.glassfish.jersey.media.multipart.ContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;

/**
 *
 * @author KSalazar
 */
@Service("cuentaVivenciaService")
@Transactional(readOnly = true)
public class CuentaVivenciaServiceImpl implements CuentaVivenciaService {

    @Autowired
    private CuentaVivenciaRepository cuentaVivenciaRepository;
    @Autowired
    private ArchivosadjuntosService archivosadjuntosService;

    @Transactional
    private void crearRegistro(CuentaVivenciaVo cuentaVivenciaVo) {

        CuentaVivencia cuentaVivencia = new CuentaVivencia();
        cuentaVivencia.setFechaRegistro(new Date());
        cuentaVivencia.setGeoLatitud(cuentaVivenciaVo.getGeoLatitud());
        cuentaVivencia.setGeoLongitud(cuentaVivenciaVo.getGeoLongitud());

        cuentaVivencia.setIdArchivoAnversoCI(cuentaVivenciaVo.getIdArchivoAnversoCI());
        cuentaVivencia.setIdArchivoReversoCI(cuentaVivenciaVo.getIdArchivoReversoCI());
        cuentaVivencia.setIdArchivoVideo(cuentaVivenciaVo.getIdArchivoVideo());

        cuentaVivencia.setIdPersonaDH(cuentaVivenciaVo.getIdPersonaDH());
        cuentaVivencia.setIdPersonaTitular(cuentaVivenciaVo.getIdPersonaTitular());
        cuentaVivencia.setIdUsuario(cuentaVivenciaVo.getIdUsuario());
        cuentaVivencia.setOrigen(cuentaVivenciaVo.getOrigen());

        this.cuentaVivenciaRepository.save(cuentaVivencia);
    }

    @Transactional
    public void actualizarCuentaVigenciaDetInicial(Long idCuentaVivencia, Long idCuentaVivenciaDetInicial) {
        CuentaVivencia cuentaVivencia = this.cuentaVivenciaRepository.getOne(idCuentaVivencia);
        if (cuentaVivencia.getIdCuentaVivenciaDetInicial() == null) {
            cuentaVivencia.setIdCuentaVivenciaDetInicial(new CuentaVivenciaDetalle(idCuentaVivenciaDetInicial));
            this.cuentaVivenciaRepository.saveAndFlush(cuentaVivencia);
        }
    }

    @Transactional
    public void guardarCuentaVivencia(CuentaVivenciaVo cuentaVivenciaVo,
            FormDataBodyPart anversoCI, FormDataBodyPart reversoCI, FormDataBodyPart video) {

        InputStream fileInputStream = anversoCI.getEntityAs(InputStream.class);
        ContentDisposition fileMetaData = anversoCI.getContentDisposition();
        SeguridadVo seguridadVo = new SeguridadVo();
        seguridadVo.setUploadPathModulo(CuentaVivenciaConstantes.UPLOAD_PATH);
        seguridadVo.setDescripcion("CI Anverso");
        seguridadVo.setIdtipoadjunto(1L);//TODO

        Archivosadjuntos archivoCIAnverso = this.archivosadjuntosService.adjuntarArchivo(seguridadVo, fileInputStream, fileMetaData);

        fileInputStream = reversoCI.getEntityAs(InputStream.class);
        fileMetaData = reversoCI.getContentDisposition();
        seguridadVo.setDescripcion("CI Reverso");
        seguridadVo.setIdtipoadjunto(1L);//TODO
        Archivosadjuntos archivoCIReverso = this.archivosadjuntosService.adjuntarArchivo(seguridadVo, fileInputStream, fileMetaData);

        fileInputStream = video.getEntityAs(InputStream.class);
        fileMetaData = video.getContentDisposition();
        seguridadVo.setDescripcion("Video");
        seguridadVo.setIdtipoadjunto(1L);//TODO        
        Archivosadjuntos archivoVideo = this.archivosadjuntosService.adjuntarArchivo(seguridadVo, fileInputStream, fileMetaData);

        cuentaVivenciaVo.setIdArchivoAnversoCI(archivoCIAnverso.getIdarchivoadjunto());
        cuentaVivenciaVo.setIdArchivoReversoCI(archivoCIReverso.getIdarchivoadjunto());
        cuentaVivenciaVo.setIdArchivoVideo(archivoVideo.getIdarchivoadjunto());

        this.crearRegistro(cuentaVivenciaVo);

    }

}
