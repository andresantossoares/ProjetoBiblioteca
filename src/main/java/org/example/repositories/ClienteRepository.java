package org.example.repositories;

import org.example.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    void deleteAllById(Long id);
}