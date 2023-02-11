/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.services;

import com.example.DemoProjectSem04.entities.Tbpositiongroupfunction;
import com.example.DemoProjectSem04.interfaces.tbPositionGroupFunctionInterface;
import com.example.DemoProjectSem04.repositories.tbPositiongroupFunctionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class tbPositionGroupFunctionService implements tbPositionGroupFunctionInterface{
    @Autowired
    tbPositiongroupFunctionRepository positiongroupFunctionRepository;

    @Override
    public List<Tbpositiongroupfunction> findAllPositionGroupFunction(String idPermision) {
        return positiongroupFunctionRepository.getFunctionByPermision(idPermision);
    }

    @Override
    public Tbpositiongroupfunction getTbpositiongroupfunctionByPermision(String idFunctionCode, String idPgCode) {
        return positiongroupFunctionRepository.getTbpositiongroupfunctionByPermision(idFunctionCode, idPgCode);
    }

    @Override
    public void createTbpositiongroupfunction(Tbpositiongroupfunction tbpositiongroupfunction) {
        positiongroupFunctionRepository.save(tbpositiongroupfunction);
    }

    @Override
    public void removeTbpositiongroupfunction(Tbpositiongroupfunction tbpositiongroupfunction) {
        positiongroupFunctionRepository.delete(tbpositiongroupfunction);
    }
}
