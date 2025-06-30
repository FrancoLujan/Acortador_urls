package entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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


    @Column(name = "url_complete")
    private URL url_completa;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_alias")
    private Url_alias url_alias;


}
