/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbrole;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface tbRoleRepository extends JpaRepository<Tbrole, Integer> {
    @Query("SELECT t FROM Tbrole t WHERE t.roleid in (1,5,7,6)")
    public List<Tbrole> getTypeStaff();
}
