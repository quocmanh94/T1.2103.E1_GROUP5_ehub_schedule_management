/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbadvise;
import com.example.DemoProjectSem04.interfaces.tbAdviseInterface;
import com.example.DemoProjectSem04.repositories.tbAdviseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbAdviseService implements tbAdviseInterface{

    @Autowired
    tbAdviseRepository adviseRepository;
    
    @Override
    public void save(Tbadvise tbadvise) {
        adviseRepository.save(tbadvise);
    }

    @Override
    public List<Tbadvise> getAllAdvise() {
        return adviseRepository.getAdviseListByStatusZero();
    }
    
}
