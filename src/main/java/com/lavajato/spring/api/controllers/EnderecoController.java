package com.lavajato.spring.api.controllers;



import java.util.Collection;

import javax.validation.Valid;

import com.lavajato.spring.api.entity.Endereco;
import com.lavajato.spring.api.security.services.exceptions.ConstraintException;
import com.lavajato.spring.api.security.services.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"https://lavajatofrontend.herokuapp.com"}, maxAge = 3600)
@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService endereco;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Endereco>> findAll() {
        Collection<Endereco> collection = endereco.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Endereco> find(@PathVariable Long id) {
        Endereco obj = endereco.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Endereco> insert(@Valid @RequestBody Endereco obj, BindingResult br) {
        if (br.hasErrors()) {
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
		}
        obj = endereco.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Endereco> saveManager(@Valid @RequestBody Endereco obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = endereco.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Endereco> update(@Valid @RequestBody Endereco obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = endereco.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        endereco.delete(id);
        return ResponseEntity.noContent().build();
    }

}