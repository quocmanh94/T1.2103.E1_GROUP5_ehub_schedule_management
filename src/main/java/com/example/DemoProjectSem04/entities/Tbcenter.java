/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tbcenter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbcenter.findAll", query = "SELECT t FROM Tbcenter t"),
    @NamedQuery(name = "Tbcenter.findByCentercode", query = "SELECT t FROM Tbcenter t WHERE t.centercode = :centercode"),
    @NamedQuery(name = "Tbcenter.findByCentername", query = "SELECT t FROM Tbcenter t WHERE t.centername = :centername"),
    @NamedQuery(name = "Tbcenter.findByCenterphone", query = "SELECT t FROM Tbcenter t WHERE t.centerphone = :centerphone"),
    @NamedQuery(name = "Tbcenter.findByCenteraddress", query = "SELECT t FROM Tbcenter t WHERE t.centeraddress = :centeraddress"),
    @NamedQuery(name = "Tbcenter.findByCenternote", query = "SELECT t FROM Tbcenter t WHERE t.centernote = :centernote"),
    @NamedQuery(name = "Tbcenter.findByCenterdefault", query = "SELECT t FROM Tbcenter t WHERE t.centerdefault = :centerdefault"),
    @NamedQuery(name = "Tbcenter.findByIsdelete", query = "SELECT t FROM Tbcenter t WHERE t.isdelete = :isdelete")})
public class Tbcenter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "centercode")
    private Integer centercode;
    @Size(max = 250)
    @Column(name = "centername")
    private String centername;
    @Size(max = 20)
    @Column(name = "centerphone")
    private String centerphone;
    @Size(max = 500)
    @Column(name = "centeraddress")
    private String centeraddress;
    @Size(max = 500)
    @Column(name = "centernote")
    private String centernote;
    @Column(name = "centerdefault")
    private Integer centerdefault;
    @Column(name = "isdelete")
    private Integer isdelete;
    @OneToMany(mappedBy = "centercode")
    @JsonBackReference
    private List<Tbuser> tbuserList;

    public Tbcenter() {
    }

    public Tbcenter(Integer centercode) {
        this.centercode = centercode;
    }

    public Integer getCentercode() {
        return centercode;
    }

    public void setCentercode(Integer centercode) {
        this.centercode = centercode;
    }

    public String getCentername() {
        return centername;
    }

    public void setCentername(String centername) {
        this.centername = centername;
    }

    public String getCenterphone() {
        return centerphone;
    }

    public void setCenterphone(String centerphone) {
        this.centerphone = centerphone;
    }

    public String getCenteraddress() {
        return centeraddress;
    }

    public void setCenteraddress(String centeraddress) {
        this.centeraddress = centeraddress;
    }

    public String getCenternote() {
        return centernote;
    }

    public void setCenternote(String centernote) {
        this.centernote = centernote;
    }

    public Integer getCenterdefault() {
        return centerdefault;
    }

    public void setCenterdefault(Integer centerdefault) {
        this.centerdefault = centerdefault;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    @XmlTransient
    public List<Tbuser> getTbuserList() {
        return tbuserList;
    }

    public void setTbuserList(List<Tbuser> tbuserList) {
        this.tbuserList = tbuserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (centercode != null ? centercode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbcenter)) {
            return false;
        }
        Tbcenter other = (Tbcenter) object;
        if ((this.centercode == null && other.centercode != null) || (this.centercode != null && !this.centercode.equals(other.centercode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbcenter[ centercode=" + centercode + " ]";
    }
    
}
