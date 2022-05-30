package com.lavajato.spring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.lavajato.spring.api.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Optional<Pedido> findById(Integer id);

    Boolean existsById(Integer id);
}
