/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbcourse;
import com.example.DemoProjectSem04.interfaces.tbCourseInterface;
import com.example.DemoProjectSem04.repositories.tbCourseRepository;
import java.util.Date;
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

    @Override
    public Tbcourse getMaxCode() {
        return courseRepository.getMaxCode();
    }

    @Override
    public void save(Tbcourse tbcourse) {
        courseRepository.save(tbcourse);
    }

    @Override
    public void updateEndDate(Date enddate, String coursecode) {
        courseRepository.updateEndDate(enddate, coursecode);
    }
    
}
