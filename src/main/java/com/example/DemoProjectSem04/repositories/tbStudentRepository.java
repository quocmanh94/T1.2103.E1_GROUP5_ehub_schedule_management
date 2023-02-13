/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbstudent;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface tbStudentRepository extends JpaRepository<Tbstudent, String> {
    @Query("SELECT MAX(t.studentcode) as studentcode FROM Tbstudent t")
    public Tbstudent getMaxCodeStudent();
    
    @Query("SELECT t FROM Tbstudent t WHERE t.classcode = :classcode and t.isdelete = 0")
    public List<Tbstudent> getStudentListByClassCode(@Param("classcode") String classcode);
    
    @Query("SELECT t FROM Tbstudent t WHERE t.isdelete = 0")
    public List<Tbstudent> getListStudentIsStudying();
    
    @Query("SELECT t FROM Tbstudent t WHERE t.studentcode = :studentcode and  t.isdelete = 0")
    public Tbstudent getStudentByCode(@Param("studentcode") String studentcode);
    
    //public List<Tbstudent> getListCourseModuleByCourse(@Param("coursecode") String coursecode);
}
