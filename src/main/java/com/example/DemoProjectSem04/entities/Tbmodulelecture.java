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
@Table(name = "tbmodulelecture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbmodulelecture.findAll", query = "SELECT t FROM Tbmodulelecture t"),
    @NamedQuery(name = "Tbmodulelecture.findByModulelectureid", query = "SELECT t FROM Tbmodulelecture t WHERE t.modulelectureid = :modulelectureid"),
    @NamedQuery(name = "Tbmodulelecture.findByModulecode", query = "SELECT t FROM Tbmodulelecture t WHERE t.modulecode = :modulecode"),
    @NamedQuery(name = "Tbmodulelecture.findByLecturecode", query = "SELECT t FROM Tbmodulelecture t WHERE t.lecturecode = :lecturecode"),
    @NamedQuery(name = "Tbmodulelecture.findByLecturename", query = "SELECT t FROM Tbmodulelecture t WHERE t.lecturename = :lecturename")})
public class Tbmodulelecture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "modulelectureid")
    private Integer modulelectureid;
    @Size(max = 10)
    @Column(name = "modulecode")
    private String modulecode;
    @Size(max = 10)
    @Column(name = "lecturecode")
    private String lecturecode;
    @Size(max = 250)
    @Column(name = "lecturename")
    private String lecturename;

    public Tbmodulelecture() {
    }

    public Tbmodulelecture(Integer modulelectureid) {
        this.modulelectureid = modulelectureid;
    }

    public Integer getModulelectureid() {
        return modulelectureid;
    }

    public void setModulelectureid(Integer modulelectureid) {
        this.modulelectureid = modulelectureid;
    }

    public String getModulecode() {
        return modulecode;
    }

    public void setModulecode(String modulecode) {
        this.modulecode = modulecode;
    }

    public String getLecturecode() {
        return lecturecode;
    }

    public void setLecturecode(String lecturecode) {
        this.lecturecode = lecturecode;
    }

    public String getLecturename() {
        return lecturename;
    }

    public void setLecturename(String lecturename) {
        this.lecturename = lecturename;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modulelectureid != null ? modulelectureid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbmodulelecture)) {
            return false;
        }
        Tbmodulelecture other = (Tbmodulelecture) object;
        if ((this.modulelectureid == null && other.modulelectureid != null) || (this.modulelectureid != null && !this.modulelectureid.equals(other.modulelectureid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbmodulelecture[ modulelectureid=" + modulelectureid + " ]";
    }
    
}
