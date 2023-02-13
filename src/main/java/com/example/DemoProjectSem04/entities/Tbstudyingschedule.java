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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tbstudyingschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbstudyingschedule.findAll", query = "SELECT t FROM Tbstudyingschedule t"),
    @NamedQuery(name = "Tbstudyingschedule.findByStudyingschedulecode", query = "SELECT t FROM Tbstudyingschedule t WHERE t.studyingschedulecode = :studyingschedulecode"),
    @NamedQuery(name = "Tbstudyingschedule.findByStudentcode", query = "SELECT t FROM Tbstudyingschedule t WHERE t.studentcode = :studentcode"),
    @NamedQuery(name = "Tbstudyingschedule.findByClasscode", query = "SELECT t FROM Tbstudyingschedule t WHERE t.classcode = :classcode"),
    @NamedQuery(name = "Tbstudyingschedule.findByWorkingday", query = "SELECT t FROM Tbstudyingschedule t WHERE t.workingday = :workingday"),
    @NamedQuery(name = "Tbstudyingschedule.findByCompleted", query = "SELECT t FROM Tbstudyingschedule t WHERE t.completed = :completed"),
    @NamedQuery(name = "Tbstudyingschedule.findByCentercode", query = "SELECT t FROM Tbstudyingschedule t WHERE t.centercode = :centercode"),
    @NamedQuery(name = "Tbstudyingschedule.findByCredt", query = "SELECT t FROM Tbstudyingschedule t WHERE t.credt = :credt")})
public class Tbstudyingschedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "studyingschedulecode")
    private Integer studyingschedulecode;
    @Size(max = 10)
    @Column(name = "studentcode")
    private String studentcode;
    @Size(max = 10)
    @Column(name = "classcode")
    private String classcode;
    @Column(name = "workingday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date workingday;
    @Column(name = "completed")
    private Integer completed;
    @Column(name = "centercode")
    private Integer centercode;
    @Column(name = "credt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date credt;

    public Tbstudyingschedule() {
    }

    public Tbstudyingschedule(Integer studyingschedulecode) {
        this.studyingschedulecode = studyingschedulecode;
    }

    public Integer getStudyingschedulecode() {
        return studyingschedulecode;
    }

    public void setStudyingschedulecode(Integer studyingschedulecode) {
        this.studyingschedulecode = studyingschedulecode;
    }

    public String getStudentcode() {
        return studentcode;
    }

    public void setStudentcode(String studentcode) {
        this.studentcode = studentcode;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public Date getWorkingday() {
        return workingday;
    }

    public void setWorkingday(Date workingday) {
        this.workingday = workingday;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getCentercode() {
        return centercode;
    }

    public void setCentercode(Integer centercode) {
        this.centercode = centercode;
    }

    public Date getCredt() {
        return credt;
    }

    public void setCredt(Date credt) {
        this.credt = credt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studyingschedulecode != null ? studyingschedulecode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbstudyingschedule)) {
            return false;
        }
        Tbstudyingschedule other = (Tbstudyingschedule) object;
        if ((this.studyingschedulecode == null && other.studyingschedulecode != null) || (this.studyingschedulecode != null && !this.studyingschedulecode.equals(other.studyingschedulecode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbstudyingschedule[ studyingschedulecode=" + studyingschedulecode + " ]";
    }
    
}
