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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tbuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbuser.findAll", query = "SELECT t FROM Tbuser t"),
    @NamedQuery(name = "Tbuser.findByUsername", query = "SELECT t FROM Tbuser t WHERE t.username = :username"),
    @NamedQuery(name = "Tbuser.findByPassword", query = "SELECT t FROM Tbuser t WHERE t.password = :password"),
    @NamedQuery(name = "Tbuser.findByFullname", query = "SELECT t FROM Tbuser t WHERE t.fullname = :fullname"),
    @NamedQuery(name = "Tbuser.findByUseremail", query = "SELECT t FROM Tbuser t WHERE t.useremail = :useremail"),
    @NamedQuery(name = "Tbuser.findByEnabled", query = "SELECT t FROM Tbuser t WHERE t.enabled = :enabled"),
    @NamedQuery(name = "Tbuser.findByVerificationcode", query = "SELECT t FROM Tbuser t WHERE t.verificationcode = :verificationcode"),
    @NamedQuery(name = "Tbuser.findByIsclock", query = "SELECT t FROM Tbuser t WHERE t.isclock = :isclock"),
    @NamedQuery(name = "Tbuser.findByIsdelete", query = "SELECT t FROM Tbuser t WHERE t.isdelete = :isdelete")})
public class Tbuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "username")
    private String username;
    @Size(max = 250)
    @Column(name = "password")
    private String password;
    @Size(max = 250)
    @Column(name = "fullname")
    private String fullname;
    @Size(max = 250)
    @Column(name = "useremail")
    private String useremail;
    @Column(name = "enabled")
    private Boolean enabled;
    @Size(max = 64)
    @Column(name = "verificationcode")
    private String verificationcode;
    @Column(name = "isclock")
    private Integer isclock;
    @Column(name = "isdelete")
    private Integer isdelete;
    @OneToMany(mappedBy = "staffuser")
    @JsonBackReference
    private List<Tbstaff> tbstaffList;
    @JoinColumn(name = "centercode", referencedColumnName = "centercode")
    @ManyToOne
    @JsonBackReference
    private Tbcenter centercode;
    @JoinColumn(name = "permision", referencedColumnName = "pgcode")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Tbpositiongroup permision;
    @JoinColumn(name = "roleid", referencedColumnName = "roleid")
    @ManyToOne
    @JsonBackReference
    private Tbrole roleid;

    public Tbuser() {
    }

    public Tbuser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getVerificationcode() {
        return verificationcode;
    }

    public void setVerificationcode(String verificationcode) {
        this.verificationcode = verificationcode;
    }

    public Integer getIsclock() {
        return isclock;
    }

    public void setIsclock(Integer isclock) {
        this.isclock = isclock;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    @XmlTransient
    public List<Tbstaff> getTbstaffList() {
        return tbstaffList;
    }

    public void setTbstaffList(List<Tbstaff> tbstaffList) {
        this.tbstaffList = tbstaffList;
    }

    public Tbcenter getCentercode() {
        return centercode;
    }

    public void setCentercode(Tbcenter centercode) {
        this.centercode = centercode;
    }

    public Tbpositiongroup getPermision() {
        return permision;
    }

    public void setPermision(Tbpositiongroup permision) {
        this.permision = permision;
    }

    public Tbrole getRoleid() {
        return roleid;
    }

    public void setRoleid(Tbrole roleid) {
        this.roleid = roleid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbuser)) {
            return false;
        }
        Tbuser other = (Tbuser) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbuser[ username=" + username + " ]";
    }
    
}
