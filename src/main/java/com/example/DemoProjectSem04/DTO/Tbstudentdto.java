/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.DTO;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Tbstudentdto {
    private String studentcode;
    private String studentname;
    private String classcode;
    private String classname;

    public Tbstudentdto() {
    }
    private Date dob;
    private String parentname;
    private String parentphone;
    private String statuspaid;

    public String getStudentcode() {
        return studentcode;
    }

    public void setStudentcode(String studentcode) {
        this.studentcode = studentcode;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public String getParentphone() {
        return parentphone;
    }

    public void setParentphone(String parentphone) {
        this.parentphone = parentphone;
    }

    public String getStatuspaid() {
        return statuspaid;
    }

    public void setStatuspaid(String statuspaid) {
        this.statuspaid = statuspaid;
    }
    
}
