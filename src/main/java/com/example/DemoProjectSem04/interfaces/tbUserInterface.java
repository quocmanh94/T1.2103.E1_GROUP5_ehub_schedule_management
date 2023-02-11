/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.interfaces;

import com.example.DemoProjectSem04.entities.Tbuser;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface tbUserInterface {
    public List<Tbuser> findAllUser();
    public Tbuser findUserByEmail(String email);
    public void save(Tbuser tbuser);
    public String getMaxCodeStaff();
}
