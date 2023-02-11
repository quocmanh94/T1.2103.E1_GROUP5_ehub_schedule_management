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
@Table(name = "tbstudent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbstudent.findAll", query = "SELECT t FROM Tbstudent t"),
    @NamedQuery(name = "Tbstudent.findByStudentcode", query = "SELECT t FROM Tbstudent t WHERE t.studentcode = :studentcode"),
    @NamedQuery(name = "Tbstudent.findByStudentname", query = "SELECT t FROM Tbstudent t WHERE t.studentname = :studentname"),
    @NamedQuery(name = "Tbstudent.findByStudentstatus", query = "SELECT t FROM Tbstudent t WHERE t.studentstatus = :studentstatus"),
    @NamedQuery(name = "Tbstudent.findByStudentaddress", query = "SELECT t FROM Tbstudent t WHERE t.studentaddress = :studentaddress"),
    @NamedQuery(name = "Tbstudent.findByStudentphone", query = "SELECT t FROM Tbstudent t WHERE t.studentphone = :studentphone"),
    @NamedQuery(name = "Tbstudent.findByStudentemail", query = "SELECT t FROM Tbstudent t WHERE t.studentemail = :studentemail"),
    @NamedQuery(name = "Tbstudent.findByParentsname", query = "SELECT t FROM Tbstudent t WHERE t.parentsname = :parentsname"),
    @NamedQuery(name = "Tbstudent.findByParentsphone", query = "SELECT t FROM Tbstudent t WHERE t.parentsphone = :parentsphone"),
    @NamedQuery(name = "Tbstudent.findByStudentdob", query = "SELECT t FROM Tbstudent t WHERE t.studentdob = :studentdob"),
    @NamedQuery(name = "Tbstudent.findByStudentgender", query = "SELECT t FROM Tbstudent t WHERE t.studentgender = :studentgender"),
    @NamedQuery(name = "Tbstudent.findByStudentlevel", query = "SELECT t FROM Tbstudent t WHERE t.studentlevel = :studentlevel"),
    @NamedQuery(name = "Tbstudent.findByStudentnote", query = "SELECT t FROM Tbstudent t WHERE t.studentnote = :studentnote"),
    @NamedQuery(name = "Tbstudent.findByClasscode", query = "SELECT t FROM Tbstudent t WHERE t.classcode = :classcode"),
    @NamedQuery(name = "Tbstudent.findByOldclasscode", query = "SELECT t FROM Tbstudent t WHERE t.oldclasscode = :oldclasscode"),
    @NamedQuery(name = "Tbstudent.findByCentercode", query = "SELECT t FROM Tbstudent t WHERE t.centercode = :centercode"),
    @NamedQuery(name = "Tbstudent.findByIsdelete", query = "SELECT t FROM Tbstudent t WHERE t.isdelete = :isdelete"),
    @NamedQuery(name = "Tbstudent.findByMonth", query = "SELECT t FROM Tbstudent t WHERE t.month = :month"),
    @NamedQuery(name = "Tbstudent.findByYear", query = "SELECT t FROM Tbstudent t WHERE t.year = :year"),
    @NamedQuery(name = "Tbstudent.findByDebt", query = "SELECT t FROM Tbstudent t WHERE t.debt = :debt"),
    @NamedQuery(name = "Tbstudent.findByBalance", query = "SELECT t FROM Tbstudent t WHERE t.balance = :balance"),
    @NamedQuery(name = "Tbstudent.findByPaid", query = "SELECT t FROM Tbstudent t WHERE t.paid = :paid")})
public class Tbstudent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "studentcode")
    private String studentcode;
    @Size(max = 250)
    @Column(name = "studentname")
    private String studentname;
    @Column(name = "studentstatus")
    private Integer studentstatus;
    @Size(max = 250)
    @Column(name = "studentaddress")
    private String studentaddress;
    @Size(max = 11)
    @Column(name = "studentphone")
    private String studentphone;
    @Size(max = 250)
    @Column(name = "studentemail")
    private String studentemail;
    @Size(max = 250)
    @Column(name = "parentsname")
    private String parentsname;
    @Size(max = 11)
    @Column(name = "parentsphone")
    private String parentsphone;
    @Column(name = "studentdob")
    @Temporal(TemporalType.TIMESTAMP)
    private Date studentdob;
    @Column(name = "studentgender")
    private Integer studentgender;
    @Size(max = 11)
    @Column(name = "studentlevel")
    private String studentlevel;
    @Size(max = 500)
    @Column(name = "studentnote")
    private String studentnote;
    @Size(max = 11)
    @Column(name = "classcode")
    private String classcode;
    @Size(max = 11)
    @Column(name = "oldclasscode")
    private String oldclasscode;
    @Column(name = "centercode")
    private Integer centercode;
    @Column(name = "isdelete")
    private Integer isdelete;
    @Column(name = "month")
    private Integer month;
    @Column(name = "year")
    private Integer year;
    @Column(name = "debt")
    private Long debt;
    @Column(name = "balance")
    private Long balance;
    @Column(name = "paid")
    private Integer paid;

    public Tbstudent() {
    }

    public Tbstudent(String studentcode) {
        this.studentcode = studentcode;
    }

    public String getStudentcode() {
        return studentcode;
    }

    public void setStudentcode(String studentcode) {
        this.studentcode = studentcode;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public Integer getStudentstatus() {
        return studentstatus;
    }

    public void setStudentstatus(Integer studentstatus) {
        this.studentstatus = studentstatus;
    }

    public String getStudentaddress() {
        return studentaddress;
    }

    public void setStudentaddress(String studentaddress) {
        this.studentaddress = studentaddress;
    }

    public String getStudentphone() {
        return studentphone;
    }

    public void setStudentphone(String studentphone) {
        this.studentphone = studentphone;
    }

    public String getStudentemail() {
        return studentemail;
    }

    public void setStudentemail(String studentemail) {
        this.studentemail = studentemail;
    }

    public String getParentsname() {
        return parentsname;
    }

    public void setParentsname(String parentsname) {
        this.parentsname = parentsname;
    }

    public String getParentsphone() {
        return parentsphone;
    }

    public void setParentsphone(String parentsphone) {
        this.parentsphone = parentsphone;
    }

    public Date getStudentdob() {
        return studentdob;
    }

    public void setStudentdob(Date studentdob) {
        this.studentdob = studentdob;
    }

    public Integer getStudentgender() {
        return studentgender;
    }

    public void setStudentgender(Integer studentgender) {
        this.studentgender = studentgender;
    }

    public String getStudentlevel() {
        return studentlevel;
    }

    public void setStudentlevel(String studentlevel) {
        this.studentlevel = studentlevel;
    }

    public String getStudentnote() {
        return studentnote;
    }

    public void setStudentnote(String studentnote) {
        this.studentnote = studentnote;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getOldclasscode() {
        return oldclasscode;
    }

    public void setOldclasscode(String oldclasscode) {
        this.oldclasscode = oldclasscode;
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

    public Long getDebt() {
        return debt;
    }

    public void setDebt(Long debt) {
        this.debt = debt;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Integer getPaid() {
        return paid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentcode != null ? studentcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbstudent)) {
            return false;
        }
        Tbstudent other = (Tbstudent) object;
        if ((this.studentcode == null && other.studentcode != null) || (this.studentcode != null && !this.studentcode.equals(other.studentcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbstudent[ studentcode=" + studentcode + " ]";
    }
    
}
