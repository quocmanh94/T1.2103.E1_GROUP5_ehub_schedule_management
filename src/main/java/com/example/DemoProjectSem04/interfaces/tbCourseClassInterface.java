/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.interfaces;

import com.example.DemoProjectSem04.entities.Tbcourseclass;

/**
 *
 * @author Admin
 */
public interface tbCourseClassInterface {
    public void saveCourseClass(Tbcourseclass tbcourseclass);
    public Tbcourseclass getCourseClassByClassCode(String code);
}
