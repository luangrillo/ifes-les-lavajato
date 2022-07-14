package com.lavajato.spring.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "endereco")	
@NoArgsConstructor
@Getter @Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(position = 1 , required = true, value = "Identificador do endereço", example = "1")
    private Integer id;


    @Size(max = 256)
    @ApiModelProperty(position = 2 , required = false, value = "Logradouro do endereço", example = "Rua dos Bobos")
    private String rua;


    @Size(min=8, max = 8)
    @ApiModelProperty(position = 3 , required = false, value = "Número do endereço", example = "12345678")
    private String cep;


    @Size(max = 6)
    @ApiModelProperty(position = 4 , required = false, value = "Bairro do endereço", example = "Centro")
    private String numero;
    
    @Size(max = 256)
    @ApiModelProperty(position = 5 , required = false, value = "Cidade do endereço", example = "São Paulo")
    private String bairro;

    @ApiModelProperty(position = 6 , required = false, value = "Estado do endereço", example = "SP")
    private String complemento;

    @ApiModelProperty(position = 7 , required = false, value = "OBS", example = "Rua sem saida")
    private String observacoes;

    @ManyToOne
    @ApiModelProperty(position = 8 , required = false, value = "Estado do endereço", example = "SP")
    private Cidade cidade;

    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

}
