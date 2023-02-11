/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbclassschedule;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface tbClassScheduleRepository extends JpaRepository<Tbclassschedule, String> {
    
    @Query("SELECT t FROM Tbclassschedule t WHERE t.tbclassschedulePK.classcode = :classcode")
    public List<Tbclassschedule> getListClassScheduleByClassCode(@Param("classcode") String classcode);
}
