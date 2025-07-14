package com.example.Acortador.controllers;

import com.example.Acortador.DTOS.Detalles.UrlDTODetalle;
import com.example.Acortador.DTOS.UrlDTO;
import com.example.Acortador.gestor.GestorServicios;
import com.example.Acortador.services.implementaciones.UrlServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.List;

@RequestMapping("/api/url")
@RestController

public class UrlController {

    private final GestorServicios servicio;

    @Autowired
    public UrlController(GestorServicios servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<UrlDTODetalle>> getAllUrls() {
        try {
            List<UrlDTODetalle> urls = servicio.getUrlServicio().listaUrls();
            return new ResponseEntity<>(urls, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/modificar/{id}")
    public ResponseEntity<ResponseEntity<HttpStatus>> updateUrl(@PathVariable int id, @RequestBody UrlDTO urlDTO) {
        try {
            servicio.getUrlServicio().actualizar(urlDTO, id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ResponseEntity<HttpStatus>> deleteUrl(@PathVariable int id) {
        try {
            servicio.getUrlServicio().eliminar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
