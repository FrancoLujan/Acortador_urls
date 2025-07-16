package com.example.Acortador.services.implementaciones;

import com.example.Acortador.DTOS.AliasDTO;
import com.example.Acortador.DTOS.Url_aliasDTO;
import com.example.Acortador.entities.Url;
import com.example.Acortador.entities.Url_alias;
import com.example.Acortador.gestor.GestorRepositorios;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Acortador.services.interfaces.Url_aliasServicio;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class Url_aliasServicioImpl extends ServicioImpl<Url_alias, Integer> implements Url_aliasServicio<Url_alias, Integer> {

    private final GestorRepositorios gestorRepositorios;

    @Autowired
    public Url_aliasServicioImpl(GestorRepositorios gestorRepositorios) {
        this.gestorRepositorios = gestorRepositorios;
    }


    @Override
    public void add(Url_alias urlAlias) {
        gestorRepositorios.getUrlAliasRepository().save(urlAlias);
    }

    @Override
    public void update(Url_alias urlAlias) {
        gestorRepositorios.getUrlAliasRepository().save(urlAlias);
    }

    @Override
    public void delete(Integer id) {
        gestorRepositorios.getUrlAliasRepository().deleteById(id);
    }

    @Override
    public List<Url_alias> findAll() {

        return gestorRepositorios.getUrlAliasRepository().findAll();
    }

    @Override
    public Url_alias findById(Integer id) {

        return gestorRepositorios.getUrlAliasRepository().findById(id).get();
    }


    // recibe la Url para mas precicion
    public void agregar(Url_aliasDTO urlAliasDTO, Url url) {
        Url_alias urlAlias = new Url_alias();
        urlAlias.setAlias(urlAliasDTO.getAlias());


        System.out.println(url);
        urlAlias.setUrl(url);
        gestorRepositorios.getUrlAliasRepository().save(urlAlias);
    }

    public void agregar(AliasDTO aliasDTO, int idUrl) {
        Url_alias urlAlias = new Url_alias();
        urlAlias.setAlias(aliasDTO.getAlias());
        urlAlias.setUrl(gestorRepositorios.getUrlRepository().findById(idUrl).orElse(null));
        gestorRepositorios.getUrlAliasRepository().save(urlAlias);


    }

    public void eliminar(int id) {
        delete(id);
    }

    // no elimina nada por alguna extraña razon
    // EL error fue hecho por la cascade de la url pero fue solucionado..
    public void eliminarAliasAsociados(int idUrl) {

        List<Url_alias> aliaseAsociados = gestorRepositorios.getUrlRepository().findById(idUrl).get().getUrl_alias();
        aliaseAsociados.forEach(urlAlias -> {eliminar(urlAlias.getId());});

    }


    // eliminar alias asociado va eliminar el alias asociado por el alias sin embargo si hay repetidos elimina los repetidos
    public void eliminarAliasAsociado(AliasDTO aliasDTO) {
        List<Url_alias> aliaseAsociados = gestorRepositorios.getUrlRepository()
                .findById(aliasDTO.getUrlAsociada()).get().getUrl_alias();
        aliaseAsociados.forEach(e -> {
            if (e.getAlias().equals(aliasDTO.getAlias())) {
                eliminar(e.getId());
            }
        });

    }

    // para una eliminacion precisa usare el el id del alias para evitar errores
    public void eliminarAliasID(int idAlias){
        eliminar(idAlias);
    }

    private int idAlias(String alias) {
        String cadena = alias.toLowerCase().trim();
        // cadena pasada a minusculas y quitado los espacios del inicio o fin
        return findAll().stream().filter(e -> e.getAlias().toLowerCase().trim().equals(cadena))
                .findFirst().get().getId();
    }

    public List<Url_aliasDTO> listarTodos() {
        return findAll().stream().map(gestorRepositorios::getUrlAliasDTO).toList();
    }


    public void modificarAlias( String aliasNuevo, String aliasViejo) {
        Url_alias urlAlias = findById(idAlias(aliasViejo));

        urlAlias.setAlias(aliasNuevo);
        update(urlAlias);


    }

    public void modificarCantidad(Url_alias url) {
        url.setCantidad_uso(url.getCantidad_uso() + 1);
    }


}
