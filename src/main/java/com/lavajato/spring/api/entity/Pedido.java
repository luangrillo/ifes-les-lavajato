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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "pedido")
@Getter @Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;   

    @Column(name = "valor_acrecimo")
    @Min(0)
    @Max(9999)
    private Double valorAcrecimo;

    @Column(name = "valor_desconto")
    @Min(0)
    @Max(9999)
    private Double valorDesconto;

    @Column(name = "data_inicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;

    @Column(name = "obs")
    @NotBlank
    @Size(max = 99999)
    private String observacoes;

    @Column(name = "status")
    @NotBlank
    private String status;

    @ManyToMany()
    @JoinTable(name = "pedido_servico", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "servico_id"))
    Set<Servico> servico;

    @OneToOne(mappedBy = "pedido")
    private Checklist Checklist;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Builder
    public Pedido(Integer id, Double valorAcrecimo, Double valorDesconto, Date dataInicio, String observacoes, String status, Set<Servico> servico, Checklist checklist, User user, Cliente cliente) {
        this.id = id;
        this.valorAcrecimo = valorAcrecimo;
        this.valorDesconto = valorDesconto;
        this.dataInicio = dataInicio;
        this.observacoes = observacoes;
        this.status = status;
        this.servico = servico;
        this.Checklist = checklist;
        this.user = user;
        this.cliente = cliente;
    }

}
