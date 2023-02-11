/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.entities;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "tbcourseclass")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbcourseclass.findAll", query = "SELECT t FROM Tbcourseclass t"),
    @NamedQuery(name = "Tbcourseclass.findByCoursecode", query = "SELECT t FROM Tbcourseclass t WHERE t.tbcourseclassPK.coursecode = :coursecode"),
    @NamedQuery(name = "Tbcourseclass.findByClasscode", query = "SELECT t FROM Tbcourseclass t WHERE t.tbcourseclassPK.classcode = :classcode"),
    @NamedQuery(name = "Tbcourseclass.findByClassname", query = "SELECT t FROM Tbcourseclass t WHERE t.classname = :classname"),
    @NamedQuery(name = "Tbcourseclass.findByDescrip", query = "SELECT t FROM Tbcourseclass t WHERE t.descrip = :descrip"),
    @NamedQuery(name = "Tbcourseclass.findByMonth", query = "SELECT t FROM Tbcourseclass t WHERE t.startdate = :startdate"),
    @NamedQuery(name = "Tbcourseclass.findByYear", query = "SELECT t FROM Tbcourseclass t WHERE t.enddate = :enddate")})
public class Tbcourseclass implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbcourseclassPK tbcourseclassPK;
    @Size(max = 250)
    @Column(name = "classname")
    private String classname;
    @Size(max = 2147483647)
    @Column(name = "descrip")
    private String descrip;
    @Column(name = "startdate")
    private Date startdate;
    @Column(name = "enddate")
    private Date enddate;

    public Tbcourseclass() {
    }

    public Tbcourseclass(TbcourseclassPK tbcourseclassPK) {
        this.tbcourseclassPK = tbcourseclassPK;
    }

    public Tbcourseclass(String coursecode, String classcode) {
        this.tbcourseclassPK = new TbcourseclassPK(coursecode, classcode);
    }

    public TbcourseclassPK getTbcourseclassPK() {
        return tbcourseclassPK;
    }

    public void setTbcourseclassPK(TbcourseclassPK tbcourseclassPK) {
        this.tbcourseclassPK = tbcourseclassPK;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Date getStartDate() {
        return startdate;
    }

    public void setStartDate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEndDate() {
        return enddate;
    }

    public void setEndDate(Date enddate) {
        this.enddate = enddate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbcourseclassPK != null ? tbcourseclassPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbcourseclass)) {
            return false;
        }
        Tbcourseclass other = (Tbcourseclass) object;
        if ((this.tbcourseclassPK == null && other.tbcourseclassPK != null) || (this.tbcourseclassPK != null && !this.tbcourseclassPK.equals(other.tbcourseclassPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbcourseclass[ tbcourseclassPK=" + tbcourseclassPK + " ]";
    }
    
}
