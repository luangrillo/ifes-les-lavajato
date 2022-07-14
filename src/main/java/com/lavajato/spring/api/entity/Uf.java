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
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "uf")
@NoArgsConstructor
@Getter @Setter
public class Uf {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(position = 1 , required = true, value = "Identificador da UF", example = "0")
    private Integer id;

    @NotBlank
    @Column(name = "sigla")
    @ApiModelProperty(position = 2 , required = true, value = "Sigla da UF", example = "SP")
    private String sigla;

    @NotBlank
    @Column(name = "nome")
    @ApiModelProperty(position = 3 , required = true, value = "Nome da UF", example = "São Paulo")
    private String nome;

}
