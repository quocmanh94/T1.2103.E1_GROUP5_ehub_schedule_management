/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbworkingschedule;
import com.example.DemoProjectSem04.interfaces.tbWorkingScheduleInterface;
import com.example.DemoProjectSem04.repositories.tbWorkingScheduleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbWorkingScheduleService implements tbWorkingScheduleInterface{

    @Autowired
    tbWorkingScheduleRepository workingScheduleRepository;
    
    @Override
    public void createWorkingSchedule(Tbworkingschedule tbworkingschedule) {
        workingScheduleRepository.save(tbworkingschedule);
    }

    @Override
    public List<Tbworkingschedule> getWorkingDateByStaffCode(String staffcode) {
        return workingScheduleRepository.getWorkingDateByUserCode(staffcode);
    }
    
}
