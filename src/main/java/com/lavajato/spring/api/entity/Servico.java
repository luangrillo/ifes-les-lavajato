package com.lavajato.spring.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
    private Integer id;   

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Column(name = "valor")
    private Float valor;

    @NotBlank
    @Column(name = "descricao")
    private String descricao;

}
