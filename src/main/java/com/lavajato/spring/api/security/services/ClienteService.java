package com.lavajato.spring.api.security.services;

import java.util.List;

import com.lavajato.spring.api.entity.Cliente;
import com.lavajato.spring.api.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente findById(Integer id) {
        return repository.findById(id).get();
    }
    public List<Cliente> findAll() {
        return repository.findAll();
    }
    public Cliente insert(Cliente cliente) {
        return repository.save(cliente);
    }
    public Cliente update(Cliente cliente) {
        return repository.save(cliente);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
