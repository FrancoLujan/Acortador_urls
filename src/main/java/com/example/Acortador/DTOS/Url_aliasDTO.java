package com.example.Acortador.DTOS;

import lombok.Data;

@Data
// se mostrara y se usara para el conteo de usos...
public class Url_aliasDTO {

    private int aliasId;
    private String alias;

    private int cantidad_uso;

    private int urlId;

}
