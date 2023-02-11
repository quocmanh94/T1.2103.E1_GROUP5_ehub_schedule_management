/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.interfaces;

import com.example.DemoProjectSem04.entities.Tbcoursemodule;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface tbCourseModuleInterface {
    public List<Tbcoursemodule> findCourseModuleByCourse(String course);
}
