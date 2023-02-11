/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbclass;
import com.example.DemoProjectSem04.interfaces.tbClassInterface;
import com.example.DemoProjectSem04.repositories.tbClassRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbClassService implements tbClassInterface{

    @Autowired
    tbClassRepository classRepository;
    
    @Override
    public Tbclass findMaxClassCode() {
        return classRepository.getMaxClassCode();
    }

    @Override
    public void createClass(Tbclass tbclass) {
        classRepository.save(tbclass);
    }

    @Override
    public List<Tbclass> getClassesStillWorking() {
        return classRepository.getClassesStillWorking();
    }

    @Override
    public Tbclass findClassByCode(String code) {
        return classRepository.getClassByCode(code);
    }
    
}
