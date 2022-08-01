package com.lavajato.spring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

import com.lavajato.spring.api.entity.Checklist;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
    Optional<Checklist> findById(Long id);

    Boolean existsById(Integer id);

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM public.checklist where id = ?1 and checklist_entrada = TRUE and checklist_saida = TRUE", nativeQuery = true)
    public  Collection<?> findChecklistsOk(Long checklist_id);
}
