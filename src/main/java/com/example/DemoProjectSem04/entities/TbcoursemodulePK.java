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
public class TbcoursemodulePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "coursecode")
    private String coursecode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "modulecode")
    private String modulecode;

    public TbcoursemodulePK() {
    }

    public TbcoursemodulePK(String coursecode, String modulecode) {
        this.coursecode = coursecode;
        this.modulecode = modulecode;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getModulecode() {
        return modulecode;
    }

    public void setModulecode(String modulecode) {
        this.modulecode = modulecode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coursecode != null ? coursecode.hashCode() : 0);
        hash += (modulecode != null ? modulecode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbcoursemodulePK)) {
            return false;
        }
        TbcoursemodulePK other = (TbcoursemodulePK) object;
        if ((this.coursecode == null && other.coursecode != null) || (this.coursecode != null && !this.coursecode.equals(other.coursecode))) {
            return false;
        }
        if ((this.modulecode == null && other.modulecode != null) || (this.modulecode != null && !this.modulecode.equals(other.modulecode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.TbcoursemodulePK[ coursecode=" + coursecode + ", modulecode=" + modulecode + " ]";
    }
    
}
