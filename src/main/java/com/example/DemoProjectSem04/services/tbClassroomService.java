/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbclassroom;
import com.example.DemoProjectSem04.interfaces.tbClassroomInterface;
import com.example.DemoProjectSem04.repositories.TbClassroomRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbClassroomService implements tbClassroomInterface{
    @Autowired
    TbClassroomRepository classroomRepository;

    @Override
    public List<Tbclassroom> findAllClassroom() {
        return classroomRepository.getCLassroomByStatus0();
    }

    @Override
    public Tbclassroom findClassroomByCode(String code) {
        return classroomRepository.getCLassroomByCode(code);
    }

    @Override
    public void saveClassroom(Tbclassroom tbclassroom) {
        classroomRepository.save(tbclassroom);
    }

    @Override
    public void deleteClassroom(Tbclassroom tbclassroom) {
        classroomRepository.delete(tbclassroom);
    }

    @Override
    public List<Tbclassroom> findClassroomCreateClass(Date startday, Date endday, String dayofweek) {
         return classroomRepository.getListCLassroomCreateClass(startday, endday, dayofweek);
    }
}
