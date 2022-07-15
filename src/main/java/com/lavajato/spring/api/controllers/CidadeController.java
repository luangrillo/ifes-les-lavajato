package com.lavajato.spring.api.controllers;

import java.util.Collection;

import javax.validation.Valid;

import com.lavajato.spring.api.entity.Cidade;
import com.lavajato.spring.api.entity.Uf;
import com.lavajato.spring.api.security.services.exceptions.ConstraintException;
import com.lavajato.spring.api.security.services.CidadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidade;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Cidade>> findAll() {
        Collection<Cidade> collection = cidade.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cidade> find(@PathVariable Integer id) {
        Cidade obj = cidade.findById(id);
        return ResponseEntity.ok().body(obj);
    }




    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Cidade> insert(@Valid @RequestBody Cidade obj, BindingResult br) {
        if (br.hasErrors()) {
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
		}
        obj = cidade.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cidade> update(@Valid @RequestBody Cidade obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = cidade.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cidade.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @RequestMapping(value="/findByUf/{idUf}", method=RequestMethod.GET)
	public ResponseEntity<Collection<Cidade>> findByUf(@PathVariable Integer idUf) {
		Uf obj = new Uf();
		obj.setId(idUf);
		Collection<Cidade> collection = cidade.findByUf(obj);
		return ResponseEntity.ok().body(collection);
	}

}