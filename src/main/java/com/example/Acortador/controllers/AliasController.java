package com.example.Acortador.controllers;

import com.example.Acortador.DTOS.AliasDTO;
import com.example.Acortador.DTOS.Url_aliasDTO;
import com.example.Acortador.gestor.GestorServicios;
import jdk.jfr.Description;
import org.hibernate.sql.Alias;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/alias")
public class AliasController {
    private final GestorServicios servicios;

    public AliasController(GestorServicios servicios) {
        this.servicios = servicios;
    }

    @PostMapping("/agregar")
    public ResponseEntity<ResponseEntity<HttpStatus>> agregar(@RequestBody AliasDTO alias) {
        try {
            servicios.getAliasServicio().agregar(alias ,alias.getUrlAsociada());
                return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // ELIMINA TODOS LOS ALIAS ASOCIADOS A UNA URL
    @DeleteMapping("/eliminar/todos/{idURL}")
    public ResponseEntity<ResponseEntity<HttpStatus>> eliminarTodos(@PathVariable int idURL) {
        try{
            servicios.getAliasServicio().eliminarAliasAsociados(idURL);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    //elimina segun un alias de una url asociada
    @DeleteMapping("/eliminar")
    public ResponseEntity<ResponseEntity<HttpStatus>> eliminar( @RequestBody AliasDTO alias) {
        try{
            servicios.getAliasServicio().eliminarAliasAsociado(alias);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminar/{idAlias}")
    public ResponseEntity<ResponseEntity<HttpStatus>> eliminar(@PathVariable int idAlias) {
        try {
            servicios.getAliasServicio().eliminarAliasID(idAlias);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/modificar")
    public ResponseEntity<ResponseEntity<HttpStatus>> modificar(AliasDTO alias) {
        try{
            servicios.getAliasServicio().modificarAlias(alias);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @PatchMapping("/uso/{idAlias}")
    public ResponseEntity<ResponseEntity<HttpStatus>> usoAlias(@PathVariable int idAlias) {
        try{
            servicios.getAliasServicio().usoAlias(idAlias);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Url_aliasDTO>> todos(){
        try {
           List<Url_aliasDTO> alias =  servicios.getAliasServicio().listarTodos();
            return new ResponseEntity<>(alias, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
