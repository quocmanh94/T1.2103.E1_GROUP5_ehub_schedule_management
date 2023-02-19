/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.interfaces;

import com.example.DemoProjectSem04.entities.Tbfee;
import com.example.DemoProjectSem04.repositories.tbFeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admi
 */
@Service
public class tbFeeService implements tbFeeInterface{

    @Autowired
    tbFeeRepository feeRepository;
    
    @Override
    public List<Tbfee> getAllFee() {
        return feeRepository.findAll();
    }
    
}
