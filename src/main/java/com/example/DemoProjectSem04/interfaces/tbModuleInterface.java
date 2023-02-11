/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.interfaces;

import com.example.DemoProjectSem04.entities.Tbmodule;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface tbModuleInterface {
    public List<Tbmodule> findAllModule();
    public List<Tbmodule> findAllModuleByClassBlock(String idClassBlock);
    public Tbmodule findModuleByCode(String code);
    public List<Tbmodule> getModuleByCourseCode(String code);
}
