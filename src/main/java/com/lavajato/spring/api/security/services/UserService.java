package com.lavajato.spring.api.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavajato.spring.api.entity.User;
import com.lavajato.spring.api.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
  
    public List<User> findAll() {
      return repository.findAll();
    }
    
}
