/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbcoursemodule;
import com.example.DemoProjectSem04.interfaces.tbCourseModuleInterface;
import com.example.DemoProjectSem04.repositories.tbCourseModuleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbCourseModuleService implements tbCourseModuleInterface{

    @Autowired
    tbCourseModuleRepository courseModuleRepository;
    
    @Override
    public List<Tbcoursemodule> findCourseModuleByCourse(String course) {
        return courseModuleRepository.getListCourseModuleByCourse(course);
    }
    
}
