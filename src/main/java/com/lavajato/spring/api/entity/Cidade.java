package com.lavajato.spring.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cidade")
@NoArgsConstructor
@Getter @Setter
public class Cidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(position = 1 , required = true, value = "Identificador da cidade", example = "0")
    private Long id;

    @NotBlank
    @Column(name = "nome")
    @ApiModelProperty(position = 2 , required = true, value = "Nome da cidade", example = "São Paulo")
    private String nome;

    @NotBlank
    @ManyToOne()
    private Uf uf;



    // @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
    // private List<Endereco> enderecos;

}
