/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbclassstudent;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface tbClassStudentRepository extends JpaRepository<Tbclassstudent, String> {
    @Query("SELECT t FROM Tbclassstudent t WHERE t.tbclassstudentPK.studentcode = :studentcode")
    public List<Tbclassstudent> getListClassStudentByStudentCode(@Param("studentcode") String studentcode);
}
