/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbfunction;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */

public interface tbFunctionRepository extends JpaRepository<Tbfunction, String> {
    @Query("SELECT t FROM Tbfunction t WHERE t.functioncode = :functioncode")
    public Tbfunction getTbfunctionByCode(@Param("functioncode") String functioncode);
}
