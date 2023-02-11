/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbcoursemodule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbcoursemodule.findAll", query = "SELECT t FROM Tbcoursemodule t"),
    @NamedQuery(name = "Tbcoursemodule.findByCoursecode", query = "SELECT t FROM Tbcoursemodule t WHERE t.tbcoursemodulePK.coursecode = :coursecode"),
    @NamedQuery(name = "Tbcoursemodule.findByModulecode", query = "SELECT t FROM Tbcoursemodule t WHERE t.tbcoursemodulePK.modulecode = :modulecode"),
    @NamedQuery(name = "Tbcoursemodule.findByModulename", query = "SELECT t FROM Tbcoursemodule t WHERE t.modulename = :modulename"),
    @NamedQuery(name = "Tbcoursemodule.findByDescriptions", query = "SELECT t FROM Tbcoursemodule t WHERE t.descriptions = :descriptions"),
    @NamedQuery(name = "Tbcoursemodule.findByYear", query = "SELECT t FROM Tbcoursemodule t WHERE t.year = :year"),
    @NamedQuery(name = "Tbcoursemodule.findByMonth", query = "SELECT t FROM Tbcoursemodule t WHERE t.month = :month"),
    @NamedQuery(name = "Tbcoursemodule.findByFromdate", query = "SELECT t FROM Tbcoursemodule t WHERE t.fromdate = :fromdate"),
    @NamedQuery(name = "Tbcoursemodule.findByTodate", query = "SELECT t FROM Tbcoursemodule t WHERE t.todate = :todate")})
public class Tbcoursemodule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbcoursemodulePK tbcoursemodulePK;
    @Size(max = 250)
    @Column(name = "modulename")
    private String modulename;
    @Size(max = 250)
    @Column(name = "descriptions")
    private String descriptions;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    @Column(name = "fromdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromdate;
    @Column(name = "todate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date todate;
    @JoinColumn(name = "coursecode", referencedColumnName = "coursecode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonBackReference
    private Tbcourse tbcourse;
    @JoinColumn(name = "modulecode", referencedColumnName = "modulecode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonBackReference
    private Tbmodule tbmodule;

    public Tbcoursemodule() {
    }

    public Tbcoursemodule(TbcoursemodulePK tbcoursemodulePK) {
        this.tbcoursemodulePK = tbcoursemodulePK;
    }

    public Tbcoursemodule(String coursecode, String modulecode) {
        this.tbcoursemodulePK = new TbcoursemodulePK(coursecode, modulecode);
    }

    public TbcoursemodulePK getTbcoursemodulePK() {
        return tbcoursemodulePK;
    }

    public void setTbcoursemodulePK(TbcoursemodulePK tbcoursemodulePK) {
        this.tbcoursemodulePK = tbcoursemodulePK;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
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

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
    }

    public Tbcourse getTbcourse() {
        return tbcourse;
    }

    public void setTbcourse(Tbcourse tbcourse) {
        this.tbcourse = tbcourse;
    }

    public Tbmodule getTbmodule() {
        return tbmodule;
    }

    public void setTbmodule(Tbmodule tbmodule) {
        this.tbmodule = tbmodule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbcoursemodulePK != null ? tbcoursemodulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbcoursemodule)) {
            return false;
        }
        Tbcoursemodule other = (Tbcoursemodule) object;
        if ((this.tbcoursemodulePK == null && other.tbcoursemodulePK != null) || (this.tbcoursemodulePK != null && !this.tbcoursemodulePK.equals(other.tbcoursemodulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbcoursemodule[ tbcoursemodulePK=" + tbcoursemodulePK + " ]";
    }
    
}
