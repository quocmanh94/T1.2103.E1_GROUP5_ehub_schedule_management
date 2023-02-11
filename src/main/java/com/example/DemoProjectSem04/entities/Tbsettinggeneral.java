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
@Table(name = "tbsettinggeneral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbsettinggeneral.findAll", query = "SELECT t FROM Tbsettinggeneral t"),
    @NamedQuery(name = "Tbsettinggeneral.findBySgid", query = "SELECT t FROM Tbsettinggeneral t WHERE t.sgid = :sgid"),
    @NamedQuery(name = "Tbsettinggeneral.findBySglogo", query = "SELECT t FROM Tbsettinggeneral t WHERE t.sglogo = :sglogo"),
    @NamedQuery(name = "Tbsettinggeneral.findBySgworkdays", query = "SELECT t FROM Tbsettinggeneral t WHERE t.sgworkdays = :sgworkdays"),
    @NamedQuery(name = "Tbsettinggeneral.findBySgdatebeforefeepayment", query = "SELECT t FROM Tbsettinggeneral t WHERE t.sgdatebeforefeepayment = :sgdatebeforefeepayment"),
    @NamedQuery(name = "Tbsettinggeneral.findBySgnumberbank1", query = "SELECT t FROM Tbsettinggeneral t WHERE t.sgnumberbank1 = :sgnumberbank1"),
    @NamedQuery(name = "Tbsettinggeneral.findBySgnamebank1", query = "SELECT t FROM Tbsettinggeneral t WHERE t.sgnamebank1 = :sgnamebank1"),
    @NamedQuery(name = "Tbsettinggeneral.findBySgnumberbank2", query = "SELECT t FROM Tbsettinggeneral t WHERE t.sgnumberbank2 = :sgnumberbank2"),
    @NamedQuery(name = "Tbsettinggeneral.findBySgnamebank2", query = "SELECT t FROM Tbsettinggeneral t WHERE t.sgnamebank2 = :sgnamebank2"),
    @NamedQuery(name = "Tbsettinggeneral.findBySgnote", query = "SELECT t FROM Tbsettinggeneral t WHERE t.sgnote = :sgnote")})
public class Tbsettinggeneral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sgid")
    private Integer sgid;
    @Size(max = 500)
    @Column(name = "sglogo")
    private String sglogo;
    @Column(name = "sgworkdays")
    private Integer sgworkdays;
    @Column(name = "sgdatebeforefeepayment")
    private Integer sgdatebeforefeepayment;
    @Size(max = 20)
    @Column(name = "sgnumberbank1")
    private String sgnumberbank1;
    @Size(max = 50)
    @Column(name = "sgnamebank1")
    private String sgnamebank1;
    @Size(max = 20)
    @Column(name = "sgnumberbank2")
    private String sgnumberbank2;
    @Size(max = 50)
    @Column(name = "sgnamebank2")
    private String sgnamebank2;
    @Size(max = 2147483647)
    @Column(name = "sgnote")
    private String sgnote;

    public Tbsettinggeneral() {
    }

    public Tbsettinggeneral(Integer sgid) {
        this.sgid = sgid;
    }

    public Integer getSgid() {
        return sgid;
    }

    public void setSgid(Integer sgid) {
        this.sgid = sgid;
    }

    public String getSglogo() {
        return sglogo;
    }

    public void setSglogo(String sglogo) {
        this.sglogo = sglogo;
    }

    public Integer getSgworkdays() {
        return sgworkdays;
    }

    public void setSgworkdays(Integer sgworkdays) {
        this.sgworkdays = sgworkdays;
    }

    public Integer getSgdatebeforefeepayment() {
        return sgdatebeforefeepayment;
    }

    public void setSgdatebeforefeepayment(Integer sgdatebeforefeepayment) {
        this.sgdatebeforefeepayment = sgdatebeforefeepayment;
    }

    public String getSgnumberbank1() {
        return sgnumberbank1;
    }

    public void setSgnumberbank1(String sgnumberbank1) {
        this.sgnumberbank1 = sgnumberbank1;
    }

    public String getSgnamebank1() {
        return sgnamebank1;
    }

    public void setSgnamebank1(String sgnamebank1) {
        this.sgnamebank1 = sgnamebank1;
    }

    public String getSgnumberbank2() {
        return sgnumberbank2;
    }

    public void setSgnumberbank2(String sgnumberbank2) {
        this.sgnumberbank2 = sgnumberbank2;
    }

    public String getSgnamebank2() {
        return sgnamebank2;
    }

    public void setSgnamebank2(String sgnamebank2) {
        this.sgnamebank2 = sgnamebank2;
    }

    public String getSgnote() {
        return sgnote;
    }

    public void setSgnote(String sgnote) {
        this.sgnote = sgnote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sgid != null ? sgid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbsettinggeneral)) {
            return false;
        }
        Tbsettinggeneral other = (Tbsettinggeneral) object;
        if ((this.sgid == null && other.sgid != null) || (this.sgid != null && !this.sgid.equals(other.sgid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbsettinggeneral[ sgid=" + sgid + " ]";
    }
    
}
