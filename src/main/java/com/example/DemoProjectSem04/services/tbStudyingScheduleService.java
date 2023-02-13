/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbstudyingschedule;
import com.example.DemoProjectSem04.interfaces.tbStudyingScheduleInterface;
import com.example.DemoProjectSem04.repositories.tbStudyingScheduleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbStudyingScheduleService implements tbStudyingScheduleInterface{
    
    @Autowired
    tbStudyingScheduleRepository studyingScheduleRepository;
    
    @Override
    public void save(Tbstudyingschedule tbstudyingschedule) {
        studyingScheduleRepository.save(tbstudyingschedule);
    }

    @Override
    public List<Tbstudyingschedule> getListStudyingDateByStudentCode(String studentcode) {
        return studyingScheduleRepository.getStudentListByStudentCode(studentcode);
    }
    
}
