/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbday;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Admin
 */
public interface tbDayRepository extends JpaRepository<Tbday, String> {
    
}
