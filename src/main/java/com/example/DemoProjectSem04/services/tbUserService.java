/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbuser;
import com.example.DemoProjectSem04.interfaces.tbUserInterface;
import com.example.DemoProjectSem04.repositories.tbUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbUserService implements tbUserInterface{

    @Autowired
    tbUserRepository repository;
    
    @Override
    public List<Tbuser> findAllUser() {
        return repository.findAll();
    }  

    @Override
    public Tbuser findUserByEmail(String email) {
        return repository.getUserByUserEmail(email);
    }

    @Override
    public void save(Tbuser tbuser) {
        repository.save(tbuser);
    }

    @Override
    public String getMaxCodeStaff() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
