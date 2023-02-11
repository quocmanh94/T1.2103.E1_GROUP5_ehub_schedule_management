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
@Table(name = "tbshift")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbshift.findAll", query = "SELECT t FROM Tbshift t"),
    @NamedQuery(name = "Tbshift.findByShiftcode", query = "SELECT t FROM Tbshift t WHERE t.shiftcode = :shiftcode"),
    @NamedQuery(name = "Tbshift.findByShiftname", query = "SELECT t FROM Tbshift t WHERE t.shiftname = :shiftname"),
    @NamedQuery(name = "Tbshift.findByCentercode", query = "SELECT t FROM Tbshift t WHERE t.centercode = :centercode"),
    @NamedQuery(name = "Tbshift.findByIsclock", query = "SELECT t FROM Tbshift t WHERE t.isclock = :isclock")})
public class Tbshift implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "shiftcode")
    private String shiftcode;
    @Size(max = 250)
    @Column(name = "shiftname")
    private String shiftname;
    @Column(name = "centercode")
    private Integer centercode;
    @Column(name = "isclock")
    private Integer isclock;

    public Tbshift() {
    }

    public Tbshift(String shiftcode) {
        this.shiftcode = shiftcode;
    }

    public String getShiftcode() {
        return shiftcode;
    }

    public void setShiftcode(String shiftcode) {
        this.shiftcode = shiftcode;
    }

    public String getShiftname() {
        return shiftname;
    }

    public void setShiftname(String shiftname) {
        this.shiftname = shiftname;
    }

    public Integer getCentercode() {
        return centercode;
    }

    public void setCentercode(Integer centercode) {
        this.centercode = centercode;
    }

    public Integer getIsclock() {
        return isclock;
    }

    public void setIsclock(Integer isclock) {
        this.isclock = isclock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shiftcode != null ? shiftcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbshift)) {
            return false;
        }
        Tbshift other = (Tbshift) object;
        if ((this.shiftcode == null && other.shiftcode != null) || (this.shiftcode != null && !this.shiftcode.equals(other.shiftcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbshift[ shiftcode=" + shiftcode + " ]";
    }
    
}
