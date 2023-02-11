/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tbcourse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbcourse.findAll", query = "SELECT t FROM Tbcourse t"),
    @NamedQuery(name = "Tbcourse.findByCoursecode", query = "SELECT t FROM Tbcourse t WHERE t.coursecode = :coursecode"),
    @NamedQuery(name = "Tbcourse.findByCoursename", query = "SELECT t FROM Tbcourse t WHERE t.coursename = :coursename"),
    @NamedQuery(name = "Tbcourse.findByOpentimecourse", query = "SELECT t FROM Tbcourse t WHERE t.opentimecourse = :opentimecourse"),
    @NamedQuery(name = "Tbcourse.findByStartcourse", query = "SELECT t FROM Tbcourse t WHERE t.startcourse = :startcourse"),
    @NamedQuery(name = "Tbcourse.findByEndcourse", query = "SELECT t FROM Tbcourse t WHERE t.endcourse = :endcourse"),
    @NamedQuery(name = "Tbcourse.findByIsactive", query = "SELECT t FROM Tbcourse t WHERE t.isactive = :isactive"),
    @NamedQuery(name = "Tbcourse.findByNumberlesson", query = "SELECT t FROM Tbcourse t WHERE t.numberlesson = :numberlesson"),
    @NamedQuery(name = "Tbcourse.findByNumberspeaking", query = "SELECT t FROM Tbcourse t WHERE t.numberspeaking = :numberspeaking"),
    @NamedQuery(name = "Tbcourse.findByNumberwriting", query = "SELECT t FROM Tbcourse t WHERE t.numberwriting = :numberwriting"),
    @NamedQuery(name = "Tbcourse.findByNumberreading", query = "SELECT t FROM Tbcourse t WHERE t.numberreading = :numberreading"),
    @NamedQuery(name = "Tbcourse.findByNumberlistening", query = "SELECT t FROM Tbcourse t WHERE t.numberlistening = :numberlistening"),
    @NamedQuery(name = "Tbcourse.findByYear", query = "SELECT t FROM Tbcourse t WHERE t.year = :year"),
    @NamedQuery(name = "Tbcourse.findByMonth", query = "SELECT t FROM Tbcourse t WHERE t.month = :month")})
public class Tbcourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "coursecode")
    private String coursecode;
    @Size(max = 250)
    @Column(name = "coursename")
    private String coursename;
    @Column(name = "opentimecourse")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date opentimecourse;
    @Column(name = "startcourse")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startcourse;
    @Column(name = "endcourse")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endcourse;
    @Column(name = "isactive")
    private Integer isactive;
    @Column(name = "numberlesson")
    private Integer numberlesson;
    @Column(name = "numberspeaking")
    private Integer numberspeaking;
    @Column(name = "numberwriting")
    private Integer numberwriting;
    @Column(name = "numberreading")
    private Integer numberreading;
    @Column(name = "numberlistening")
    private Integer numberlistening;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbcourse")
    @JsonBackReference
    private List<Tbcoursemodule> tbcoursemoduleList;

    public Tbcourse() {
    }

    public Tbcourse(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Date getOpentimecourse() {
        return opentimecourse;
    }

    public void setOpentimecourse(Date opentimecourse) {
        this.opentimecourse = opentimecourse;
    }

    public Date getStartcourse() {
        return startcourse;
    }

    public void setStartcourse(Date startcourse) {
        this.startcourse = startcourse;
    }

    public Date getEndcourse() {
        return endcourse;
    }

    public void setEndcourse(Date endcourse) {
        this.endcourse = endcourse;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    public Integer getNumberlesson() {
        return numberlesson;
    }

    public void setNumberlesson(Integer numberlesson) {
        this.numberlesson = numberlesson;
    }

    public Integer getNumberspeaking() {
        return numberspeaking;
    }

    public void setNumberspeaking(Integer numberspeaking) {
        this.numberspeaking = numberspeaking;
    }

    public Integer getNumberwriting() {
        return numberwriting;
    }

    public void setNumberwriting(Integer numberwriting) {
        this.numberwriting = numberwriting;
    }

    public Integer getNumberreading() {
        return numberreading;
    }

    public void setNumberreading(Integer numberreading) {
        this.numberreading = numberreading;
    }

    public Integer getNumberlistening() {
        return numberlistening;
    }

    public void setNumberlistening(Integer numberlistening) {
        this.numberlistening = numberlistening;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @XmlTransient
    public List<Tbcoursemodule> getTbcoursemoduleList() {
        return tbcoursemoduleList;
    }

    public void setTbcoursemoduleList(List<Tbcoursemodule> tbcoursemoduleList) {
        this.tbcoursemoduleList = tbcoursemoduleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coursecode != null ? coursecode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbcourse)) {
            return false;
        }
        Tbcourse other = (Tbcourse) object;
        if ((this.coursecode == null && other.coursecode != null) || (this.coursecode != null && !this.coursecode.equals(other.coursecode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbcourse[ coursecode=" + coursecode + " ]";
    }
    
}
