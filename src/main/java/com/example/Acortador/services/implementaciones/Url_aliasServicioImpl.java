package com.example.Acortador.services.implementaciones;

import com.example.Acortador.DTOS.Url_aliasDTO;
import com.example.Acortador.entities.Url;
import com.example.Acortador.entities.Url_alias;
import com.example.Acortador.gestor.Gestor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Acortador.services.interfaces.Url_aliasServicio;

import java.util.ArrayList;
import java.util.List;

@Service
public class Url_aliasServicioImpl extends ServicioImpl<Url_alias, Integer> implements Url_aliasServicio<Url_alias, Integer> {

    private final Gestor gestor;

    @Autowired
    public Url_aliasServicioImpl(Gestor gestor) {
        this.gestor = gestor;
    }


    @Override
    public void add(Url_alias urlAlias) {
        gestor.getUrlAliasRepository().save(urlAlias);
    }

    @Override
    public void update(Url_alias urlAlias) {
        gestor.getUrlAliasRepository().save(urlAlias);
    }

    @Override
    public void delete(Integer id) {
        gestor.getUrlAliasRepository().deleteById(id);
    }

    @Override
    public List<Url_alias> findAll() {

        return gestor.getUrlAliasRepository().findAll();
    }

    @Override
    public Url_alias findById(Integer id) {

        return gestor.getUrlAliasRepository().findById(id).get();
    }


    public void agregar(Url_aliasDTO urlAliasDTO) {
        Url_alias urlAlias = new Url_alias();
        urlAlias.setAlias(urlAliasDTO.getAlias());
        Url url = new Url();
        url = gestor.getUrlRepository().findById(urlAlias.getUrl().getId_url()).get();
        urlAlias.setUrl(url);
        gestor.getUrlAliasRepository().save(urlAlias);
    }

    public void eliminar(int id) {
        delete(id);
    }

    public List<Url_aliasDTO> listarTodos() {
        return findAll().stream().map(gestor::getUrlAliasDTO).toList();
    }

    public List<Url_aliasDTO> buscarPorAlias(String alias) {
        char[] cadena = alias.toCharArray();

        List<Url_alias> urls = gestor.getUrlAliasRepository().findAll().stream()
                .map(e -> {
                    int iguales = 0;
                    List<Url_alias> coincidencias = new ArrayList<>(List.of());
                    for (int i = 0; i < cadena.length; i++) {
                        if (cadena[i] == e.getAlias().charAt(i)) {
                            iguales++;

                        }

                    }

                    if (iguales > 1 && iguales <= cadena.length) {
                        return e;
                    }

                    return null;
                }).toList();
        return urls.stream().map(gestor::getUrlAliasDTO).toList();
    }

    public void modificarAlias(Url_aliasDTO urlAliasDTO, int id) {
        Url_alias urlAlias = findById(id);
        urlAlias.setAlias(urlAliasDTO.getAlias());
        update(urlAlias);


    }

    public void modificarCantidad(Url_alias url) {
        url.setCantidad_uso(url.getCantidad_uso() + 1);
    }


}
