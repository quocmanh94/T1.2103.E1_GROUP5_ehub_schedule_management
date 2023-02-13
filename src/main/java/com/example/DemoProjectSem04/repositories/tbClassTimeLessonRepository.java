/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbclasstimelesson;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface tbClassTimeLessonRepository extends JpaRepository<Tbclasstimelesson, String> {
    @Query("SELECT t FROM Tbclasstimelesson t WHERE t.islock = 0")
    public List<Tbclasstimelesson> getListClassTimeLessonIsLock();
    
    @Query("SELECT t FROM Tbclasstimelesson t WHERE t.ctlcode = :ctlcode and t.islock = 0")
    public Tbclasstimelesson getClassTimeLessonById(@Param("ctlcode") String ctlcode);
}
