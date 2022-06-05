package com.lavajato.spring.api.security.services;

import java.util.List;

import com.lavajato.spring.api.entity.Veiculo;
import com.lavajato.spring.api.repository.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository repository;

    public Veiculo findById(Integer id) {
        return repository.findById(id).get();
    }
    public List<Veiculo> findAll() {
        return repository.findAll();
    }
    public Veiculo insert(Veiculo veiculo) {
        return repository.save(veiculo);
    }
    public Veiculo update(Veiculo veiculo) {
        return repository.save(veiculo);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
