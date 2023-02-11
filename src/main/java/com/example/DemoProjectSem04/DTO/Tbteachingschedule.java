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
public class Tbteachingschedule {
    private String staffcode;
    private String classtimecode;
    private String classcode;
    private String classroomcode;
    private Date workingday;
    private String month;
    private String day;
    private String year;
    private String classtimename;
    private String classname;

    public String getClasstimename() {
        return classtimename;
    }

    public void setClasstimename(String classtimename) {
        this.classtimename = classtimename;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getClassroomname() {
        return classroomname;
    }

    public void setClassroomname(String classroomname) {
        this.classroomname = classroomname;
    }
    private String classroomname;
    public Tbteachingschedule() {
    }

    public String getStaffcode() {
        return staffcode;
    }

    public void setStaffcode(String staffcode) {
        this.staffcode = staffcode;
    }

    public String getClasstimecode() {
        return classtimecode;
    }

    public void setClasstimecode(String classtimecode) {
        this.classtimecode = classtimecode;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getClassroomcode() {
        return classroomcode;
    }

    public void setClassroomcode(String classroomcode) {
        this.classroomcode = classroomcode;
    }

    public Date getWorkingday() {
        return workingday;
    }

    public void setWorkingday(Date workingday) {
        this.workingday = workingday;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    
    
    
    
}
