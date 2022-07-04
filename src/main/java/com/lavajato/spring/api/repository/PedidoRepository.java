package com.lavajato.spring.api.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import com.lavajato.spring.api.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Optional<Pedido> findById(Integer id);

    Boolean existsById(Integer id);

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM public.pedido where cliente_id = ?1 and status = 'ABERTO'", nativeQuery = true)
    public  Collection<?> checkAgendamento(Integer client_id);
}
