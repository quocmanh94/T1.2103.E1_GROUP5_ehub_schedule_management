/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbmodule;
import com.example.DemoProjectSem04.interfaces.tbModuleInterface;
import com.example.DemoProjectSem04.repositories.tbModuleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbModuleService implements tbModuleInterface{

    @Autowired
    tbModuleRepository moduleRepository;
    
    @Override
    public List<Tbmodule> findAllModule() {
        return moduleRepository.findAll();
    }

    @Override
    public List<Tbmodule> findAllModuleByClassBlock(String idClassBlock) {
        return moduleRepository.getModuleByClassBlock(idClassBlock);
    }

    @Override
    public Tbmodule findModuleByCode(String code) {
        return moduleRepository.getModuleByCode(code);
    }

    @Override
    public List<Tbmodule> getModuleByCourseCode(String coursecode) {
        return moduleRepository.getModuleByCourseCode(coursecode);
    }
    
}
