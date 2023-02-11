/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbday;
import com.example.DemoProjectSem04.interfaces.tbDayInterface;
import com.example.DemoProjectSem04.repositories.tbDayRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbDayService implements tbDayInterface{

    @Autowired
    tbDayRepository dayRepository;
    
    @Override
    public List<Tbday> getAllDay() {
        return dayRepository.findAll();
    }
    
}
