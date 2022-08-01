package com.lavajato.spring.api.controllers;

import java.util.Collection;

import javax.validation.Valid;

import com.lavajato.spring.api.entity.Checklist;
import com.lavajato.spring.api.security.services.exceptions.ConstraintException;
import com.lavajato.spring.api.security.services.ChecklistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/checklist")
public class ChecklistController {

    @Autowired
    private ChecklistService checklist;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Checklist>> findAll() {
        Collection<Checklist> collection = checklist.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Checklist> find(@PathVariable Long id) {
        Checklist obj = checklist.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Checklist> insert(@Valid @RequestBody Checklist obj, BindingResult br) {
        if (br.hasErrors()) {
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
		}
        obj = checklist.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Checklist> update(@Valid @RequestBody Checklist obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = checklist.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        checklist.delete(id);
        return ResponseEntity.noContent().build();
    }

}