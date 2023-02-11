/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbpositiongroup;
import com.example.DemoProjectSem04.entities.Tbpositiongroupfunction;
import com.example.DemoProjectSem04.entities.Tbuser;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface TbpositiongroupRepository extends JpaRepository<Tbpositiongroup, String> {

    @Query("SELECT t FROM Tbpositiongroup t WHERE t.pgcode = :pgcode")
    public Tbpositiongroup getTbpositiongroupByCode(@Param("pgcode") String pgcode);
    
    @Query("SELECT t FROM Tbpositiongroup t ORDER BY t.pgname")
    public List<Tbpositiongroup> getListTbpositiongroup();
}
