/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.DTO.Tbteacherdto;
import com.example.DemoProjectSem04.entities.Tbclassschedule;
import com.example.DemoProjectSem04.entities.Tbcourseclass;
import com.example.DemoProjectSem04.entities.Tbstaff;
import com.example.DemoProjectSem04.interfaces.tbStaffInterface;
import com.example.DemoProjectSem04.repositories.tbStaffRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbStaffService implements tbStaffInterface{
    @Autowired
    tbStaffRepository staffRepository;

    @Override
    public List<Tbstaff> findAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Tbstaff findStaffByEmail(String email) {
        return staffRepository.getStaffByEmail(email);
    }

    @Override
    public void updateProfile(Tbstaff tbstaff) {
        staffRepository.save(tbstaff);
    }

    @Override
    public Tbstaff findStaffByCode(String code) {
        return staffRepository.getStaffByCode(code);
    }

    @Override
    public List<Tbstaff> findStaffByTypeCode(String code) {
        return staffRepository.getStaffByTypeCode(code);
    }

    @Override
    public String getMaxCodeStaff() {
        return staffRepository.getMaxCodeStaff();
    }

    @Override
    public List<Tbstaff> findTeacherCreateClass(Date startday, Date endday, String dow, String room) {
        return staffRepository.getListStaffCreateClass(startday, endday, dow, room);
    }

    @Override
    public List<Tbstaff> findTeacherHaveClassInTime(Date startday, Date endday, String dow, String room, String shift) {
        return staffRepository.getListStaffHaveClassInTime(startday, endday, dow, room, shift);
    }

}
