/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.DTO;

/**
 *
 * @author Admin
 */
public class Tbclassdto {
    private String classcode;
    private String classname;
    private String coursecode;
    private String coursename;

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
    private String coursetime;
    private String classroomcode;
    private String classroomname;
    private String classstatus;

    public Tbclassdto() {
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(String coursetime) {
        this.coursetime = coursetime;
    }

    public String getClassroomcode() {
        return classroomcode;
    }

    public void setClassroomcode(String classroomcode) {
        this.classroomcode = classroomcode;
    }

    public String getClassroomname() {
        return classroomname;
    }

    public void setClassroomname(String classroomname) {
        this.classroomname = classroomname;
    }

    public String getClassstatus() {
        return classstatus;
    }

    public void setClassstatus(String classstatus) {
        this.classstatus = classstatus;
    }
    
}
