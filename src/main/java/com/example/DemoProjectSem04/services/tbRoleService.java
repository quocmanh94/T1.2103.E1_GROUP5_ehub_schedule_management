/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbrole;
import com.example.DemoProjectSem04.interfaces.tbRoleInterface;
import com.example.DemoProjectSem04.repositories.tbRoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbRoleService implements tbRoleInterface{

    @Autowired
    tbRoleRepository roleRepository;
    
    @Override
    public List<Tbrole> getTypeStaff() {
        return roleRepository.getTypeStaff();
    }
    
}
