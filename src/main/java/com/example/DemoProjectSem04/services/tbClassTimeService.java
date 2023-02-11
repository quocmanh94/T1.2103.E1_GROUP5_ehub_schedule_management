/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbclasstime;
import com.example.DemoProjectSem04.interfaces.tbClassTimeInterface;
import com.example.DemoProjectSem04.repositories.tbClassTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
@Service
public class tbClassTimeService implements tbClassTimeInterface{

    @Autowired
    tbClassTimeRepository classTimeRepository;
    
    @Override
    public List<Tbclasstime> finClassTimeCreatClass(Date StartDay, Date EndDay, String DayofWeek, String Room) {
        return classTimeRepository.getListCLassTimeCreateClass(StartDay, EndDay, DayofWeek, Room);
    }

    @Override
    public Tbclasstime getClassTimeLessonByCode(String code) {
        return classTimeRepository.getCLassTimeLessonByCode(code);
    }

    @Override
    public Tbclasstime getCLassTimeByCode(String code) {
        return classTimeRepository.getCLassTimeByCode(code);
    }

    @Override
    public List<Tbclasstime> getListClasstimeByIslock() {
        return classTimeRepository.getListClassTimeByIslock0();
    }

    @Override
    public List<Tbclasstime> getClasstimebyShift(String id) {
        return classTimeRepository.getClassTimeByShift(id);
    }
    
}
