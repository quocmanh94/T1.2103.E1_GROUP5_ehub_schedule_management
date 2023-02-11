/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbcenter;
import com.example.DemoProjectSem04.interfaces.tbCenterInterface;
import com.example.DemoProjectSem04.repositories.tbCenterRepositoty;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbCenterService implements tbCenterInterface{

    @Autowired
    tbCenterRepositoty centerRepositoty;
    
    @Override
    public List<Tbcenter> findAllCenter() {
        return centerRepositoty.findAll();
    }

    @Override
    public Tbcenter findCenterById(int id) {
        return (Tbcenter) centerRepositoty.findById(id);
    }

    @Override
    public void saveCenter(Tbcenter tbcenter) {
        centerRepositoty.save(tbcenter);
    }
    
}
