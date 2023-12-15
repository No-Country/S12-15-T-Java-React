package com.nocountry.S12G15.controller.dto;

import com.nocountry.S12G15.domain.entity.ImagenEntity;
import com.nocountry.S12G15.service.CloudinaryService;
import com.nocountry.S12G15.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/imagen")
public class ImagenController {

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImagenService imagenService;

    //* Listar todas las imágenes
    @GetMapping("/list")
    public ResponseEntity<List<ImagenEntity>> list() {
        List<ImagenEntity> list = imagenService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //* Buscar una imagen por su Id (el autogenerado en la Base de Datos, no el HASH generado por Cloudinary)
    @GetMapping("/{fileId}")
    public ResponseEntity<?> getImagen(@PathVariable Long fileId) throws IOException {
        ImagenEntity imageData = imagenService.getImagen(fileId).get();
        return ResponseEntity.status(HttpStatus.OK).body(imageData);
    }

    //* Subir una imagen
    public ResponseEntity<?> upload(@RequestParam("imagen") MultipartFile multipartFile) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if (bi == null) {
            return new ResponseEntity("imagen no válida", HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(multipartFile);
        ImagenEntity imagen = new ImagenEntity();
        imagen.setName((String) result.get("original_filename"));
        imagen.setImagenUrl((String) result.get("url"));
        imagen.setCloudinaryId((String) result.get("public_id"));

        imagenService.save(imagen);
        return new ResponseEntity(imagen, HttpStatus.OK);
    }

    // * Eliminar una imagen por su Id (se borrará tanto en la base de datos como en el drive de Cloudinary).
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) throws IOException {
        if (!imagenService.exists(id))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        ImagenEntity imagen = imagenService.getImagen(id).get();
        Map result = CloudinaryService.delete(imagen.getCloudinaryId());
        imagenService.delete(id);
        return new ResponseEntity("imagen eliminada", HttpStatus.OK);
    }
}