/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Admin
 */
@Embeddable
public class TbpositiongroupfunctionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pgcode")
    private String pgcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "functioncode")
    private String functioncode;

    public TbpositiongroupfunctionPK() {
    }

    public TbpositiongroupfunctionPK(String pgcode, String functioncode) {
        this.pgcode = pgcode;
        this.functioncode = functioncode;
    }

    public String getPgcode() {
        return pgcode;
    }

    public void setPgcode(String pgcode) {
        this.pgcode = pgcode;
    }

    public String getFunctioncode() {
        return functioncode;
    }

    public void setFunctioncode(String functioncode) {
        this.functioncode = functioncode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pgcode != null ? pgcode.hashCode() : 0);
        hash += (functioncode != null ? functioncode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbpositiongroupfunctionPK)) {
            return false;
        }
        TbpositiongroupfunctionPK other = (TbpositiongroupfunctionPK) object;
        if ((this.pgcode == null && other.pgcode != null) || (this.pgcode != null && !this.pgcode.equals(other.pgcode))) {
            return false;
        }
        if ((this.functioncode == null && other.functioncode != null) || (this.functioncode != null && !this.functioncode.equals(other.functioncode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.TbpositiongroupfunctionPK[ pgcode=" + pgcode + ", functioncode=" + functioncode + " ]";
    }
    
}
