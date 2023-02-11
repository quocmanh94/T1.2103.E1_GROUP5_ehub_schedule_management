/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.interfaces;

import com.example.DemoProjectSem04.entities.Tbclasstime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface tbClassTimeInterface {
    public List<Tbclasstime> finClassTimeCreatClass(Date StartDay, Date EndDay, String DayofWeek, String Room);
    public Tbclasstime getClassTimeLessonByCode(String code);
    public Tbclasstime getCLassTimeByCode(String code);
}
