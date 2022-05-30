package com.lavajato.spring.api.repository;

import java.util.Optional;

import com.lavajato.spring.api.entity.EnumerateRoles;
import com.lavajato.spring.api.entity.Roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
  Optional<Roles> findByName(EnumerateRoles name);
}
