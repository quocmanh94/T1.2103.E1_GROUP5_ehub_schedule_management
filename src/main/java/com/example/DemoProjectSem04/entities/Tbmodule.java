package com.example.DemoProjectSem04.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tbmodule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbmodule.findAll", query = "SELECT t FROM Tbmodule t"),
    @NamedQuery(name = "Tbmodule.findByModulecode", query = "SELECT t FROM Tbmodule t WHERE t.modulecode = :modulecode"),
    @NamedQuery(name = "Tbmodule.findByModulename", query = "SELECT t FROM Tbmodule t WHERE t.modulename = :modulename"),
    @NamedQuery(name = "Tbmodule.findByModuletime", query = "SELECT t FROM Tbmodule t WHERE t.moduletime = :moduletime"),
    @NamedQuery(name = "Tbmodule.findByModulenote", query = "SELECT t FROM Tbmodule t WHERE t.modulenote = :modulenote"),
    @NamedQuery(name = "Tbmodule.findByModuleisclock", query = "SELECT t FROM Tbmodule t WHERE t.moduleisclock = :moduleisclock"),
    @NamedQuery(name = "Tbmodule.findByModuleisdelete", query = "SELECT t FROM Tbmodule t WHERE t.moduleisdelete = :moduleisdelete"),
    @NamedQuery(name = "Tbmodule.findByCentercode", query = "SELECT t FROM Tbmodule t WHERE t.centercode = :centercode"),
    @NamedQuery(name = "Tbmodule.findByClassblock", query = "SELECT t FROM Tbmodule t WHERE t.classblock = :classblock")})
public class Tbmodule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "modulecode")
    private String modulecode;
    @Size(max = 250)
    @Column(name = "modulename")
    private String modulename;
    @Size(max = 50)
    @Column(name = "moduletime")
    private String moduletime;
    @Size(max = 2147483647)
    @Column(name = "modulenote")
    private String modulenote;
    @Column(name = "moduleisclock")
    private Integer moduleisclock;
    @Column(name = "moduleisdelete")
    private Integer moduleisdelete;
    @Column(name = "centercode")
    private Integer centercode;
    @Size(max = 10)
    @Column(name = "classblock")
    private String classblock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbmodule")
    @JsonBackReference
    private List<Tbcoursemodule> tbcoursemoduleList;

    public Tbmodule() {
    }

    public Tbmodule(String modulecode) {
        this.modulecode = modulecode;
    }

    public String getModulecode() {
        return modulecode;
    }

    public void setModulecode(String modulecode) {
        this.modulecode = modulecode;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename;
    }

    public String getModuletime() {
        return moduletime;
    }

    public void setModuletime(String moduletime) {
        this.moduletime = moduletime;
    }

    public String getModulenote() {
        return modulenote;
    }

    public void setModulenote(String modulenote) {
        this.modulenote = modulenote;
    }

    public Integer getModuleisclock() {
        return moduleisclock;
    }

    public void setModuleisclock(Integer moduleisclock) {
        this.moduleisclock = moduleisclock;
    }

    public Integer getModuleisdelete() {
        return moduleisdelete;
    }

    public void setModuleisdelete(Integer moduleisdelete) {
        this.moduleisdelete = moduleisdelete;
    }

    public Integer getCentercode() {
        return centercode;
    }

    public void setCentercode(Integer centercode) {
        this.centercode = centercode;
    }

    public String getClassblock() {
        return classblock;
    }

    public void setClassblock(String classblock) {
        this.classblock = classblock;
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
        hash += (modulecode != null ? modulecode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbmodule)) {
            return false;
        }
        Tbmodule other = (Tbmodule) object;
        if ((this.modulecode == null && other.modulecode != null) || (this.modulecode != null && !this.modulecode.equals(other.modulecode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbmodule[ modulecode=" + modulecode + " ]";
    }

}
