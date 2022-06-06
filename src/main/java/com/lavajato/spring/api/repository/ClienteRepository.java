package com.lavajato.spring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.lavajato.spring.api.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findById(Integer id);

    Boolean existsById(Integer id);
}
