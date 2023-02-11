/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.interfaces;

import com.example.DemoProjectSem04.entities.Tbclassschedule;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface tbClassScheduleInterface {
    public void createNewClassSchedule(Tbclassschedule tbclassschedule);
    public List<Tbclassschedule> getListClassScheduleByClassCode(String classCode);
}
