package com.example.Acortador.services.implementaciones;

import com.example.Acortador.DTOS.Url_aliasDTO;
import com.example.Acortador.entities.Url_alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Acortador.repositories.Url_aliasRepository;
import com.example.Acortador.services.interfaces.Url_aliasServicio;

import java.util.List;

@Service
public class Url_aliasServicioImpl extends ServicioImpl<Url_alias, Integer> implements Url_aliasServicio<Url_alias, Integer> {

    private final Url_aliasRepository url_aliasRepository;
    private final UrlServicioImpl urlServicioImpl;
    @Autowired
    public Url_aliasServicioImpl(Url_aliasRepository url_aliasRepository, UrlServicioImpl urlServicioImpl) {
        this.url_aliasRepository = url_aliasRepository;
        this.urlServicioImpl = urlServicioImpl;
    }


    @Override
    public void add(Url_alias urlAlias) {
        url_aliasRepository.save(urlAlias);
    }

    @Override
    public void update(Url_alias urlAlias) {
        url_aliasRepository.save(urlAlias);
    }

    @Override
    public void delete(Integer id) {
            url_aliasRepository.deleteById(id);
    }

    @Override
    public List<Url_alias> findAll() {

        return url_aliasRepository.findAll();
    }

    @Override
    public Url_alias findById(Integer id) {

        return url_aliasRepository.findById(id).get();
    }


    public void agregar(Url_aliasDTO urlAliasDTO) {
        Url_alias urlAlias = new Url_alias();
        urlAlias.setAlias(urlAliasDTO.getAlias());
        urlAlias.setCantidad_uso(urlAliasDTO.getCantidad_uso());
        url_aliasRepository.save(urlAlias);
    }

    public void eliminar(int id) {
        delete(id);
    }
    public List<Url_aliasDTO> listarTodos() {
        List<Url_alias> urlsAlias = findAll();
       return  urlsAlias.stream().map(e -> {
            Url_aliasDTO urlAliasDTO = new Url_aliasDTO();
            urlAliasDTO.setAlias(e.getAlias());
            urlAliasDTO.setCantidad_uso(e.getCantidad_uso());
            return urlAliasDTO;
        }).toList();
    }

    public Url_aliasDTO buscarPorAlias(String alias) {
        List<Url_alias> urlsAlias = findAll();
       Url_alias encontrado = urlsAlias.stream().filter(e -> e.getAlias().equals(alias)).findFirst().get();
       Url_aliasDTO urlAliasDTO = new Url_aliasDTO();
       urlAliasDTO.setAlias(encontrado.getAlias());
       urlAliasDTO.setCantidad_uso(encontrado.getCantidad_uso());
       return urlAliasDTO;
    }
    public void modificarAlias(Url_aliasDTO urlAliasDTO, String alias) {
        Url_aliasDTO modificable = buscarPorAlias(alias);

        modificable.setAlias(urlAliasDTO.getAlias());
    }

    public void modificarCantidad(Url_alias url) {
        url.setCantidad_uso(url.getCantidad_uso() + 1);
    }
}
