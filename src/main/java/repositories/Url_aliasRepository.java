package repositories;

import entities.Url_alias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Url_aliasRepository extends JpaRepository<Url_alias, Integer> {
}
