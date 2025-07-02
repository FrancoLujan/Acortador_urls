package com.example.Acortador.services.implementaciones;

import com.example.Acortador.DTOS.UrlDTO;
import com.example.Acortador.DTOS.Url_aliasDTO;
import com.example.Acortador.entities.Url;
import jakarta.validation.constraints.NotNull;
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


    //GUARDA TANTO EL URL COMO EL ALIAS
    // USAR EN METODO POST
    public void acortarUrl(URL urlU, String alias) {
        Url url = new Url();
        url.setUrl_completa(urlU);
        urlServicio.agregar(convertirAdto(url));

    }


    private UrlDTO convertirAdto(Url url) {
        UrlDTO urlDTO = new UrlDTO();
        urlDTO.setUrl_completa(url.getUrl_completa());
        return urlDTO;
    }
    private Url_aliasDTO convertirAliasdto(String alias, int idUrl) {
        Url_aliasDTO urlAliasDTO = new Url_aliasDTO();
        urlAliasDTO.setAlias(alias);
        urlAliasDTO.setUrlId(idUrl);
        return urlAliasDTO;
    }


}



