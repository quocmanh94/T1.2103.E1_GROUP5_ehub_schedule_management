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
@Table(name = "tbclasstimelesson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbclasstimelesson.findAll", query = "SELECT t FROM Tbclasstimelesson t"),
    @NamedQuery(name = "Tbclasstimelesson.findByCtlcode", query = "SELECT t FROM Tbclasstimelesson t WHERE t.ctlcode = :ctlcode"),
    @NamedQuery(name = "Tbclasstimelesson.findByCtlname", query = "SELECT t FROM Tbclasstimelesson t WHERE t.ctlname = :ctlname"),
    @NamedQuery(name = "Tbclasstimelesson.findByCentercode", query = "SELECT t FROM Tbclasstimelesson t WHERE t.centercode = :centercode"),
    @NamedQuery(name = "Tbclasstimelesson.findByIslock", query = "SELECT t FROM Tbclasstimelesson t WHERE t.islock = :islock")})
public class Tbclasstimelesson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ctlcode")
    private String ctlcode;
    @Size(max = 250)
    @Column(name = "ctlname")
    private String ctlname;
    @Column(name = "centercode")
    private Integer centercode;
    @Column(name = "islock")
    private Integer islock;
    @OneToMany(mappedBy = "classtimelesson")
    @JsonBackReference
    private List<Tbclasstime> tbclasstimeList;

    public Tbclasstimelesson() {
    }

    public Tbclasstimelesson(String ctlcode) {
        this.ctlcode = ctlcode;
    }

    public String getCtlcode() {
        return ctlcode;
    }

    public void setCtlcode(String ctlcode) {
        this.ctlcode = ctlcode;
    }

    public String getCtlname() {
        return ctlname;
    }

    public void setCtlname(String ctlname) {
        this.ctlname = ctlname;
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

    @XmlTransient
    public List<Tbclasstime> getTbclasstimeList() {
        return tbclasstimeList;
    }

    public void setTbclasstimeList(List<Tbclasstime> tbclasstimeList) {
        this.tbclasstimeList = tbclasstimeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctlcode != null ? ctlcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbclasstimelesson)) {
            return false;
        }
        Tbclasstimelesson other = (Tbclasstimelesson) object;
        if ((this.ctlcode == null && other.ctlcode != null) || (this.ctlcode != null && !this.ctlcode.equals(other.ctlcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbclasstimelesson[ ctlcode=" + ctlcode + " ]";
    }
    
}
