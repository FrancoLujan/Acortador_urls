package com.example.Acortador.controllers;

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

}
