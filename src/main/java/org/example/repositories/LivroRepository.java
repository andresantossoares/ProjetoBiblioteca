package org.example.repositories;

import org.example.entities.Fornecedor;
import org.example.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface LivroRepository extends JpaRepository<Livro, Long> {
    }

