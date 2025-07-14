package com.example.Acortador.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

//este es unicamente para limitar el cambio de alias sin dar mas opciones de cambio y agregar un alias ya asociado a una url
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AliasDTO {
    private String alias;
    private int urlAsociada;
}
