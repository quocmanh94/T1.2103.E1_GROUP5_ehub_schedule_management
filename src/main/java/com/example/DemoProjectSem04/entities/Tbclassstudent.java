/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "tbclassstudent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbclassstudent.findAll", query = "SELECT t FROM Tbclassstudent t"),
    @NamedQuery(name = "Tbclassstudent.findByClasscode", query = "SELECT t FROM Tbclassstudent t WHERE t.tbclassstudentPK.classcode = :classcode"),
    @NamedQuery(name = "Tbclassstudent.findByStudentcode", query = "SELECT t FROM Tbclassstudent t WHERE t.tbclassstudentPK.studentcode = :studentcode"),
    @NamedQuery(name = "Tbclassstudent.findByStudentname", query = "SELECT t FROM Tbclassstudent t WHERE t.studentname = :studentname"),
    @NamedQuery(name = "Tbclassstudent.findByStudentphone", query = "SELECT t FROM Tbclassstudent t WHERE t.studentphone = :studentphone"),
    @NamedQuery(name = "Tbclassstudent.findByIsdelete", query = "SELECT t FROM Tbclassstudent t WHERE t.isdelete = :isdelete"),
    @NamedQuery(name = "Tbclassstudent.findByOldclasscode", query = "SELECT t FROM Tbclassstudent t WHERE t.oldclasscode = :oldclasscode"),
    @NamedQuery(name = "Tbclassstudent.findByNote", query = "SELECT t FROM Tbclassstudent t WHERE t.note = :note"),
    @NamedQuery(name = "Tbclassstudent.findByMonth", query = "SELECT t FROM Tbclassstudent t WHERE t.month = :month"),
    @NamedQuery(name = "Tbclassstudent.findByYear", query = "SELECT t FROM Tbclassstudent t WHERE t.year = :year"),
    @NamedQuery(name = "Tbclassstudent.findByCentercode", query = "SELECT t FROM Tbclassstudent t WHERE t.centercode = :centercode")})
public class Tbclassstudent implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbclassstudentPK tbclassstudentPK;
    @Size(max = 250)
    @Column(name = "studentname")
    private String studentname;
    @Size(max = 11)
    @Column(name = "studentphone")
    private String studentphone;
    @Column(name = "isdelete")
    private Integer isdelete;
    @Size(max = 11)
    @Column(name = "oldclasscode")
    private String oldclasscode;
    @Size(max = 500)
    @Column(name = "note")
    private String note;
    @Column(name = "month")
    private Integer month;
    @Column(name = "year")
    private Integer year;
    @Column(name = "centercode")
    private Integer centercode;

    public Tbclassstudent() {
    }

    public Tbclassstudent(TbclassstudentPK tbclassstudentPK) {
        this.tbclassstudentPK = tbclassstudentPK;
    }

    public Tbclassstudent(String classcode, String studentcode) {
        this.tbclassstudentPK = new TbclassstudentPK(classcode, studentcode);
    }

    public TbclassstudentPK getTbclassstudentPK() {
        return tbclassstudentPK;
    }

    public void setTbclassstudentPK(TbclassstudentPK tbclassstudentPK) {
        this.tbclassstudentPK = tbclassstudentPK;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentphone() {
        return studentphone;
    }

    public void setStudentphone(String studentphone) {
        this.studentphone = studentphone;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getOldclasscode() {
        return oldclasscode;
    }

    public void setOldclasscode(String oldclasscode) {
        this.oldclasscode = oldclasscode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbclassstudentPK != null ? tbclassstudentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbclassstudent)) {
            return false;
        }
        Tbclassstudent other = (Tbclassstudent) object;
        if ((this.tbclassstudentPK == null && other.tbclassstudentPK != null) || (this.tbclassstudentPK != null && !this.tbclassstudentPK.equals(other.tbclassstudentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbclassstudent[ tbclassstudentPK=" + tbclassstudentPK + " ]";
    }
    
}
