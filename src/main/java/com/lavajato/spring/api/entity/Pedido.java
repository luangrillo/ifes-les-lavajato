package com.lavajato.spring.api.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "pedido")
@Getter @Setter
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(position = 1 , required = true, value = "Identificador do pedido", example = "0")
    private Integer id;   

    @Column(name = "valor_acrecimo")
    @Min(0)
    @Max(9999)
    @ApiModelProperty(position = 2 , required = true, value = "Valor do acréscimo", example = "0")
    private Double valorAcrecimo;

    @Column(name = "valor_desconto")
    @Min(0)
    @Max(9999)
    @ApiModelProperty(position = 3 , required = true, value = "Valor do desconto", example = "0")
    private Double valorDesconto;

    @Column(name = "data_inicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    @ApiModelProperty(position = 4 , required = true, value = "Data de início do pedido", example = "2020-01-01")
    private Date dataInicio;

    @Column(name = "obs")
    @NotBlank
    @Size(max = 99999)
    @ApiModelProperty(position = 5 , required = true, value = "Observação do pedido", example = "Lavagem de carro")
    private String observacoes;

    @Column(name = "status")
    @NotBlank
    @ApiModelProperty(position = 6 , required = true, value = "Status do pedido", example = "ABERTO")
    private String status;

    @ManyToMany()
    @JoinTable(name = "pedido_servico", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "servico_id"))
    Set<Servico> servico;


    @NotBlank
    @ManyToOne
    @JoinColumn(name = "user_id")
    @ApiModelProperty(position = 7 , required = true, value = "Identificador do usuário", example = "1")
    private User user;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @ApiModelProperty(position = 8 , required = true, value = "Identificador do cliente", example = "1")
    private Cliente cliente;


}
