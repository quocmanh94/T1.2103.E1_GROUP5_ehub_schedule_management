/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.DTO.Tbfindroomaddclass;
import com.example.DemoProjectSem04.entities.Tbcourseclass;
import com.example.DemoProjectSem04.entities.Tbfunctiontype;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */

public interface tbCourseClassRepository extends JpaRepository<Tbcourseclass, String> {
    @Query("SELECT t FROM Tbcourseclass t WHERE t.tbcourseclassPK.classcode = :classcode")
    public Tbcourseclass getCourseClassByClassCode(@Param("classcode") String classcode);
}
