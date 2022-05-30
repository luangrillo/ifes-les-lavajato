package com.lavajato.spring.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "uf")
@Getter @Setter
public class Uf {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sigla")
    private String sigla;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "uf", cascade = CascadeType.ALL)
    private List<Cidade> cidades;
}
