/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbadvise;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface tbAdviseRepository extends JpaRepository<Tbadvise, Integer> {
    @Query("SELECT t FROM Tbadvise t WHERE t.adivsestatus = 0")
    public List<Tbadvise> getAdviseListByStatusZero();
}
