/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.DTO;

import com.example.DemoProjectSem04.entities.Tbpositiongroup;
import com.example.DemoProjectSem04.entities.Tbstaff;
import com.example.DemoProjectSem04.entities.Tbuser;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Tbuserdto {
    List<Tbuser> userList;
    List<Tbuserdto2> user2List;
    List<Tbpositiongroup> positionList;
    List<Tbstaff> staffList;

    public List<Tbstaff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Tbstaff> staffList) {
        this.staffList = staffList;
    }
    
    public Tbuserdto(List<Tbuser> userList, List<Tbuserdto2> userList2, List<Tbpositiongroup> positionList, List<Tbstaff> staffList) {
        this.userList = userList;
        this.user2List = userList2;
        this.positionList = positionList;
        this.staffList = staffList;
    }

    public List<Tbuserdto2> getUser2List() {
        return user2List;
    }

    public void setUser2List(List<Tbuserdto2> user2List) {
        this.user2List = user2List;
    }

    public List<Tbuser> getUserList() {
        return userList;
    }

    public void setUserList(List<Tbuser> userList) {
        this.userList = userList;
    }

    public List<Tbpositiongroup> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Tbpositiongroup> positionList) {
        this.positionList = positionList;
    }

    public Tbuserdto() {
    }
    
}
