/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.sarcoweb.services.impl;

import bo.gob.senasir.sarcoweb.model.Detalleclasificador;
import bo.gob.senasir.sarcoweb.model.Documento;
import bo.gob.senasir.sarcoweb.model.Documentoadjunto;
import bo.gob.senasir.sarcoweb.repositories.DocumentoAdjuntoRepository;
import bo.gob.senasir.sarcoweb.services.DocumentoAdjuntoService;
import bo.gob.senasir.sarcoweb.util.MostrarMensajeError;
import bo.gob.senasir.sarcoweb.vo.DocumentoAdjuntoVo;
import bo.gob.senasir.sarcoweb.vo.SarcoWebVo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.DatatypeConverter;
import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.ContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author KAREN
 */
@Service("documentoAdjuntoService")
@Transactional(readOnly = true)
public class DocumentoAdjuntoServiceImpl implements DocumentoAdjuntoService {

    @Autowired
    private DocumentoAdjuntoRepository documentoAdjuntoRepository;

    public static final String UPLOAD_PATH = "//172.17.5.60/ImgWebSarco/";

    @Transactional
    public Documentoadjunto guardarDocumentoAdjunto(DocumentoAdjuntoVo documentoAdjuntoVo) {

        Documentoadjunto documentoadjunto = new Documentoadjunto();

        documentoadjunto.setDescripcion(documentoAdjuntoVo.getDescripcion());
        documentoadjunto.setNombrearchivo(documentoAdjuntoVo.getNombreArchivo());
        documentoadjunto.setFirmadigital("S".equals(documentoAdjuntoVo.getFirmadigital()));
        documentoadjunto.setIddocumento(new Documento(documentoAdjuntoVo.getIdDocumento()));
        documentoadjunto.setIdtipoadjunto(new Detalleclasificador(documentoAdjuntoVo.getIdtipoadjunto()));
        documentoadjunto.setExtension(documentoAdjuntoVo.getExtension());
        documentoadjunto.setRuta(documentoAdjuntoVo.getRuta());
        documentoadjunto.setCrc(documentoAdjuntoVo.getCrc());
        documentoadjunto.setFecharegistro(new Date());
        return this.documentoAdjuntoRepository.save(documentoadjunto);
    }

    public void guardarListaDocumentosAdjuntos(SarcoWebVo sarcoWebVo, FormDataBodyPart files) {
        //List<BodyPart> archivosBody = files.getParent().getBodyParts();
        List<BodyPart> archivos = files.getParent().getBodyParts();
        List<DocumentoAdjuntoVo> informacionArchivos = sarcoWebVo.getListaDocumentosAdjuntos();

        archivos.remove(0);

        /*String xx = "";

        for (int i = 0; i < archivos.size(); i++) {
            Logger log = Logger.getLogger(DocumentoAdjuntoServiceImpl.class);
            xx += "archivos.get(" + i + ")" + archivos.get(i);
            xx += "archivos.getEntityAs(" + i + ")" + archivos.get(i).getEntityAs(InputStream.class);
            xx += "archivos.getContentDisposition(" + i + ")" + archivos.get(i).getContentDisposition();

            log.error("archivos.get(i)");
            log.error(archivos.get(i));
            log.error("archivos.get(i).getEntityAs");
            log.error(archivos.get(i).getEntityAs(InputStream.class));
            log.error("archivos.get(i).getContentDisposition");
            log.error(archivos.get(i).getContentDisposition());
        }

        MostrarMensajeError.enviarError(
                xx,
                "La lista de archivos no coindice con la información registrada para cada uno " + informacionArchivos.size(),
                "Favor revisar los documentos adjuntos enviados");
         */
        if (archivos.size() != informacionArchivos.size()) {
            MostrarMensajeError.enviarError(
                    "Error al recibir los archivos " + archivos.size(),
                    "La lista de archivos no coindice con la información registrada para cada uno " + informacionArchivos.size(),
                    "Favor revisar los documentos adjuntos enviados");
        }

        for (int i = 0; i < archivos.size(); i++) {
            InputStream fileInputStream = archivos.get(i).getEntityAs(InputStream.class);
            ContentDisposition fileMetaData = archivos.get(i).getContentDisposition();
            informacionArchivos.get(i).setIdDocumento(sarcoWebVo.getIdDocumento());
            informacionArchivos.get(i).setNombreArchivo(fileMetaData.getFileName());
            String extension = getExtension(fileMetaData.getFileName());
            informacionArchivos.get(i).setExtension(extension);
            //informacionArchivos.get(i).setCrc("WEWRDSSIE2346755585");            
            String rutaArchivo = adjuntar(fileInputStream, i+1, extension, sarcoWebVo.getIdDocumento());
            informacionArchivos.get(i).setCrc(generarCRC(rutaArchivo));
            informacionArchivos.get(i).setRuta(rutaArchivo);
            Documentoadjunto documentoadjunto = this.guardarDocumentoAdjunto(informacionArchivos.get(i));

            this.documentoAdjuntoRepository.save(documentoadjunto);
        }
    }

    private static String getExtension(String nombreArchivo) {
        // Obtenemos la extension del archivo
        String ext = "";
        int pos = nombreArchivo.lastIndexOf('.');
        try {

            if (pos == -1) {
                MostrarMensajeError.enviarError("El nombre de archivo ["
                        + nombreArchivo
                        + "] no tiene extension.", "El archivo enviado no es permitido", "Revise el archivo enviado");
            }
            ext = nombreArchivo.substring(pos);
            if (ext.length() == 0) {
                MostrarMensajeError.enviarError("El nombre de archivo ["
                        + nombreArchivo
                        + "] no tiene extension.", "El archivo enviado no es permitido", "Revise el archivo enviado");
            }
            ext = ext.toLowerCase();
        } catch (Exception e) {
            MostrarMensajeError.enviarError("Error al revisar el nombre de archivo [" + nombreArchivo
                    + "] no tiene extension.", "El archivo enviado no es permitido", "Revise el archivo enviado");
        }

        // Verificando la extension del archivo
        if (!ext.equals(".pdf")) {
            MostrarMensajeError.enviarError(
                    "El formato de archivo [" + ext + "] no es admitido",
                    "El archivo enviado no es permitido",
                    "Revise el archivo enviado");
        }
        // Verificamos el nombre del archivo
        if (pos > 0) {
            String nameFile = nombreArchivo.substring(0, pos);
            if (!isValidName(nameFile)) {
                MostrarMensajeError.enviarError(
                        "El nombre de archivo [" + nombreArchivo + "] no es valido",
                        "El archivo enviado no es permitido",
                        "Verifique que no tenga caracteres invalidos en el nombre del archivo");
            }
        }
        return ext;
    }

    private String adjuntar(InputStream fileInputStream, int nroDocumentoAdjunto, String extensionArchivo, Long idDocumento) {

        Date fechaActual = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActual);
        String ruta = UPLOAD_PATH
                + calendar.get(Calendar.YEAR)
                + "/" + (calendar.get(Calendar.MONTH) + 1)
                /*+ "/" + calendar.get(Calendar.DAY_OF_MONTH) + "/";*/
                + "/" + idDocumento + "/";

        File uploadPath = Paths.get(ruta).toFile();
        if (uploadPath.exists() == false) {
            uploadPath.mkdirs();
        }
        ruta = ruta + nroDocumentoAdjunto + extensionArchivo;

        try {
            int read = 0;
            byte[] bytes = new byte[1024];

            OutputStream out = new FileOutputStream(new File(ruta));
            while ((read = fileInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            MostrarMensajeError.enviarError(
                    "Error al subir archivo al servidor",
                    "No se pudo subir el documento adjunto",
                    "Favor intente nuevamente, de persistirse el error contáctese con el administrador del sistema");
            //e.printStackTrace();
        }
        return ruta;
    }

    public static boolean isValidName(String text) {
        Pattern pattern = Pattern.compile(
                "# Match a valid Windows filename (unspecified file system).          \n"
                + "^                                # Anchor to start of string.        \n"
                + "(?!                              # Assert filename is not: CON, PRN, \n"
                + "  (?:                            # AUX, NUL, COM1, COM2, COM3, COM4, \n"
                + "    CON|PRN|AUX|NUL|             # COM5, COM6, COM7, COM8, COM9,     \n"
                + "    COM[1-9]|LPT[1-9]            # LPT1, LPT2, LPT3, LPT4, LPT5,     \n"
                + "  )                              # LPT6, LPT7, LPT8, and LPT9...     \n"
                + "  (?:\\.[^.]*)?                  # followed by optional extension    \n"
                + "  $                              # and end of string                 \n"
                + ")                                # End negative lookahead assertion. \n"
                + "[^<>:\"/\\\\|?*\\x00-\\x1F]*     # Zero or more valid filename chars.\n"
                + "[^<>:\"/\\\\|?*\\x00-\\x1F\\. ]  # Last char is not a space or dot.  \n"
                + "$                                # Anchor to end of string.            ",
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.COMMENTS);
        Matcher matcher = pattern.matcher(text);
        boolean isMatch = matcher.matches();
        return isMatch;
    }

    // CRC = GenerarCRC(img);// el parametro img es la ruta del archivo del cual se desea sacar el crc
    protected static String generarCRC(String img) {
        String vHash = null;
        try {
            java.nio.file.Path path = Paths.get(img);
            byte data[] = Files.readAllBytes(path);
            vHash = algoritmoHash(data, "MD5");

        } catch (Exception e) {
            MostrarMensajeError.enviarError(
                    "Error al generar CRC",
                    "No se pudo realizar la generación del CRC",
                    "Favor intente nuevamente, de persistirse el error contáctese con el administrador del sistema");
        }
        return vHash;
    }

    public static String algoritmoHash(byte[] pArchivo, String algorithm) {
        String hashValue = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(pArchivo);
            byte[] digestedBytes = messageDigest.digest();
            hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
        } catch (Exception e) {
            MostrarMensajeError.enviarError(
                    "Error al generar el algortimo del Hash",
                    "No se pudo utilizar el método del algoritmo del Hash",
                    "Favor intente nuevamente, de persistirse el error contáctese con el administrador del sistema");

        }
        return hashValue;
    }
}
