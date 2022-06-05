package com.lavajato.spring.api.security.services;

import java.util.List;

import com.lavajato.spring.api.entity.Servico;
import com.lavajato.spring.api.repository.ServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicoService {
    @Autowired
    private ServicoRepository repository;

    public Servico findById(Integer id) {
        return repository.findById(id).get();
    }
    public List<Servico> findAll() {
        return repository.findAll();
    }
    public Servico insert(Servico servico) {
        return repository.save(servico);
    }
    public Servico update(Servico servico) {
        return repository.save(servico);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
