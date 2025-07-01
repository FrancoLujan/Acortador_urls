package com.example.Acortador.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "URLS_ALIAS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Url_alias {
    @Id
    @Column(name="id_alias")
    private int id;

    @Column(name = "id_url")
    @OneToMany(mappedBy = "url_alias")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonManagedReference
    private List<Url> urls;

    @Column(name = "alias")
    private String alias;

    @Column(name = "cantidad_uso")
    private int cantidad_uso;

}
