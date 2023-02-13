/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbclassstudent;
import com.example.DemoProjectSem04.interfaces.tbClassStudentInterface;
import com.example.DemoProjectSem04.repositories.tbClassStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbClassStudentService implements tbClassStudentInterface{

    @Autowired
    tbClassStudentRepository classStudentRepository;
    
    @Override
    public void save(Tbclassstudent tbclassstudent) {
        classStudentRepository.save(tbclassstudent);
    }
    
}
