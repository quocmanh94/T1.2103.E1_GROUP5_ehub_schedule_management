/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbcourse;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface tbCourseRepository extends JpaRepository<Tbcourse, String> {
    @Query("SELECT t FROM Tbcourse t WHERE t.coursecode = :coursecode")
    public Tbcourse getCourseByCode(@Param("coursecode") String coursecode);
}
