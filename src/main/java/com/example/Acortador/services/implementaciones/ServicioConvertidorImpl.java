package com.example.Acortador.services.implementaciones;

import com.example.Acortador.DTOS.UrlDTO;
import com.example.Acortador.entities.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class ServicioConvertidorImpl {
    private UrlServicioImpl urlServicio;
    private Url_aliasServicioImpl urlAliasServicio;

    @Autowired
    public ServicioConvertidorImpl(UrlServicioImpl urlServicio, Url_aliasServicioImpl urlAliasServicio) {
        this.urlServicio = urlServicio;
        this.urlAliasServicio = urlAliasServicio;
    }


    public void acortarUrl(URL urlU) {
        Url url = new Url();
        url.setUrl_completa(urlU);
        urlServicio.agregar(convertirAdto(url));


    }

    public UrlDTO convertirAdto(Url url) {
        UrlDTO urlDTO = new UrlDTO();
        urlDTO.setUrl_completa(url.getUrl_completa());
        return urlDTO;
    }
}



