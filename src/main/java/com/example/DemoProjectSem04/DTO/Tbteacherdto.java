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
public class Tbteacherdto {
    private String teachercode;
    private String teachername;
    private int islock;

    public Tbteacherdto(String teachercode, String teachername, int islock) {
        this.teachercode = teachercode;
        this.teachername = teachername;
        this.islock = islock;
    }

    public Tbteacherdto() {
    }

    public String getTeachercode() {
        return teachercode;
    }

    public void setTeachercode(String teachercode) {
        this.teachercode = teachercode;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public int getIslock() {
        return islock;
    }

    public void setIslock(int islock) {
        this.islock = islock;
    }
    
}
