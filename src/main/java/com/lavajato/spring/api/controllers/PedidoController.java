package com.lavajato.spring.api.controllers;

import javax.validation.Valid;

import com.lavajato.spring.api.payload.request.PedidoRequest;
import com.lavajato.spring.api.payload.response.MessageResponse;
import com.lavajato.spring.api.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
    @Autowired
    PedidoRepository pedidoRepository;

    @PostMapping()
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public ResponseEntity<?> createPedido(@Valid @RequestBody PedidoRequest pedidoRequest){


        // Pedido pedido = new Pedido(pedidoRequest.getValorAcrecimo(), 
        // pedidoRequest.getValorDesconto(), 
        // pedidoRequest.getDataInicio(), 
        // pedidoRequest.getObservacoes(),
        // pedidoRequest.getServicoId());

        //System.out.println(new Gson().toJson(pedido));

        // pedidoRepository.save(pedido);

        return ResponseEntity.ok(new MessageResponse("Pedido created succefully!"));

    }

}
