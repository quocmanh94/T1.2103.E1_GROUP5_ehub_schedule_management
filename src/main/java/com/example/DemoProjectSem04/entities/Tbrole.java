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
@Table(name = "tbrole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbrole.findAll", query = "SELECT t FROM Tbrole t"),
    @NamedQuery(name = "Tbrole.findByRoleid", query = "SELECT t FROM Tbrole t WHERE t.roleid = :roleid"),
    @NamedQuery(name = "Tbrole.findByRolename", query = "SELECT t FROM Tbrole t WHERE t.rolename = :rolename"),
    @NamedQuery(name = "Tbrole.findByRoleisclock", query = "SELECT t FROM Tbrole t WHERE t.roleisclock = :roleisclock")})
public class Tbrole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "roleid")
    private Integer roleid;
    @Size(max = 250)
    @Column(name = "rolename")
    private String rolename;
    @Column(name = "roleisclock")
    private Integer roleisclock;
    @OneToMany(mappedBy = "roleid")
    @JsonBackReference
    private List<Tbuser> tbuserList;

    public Tbrole() {
    }

    public Tbrole(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Integer getRoleisclock() {
        return roleisclock;
    }

    public void setRoleisclock(Integer roleisclock) {
        this.roleisclock = roleisclock;
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
        hash += (roleid != null ? roleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbrole)) {
            return false;
        }
        Tbrole other = (Tbrole) object;
        if ((this.roleid == null && other.roleid != null) || (this.roleid != null && !this.roleid.equals(other.roleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbrole[ roleid=" + roleid + " ]";
    }
    
}
