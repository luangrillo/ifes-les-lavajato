package com.lavajato.spring.api.security.services;

import java.util.Collection;
import java.util.List;

import com.lavajato.spring.api.entity.Cidade;
import com.lavajato.spring.api.entity.Uf;
import com.lavajato.spring.api.repository.CidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CidadeService {
    @Autowired
    private CidadeRepository repository;

    public Cidade findById(Long id) {
        return repository.findById(id).get();
    }
    public List<Cidade> findAll() {
        return repository.findAll();
    }
    public Cidade insert(Cidade cidade) {
        return repository.save(cidade);
    }
    public Cidade update(Cidade cidade) {
        return repository.save(cidade);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Collection<Cidade> findByUf(Uf uf) {
        return repository.findByUf(uf);
    }
}
