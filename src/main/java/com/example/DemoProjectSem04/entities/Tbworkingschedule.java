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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tbworkingschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbworkingschedule.findAll", query = "SELECT t FROM Tbworkingschedule t"),
    @NamedQuery(name = "Tbworkingschedule.findByWorkingschedulecode", query = "SELECT t FROM Tbworkingschedule t WHERE t.workingschedulecode = :workingschedulecode"),
    @NamedQuery(name = "Tbworkingschedule.findByStaffcode", query = "SELECT t FROM Tbworkingschedule t WHERE t.staffcode = :staffcode"),
    @NamedQuery(name = "Tbworkingschedule.findByClasstimecode", query = "SELECT t FROM Tbworkingschedule t WHERE t.classtimecode = :classtimecode"),
    @NamedQuery(name = "Tbworkingschedule.findByClasscode", query = "SELECT t FROM Tbworkingschedule t WHERE t.classcode = :classcode"),
    @NamedQuery(name = "Tbworkingschedule.findByClassroomcode", query = "SELECT t FROM Tbworkingschedule t WHERE t.classroomcode = :classroomcode"),
    @NamedQuery(name = "Tbworkingschedule.findByWorkingday", query = "SELECT t FROM Tbworkingschedule t WHERE t.workingday = :workingday"),
    @NamedQuery(name = "Tbworkingschedule.findByMonth", query = "SELECT t FROM Tbworkingschedule t WHERE t.month = :month"),
    @NamedQuery(name = "Tbworkingschedule.findByYear", query = "SELECT t FROM Tbworkingschedule t WHERE t.year = :year"),
    @NamedQuery(name = "Tbworkingschedule.findByCentercode", query = "SELECT t FROM Tbworkingschedule t WHERE t.centercode = :centercode"),
    @NamedQuery(name = "Tbworkingschedule.findByStaffforeigner", query = "SELECT t FROM Tbworkingschedule t WHERE t.staffforeigner = :staffforeigner"),
    @NamedQuery(name = "Tbworkingschedule.findByIsforeign", query = "SELECT t FROM Tbworkingschedule t WHERE t.isforeign = :isforeign"),
    @NamedQuery(name = "Tbworkingschedule.findByCompleted", query = "SELECT t FROM Tbworkingschedule t WHERE t.completed = :completed")})
public class Tbworkingschedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "workingschedulecode")
    private Integer workingschedulecode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "staffcode")
    private String staffcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "classtimecode")
    private String classtimecode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "classcode")
    private String classcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "classroomcode")
    private String classroomcode;
    @Column(name = "workingday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date workingday;
    @Column(name = "month")
    private Integer month;
    @Column(name = "year")
    private Integer year;
    @Column(name = "centercode")
    private Integer centercode;
    @Size(max = 10)
    @Column(name = "staffforeigner")
    private String staffforeigner;
    @Column(name = "isforeign")
    private Integer isforeign;
    @Column(name = "completed")
    private Integer completed;

    public Tbworkingschedule() {
    }

    public Tbworkingschedule(Integer workingschedulecode) {
        this.workingschedulecode = workingschedulecode;
    }

    public Tbworkingschedule(Integer workingschedulecode, String staffcode, String classtimecode, String classcode, String classroomcode) {
        this.workingschedulecode = workingschedulecode;
        this.staffcode = staffcode;
        this.classtimecode = classtimecode;
        this.classcode = classcode;
        this.classroomcode = classroomcode;
    }

    public Integer getWorkingschedulecode() {
        return workingschedulecode;
    }

    public void setWorkingschedulecode(Integer workingschedulecode) {
        this.workingschedulecode = workingschedulecode;
    }

    public String getStaffcode() {
        return staffcode;
    }

    public void setStaffcode(String staffcode) {
        this.staffcode = staffcode;
    }

    public String getClasstimecode() {
        return classtimecode;
    }

    public void setClasstimecode(String classtimecode) {
        this.classtimecode = classtimecode;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getClassroomcode() {
        return classroomcode;
    }

    public void setClassroomcode(String classroomcode) {
        this.classroomcode = classroomcode;
    }

    public Date getWorkingday() {
        return workingday;
    }

    public void setWorkingday(Date workingday) {
        this.workingday = workingday;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCentercode() {
        return centercode;
    }

    public void setCentercode(Integer centercode) {
        this.centercode = centercode;
    }

    public String getStaffforeigner() {
        return staffforeigner;
    }

    public void setStaffforeigner(String staffforeigner) {
        this.staffforeigner = staffforeigner;
    }

    public Integer getIsforeign() {
        return isforeign;
    }

    public void setIsforeign(Integer isforeign) {
        this.isforeign = isforeign;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workingschedulecode != null ? workingschedulecode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbworkingschedule)) {
            return false;
        }
        Tbworkingschedule other = (Tbworkingschedule) object;
        if ((this.workingschedulecode == null && other.workingschedulecode != null) || (this.workingschedulecode != null && !this.workingschedulecode.equals(other.workingschedulecode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbworkingschedule[ workingschedulecode=" + workingschedulecode + " ]";
    }
    
}
