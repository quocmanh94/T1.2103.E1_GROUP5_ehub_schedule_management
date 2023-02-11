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
public class Tbcoursedto {
    private String coursecode;
    private String coursename;
    private Date opentimecourse;
    private Date startcourse;
    private Date endcourse;
    private Integer numberlesson;
    private Integer year;
    private Integer month;
    private String status;

    public Tbcoursedto() {
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Date getOpentimecourse() {
        return opentimecourse;
    }

    public void setOpentimecourse(Date opentimecourse) {
        this.opentimecourse = opentimecourse;
    }

    public Date getStartcourse() {
        return startcourse;
    }

    public void setStartcourse(Date startcourse) {
        this.startcourse = startcourse;
    }

    public Date getEndcourse() {
        return endcourse;
    }

    public void setEndcourse(Date endcourse) {
        this.endcourse = endcourse;
    }

    public Integer getNumberlesson() {
        return numberlesson;
    }

    public void setNumberlesson(Integer numberlesson) {
        this.numberlesson = numberlesson;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
