/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbcourseclass;
import com.example.DemoProjectSem04.interfaces.tbCourseClassInterface;
import com.example.DemoProjectSem04.repositories.tbCourseClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbCourseClassService implements tbCourseClassInterface{

    @Autowired
    tbCourseClassRepository courseClassRepository;
    
    @Override
    public void saveCourseClass(Tbcourseclass tbcourseclass) {
        courseClassRepository.save(tbcourseclass);
    }

    @Override
    public Tbcourseclass getCourseClassByClassCode(String code) {
        return courseClassRepository.getCourseClassByClassCode(code);
    }
    
}
