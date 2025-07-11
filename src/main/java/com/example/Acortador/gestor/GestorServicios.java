package com.example.Acortador.gestor;

import com.example.Acortador.services.implementaciones.ServicioImpl;
import com.example.Acortador.services.implementaciones.UrlServicioImpl;
import com.example.Acortador.services.implementaciones.Url_aliasServicioImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class GestorServicios {
    final private UrlServicioImpl urlServicio;
    final private Url_aliasServicioImpl aliasServicio;

    @Autowired
    public GestorServicios(UrlServicioImpl urlServicio, Url_aliasServicioImpl aliasServicio) {
        this.urlServicio = urlServicio;
        this.aliasServicio = aliasServicio;
    }
}
