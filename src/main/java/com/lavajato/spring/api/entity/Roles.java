package com.lavajato.spring.api.entity;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "roles")
@NoArgsConstructor
@Getter @Setter
public class Roles {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private EnumerateRoles name;

  @Builder
  public Roles(Integer id, EnumerateRoles name) {
    this.id = id;
    this.name = name;
  }

}