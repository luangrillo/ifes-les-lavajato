package com.lavajato.spring.api.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "email")
})
@NoArgsConstructor
@Getter @Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(position = 1 , required = true, value = "Identificador do usuário", example = "0")
  private Long id;

  @NotBlank
  @Size(max = 20)
  @ApiModelProperty(position = 2 , required = true, value = "Nome do usuário", example = "Lavajato")
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  @ApiModelProperty(position = 3 , required = true, value = "Email do usuário", example = "teste@teste.com")
  private String email;



  @Size(max = 120)
  @ApiModelProperty(position = 5 , required = true, value = "Senha do usuário", example = "1234")
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @ApiModelProperty(position = 6 , required = true, value = "Permissões do usuário", example = "ROLE_FUNCIONARIO")
  @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Roles> roles = new HashSet<>();

  // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  // private List<Pedido> pedidos;

  @Builder
  public User(String username, String email, String password) {
      this.username = username;
      this.email = email;
      this.password = password;
    }
  
}
