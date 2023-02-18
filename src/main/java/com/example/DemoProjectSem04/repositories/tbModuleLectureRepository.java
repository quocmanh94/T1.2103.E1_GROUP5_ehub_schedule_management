/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbmodulelecture;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface tbModuleLectureRepository extends JpaRepository<Tbmodulelecture, Integer> {
    @Query("SELECT t FROM Tbmodulelecture t WHERE t.modulecode = :modulecode")
    public List<Tbmodulelecture> getLectureByModule(@Param("modulecode") String modulecode);
}
