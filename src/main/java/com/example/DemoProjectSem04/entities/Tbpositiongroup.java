/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tbpositiongroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbpositiongroup.findAll", query = "SELECT t FROM Tbpositiongroup t"),
    @NamedQuery(name = "Tbpositiongroup.findByPgcode", query = "SELECT t FROM Tbpositiongroup t WHERE t.pgcode = :pgcode"),
    @NamedQuery(name = "Tbpositiongroup.findByPgname", query = "SELECT t FROM Tbpositiongroup t WHERE t.pgname = :pgname"),
    @NamedQuery(name = "Tbpositiongroup.findByPgnote", query = "SELECT t FROM Tbpositiongroup t WHERE t.pgnote = :pgnote"),
    @NamedQuery(name = "Tbpositiongroup.findByCentercode", query = "SELECT t FROM Tbpositiongroup t WHERE t.centercode = :centercode"),
    @NamedQuery(name = "Tbpositiongroup.findByPgisdelete", query = "SELECT t FROM Tbpositiongroup t WHERE t.pgisdelete = :pgisdelete")})
public class Tbpositiongroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pgcode")
    private String pgcode;
    @Size(max = 250)
    @Column(name = "pgname")
    private String pgname;
    @Size(max = 2147483647)
    @Column(name = "pgnote")
    private String pgnote;
    @Column(name = "centercode")
    private Integer centercode;
    @Column(name = "pgisdelete")
    private Integer pgisdelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbpositiongroup")
    @JsonBackReference
    private List<Tbpositiongroupfunction> tbpositiongroupfunctionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permision")
    @JsonBackReference
    private List<Tbuser> tbuserList;

    public Tbpositiongroup() {
    }

    public Tbpositiongroup(String pgcode) {
        this.pgcode = pgcode;
    }

    public String getPgcode() {
        return pgcode;
    }

    public void setPgcode(String pgcode) {
        this.pgcode = pgcode;
    }

    public String getPgname() {
        return pgname;
    }

    public void setPgname(String pgname) {
        this.pgname = pgname;
    }

    public String getPgnote() {
        return pgnote;
    }

    public void setPgnote(String pgnote) {
        this.pgnote = pgnote;
    }

    public Integer getCentercode() {
        return centercode;
    }

    public void setCentercode(Integer centercode) {
        this.centercode = centercode;
    }

    public Integer getPgisdelete() {
        return pgisdelete;
    }

    public void setPgisdelete(Integer pgisdelete) {
        this.pgisdelete = pgisdelete;
    }

    @XmlTransient
    public List<Tbpositiongroupfunction> getTbpositiongroupfunctionList() {
        return tbpositiongroupfunctionList;
    }

    public void setTbpositiongroupfunctionList(List<Tbpositiongroupfunction> tbpositiongroupfunctionList) {
        this.tbpositiongroupfunctionList = tbpositiongroupfunctionList;
    }

    @XmlTransient
    public List<Tbuser> getTbuserList() {
        return tbuserList;
    }

    public void setTbuserList(List<Tbuser> tbuserList) {
        this.tbuserList = tbuserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pgcode != null ? pgcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbpositiongroup)) {
            return false;
        }
        Tbpositiongroup other = (Tbpositiongroup) object;
        if ((this.pgcode == null && other.pgcode != null) || (this.pgcode != null && !this.pgcode.equals(other.pgcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbpositiongroup[ pgcode=" + pgcode + " ]";
    }
    
}
