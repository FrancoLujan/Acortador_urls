package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.net.URL;

@Entity
@Table(name = "URLS")
@Data
public class Url {
    @Id
    @Column(name = "id_url")
    private int id_url;


    @ManyToOne
    @JoinColumn(name = "id")
    private Usuario usuario;

    @Column(name = "url_complete")
    private URL url_completa;

    @ManyToOne
    @JoinColumn(name = "id_alias")
    private Url_alias url_alias;



}
