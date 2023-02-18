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

/**
 *
 * @author Admin
 */
public interface tbUserAppRepository extends JpaRepository<Tbuser, String> {
    @Query("SELECT t FROM Tbuser t WHERE t.password = :password and t.useremail = :useremail")
    public Tbuser getUserByEmailPassword(@Param("password") String password,@Param("useremail") String useremail);
}
