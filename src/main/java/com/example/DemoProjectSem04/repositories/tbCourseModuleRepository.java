/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbcoursemodule;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface tbCourseModuleRepository extends JpaRepository<Tbcoursemodule, String> {

    @Query("SELECT t FROM Tbcoursemodule t WHERE t.tbcoursemodulePK.coursecode = :coursecode")
    public List<Tbcoursemodule> getListCourseModuleByCourse(@Param("coursecode") String coursecode);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("Update Tbcoursemodule t set t.todate =:todate where t.tbcoursemodulePK.coursecode =:coursecode")
    void updateEndDate(@Param("todate") Date todate, @Param("coursecode") String coursecode);
}
