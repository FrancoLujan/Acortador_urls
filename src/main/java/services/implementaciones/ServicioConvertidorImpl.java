package services.implementaciones;

import DTOS.UrlDTO;
import entities.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.interfaces.Url_aliasServicio;

import java.net.URL;
import java.security.PublicKey;

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

        urlAliasServicio.
    }

    public UrlDTO convertirAdto(Url url) {
        UrlDTO urlDTO = new UrlDTO();
        urlDTO.setUrl_completa(url.getUrl_completa());
        return urlDTO;
    }
}



