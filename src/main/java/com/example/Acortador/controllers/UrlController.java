package com.example.Acortador.controllers;

import com.example.Acortador.DTOS.AcortarDTO;
import com.example.Acortador.DTOS.UrlDTO;
import com.example.Acortador.entities.Url;
import com.example.Acortador.services.implementaciones.ServicioConvertidorImpl;
import com.example.Acortador.services.implementaciones.UrlServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.List;
import java.util.Objects;


@RequestMapping("/api/url")
@RestController
public class UrlController {

    private ServicioConvertidorImpl servicioConvertidor;

    @Autowired
    public UrlController(ServicioConvertidorImpl servicioConvertidor) {
        this.servicioConvertidor = servicioConvertidor;
    }

    //ERROR 500 SURGIO CUANDO USE acortadorDTO , ERROR A LA HORA DE CARGAR MAS DE UN DATO

    /*
    EL ERROR SE SOLUCIONO ERA UN ERROR EN LOS TOSTRING, LA SOLUCION FUE EL DECORADOR @ToString(exclude = )
    es cada entidad exclui la referencia a la otra entidad en decir en Url exclui Url_alias y viceversa para evitar
    recursividad en ToString todo esto por usar lombok(importante en este caso)


    Cuidado ojo: el error era en los System.out.print(url) (si se quitaba se solucionaba)
     por eso surgia el error sin embargo se dejara la correccion
    con decorador para evitar ese error a futuro...
     */

    @PostMapping("/acortar")
    public ResponseEntity<UrlDTO> acortar(@RequestBody AcortarDTO acortarDTO) {
        try {
            servicioConvertidor.acortarUrl(acortarDTO.getUrlDTO(), acortarDTO.getAlias());
            return new ResponseEntity<>(acortarDTO.getUrlDTO(), HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
