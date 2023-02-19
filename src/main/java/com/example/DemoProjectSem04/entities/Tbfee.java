/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tbfee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbfee.findAll", query = "SELECT t FROM Tbfee t"),
    @NamedQuery(name = "Tbfee.findByFeecode", query = "SELECT t FROM Tbfee t WHERE t.feecode = :feecode"),
    @NamedQuery(name = "Tbfee.findByClassblock", query = "SELECT t FROM Tbfee t WHERE t.classblock = :classblock"),
    @NamedQuery(name = "Tbfee.findByObjectname", query = "SELECT t FROM Tbfee t WHERE t.objectname = :objectname"),
    @NamedQuery(name = "Tbfee.findByCost", query = "SELECT t FROM Tbfee t WHERE t.cost = :cost"),
    @NamedQuery(name = "Tbfee.findByCredt", query = "SELECT t FROM Tbfee t WHERE t.credt = :credt"),
    @NamedQuery(name = "Tbfee.findByUpdt", query = "SELECT t FROM Tbfee t WHERE t.updt = :updt")})
public class Tbfee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "feecode")
    private String feecode;
    @Size(max = 10)
    @Column(name = "classblock")
    private String classblock;
    @Size(max = 250)
    @Column(name = "objectname")
    private String objectname;
    @Column(name = "cost")
    private Long cost;
    @Column(name = "credt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date credt;
    @Column(name = "updt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updt;

    public Tbfee() {
    }

    public Tbfee(String feecode) {
        this.feecode = feecode;
    }

    public String getFeecode() {
        return feecode;
    }

    public void setFeecode(String feecode) {
        this.feecode = feecode;
    }

    public String getClassblock() {
        return classblock;
    }

    public void setClassblock(String classblock) {
        this.classblock = classblock;
    }

    public String getObjectname() {
        return objectname;
    }

    public void setObjectname(String objectname) {
        this.objectname = objectname;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Date getCredt() {
        return credt;
    }

    public void setCredt(Date credt) {
        this.credt = credt;
    }

    public Date getUpdt() {
        return updt;
    }

    public void setUpdt(Date updt) {
        this.updt = updt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feecode != null ? feecode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbfee)) {
            return false;
        }
        Tbfee other = (Tbfee) object;
        if ((this.feecode == null && other.feecode != null) || (this.feecode != null && !this.feecode.equals(other.feecode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbfee[ feecode=" + feecode + " ]";
    }
    
}
