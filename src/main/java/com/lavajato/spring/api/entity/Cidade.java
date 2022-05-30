package com.lavajato.spring.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cidade")
@Getter @Setter
public class Cidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @ManyToOne
    private Uf uf;

    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

}
