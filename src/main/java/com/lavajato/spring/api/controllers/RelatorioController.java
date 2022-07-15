package com.lavajato.spring.api.controllers;

import java.util.Collection;

import com.lavajato.spring.api.entity.Cliente;
import com.lavajato.spring.api.entity.Servico;
import com.lavajato.spring.api.entity.User;
import com.lavajato.spring.api.entity.Veiculo;
import com.lavajato.spring.api.entity.Pedido;
import com.lavajato.spring.api.security.services.ClienteService;
import com.lavajato.spring.api.security.services.PedidoService;
import com.lavajato.spring.api.security.services.ServicoService;
import com.lavajato.spring.api.security.services.UserService;
import com.lavajato.spring.api.security.services.VeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/relatorio")
public class RelatorioController {

    @Autowired
    private VeiculoService veiculo;
    @Autowired
    private ClienteService cliente;
    @Autowired
    private ServicoService servico;
    @Autowired
    private UserService user;
    @Autowired
    private PedidoService pedido;


    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public ResponseEntity<Collection<Cliente>> findAllClientes() {
        Collection<Cliente> collection = cliente.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/servicos", method = RequestMethod.GET)
    public ResponseEntity<Collection<Servico>> findAllServices() {
        Collection<Servico> collection = servico.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/veiculos", method = RequestMethod.GET)
    public ResponseEntity<Collection<Veiculo>> findAllVeiculos() {
        Collection<Veiculo> collection = veiculo.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ResponseEntity<Collection<User>> findAllUsers() {
        Collection<User> collection = user.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/faturamento",method = RequestMethod.GET)
    public ResponseEntity<Collection<Pedido>> findAllPedidos() {
        Collection<com.lavajato.spring.api.entity.Pedido> collection = pedido.findAll();
        return ResponseEntity.ok().body(collection);
    }


}