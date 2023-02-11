/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbcoursemodule;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface tbCourseModuleRepository extends JpaRepository<Tbcoursemodule, String> {
    @Query("SELECT t FROM Tbcoursemodule t WHERE t.tbcoursemodulePK.coursecode = :coursecode")
    public List<Tbcoursemodule> getListCourseModuleByCourse(@Param("coursecode") String coursecode);
}
