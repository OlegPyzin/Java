package com.example.study.model.db.repository;

import com.example.study.model.db.entity.Client;
import com.example.study.model.enums.ClientStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c where c.status <> :status")
    Page<Client> findAllByStatusNot(Pageable request, ClientStatus status);

    Optional<Client> findByEmailIgnoreCase(String email);
}
