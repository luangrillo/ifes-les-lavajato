package com.lavajato.spring.api.payload.request;


import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PedidoRequest {
	private Double valorAcrecimo;

	private Double valorDesconto;

    private Timestamp dataInicio;

    private String observacoes;

    public Long getServicoId() {
        return null;
    }

}
