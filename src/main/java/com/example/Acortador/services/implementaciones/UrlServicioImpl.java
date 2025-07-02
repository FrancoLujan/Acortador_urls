package com.example.Acortador.services.implementaciones;

import com.example.Acortador.DTOS.Detalles.UrlDTODetalle;
import com.example.Acortador.DTOS.UrlDTO;
import com.example.Acortador.entities.Url;
import com.example.Acortador.gestor.Gestor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Acortador.services.interfaces.UrlServicio;

import java.util.List;

@Service
public class UrlServicioImpl extends ServicioImpl<Url, Integer> implements UrlServicio<Url, Integer> {

    private final Gestor gestor;

    @Autowired
    public UrlServicioImpl(Gestor gestor) {
        this.gestor = gestor;
    }

    @Override
    public void add(Url url) {
        gestor.getUrlRepository().save(url);

    }

    @Override
    public void update(Url url) {
        gestor.getUrlRepository().save(url);

    }

    @Override
    public void delete(Integer id) {
        gestor.getUrlRepository().deleteById(id);
    }

    @Override
    public List<Url> findAll() {
        return gestor.getUrlRepository().findAll();
    }

    @Override
    public Url findById(Integer id) {

        return gestor.getUrlRepository().findById(id).get();
    }


    public void agregar(UrlDTO urlDTO) {
        Url url = new Url();
        url.setUrl_completa(urlDTO.getUrl_completa());
        url.setUrl_alias(gestor.getUrlAliasRepository().findAll());


    }

    public void actualizar(UrlDTO urlDTO, int id) {
        Url url = findById(id);
        url.setUrl_completa(urlDTO.getUrl_completa());
        update(url);
    }

    public void eliminar(int id) {
        delete(id);
    }

    public UrlDTODetalle buscar(int id) {
        Url url = findById(id);

        return gestor.getDetalleUrlDTO(url);

    }
    public List<UrlDTODetalle> listaUrls() {
       List<Url> urls = findAll();
       return urls.stream().map(gestor::getDetalleUrlDTO).toList();
    }



}
