package services.implementaciones;

import entities.Url;
import services.interfaces.UrlServicio;

import java.util.List;

public class UrlServicioImpl extends ServicioImpl<Url, Integer> implements UrlServicio<Url, Integer> {
    @Override
    public void add(Url url) {

    }

    @Override
    public void update(Url url) {

    }

    @Override
    public void delete(Url url) {

    }

    @Override
    public List<Url> findAll() {
        return List.of();
    }

    @Override
    public Url findById(Integer id) {
        return null;
    }
}
