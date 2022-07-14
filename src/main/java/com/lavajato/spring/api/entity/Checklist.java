package com.lavajato.spring.api.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "checklist")
@Getter @Setter
public class Checklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "O campo data_entrada é obrigatório")
    @Column(name = "data_entrada")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEntrada;

    @Column(name = "data_saida")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataSaida;
    
    @NotBlank(message = "O campo lataria é obrigatório")
    @Column(name= "lataria")
    private Boolean lataria;

    @NotBlank(message = "O campo pneu é obrigatório")
    @Column(name= "pneu")
    private Boolean pneu;

    @NotBlank(message = "O campo vidro é obrigatório")
    @Column(name= "vidro")
    private Boolean vidro;

    @NotBlank(message = "O campo quilimetragem é obrigatório")
    @Column(name= "quilimetragem")
    private Boolean quilometragem;

    @NotBlank(message = "O campo farois_lanternas é obrigatório")
    @Column(name= "farois_lanternas")
    private Boolean faroisLanternas;

    @NotBlank(message = "O campo interior_veiculo é obrigatório")
    @Column(name= "interior_veiculo")
    private Boolean interiro_veiculo;

    @NotBlank(message = "O campo checklist_entrada é obrigatório")
    @Column(name= "checklist_entrada")
    private Boolean checklistEntrada;

    @Column(name= "checklist_saida")
    private Boolean checklistSaida;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    private Pedido pedido;

    @Builder
    public Checklist(Integer id, Date dataEntrada, Date dataSaida, Boolean lataria, Boolean pneu, Boolean vidro, Boolean quilometragem, Boolean faroisLanternas, Boolean interiro_veiculo, Boolean checklistEntrada, Boolean checklistSaida, Pedido pedido) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.lataria = lataria;
        this.pneu = pneu;
        this.vidro = vidro;
        this.quilometragem = quilometragem;
        this.faroisLanternas = faroisLanternas;
        this.interiro_veiculo = interiro_veiculo;
        this.checklistEntrada = checklistEntrada;
        this.checklistSaida = checklistSaida;
        this.pedido = pedido;
    }

}
