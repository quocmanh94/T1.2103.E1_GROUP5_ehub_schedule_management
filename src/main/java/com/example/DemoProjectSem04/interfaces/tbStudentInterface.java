/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.interfaces;

import com.example.DemoProjectSem04.entities.Tbstudent;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface tbStudentInterface {
    public List<Tbstudent> getStudentList();
    public Tbstudent getStudentByCode(String code);
    public Tbstudent getMaxCodeStudent();
    public List<Tbstudent> getStudentListByName(String name);
    public List<Tbstudent> getStudentListByClassCode(String classcode);
    public List<Tbstudent> getStudentListByPaid(int paid);
    public List<Tbstudent> getStudentListByPaidAndName(String name, int paid);
    public List<Tbstudent> getStudentListByClassCodeAndName(String name, String classcode);
    public List<Tbstudent> getStudentListByClassCodeAndPaid(String name, int paid);
    public List<Tbstudent> getStudentListByPaidAndNameAndClassCode(String name, int paid, String classcode);
    public void createNewStudent(Tbstudent tbstudent);
    public void editStudent(Tbstudent tbstudent);
}
