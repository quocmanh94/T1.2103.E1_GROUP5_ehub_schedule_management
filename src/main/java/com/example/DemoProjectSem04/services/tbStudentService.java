/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbstudent;
import com.example.DemoProjectSem04.interfaces.tbStudentInterface;
import com.example.DemoProjectSem04.repositories.tbStudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbStudentService implements tbStudentInterface{

    @Autowired
    tbStudentRepository studentRepository;
    
    @Override
    public List<Tbstudent> getStudentList() {
        return studentRepository.getListStudentIsStudying();
    }

    @Override
    public Tbstudent getStudentByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tbstudent getMaxCodeStudent() {
       return studentRepository.getMaxCodeStudent();
    }

    @Override
    public List<Tbstudent> getStudentListByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tbstudent> getStudentListByClassCode(String classcode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tbstudent> getStudentListByPaid(int paid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tbstudent> getStudentListByPaidAndName(String name, int paid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tbstudent> getStudentListByClassCodeAndName(String name, String classcode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tbstudent> getStudentListByClassCodeAndPaid(String name, int paid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tbstudent> getStudentListByPaidAndNameAndClassCode(String name, int paid, String classcode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createNewStudent(Tbstudent newTbstudent) {
        studentRepository.save(newTbstudent);
    }

    @Override
    public void editStudent(Tbstudent edittbstudent) {
        studentRepository.save(edittbstudent);
    }
    
}
