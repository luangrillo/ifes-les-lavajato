package com.lavajato.spring.api.security.services;

import java.util.List;

import com.lavajato.spring.api.entity.Endereco;
import com.lavajato.spring.api.repository.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;

    public Endereco findById(Long id) {
        return repository.findById(id).get();
    }
    public List<Endereco> findAll() {
        return repository.findAll();
    }
    public Endereco insert(Endereco endereco) {
        return repository.save(endereco);
    }
    public Endereco update(Endereco endereco) {
        return repository.save(endereco);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
