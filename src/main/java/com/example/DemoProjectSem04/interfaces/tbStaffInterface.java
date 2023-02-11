/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.interfaces;

import com.example.DemoProjectSem04.DTO.Tbteacherdto;
import com.example.DemoProjectSem04.entities.Tbclassschedule;
import com.example.DemoProjectSem04.entities.Tbcourseclass;
import com.example.DemoProjectSem04.entities.Tbstaff;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface tbStaffInterface {
    public List<Tbstaff> findAllStaff();
    public Tbstaff findStaffByEmail(String email);
    public Tbstaff findStaffByCode(String code);
    public List<Tbstaff> findStaffByTypeCode(String code);
    public List<Tbstaff> findTeacherCreateClass(Date startday, Date endday, String dow, String room);
    public List<Tbstaff> findTeacherHaveClassInTime(Date startday, Date endday, String dow, String room, String shift);
    public void updateProfile(Tbstaff tbstaff);
    public String getMaxCodeStaff();
}
