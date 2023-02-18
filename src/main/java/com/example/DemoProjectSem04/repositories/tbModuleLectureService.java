/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbmodulelecture;
import com.example.DemoProjectSem04.interfaces.tbModuleLectureInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbModuleLectureService implements tbModuleLectureInterface{

    @Autowired
    tbModuleLectureRepository moduleLectureRepository;
    
    @Override
    public List<Tbmodulelecture> getLectureListByModule(String module) {
        return moduleLectureRepository.getLectureByModule(module);
    }
    
}
