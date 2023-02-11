/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.interfaces;

import com.example.DemoProjectSem04.entities.Tbcenter;
import com.example.DemoProjectSem04.entities.Tbuser;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface tbCenterInterface {
    public List<Tbcenter> findAllCenter();
    public Tbcenter findCenterById(int id);
    public void saveCenter(Tbcenter tbcenter);
}
