/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbstudyingschedule;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface tbStudyingScheduleRepository extends JpaRepository<Tbstudyingschedule, Integer> {
    
    @Query("SELECT t FROM Tbstudyingschedule t WHERE t.studentcode = :studentcode")
    public List<Tbstudyingschedule> getStudentListByStudentCode(@Param("studentcode") String studentcode);
}
