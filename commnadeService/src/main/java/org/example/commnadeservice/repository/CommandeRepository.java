package org.example.commnadeservice.repository;


import org.example.commnadeservice.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;


@RepositoryRestResource
public interface CommandeRepository extends JpaRepository<Commande, Long> {

    @Query("SELECT c FROM Commande c WHERE c.date >= :dateLimite")
    List<Commande> findCommandesDepuis(@Param("dateLimite") LocalDate dateLimite);
    long count();


}
