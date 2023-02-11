/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbclasstime")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbclasstime.findAll", query = "SELECT t FROM Tbclasstime t"),
    @NamedQuery(name = "Tbclasstime.findByClasstimecode", query = "SELECT t FROM Tbclasstime t WHERE t.classtimecode = :classtimecode"),
    @NamedQuery(name = "Tbclasstime.findByClasstimename", query = "SELECT t FROM Tbclasstime t WHERE t.classtimename = :classtimename"),
    @NamedQuery(name = "Tbclasstime.findByCentercode", query = "SELECT t FROM Tbclasstime t WHERE t.centercode = :centercode"),
    @NamedQuery(name = "Tbclasstime.findByIslock", query = "SELECT t FROM Tbclasstime t WHERE t.islock = :islock")})
public class Tbclasstime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "classtimecode")
    private String classtimecode;
    @Size(max = 50)
    @Column(name = "classtimename")
    private String classtimename;
    @Column(name = "centercode")
    private Integer centercode;
    @Column(name = "islock")
    private Integer islock;
    @JoinColumn(name = "classtimelesson", referencedColumnName = "ctlcode")
    @ManyToOne
    @JsonBackReference
    private Tbclasstimelesson classtimelesson;

    public Tbclasstime() {
    }

    public Tbclasstime(String classtimecode) {
        this.classtimecode = classtimecode;
    }

    public String getClasstimecode() {
        return classtimecode;
    }

    public void setClasstimecode(String classtimecode) {
        this.classtimecode = classtimecode;
    }

    public String getClasstimename() {
        return classtimename;
    }

    public void setClasstimename(String classtimename) {
        this.classtimename = classtimename;
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

    public Tbclasstimelesson getClasstimelesson() {
        return classtimelesson;
    }

    public void setClasstimelesson(Tbclasstimelesson classtimelesson) {
        this.classtimelesson = classtimelesson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classtimecode != null ? classtimecode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbclasstime)) {
            return false;
        }
        Tbclasstime other = (Tbclasstime) object;
        if ((this.classtimecode == null && other.classtimecode != null) || (this.classtimecode != null && !this.classtimecode.equals(other.classtimecode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbclasstime[ classtimecode=" + classtimecode + " ]";
    }
    
}
