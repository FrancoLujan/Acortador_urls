package com.example.Acortador.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.net.URL;
import java.util.List;

@Entity
@Table(name = "URLS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "url_alias")
public class Url {
    @Id
    @Column(name = "id_url")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_url;


    @Column(name = "url_completa")
    private URL url_completa;

    @OneToMany(mappedBy = "url", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Url_alias> url_alias;


}
