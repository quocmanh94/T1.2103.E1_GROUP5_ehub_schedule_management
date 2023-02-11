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
public class TbclassstudentPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "classcode")
    private String classcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "studentcode")
    private String studentcode;

    public TbclassstudentPK() {
    }

    public TbclassstudentPK(String classcode, String studentcode) {
        this.classcode = classcode;
        this.studentcode = studentcode;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getStudentcode() {
        return studentcode;
    }

    public void setStudentcode(String studentcode) {
        this.studentcode = studentcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classcode != null ? classcode.hashCode() : 0);
        hash += (studentcode != null ? studentcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbclassstudentPK)) {
            return false;
        }
        TbclassstudentPK other = (TbclassstudentPK) object;
        if ((this.classcode == null && other.classcode != null) || (this.classcode != null && !this.classcode.equals(other.classcode))) {
            return false;
        }
        if ((this.studentcode == null && other.studentcode != null) || (this.studentcode != null && !this.studentcode.equals(other.studentcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.TbclassstudentPK[ classcode=" + classcode + ", studentcode=" + studentcode + " ]";
    }
    
}
