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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbfunction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbfunction.findAll", query = "SELECT t FROM Tbfunction t"),
    @NamedQuery(name = "Tbfunction.findByFunctioncode", query = "SELECT t FROM Tbfunction t WHERE t.functioncode = :functioncode"),
    @NamedQuery(name = "Tbfunction.findByFunctionname", query = "SELECT t FROM Tbfunction t WHERE t.functionname = :functionname"),
    @NamedQuery(name = "Tbfunction.findByFunctionnote", query = "SELECT t FROM Tbfunction t WHERE t.functionnote = :functionnote"),
    @NamedQuery(name = "Tbfunction.findByCentercode", query = "SELECT t FROM Tbfunction t WHERE t.centercode = :centercode"),
    @NamedQuery(name = "Tbfunction.findByFunctionisclock", query = "SELECT t FROM Tbfunction t WHERE t.functionisclock = :functionisclock")})
public class Tbfunction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "functioncode")
    private String functioncode;
    @Size(max = 250)
    @Column(name = "functionname")
    private String functionname;
    @Size(max = 2147483647)
    @Column(name = "functionnote")
    private String functionnote;
    @Column(name = "centercode")
    private Integer centercode;
    @Column(name = "functionisclock")
    private Integer functionisclock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbfunction")
    @JsonBackReference
    private List<Tbpositiongroupfunction> tbpositiongroupfunctionList;
    @JoinColumn(name = "functiontype", referencedColumnName = "ftcode")
    @ManyToOne
    @JsonBackReference
    private Tbfunctiontype functiontype;

    public Tbfunction() {
    }

    public Tbfunction(String functioncode) {
        this.functioncode = functioncode;
    }

    public String getFunctioncode() {
        return functioncode;
    }

    public void setFunctioncode(String functioncode) {
        this.functioncode = functioncode;
    }

    public String getFunctionname() {
        return functionname;
    }

    public void setFunctionname(String functionname) {
        this.functionname = functionname;
    }

    public String getFunctionnote() {
        return functionnote;
    }

    public void setFunctionnote(String functionnote) {
        this.functionnote = functionnote;
    }

    public Integer getCentercode() {
        return centercode;
    }

    public void setCentercode(Integer centercode) {
        this.centercode = centercode;
    }

    public Integer getFunctionisclock() {
        return functionisclock;
    }

    public void setFunctionisclock(Integer functionisclock) {
        this.functionisclock = functionisclock;
    }

    @XmlTransient
    public List<Tbpositiongroupfunction> getTbpositiongroupfunctionList() {
        return tbpositiongroupfunctionList;
    }

    public void setTbpositiongroupfunctionList(List<Tbpositiongroupfunction> tbpositiongroupfunctionList) {
        this.tbpositiongroupfunctionList = tbpositiongroupfunctionList;
    }

    public Tbfunctiontype getFunctiontype() {
        return functiontype;
    }

    public void setFunctiontype(Tbfunctiontype functiontype) {
        this.functiontype = functiontype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (functioncode != null ? functioncode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbfunction)) {
            return false;
        }
        Tbfunction other = (Tbfunction) object;
        if ((this.functioncode == null && other.functioncode != null) || (this.functioncode != null && !this.functioncode.equals(other.functioncode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbfunction[ functioncode=" + functioncode + " ]";
    }
    
}
