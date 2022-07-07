package com.lavajato.spring.api.security.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime data_fim = LocalDateTime.now();  

        System.out.println(dtf.format(data_fim));
        // Minus date two months from date_fim
        LocalDateTime data_inicio = data_fim.minusMonths(2);
        
        Collection<?> agendamento = repository.checkAgendamento(pedido.getCliente().getId());

        Collection<?> pedidoDesconto = repository.checkDesconto(pedido.getCliente().getId(), data_inicio.toString(), data_fim.toString());

        // Cliente não pode efetuar mais que quatro agendamentos de serviços. 
        

        if (agendamento.size() > 4) { 
            // Cliente não pode efetuar mais que quatro agendamentos de serviços.
            throw new ConstraintException("Cliente já possui quatro agendamentos aberto");
        }else if (pedidoDesconto.size() > 4) {
            // Desconto - o cliente tera um desconto de 20 reais em caso de efetuar quatro pedidos concluido em dois meses: 
            pedido.setValorDesconto(20.0);
            return repository.save(pedido);
        }else{
            return repository.save(pedido); // Salva o pedido sem desconto
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
