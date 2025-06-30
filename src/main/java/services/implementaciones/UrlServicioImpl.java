package services.implementaciones;

import DTOS.UrlDTO;
import entities.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UrlRepository;
import services.interfaces.UrlServicio;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UrlServicioImpl extends ServicioImpl<Url, Integer> implements UrlServicio<Url, Integer> {

    private final UrlRepository urlRepository;

    @Autowired
    public UrlServicioImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public void add(Url url) {
        urlRepository.save(url);

    }

    @Override
    public void update(Url url) {
        urlRepository.save(url);

    }

    @Override
    public void delete(Integer id) {
        urlRepository.deleteById(id);
    }

    @Override
    public List<Url> findAll() {
        return urlRepository.findAll();
    }

    @Override
    public Url findById(Integer id) {

        return urlRepository.findById(id).get();
    }


    public void agregar(UrlDTO urlDTO) {
        Url url = new Url();
        url.setUrl_completa(urlDTO.getUrl_completa());
        add(url);
    }

    public void actualizar(UrlDTO urlDTO, int id) {

        Url url = findById(id);

        if(url != null){
            url.setUrl_completa(urlDTO.getUrl_completa());
        }
    }

    public void eliminar(int id) {
        delete(id);
    }

    public Url buscarId(int id) {
        return findById(id);
    }
    public List<Url> listaUrls(String url_completa) {
        return findAll();
    }



}
