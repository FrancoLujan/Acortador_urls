package com.example.Acortador.controllers;

import com.example.Acortador.DTOS.AliasDTO;
import com.example.Acortador.DTOS.Url_aliasDTO;
import com.example.Acortador.gestor.GestorServicios;
import org.hibernate.sql.Alias;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    //elimina segun un alias
    @DeleteMapping("/eliminar/{alias}")
    public ResponseEntity<ResponseEntity<HttpStatus>> eliminar( @PathVariable String alias) {
        try{
            servicios.getAliasServicio().eliminarAlias(alias);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
