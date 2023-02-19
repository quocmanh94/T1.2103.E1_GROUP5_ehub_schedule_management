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
@Table(name = "tbadvise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbadvise.findAll", query = "SELECT t FROM Tbadvise t"),
    @NamedQuery(name = "Tbadvise.findByAdviseid", query = "SELECT t FROM Tbadvise t WHERE t.adviseid = :adviseid"),
    @NamedQuery(name = "Tbadvise.findByAdvisename", query = "SELECT t FROM Tbadvise t WHERE t.advisename = :advisename"),
    @NamedQuery(name = "Tbadvise.findByAdviseemail", query = "SELECT t FROM Tbadvise t WHERE t.adviseemail = :adviseemail"),
    @NamedQuery(name = "Tbadvise.findByAdviseclassblock", query = "SELECT t FROM Tbadvise t WHERE t.adviseclassblock = :adviseclassblock"),
    @NamedQuery(name = "Tbadvise.findByAdvisecoursename", query = "SELECT t FROM Tbadvise t WHERE t.advisecoursename = :advisecoursename"),
    @NamedQuery(name = "Tbadvise.findByAdvisecontent", query = "SELECT t FROM Tbadvise t WHERE t.advisecontent = :advisecontent"),
    @NamedQuery(name = "Tbadvise.findByAdivsestatus", query = "SELECT t FROM Tbadvise t WHERE t.adivsestatus = :adivsestatus")})
public class Tbadvise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adviseid")
    private Integer adviseid;
    @Size(max = 250)
    @Column(name = "advisename")
    private String advisename;
    @Size(max = 250)
    @Column(name = "adviseemail")
    private String adviseemail;
    @Size(max = 10)
    @Column(name = "adviseclassblock")
    private String adviseclassblock;
    @Size(max = 250)
    @Column(name = "advisecoursename")
    private String advisecoursename;
    @Size(max = 500)
    @Column(name = "advisecontent")
    private String advisecontent;
    @Column(name = "adivsestatus")
    private Integer adivsestatus;

    public Tbadvise() {
    }

    public Tbadvise(Integer adviseid) {
        this.adviseid = adviseid;
    }

    public Integer getAdviseid() {
        return adviseid;
    }

    public void setAdviseid(Integer adviseid) {
        this.adviseid = adviseid;
    }

    public String getAdvisename() {
        return advisename;
    }

    public void setAdvisename(String advisename) {
        this.advisename = advisename;
    }

    public String getAdviseemail() {
        return adviseemail;
    }

    public void setAdviseemail(String adviseemail) {
        this.adviseemail = adviseemail;
    }

    public String getAdviseclassblock() {
        return adviseclassblock;
    }

    public void setAdviseclassblock(String adviseclassblock) {
        this.adviseclassblock = adviseclassblock;
    }

    public String getAdvisecoursename() {
        return advisecoursename;
    }

    public void setAdvisecoursename(String advisecoursename) {
        this.advisecoursename = advisecoursename;
    }

    public String getAdvisecontent() {
        return advisecontent;
    }

    public void setAdvisecontent(String advisecontent) {
        this.advisecontent = advisecontent;
    }

    public Integer getAdivsestatus() {
        return adivsestatus;
    }

    public void setAdivsestatus(Integer adivsestatus) {
        this.adivsestatus = adivsestatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adviseid != null ? adviseid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbadvise)) {
            return false;
        }
        Tbadvise other = (Tbadvise) object;
        if ((this.adviseid == null && other.adviseid != null) || (this.adviseid != null && !this.adviseid.equals(other.adviseid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbadvise[ adviseid=" + adviseid + " ]";
    }
    
}
