package com.lavajato.spring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.lavajato.spring.api.entity.Uf;

@Repository
public interface UfRepository extends JpaRepository<Uf, Long> {
    Optional<Uf> findById(Integer id);

    Boolean existsById(Integer id);
}
