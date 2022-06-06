package com.lavajato.spring.api.controllers;

import java.util.Collection;

import javax.validation.Valid;

import com.lavajato.spring.api.entity.Uf;
import com.lavajato.spring.api.repository.exeptions.ConstraintException;
import com.lavajato.spring.api.security.services.UfService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/uf")
public class UfController {

    @Autowired
    private UfService service;

   

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Uf>> findAll() {
        Collection<Uf> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Uf> find(@PathVariable Integer id) {
        Uf obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
        
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Uf> insert(@Valid @RequestBody Uf obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Uf> update(@Valid @RequestBody Uf obj, BindingResult br) {
    	if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}