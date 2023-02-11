/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tbpositiongroupfunction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbpositiongroupfunction.findAll", query = "SELECT t FROM Tbpositiongroupfunction t"),
    @NamedQuery(name = "Tbpositiongroupfunction.findByPgcode", query = "SELECT t FROM Tbpositiongroupfunction t WHERE t.tbpositiongroupfunctionPK.pgcode = :pgcode"),
    @NamedQuery(name = "Tbpositiongroupfunction.findByFunctioncode", query = "SELECT t FROM Tbpositiongroupfunction t WHERE t.tbpositiongroupfunctionPK.functioncode = :functioncode"),
    @NamedQuery(name = "Tbpositiongroupfunction.findByCentercode", query = "SELECT t FROM Tbpositiongroupfunction t WHERE t.centercode = :centercode"),
    @NamedQuery(name = "Tbpositiongroupfunction.findByIsdelete", query = "SELECT t FROM Tbpositiongroupfunction t WHERE t.isdelete = :isdelete")})
public class Tbpositiongroupfunction implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbpositiongroupfunctionPK tbpositiongroupfunctionPK;
    @Column(name = "centercode")
    private Integer centercode;
    @Column(name = "isdelete")
    private Integer isdelete;
    @JoinColumn(name = "functioncode", referencedColumnName = "functioncode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonBackReference
    private Tbfunction tbfunction;
    @JoinColumn(name = "pgcode", referencedColumnName = "pgcode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonBackReference
    private Tbpositiongroup tbpositiongroup;

    public Tbpositiongroupfunction() {
    }

    public Tbpositiongroupfunction(TbpositiongroupfunctionPK tbpositiongroupfunctionPK) {
        this.tbpositiongroupfunctionPK = tbpositiongroupfunctionPK;
    }

    public Tbpositiongroupfunction(String pgcode, String functioncode) {
        this.tbpositiongroupfunctionPK = new TbpositiongroupfunctionPK(pgcode, functioncode);
    }

    public TbpositiongroupfunctionPK getTbpositiongroupfunctionPK() {
        return tbpositiongroupfunctionPK;
    }

    public void setTbpositiongroupfunctionPK(TbpositiongroupfunctionPK tbpositiongroupfunctionPK) {
        this.tbpositiongroupfunctionPK = tbpositiongroupfunctionPK;
    }

    public Integer getCentercode() {
        return centercode;
    }

    public void setCentercode(Integer centercode) {
        this.centercode = centercode;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Tbfunction getTbfunction() {
        return tbfunction;
    }

    public void setTbfunction(Tbfunction tbfunction) {
        this.tbfunction = tbfunction;
    }

    public Tbpositiongroup getTbpositiongroup() {
        return tbpositiongroup;
    }

    public void setTbpositiongroup(Tbpositiongroup tbpositiongroup) {
        this.tbpositiongroup = tbpositiongroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbpositiongroupfunctionPK != null ? tbpositiongroupfunctionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbpositiongroupfunction)) {
            return false;
        }
        Tbpositiongroupfunction other = (Tbpositiongroupfunction) object;
        if ((this.tbpositiongroupfunctionPK == null && other.tbpositiongroupfunctionPK != null) || (this.tbpositiongroupfunctionPK != null && !this.tbpositiongroupfunctionPK.equals(other.tbpositiongroupfunctionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbpositiongroupfunction[ tbpositiongroupfunctionPK=" + tbpositiongroupfunctionPK + " ]";
    }
    
}
