/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.DTO;

import com.example.DemoProjectSem04.entities.Tbworkingschedule;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Tbworkingstafflistdto {
    private String staffcode;
    private String staffname;
    private String staffimg;
    private String positiongroupname;
    private List<Tbteachingschedule> listworkingschedule;

    public String getStaffcode() {
        return staffcode;
    }

    public void setStaffcode(String staffcode) {
        this.staffcode = staffcode;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getStaffimg() {
        return staffimg;
    }

    public void setStaffimg(String staffimg) {
        this.staffimg = staffimg;
    }

    public String getPositiongroupname() {
        return positiongroupname;
    }

    public void setPositiongroupname(String positiongroupname) {
        this.positiongroupname = positiongroupname;
    }

    public List<Tbteachingschedule> getListworkingschedule() {
        return listworkingschedule;
    }

    public void setListworkingschedule(List<Tbteachingschedule> listworkingschedule) {
        this.listworkingschedule = listworkingschedule;
    }

    public Tbworkingstafflistdto() {
    }
    
    
}
