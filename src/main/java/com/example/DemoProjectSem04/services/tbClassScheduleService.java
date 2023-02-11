/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbclassschedule;
import com.example.DemoProjectSem04.interfaces.tbClassScheduleInterface;
import com.example.DemoProjectSem04.repositories.tbClassScheduleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbClassScheduleService implements tbClassScheduleInterface{

    @Autowired
    tbClassScheduleRepository classScheduleRepository;
    
    @Override
    public void createNewClassSchedule(Tbclassschedule tbclassschedule) {
        classScheduleRepository.save(tbclassschedule);
    }

    @Override
    public List<Tbclassschedule> getListClassScheduleByClassCode(String classCode) {
        return classScheduleRepository.getListClassScheduleByClassCode(classCode);
    }
    
}
