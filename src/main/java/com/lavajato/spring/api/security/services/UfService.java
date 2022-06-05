package com.lavajato.spring.api.security.services;

import java.util.List;

import com.lavajato.spring.api.entity.Uf;
import com.lavajato.spring.api.repository.UfRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UfService {
    @Autowired
    private UfRepository repository;

    public Uf findById(Integer id) {
        return repository.findById(id).get();
    }
    public List<Uf> findAll() {
        return repository.findAll();
    }
    public Uf insert(Uf uf) {
        return repository.save(uf);
    }
    public Uf update(Uf uf) {
        return repository.save(uf);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
