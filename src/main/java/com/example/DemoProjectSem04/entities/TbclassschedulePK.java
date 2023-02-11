/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Admin
 */
@Embeddable
public class TbclassschedulePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "classcode")
    private String classcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "daycode")
    private String daycode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "classtimecode")
    private String classtimecode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "teachercode")
    private String teachercode;

    public TbclassschedulePK() {
    }

    public TbclassschedulePK(String classcode, String daycode, String classtimecode, String teachercode) {
        this.classcode = classcode;
        this.daycode = daycode;
        this.classtimecode = classtimecode;
        this.teachercode = teachercode;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getDaycode() {
        return daycode;
    }

    public void setDaycode(String daycode) {
        this.daycode = daycode;
    }

    public String getClasstimecode() {
        return classtimecode;
    }

    public void setClasstimecode(String classtimecode) {
        this.classtimecode = classtimecode;
    }

    public String getTeachercode() {
        return teachercode;
    }

    public void setTeachercode(String teachercode) {
        this.teachercode = teachercode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classcode != null ? classcode.hashCode() : 0);
        hash += (daycode != null ? daycode.hashCode() : 0);
        hash += (classtimecode != null ? classtimecode.hashCode() : 0);
        hash += (teachercode != null ? teachercode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbclassschedulePK)) {
            return false;
        }
        TbclassschedulePK other = (TbclassschedulePK) object;
        if ((this.classcode == null && other.classcode != null) || (this.classcode != null && !this.classcode.equals(other.classcode))) {
            return false;
        }
        if ((this.daycode == null && other.daycode != null) || (this.daycode != null && !this.daycode.equals(other.daycode))) {
            return false;
        }
        if ((this.classtimecode == null && other.classtimecode != null) || (this.classtimecode != null && !this.classtimecode.equals(other.classtimecode))) {
            return false;
        }
        if ((this.teachercode == null && other.teachercode != null) || (this.teachercode != null && !this.teachercode.equals(other.teachercode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.TbclassschedulePK[ classcode=" + classcode + ", daycode=" + daycode + ", classtimecode=" + classtimecode + ", teachercode=" + teachercode + " ]";
    }
    
}
