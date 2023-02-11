/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbclass;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface tbClassRepository extends JpaRepository<Tbclass, String> {
    @Query("SELECT MAX(t.classcode) AS classcode FROM Tbclass t")
    public Tbclass getMaxClassCode();
    
    @Query("SELECT t FROM Tbclass t WHERE t.islock = 0")
    public List<Tbclass> getClassesStillWorking();
    
    @Query("SELECT t FROM Tbclass t WHERE t.classcode = :classcode")
    public Tbclass getClassByCode(@Param("classcode") String classcode);
}
