package services.implementaciones;

import entities.Usuario;
import services.interfaces.UsuarioServicio;

import java.util.List;

public class UsuarioServicioImpl extends ServicioImpl<Usuario, Integer> implements UsuarioServicio<Usuario, Integer> {
    @Override
    public void add(Usuario usuario) {

    }

    @Override
    public void update(Usuario usuario) {

    }

    @Override
    public void delete(Usuario usuario) {

    }

    @Override
    public List<Usuario> findAll() {
        return List.of();
    }

    @Override
    public Usuario findById(Integer id) {
        return null;
    }
}
