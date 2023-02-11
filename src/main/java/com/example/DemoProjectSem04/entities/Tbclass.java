/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tbclass")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbclass.findAll", query = "SELECT t FROM Tbclass t"),
    @NamedQuery(name = "Tbclass.findByClasscode", query = "SELECT t FROM Tbclass t WHERE t.classcode = :classcode"),
    @NamedQuery(name = "Tbclass.findByClassname", query = "SELECT t FROM Tbclass t WHERE t.classname = :classname"),
    @NamedQuery(name = "Tbclass.findByClasscontent", query = "SELECT t FROM Tbclass t WHERE t.classcontent = :classcontent"),
    @NamedQuery(name = "Tbclass.findByStaffcode", query = "SELECT t FROM Tbclass t WHERE t.staffcode = :staffcode"),
    @NamedQuery(name = "Tbclass.findByMonth", query = "SELECT t FROM Tbclass t WHERE t.month = :month"),
    @NamedQuery(name = "Tbclass.findByYear", query = "SELECT t FROM Tbclass t WHERE t.year = :year"),
    @NamedQuery(name = "Tbclass.findByCentercode", query = "SELECT t FROM Tbclass t WHERE t.centercode = :centercode"),
    @NamedQuery(name = "Tbclass.findByStatus", query = "SELECT t FROM Tbclass t WHERE t.status = :status"),
    @NamedQuery(name = "Tbclass.findByIslock", query = "SELECT t FROM Tbclass t WHERE t.islock = :islock"),
    @NamedQuery(name = "Tbclass.findByManage", query = "SELECT t FROM Tbclass t WHERE t.manage = :manage"),
    @NamedQuery(name = "Tbclass.findByLevelcode", query = "SELECT t FROM Tbclass t WHERE t.levelcode = :levelcode")})
public class Tbclass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "classcode")
    private String classcode;
    @Size(max = 250)
    @Column(name = "classname")
    private String classname;
    @Size(max = 500)
    @Column(name = "classcontent")
    private String classcontent;
    @Size(max = 10)
    @Column(name = "staffcode")
    private String staffcode;
    @Column(name = "month")
    private Integer month;
    @Column(name = "year")
    private Integer year;
    @Column(name = "centercode")
    private Integer centercode;
    @Column(name = "status")
    private Integer status;
    @Column(name = "islock")
    private Integer islock;
    @Size(max = 10)
    @Column(name = "manage")
    private String manage;
    @Size(max = 10)
    @Column(name = "levelcode")
    private String levelcode;

    public Tbclass() {
    }

    public Tbclass(String classcode) {
        this.classcode = classcode;
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

    public String getClasscontent() {
        return classcontent;
    }

    public void setClasscontent(String classcontent) {
        this.classcontent = classcontent;
    }

    public String getStaffcode() {
        return staffcode;
    }

    public void setStaffcode(String staffcode) {
        this.staffcode = staffcode;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCentercode() {
        return centercode;
    }

    public void setCentercode(Integer centercode) {
        this.centercode = centercode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIslock() {
        return islock;
    }

    public void setIslock(Integer islock) {
        this.islock = islock;
    }

    public String getManage() {
        return manage;
    }

    public void setManage(String manage) {
        this.manage = manage;
    }

    public String getLevelcode() {
        return levelcode;
    }

    public void setLevelcode(String levelcode) {
        this.levelcode = levelcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classcode != null ? classcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbclass)) {
            return false;
        }
        Tbclass other = (Tbclass) object;
        if ((this.classcode == null && other.classcode != null) || (this.classcode != null && !this.classcode.equals(other.classcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbclass[ classcode=" + classcode + " ]";
    }
    
}
