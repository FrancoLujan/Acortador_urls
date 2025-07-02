package com.example.Acortador.DTOS.Detalles;

import com.example.Acortador.DTOS.UrlDTO;
import com.example.Acortador.DTOS.Url_aliasDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UrlDTODetalle {
    private UrlDTO url;
    private List<Url_aliasDTO> urlAliasDtos;
}
