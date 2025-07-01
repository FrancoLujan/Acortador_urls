package com.example.Acortador.repositories;

import com.example.Acortador.entities.Url_alias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Url_aliasRepository extends JpaRepository<Url_alias, Integer> {
}
