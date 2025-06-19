package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private List<Url> urls;

    @Column(name = "alias")
    private String alias;

}
