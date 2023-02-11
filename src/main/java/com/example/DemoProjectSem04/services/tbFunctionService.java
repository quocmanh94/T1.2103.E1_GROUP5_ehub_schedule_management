/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbfunction;
import com.example.DemoProjectSem04.interfaces.tbFunctionInterface;
import com.example.DemoProjectSem04.repositories.tbFunctionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbFunctionService implements tbFunctionInterface{

    @Autowired
    tbFunctionRepository functionRepository;
    
    @Override
    public List<Tbfunction> findAllFunction() {
        return functionRepository.findAll();
    }

    @Override
    public Tbfunction getFunctionById(String code) {
        return functionRepository.getTbfunctionByCode(code);
    }
    
}
