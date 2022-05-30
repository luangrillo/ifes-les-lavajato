package com.lavajato.spring.api.entity;

import java.util.Set;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cliente", uniqueConstraints = {
    @UniqueConstraint(columnNames = "cpf"),
    @UniqueConstraint(columnNames = "telefone"),
    @UniqueConstraint(columnNames = "email")
})
@Getter @Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(length = 250, unique = true)
    @CPF
    private String cpf;

    @NotBlank
    @Column(length = 250, unique = true)
    private String nome;
    
    @Column(length = 250, unique = true)
    private String telefone;

    @Column(length = 250, unique = true)
    private String email;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Set<Veiculo> veiculos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Set<Pedido> pedidos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;
    
}
