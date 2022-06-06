package com.lavajato.spring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import com.lavajato.spring.api.entity.Cidade;
import com.lavajato.spring.api.entity.Uf;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Optional<Cidade> findById(Integer id);
    Boolean existsById(Integer id);
    
    @Transactional()
    public Collection<Cidade> findByUf(Uf uf);
}
