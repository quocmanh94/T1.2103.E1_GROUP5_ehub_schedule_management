/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.interfaces;

import com.example.DemoProjectSem04.entities.Tbcenter;
import com.example.DemoProjectSem04.entities.Tbfunction;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface tbFunctionInterface {
    public List<Tbfunction> findAllFunction();
    public Tbfunction getFunctionById(String id);
}
