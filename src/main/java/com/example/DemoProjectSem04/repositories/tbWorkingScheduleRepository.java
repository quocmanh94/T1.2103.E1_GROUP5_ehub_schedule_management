/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbworkingschedule;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface tbWorkingScheduleRepository extends JpaRepository<Tbworkingschedule, Integer> {
    @Query("SELECT t FROM Tbworkingschedule t WHERE t.staffcode = :staffcode order by t.workingday")
    public List<Tbworkingschedule> getWorkingDateByUserCode(@Param("staffcode") String staffcode);
}
