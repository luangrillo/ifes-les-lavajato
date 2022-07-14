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
    private Integer id;

    @Column(length = 250, unique = true)
    private String placa;

    @Column(length = 250)
    private String modelo;

    @Column(length = 250)
    private String cor;

    @Column(length = 250)
    private String ano;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    
}
