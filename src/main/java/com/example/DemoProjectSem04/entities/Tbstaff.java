/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tbstaff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbstaff.findAll", query = "SELECT t FROM Tbstaff t"),
    @NamedQuery(name = "Tbstaff.findByStaffcode", query = "SELECT t FROM Tbstaff t WHERE t.staffcode = :staffcode"),
    @NamedQuery(name = "Tbstaff.findByStafftype", query = "SELECT t FROM Tbstaff t WHERE t.stafftype = :stafftype"),
    @NamedQuery(name = "Tbstaff.findByStaffname", query = "SELECT t FROM Tbstaff t WHERE t.staffname = :staffname"),
    @NamedQuery(name = "Tbstaff.findByStaffemail", query = "SELECT t FROM Tbstaff t WHERE t.staffemail = :staffemail"),
    @NamedQuery(name = "Tbstaff.findByStaffaddress", query = "SELECT t FROM Tbstaff t WHERE t.staffaddress = :staffaddress"),
    @NamedQuery(name = "Tbstaff.findByStaffphone", query = "SELECT t FROM Tbstaff t WHERE t.staffphone = :staffphone"),
    @NamedQuery(name = "Tbstaff.findByStaffgender", query = "SELECT t FROM Tbstaff t WHERE t.staffgender = :staffgender"),
    @NamedQuery(name = "Tbstaff.findByStaffdob", query = "SELECT t FROM Tbstaff t WHERE t.staffdob = :staffdob"),
    @NamedQuery(name = "Tbstaff.findByStafflevel", query = "SELECT t FROM Tbstaff t WHERE t.stafflevel = :stafflevel"),
    @NamedQuery(name = "Tbstaff.findByStaffjob", query = "SELECT t FROM Tbstaff t WHERE t.staffjob = :staffjob"),
    @NamedQuery(name = "Tbstaff.findByCentercode", query = "SELECT t FROM Tbstaff t WHERE t.centercode = :centercode"),
    @NamedQuery(name = "Tbstaff.findByIslock", query = "SELECT t FROM Tbstaff t WHERE t.islock = :islock"),
    @NamedQuery(name = "Tbstaff.findByStaffimg", query = "SELECT t FROM Tbstaff t WHERE t.staffimg = :staffimg")})
public class Tbstaff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "staffcode")
    private String staffcode;
    @Column(name = "stafftype")
    private String stafftype;
    @Size(max = 250)
    @Column(name = "staffname")
    private String staffname;
    @Size(max = 250)
    @Column(name = "staffemail")
    private String staffemail;
    @Size(max = 250)
    @Column(name = "staffaddress")
    private String staffaddress;
    @Size(max = 250)
    @Column(name = "staffphone")
    private String staffphone;
    @Column(name = "staffgender")
    private Integer staffgender;
    @Column(name = "staffdob")
//    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date staffdob;
    @Size(max = 10)
    @Column(name = "stafflevel")
    private String stafflevel;
    @Size(max = 10)
    @Column(name = "staffjob")
    private String staffjob;
    @Column(name = "centercode")
    private Integer centercode;
    @Column(name = "islock")
    private Integer islock;
    @Size(max = 250)
    @Column(name = "staffimg")
    private String staffimg;
    @JoinColumn(name = "staffuser", referencedColumnName = "username")
    @ManyToOne
    @JsonBackReference
    private Tbuser staffuser;

    public Tbstaff() {
    }

    public Tbstaff(String staffcode) {
        this.staffcode = staffcode;
    }

    public String getStaffcode() {
        return staffcode;
    }

    public void setStaffcode(String staffcode) {
        this.staffcode = staffcode;
    }

    public String getStafftype() {
        return stafftype;
    }

    public void setStafftype(String stafftype) {
        this.stafftype = stafftype;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getStaffemail() {
        return staffemail;
    }

    public void setStaffemail(String staffemail) {
        this.staffemail = staffemail;
    }

    public String getStaffaddress() {
        return staffaddress;
    }

    public void setStaffaddress(String staffaddress) {
        this.staffaddress = staffaddress;
    }

    public String getStaffphone() {
        return staffphone;
    }

    public void setStaffphone(String staffphone) {
        this.staffphone = staffphone;
    }

    public Integer getStaffgender() {
        return staffgender;
    }

    public void setStaffgender(Integer staffgender) {
        this.staffgender = staffgender;
    }

    public Date getStaffdob() {
        return staffdob;
    }

    public void setStaffdob(Date staffdob) {
        this.staffdob = staffdob;
    }

    public String getStafflevel() {
        return stafflevel;
    }

    public void setStafflevel(String stafflevel) {
        this.stafflevel = stafflevel;
    }

    public String getStaffjob() {
        return staffjob;
    }

    public void setStaffjob(String staffjob) {
        this.staffjob = staffjob;
    }

    public Integer getCentercode() {
        return centercode;
    }

    public void setCentercode(Integer centercode) {
        this.centercode = centercode;
    }

    public Integer getIslock() {
        return islock;
    }

    public void setIslock(Integer islock) {
        this.islock = islock;
    }

    public String getStaffimg() {
        return staffimg;
    }

    public void setStaffimg(String staffimg) {
        this.staffimg = staffimg;
    }

    public Tbuser getStaffuser() {
        return staffuser;
    }

    public void setStaffuser(Tbuser staffuser) {
        this.staffuser = staffuser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffcode != null ? staffcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbstaff)) {
            return false;
        }
        Tbstaff other = (Tbstaff) object;
        if ((this.staffcode == null && other.staffcode != null) || (this.staffcode != null && !this.staffcode.equals(other.staffcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbstaff[ staffcode=" + staffcode + " ]";
    }
    
}
