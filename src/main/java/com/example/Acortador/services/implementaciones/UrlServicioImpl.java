package com.example.Acortador.services.implementaciones;

import com.example.Acortador.DTOS.Detalles.UrlDTODetalle;
import com.example.Acortador.DTOS.UrlDTO;
import com.example.Acortador.entities.Url;
import com.example.Acortador.gestor.GestorRepositorios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Acortador.services.interfaces.UrlServicio;

import java.net.URL;
import java.util.List;

@Service
public class UrlServicioImpl extends ServicioImpl<Url, Integer> implements UrlServicio<Url, Integer> {

    private final GestorRepositorios gestorRepositorios;

    @Autowired
    public UrlServicioImpl(GestorRepositorios gestorRepositorios) {
        this.gestorRepositorios = gestorRepositorios;
    }

    @Override
    public void add(Url url) {
        gestorRepositorios.getUrlRepository().save(url);

    }

    @Override
    public void update(Url url) {
        gestorRepositorios.getUrlRepository().save(url);

    }

    @Override
    public void delete(Integer id) {
        gestorRepositorios.getUrlRepository().deleteById(id);
    }

    @Override
    public List<Url> findAll() {
        return gestorRepositorios.getUrlRepository().findAll();
    }

    @Override
    public Url findById(Integer id) {
        return gestorRepositorios.getUrlRepository().findById(id).orElseThrow();
    }


    public void agregar(UrlDTO urlDTO) {
        Url url = new Url();
        url.setUrl_completa(urlDTO.getUrl_completa());
        url.setUrl_alias(gestorRepositorios.getUrlAliasRepository().findAll());
        add(url);


    }

    public void actualizar(UrlDTO urlCompleta, int id) {
        Url url = findById(id);
        url.setUrl_completa(urlCompleta.getUrl_completa());
        update(url);
    }

    public void eliminar(int id) {
        delete(id);
    }

    public UrlDTODetalle buscar(int id) {
        Url url = findById(id);

        return gestorRepositorios.getDetalleUrlDTO(url);

    }

    public List<UrlDTODetalle> listaUrls() {
        List<Url> urls = findAll();
        return urls.stream().map(gestorRepositorios::getDetalleUrlDTO).toList();
    }

    public int buscarIdUltimo() {
        List<Url> urls = findAll();
        return urls.getLast().getId_url();
    }


}
