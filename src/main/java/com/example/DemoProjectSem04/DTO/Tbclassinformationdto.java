/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.DTO;

import java.util.List;

/**
 *
 * @author Admin
 */
public class Tbclassinformationdto {

    private String classcode;
    private String classname;
    private List<String> timestudying;
    private String shiftcode;
    private String shiftname;
    private int toalseats;
    private int actuallyseats;
    private String classroomname;
    private List<String> teacher;
    
    public String getClassroomname() {
        return classroomname;
    }

    public void setClassroomname(String classroomname) {
        this.classroomname = classroomname;
    }
    

    public Tbclassinformationdto() {
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

    public List<String> getTimestudying() {
        return timestudying;
    }

    public void setTimestudying(List<String> timestudying) {
        this.timestudying = timestudying;
    }

    public List<String> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<String> teacher) {
        this.teacher = teacher;
    }

    

    public String getShiftcode() {
        return shiftcode;
    }

    public void setShiftcode(String shiftcode) {
        this.shiftcode = shiftcode;
    }

    public String getShiftname() {
        return shiftname;
    }

    public void setShiftname(String shiftname) {
        this.shiftname = shiftname;
    }

    public int getToalseats() {
        return toalseats;
    }

    public void setToalseats(int toalseats) {
        this.toalseats = toalseats;
    }

    public int getActuallyseats() {
        return actuallyseats;
    }

    public void setActuallyseats(int actuallyseats) {
        this.actuallyseats = actuallyseats;
    }  

}
