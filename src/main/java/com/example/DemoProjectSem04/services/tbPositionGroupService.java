/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbpositiongroup;
import com.example.DemoProjectSem04.interfaces.tbPositionGroupInterface;
import com.example.DemoProjectSem04.repositories.TbpositiongroupRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */

@Service
public class tbPositionGroupService implements tbPositionGroupInterface{

    @Autowired
    TbpositiongroupRepository tbpositiongroupRepository;
    
    @Override
    public List<Tbpositiongroup> findAllPositionGroup() {
        return tbpositiongroupRepository.getListTbpositiongroup();
    }

    @Override
    public Tbpositiongroup getPositionGroupById(String code) {
        return tbpositiongroupRepository.getTbpositiongroupByCode(code);
    }
    
}
