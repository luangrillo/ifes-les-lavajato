package com.lavajato.spring.api.security.services;

import java.util.List;

import com.lavajato.spring.api.entity.Pedido;
import com.lavajato.spring.api.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    public Pedido findById(Integer id) {
        return repository.findById(id).get();
    }
    public List<Pedido> findAll() {
        return repository.findAll();
    }
    public Pedido insert(Pedido pedido) {
        return repository.save(pedido);
    }
    public Pedido update(Pedido pedido) {
        return repository.save(pedido);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
