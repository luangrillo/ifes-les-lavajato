package com.lavajato.spring.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "servico")
@Getter @Setter
@NoArgsConstructor
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(position = 1 , required = true, value = "Identificador do serviço", example = "0")
    private Integer id;   

    @NotBlank
    @Column(name = "nome")
    @ApiModelProperty(position = 2 , required = true, value = "Nome do serviço", example = "Lavagem")
    private String nome;

    @NotBlank
    @Column(name = "valor")
    @ApiModelProperty(position = 3 , required = true, value = "Valor do serviço", example = "R$ 100,00")
    private Float valor;

    @Column(name = "descricao")
    @ApiModelProperty(position = 4 , required = true, value = "Descrição do serviço", example = "Lavagem de carro")
    private String descricao;

}
