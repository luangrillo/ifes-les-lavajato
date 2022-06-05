package com.lavajato.spring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.lavajato.spring.api.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Optional<Cidade> findById(Integer id);

    Boolean existsById(Integer id);
}
