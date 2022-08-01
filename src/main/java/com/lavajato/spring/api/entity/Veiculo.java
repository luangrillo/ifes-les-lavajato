package com.lavajato.spring.api.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "veiculo")
@NoArgsConstructor
@Getter @Setter
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(position = 1 , required = true, value = "Identificador do veículo", example = "0")
    private Long id;

    @Column(length = 250, unique = true)
    @ApiModelProperty(position = 2 , required = true, value = "Placa do veículo", example = "ABC-1234")
    private String placa;

    @Column(length = 250)
    @ApiModelProperty(position = 3 , required = true, value = "Modelo do veículo", example = "Fusca")
    private String modelo;

    @Column(length = 250)
    @ApiModelProperty(position = 4 , required = true, value = "Marca do veículo", example = "Volkswagen")
    private String cor;

    @Column(length = 4)
    @ApiModelProperty(position = 5 , required = true, value = "Ano do veículo", example = "1979")
    private String ano;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    
}
