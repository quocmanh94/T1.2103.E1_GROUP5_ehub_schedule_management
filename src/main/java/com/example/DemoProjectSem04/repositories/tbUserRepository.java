/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbuser;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */

@Repository
public interface tbUserRepository extends JpaRepository<Tbuser, String> {
    @Query("SELECT t FROM Tbuser t WHERE t.useremail = :useremail")
    public Tbuser getUserByUserEmail(@Param("useremail") String useremail);
}
