package com.lavajato.spring.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "endereco")	
@Getter @Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 256)
    private String rua;

    @NotBlank
    @Size(min=8, max = 8)
    private String cep;

    @NotBlank
    @Size(max = 6)
    private String numero;
    
    @NotBlank
    private String bairro;

    private String complemento;

    private String observacoes;

    @ManyToOne
    private Cidade cidade;

    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;
}
