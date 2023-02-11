/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.interfaces;

import com.example.DemoProjectSem04.entities.Tbclassroom;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */

public interface tbClassroomInterface {
    public List<Tbclassroom> findAllClassroom();
    public List<Tbclassroom> findClassroomCreateClass(Date startday, Date endday, String dayofweek);
    public Tbclassroom findClassroomByCode(String code);
    public void saveClassroom(Tbclassroom tbclassroom);
    public void deleteClassroom(Tbclassroom tbclassroom);
}
