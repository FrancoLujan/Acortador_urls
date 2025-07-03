package com.example.Acortador.gestor;

import com.example.Acortador.DTOS.Detalles.UrlDTODetalle;
import com.example.Acortador.DTOS.UrlDTO;
import com.example.Acortador.DTOS.Url_aliasDTO;
import com.example.Acortador.entities.Url;
import com.example.Acortador.entities.Url_alias;
import com.example.Acortador.repositories.UrlRepository;
import com.example.Acortador.repositories.Url_aliasRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

// EL GESTOR MANEJA LOS REPOSITORIOS Y LOS DTO PARA QUE QUEDE LIMPIO LOS SERVICIOS
// Y SOLO TENGAN LOGICA PROPIA Y NO DE DTOS
@Component
@Data

public class GestorRepositorios {
    final private UrlRepository urlRepository;
    final private Url_aliasRepository urlAliasRepository;

    @Autowired
    public GestorRepositorios(UrlRepository urlRepository, Url_aliasRepository urlAliasRepository) {
        this.urlRepository = urlRepository;
        this.urlAliasRepository = urlAliasRepository;
    }



    public UrlDTODetalle getDetalleUrlDTO(Url url) {
        UrlDTODetalle urlDTO = new UrlDTODetalle();
        UrlDTO dto = new UrlDTO();
        dto.setUrl_completa(url.getUrl_completa());

        urlDTO.setUrl(dto);
        List<Url_alias> url_alias = urlAliasRepository.findAll();
        List<Url_aliasDTO> url_aliasDTO = url_alias.stream().map(this::getUrlAliasDTO).toList();
        urlDTO.setUrlAliasDtos(url_aliasDTO);

        return urlDTO;
    }

    public Url_aliasDTO getUrlAliasDTO(Url_alias url_alias) {
        Url_aliasDTO dto = new Url_aliasDTO();
        dto.setAlias(url_alias.getAlias());
        dto.setUrlId(url_alias.getUrl().getId_url());
        dto.setCantidad_uso(url_alias.getCantidad_uso());
        return dto;
    }
}
