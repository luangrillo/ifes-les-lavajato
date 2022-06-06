package com.lavajato.spring.api.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "veiculo")
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
    
}
