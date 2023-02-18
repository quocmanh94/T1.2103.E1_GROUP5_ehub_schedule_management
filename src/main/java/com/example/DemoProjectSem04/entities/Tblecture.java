/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "tblecture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblecture.findAll", query = "SELECT t FROM Tblecture t"),
    @NamedQuery(name = "Tblecture.findByLecturecode", query = "SELECT t FROM Tblecture t WHERE t.lecturecode = :lecturecode"),
    @NamedQuery(name = "Tblecture.findByLecturename", query = "SELECT t FROM Tblecture t WHERE t.lecturename = :lecturename")})
public class Tblecture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "lecturecode")
    private String lecturecode;
    @Size(max = 250)
    @Column(name = "lecturename")
    private String lecturename;

    public Tblecture() {
    }

    public Tblecture(String lecturecode) {
        this.lecturecode = lecturecode;
    }

    public String getLecturecode() {
        return lecturecode;
    }

    public void setLecturecode(String lecturecode) {
        this.lecturecode = lecturecode;
    }

    public String getLecturename() {
        return lecturename;
    }

    public void setLecturename(String lecturename) {
        this.lecturename = lecturename;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lecturecode != null ? lecturecode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblecture)) {
            return false;
        }
        Tblecture other = (Tblecture) object;
        if ((this.lecturecode == null && other.lecturecode != null) || (this.lecturecode != null && !this.lecturecode.equals(other.lecturecode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tblecture[ lecturecode=" + lecturecode + " ]";
    }
    
}
