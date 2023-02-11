/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbmodule;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface tbModuleRepository extends JpaRepository<Tbmodule, String> {
    @Query("SELECT t FROM Tbmodule t WHERE t.classblock = :classblock")
    public List<Tbmodule> getModuleByClassBlock(@Param("classblock") String classblock);
    
    @Query("SELECT t FROM Tbmodule t WHERE t.modulecode = :modulecode")
    public Tbmodule getModuleByCode(@Param("modulecode") String modulecode);
    
    @Query("SELECT u FROM Tbmodule u WHERE u.modulecode in (SELECT t.tbcoursemodulePK.modulecode FROM Tbcoursemodule t WHERE t.tbcoursemodulePK.coursecode = :coursecode)")
    public List<Tbmodule> getModuleByCourseCode(@Param("coursecode") String coursecode);
}
