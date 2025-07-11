package com.example.Acortador.services.implementaciones;

import com.example.Acortador.DTOS.Detalles.UrlDTODetalle;
import com.example.Acortador.DTOS.UrlDTO;
import com.example.Acortador.DTOS.Url_aliasDTO;
import com.example.Acortador.entities.Url;
import com.example.Acortador.gestor.GestorRepositorios;
import com.example.Acortador.gestor.GestorServicios;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;

@Service
public class ServicioConvertidorImpl {
    final private GestorServicios gestor;


    public ServicioConvertidorImpl(GestorServicios gestor) {
        this.gestor = gestor;

    }

    //GUARDA TANTO EL URL COMO EL ALIAS
    // USAR EN METODO POST
    public void acortarUrl(UrlDTO urlDTO, String alias) {

        Url_aliasDTO url_aliasDTO = new Url_aliasDTO();
        url_aliasDTO.setAlias(alias);
        gestor.getUrlServicio().agregar(urlDTO); // agrega pero no asocia el alias....
        int id = gestor.getUrlServicio().buscarIdUltimo();
        System.out.println(id);
        url_aliasDTO.setUrlId(id);
        gestor.getAliasServicio().agregar(url_aliasDTO,gestor.getUrlServicio().findById(id));
    }


    public List<UrlDTODetalle> detallesUrlDTO() {
        return gestor.getUrlServicio().listaUrls();
    }



}



