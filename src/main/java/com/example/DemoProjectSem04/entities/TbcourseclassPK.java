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
public class TbcourseclassPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "coursecode")
    private String coursecode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "classcode")
    private String classcode;

    public TbcourseclassPK() {
    }

    public TbcourseclassPK(String coursecode, String classcode) {
        this.coursecode = coursecode;
        this.classcode = classcode;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coursecode != null ? coursecode.hashCode() : 0);
        hash += (classcode != null ? classcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbcourseclassPK)) {
            return false;
        }
        TbcourseclassPK other = (TbcourseclassPK) object;
        if ((this.coursecode == null && other.coursecode != null) || (this.coursecode != null && !this.coursecode.equals(other.coursecode))) {
            return false;
        }
        if ((this.classcode == null && other.classcode != null) || (this.classcode != null && !this.classcode.equals(other.classcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.TbcourseclassPK[ coursecode=" + coursecode + ", classcode=" + classcode + " ]";
    }
    
}
