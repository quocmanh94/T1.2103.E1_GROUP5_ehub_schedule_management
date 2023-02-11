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
@Table(name = "tbday")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbday.findAll", query = "SELECT t FROM Tbday t"),
    @NamedQuery(name = "Tbday.findByDaycode", query = "SELECT t FROM Tbday t WHERE t.daycode = :daycode"),
    @NamedQuery(name = "Tbday.findByDayname", query = "SELECT t FROM Tbday t WHERE t.dayname = :dayname"),
    @NamedQuery(name = "Tbday.findByCentercode", query = "SELECT t FROM Tbday t WHERE t.centercode = :centercode"),
    @NamedQuery(name = "Tbday.findByIslock", query = "SELECT t FROM Tbday t WHERE t.islock = :islock")})
public class Tbday implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "daycode")
    private String daycode;
    @Size(max = 250)
    @Column(name = "dayname")
    private String dayname;
    @Column(name = "centercode")
    private Integer centercode;
    @Column(name = "islock")
    private Integer islock;

    public Tbday() {
    }

    public Tbday(String daycode) {
        this.daycode = daycode;
    }

    public String getDaycode() {
        return daycode;
    }

    public void setDaycode(String daycode) {
        this.daycode = daycode;
    }

    public String getDayname() {
        return dayname;
    }

    public void setDayname(String dayname) {
        this.dayname = dayname;
    }

    public Integer getCentercode() {
        return centercode;
    }

    public void setCentercode(Integer centercode) {
        this.centercode = centercode;
    }

    public Integer getIslock() {
        return islock;
    }

    public void setIslock(Integer islock) {
        this.islock = islock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (daycode != null ? daycode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbday)) {
            return false;
        }
        Tbday other = (Tbday) object;
        if ((this.daycode == null && other.daycode != null) || (this.daycode != null && !this.daycode.equals(other.daycode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbday[ daycode=" + daycode + " ]";
    }
    
}
