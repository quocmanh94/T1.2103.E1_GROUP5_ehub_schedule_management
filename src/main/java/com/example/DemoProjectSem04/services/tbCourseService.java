/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbcourse;
import com.example.DemoProjectSem04.interfaces.tbCourseInterface;
import com.example.DemoProjectSem04.repositories.tbCourseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbCourseService implements tbCourseInterface{

    @Autowired
    tbCourseRepository courseRepository;
    
    @Override
    public List<Tbcourse> findAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Tbcourse findCourseByCode(String code) {
        return courseRepository.getCourseByCode(code);
    }
    
}
