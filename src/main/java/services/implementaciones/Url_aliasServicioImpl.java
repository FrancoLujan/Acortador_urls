package services.implementaciones;

import entities.Url_alias;
import org.springframework.stereotype.Service;
import services.interfaces.Url_aliasServicio;

import java.util.List;

@Service
public class Url_aliasServicioImpl extends ServicioImpl<Url_alias, Integer> implements Url_aliasServicio<Url_alias, Integer> {
    @Override
    public void add(Url_alias urlAlias) {

    }

    @Override
    public void update(Url_alias urlAlias) {

    }

    @Override
    public void delete(Url_alias urlAlias) {

    }

    @Override
    public List<Url_alias> findAll() {
        return List.of();
    }

    @Override
    public Url_alias findById(Integer id) {
        return null;
    }




}
