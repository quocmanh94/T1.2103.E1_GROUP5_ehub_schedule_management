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
@Table(name = "tbfunctiontype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbfunctiontype.findAll", query = "SELECT t FROM Tbfunctiontype t"),
    @NamedQuery(name = "Tbfunctiontype.findByFtcode", query = "SELECT t FROM Tbfunctiontype t WHERE t.ftcode = :ftcode"),
    @NamedQuery(name = "Tbfunctiontype.findByFtname", query = "SELECT t FROM Tbfunctiontype t WHERE t.ftname = :ftname"),
    @NamedQuery(name = "Tbfunctiontype.findByFtnote", query = "SELECT t FROM Tbfunctiontype t WHERE t.ftnote = :ftnote"),
    @NamedQuery(name = "Tbfunctiontype.findByFtisclock", query = "SELECT t FROM Tbfunctiontype t WHERE t.ftisclock = :ftisclock"),
    @NamedQuery(name = "Tbfunctiontype.findByFtisdelete", query = "SELECT t FROM Tbfunctiontype t WHERE t.ftisdelete = :ftisdelete")})
public class Tbfunctiontype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ftcode")
    private String ftcode;
    @Size(max = 250)
    @Column(name = "ftname")
    private String ftname;
    @Size(max = 500)
    @Column(name = "ftnote")
    private String ftnote;
    @Column(name = "ftisclock")
    private Integer ftisclock;
    @Column(name = "ftisdelete")
    private Integer ftisdelete;
    @OneToMany(mappedBy = "functiontype")
    @JsonBackReference
    private List<Tbfunction> tbfunctionList;

    public Tbfunctiontype() {
    }

    public Tbfunctiontype(String ftcode) {
        this.ftcode = ftcode;
    }

    public String getFtcode() {
        return ftcode;
    }

    public void setFtcode(String ftcode) {
        this.ftcode = ftcode;
    }

    public String getFtname() {
        return ftname;
    }

    public void setFtname(String ftname) {
        this.ftname = ftname;
    }

    public String getFtnote() {
        return ftnote;
    }

    public void setFtnote(String ftnote) {
        this.ftnote = ftnote;
    }

    public Integer getFtisclock() {
        return ftisclock;
    }

    public void setFtisclock(Integer ftisclock) {
        this.ftisclock = ftisclock;
    }

    public Integer getFtisdelete() {
        return ftisdelete;
    }

    public void setFtisdelete(Integer ftisdelete) {
        this.ftisdelete = ftisdelete;
    }

    @XmlTransient
    public List<Tbfunction> getTbfunctionList() {
        return tbfunctionList;
    }

    public void setTbfunctionList(List<Tbfunction> tbfunctionList) {
        this.tbfunctionList = tbfunctionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ftcode != null ? ftcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbfunctiontype)) {
            return false;
        }
        Tbfunctiontype other = (Tbfunctiontype) object;
        if ((this.ftcode == null && other.ftcode != null) || (this.ftcode != null && !this.ftcode.equals(other.ftcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbfunctiontype[ ftcode=" + ftcode + " ]";
    }
    
}
