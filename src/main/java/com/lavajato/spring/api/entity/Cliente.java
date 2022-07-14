package com.lavajato.spring.api.entity;


import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente", uniqueConstraints = {
    @UniqueConstraint(columnNames = "cpf"),
    @UniqueConstraint(columnNames = "telefone"),
    @UniqueConstraint(columnNames = "email")
})
@Getter @Setter
@NoArgsConstructor
public class Cliente {
    @Id
    @ApiModelProperty(position = 1 , required = true, value = "Identificador do cliente", example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(length = 250, unique = true)
    @ApiModelProperty(position = 2 , required = true, value = "CPF do cliente", example = "12345678901")
    private String cpf;


    @Column(length = 250, unique = true)
    @ApiModelProperty(position = 3 , required = true, value = "Nome do cliente", example = "João")
    private String nome;
    
    @Column(length = 250, unique = true)
    @ApiModelProperty(position = 4 , required = true, value = "Telefone do cliente", example = "11999999999")
    private String telefone;

    @Column(length = 250, unique = true)
    @ApiModelProperty(position = 5 , required = true, value = "Email do cliente", example = "teste@teste.com")
    private String email;
    
    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "cliente_id")
    // private Set<Veiculo> veiculos;

    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "cliente_id")
    // private Set<Pedido> pedidos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    
}
