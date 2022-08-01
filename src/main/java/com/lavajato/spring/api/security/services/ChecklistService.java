package com.lavajato.spring.api.security.services;

import java.util.List;

import com.lavajato.spring.api.entity.Checklist;
import com.lavajato.spring.api.repository.ChecklistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChecklistService {
    @Autowired
    private ChecklistRepository repository;

    public Checklist findById(Long id) {
        return repository.findById(id).get();
    }
    public List<Checklist> findAll() {
        return repository.findAll();
    }
    public Checklist insert(Checklist checklist) {
        return repository.save(checklist);
    }
    public Checklist update(Checklist checklist) {
        return repository.save(checklist);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
