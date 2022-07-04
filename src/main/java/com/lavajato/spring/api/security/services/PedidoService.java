package com.lavajato.spring.api.security.services;

import java.util.Collection;
import java.util.List;

import com.lavajato.spring.api.entity.Pedido;
import com.lavajato.spring.api.repository.PedidoRepository;
import com.lavajato.spring.api.repository.ChecklistRepository;
import com.lavajato.spring.api.security.services.exceptions.ConstraintException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ChecklistRepository ChecklistRepository;

    public Pedido findById(Integer id) {
        return repository.findById(id).get();
    }
    public List<Pedido> findAll() {
        return repository.findAll();
    }
    public Pedido insert(Pedido pedido) {
        Collection<?> agendamento = repository.checkAgendamento(pedido.getCliente().getId());

        // Cliente não pode efetuar mais que quatro agendamentos de serviços. 

        if (agendamento.size() > 4) {
            throw new ConstraintException("Cliente já possui quatro agendamentos aberto");
        }else{
            return repository.save(pedido);
        }
    }
    public Pedido update(Pedido pedido) {
        return repository.save(pedido);
    }

    public Pedido updateStatus(Pedido pedido) {
        Collection<?> checklist = ChecklistRepository.findChecklistsOk(pedido.getChecklist().getId());
        
        // Encerramento do pedido mediante checklist do veículo.

        if (checklist.size() == 0) {
            throw new ConstraintException("Cliente não possui checklist ok"); 
        }else{
            return repository.save(pedido);
        }
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
