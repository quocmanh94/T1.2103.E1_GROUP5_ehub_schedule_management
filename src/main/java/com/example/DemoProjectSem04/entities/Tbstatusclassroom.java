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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tbstatusclassroom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbstatusclassroom.findAll", query = "SELECT t FROM Tbstatusclassroom t"),
    @NamedQuery(name = "Tbstatusclassroom.findByScrcode", query = "SELECT t FROM Tbstatusclassroom t WHERE t.scrcode = :scrcode"),
    @NamedQuery(name = "Tbstatusclassroom.findByScrname", query = "SELECT t FROM Tbstatusclassroom t WHERE t.scrname = :scrname"),
    @NamedQuery(name = "Tbstatusclassroom.findByScrnote", query = "SELECT t FROM Tbstatusclassroom t WHERE t.scrnote = :scrnote"),
    @NamedQuery(name = "Tbstatusclassroom.findByScrisclock", query = "SELECT t FROM Tbstatusclassroom t WHERE t.scrisclock = :scrisclock"),
    @NamedQuery(name = "Tbstatusclassroom.findByCentercode", query = "SELECT t FROM Tbstatusclassroom t WHERE t.centercode = :centercode")})
public class Tbstatusclassroom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "scrcode")
    private Integer scrcode;
    @Size(max = 250)
    @Column(name = "scrname")
    private String scrname;
    @Size(max = 2147483647)
    @Column(name = "scrnote")
    private String scrnote;
    @Column(name = "scrisclock")
    private Integer scrisclock;
    @Column(name = "centercode")
    private Integer centercode;

    public Tbstatusclassroom() {
    }

    public Tbstatusclassroom(Integer scrcode) {
        this.scrcode = scrcode;
    }

    public Integer getScrcode() {
        return scrcode;
    }

    public void setScrcode(Integer scrcode) {
        this.scrcode = scrcode;
    }

    public String getScrname() {
        return scrname;
    }

    public void setScrname(String scrname) {
        this.scrname = scrname;
    }

    public String getScrnote() {
        return scrnote;
    }

    public void setScrnote(String scrnote) {
        this.scrnote = scrnote;
    }

    public Integer getScrisclock() {
        return scrisclock;
    }

    public void setScrisclock(Integer scrisclock) {
        this.scrisclock = scrisclock;
    }

    public Integer getCentercode() {
        return centercode;
    }

    public void setCentercode(Integer centercode) {
        this.centercode = centercode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scrcode != null ? scrcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbstatusclassroom)) {
            return false;
        }
        Tbstatusclassroom other = (Tbstatusclassroom) object;
        if ((this.scrcode == null && other.scrcode != null) || (this.scrcode != null && !this.scrcode.equals(other.scrcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbstatusclassroom[ scrcode=" + scrcode + " ]";
    }
    
}
