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
@Table(name = "tbclassroom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbclassroom.findAll", query = "SELECT t FROM Tbclassroom t"),
    @NamedQuery(name = "Tbclassroom.findByRoomcode", query = "SELECT t FROM Tbclassroom t WHERE t.roomcode = :roomcode"),
    @NamedQuery(name = "Tbclassroom.findByCentercode", query = "SELECT t FROM Tbclassroom t WHERE t.centercode = :centercode"),
    @NamedQuery(name = "Tbclassroom.findByRoomname", query = "SELECT t FROM Tbclassroom t WHERE t.roomname = :roomname"),
    @NamedQuery(name = "Tbclassroom.findByRoomfloor", query = "SELECT t FROM Tbclassroom t WHERE t.roomfloor = :roomfloor"),
    @NamedQuery(name = "Tbclassroom.findByRoomcontent", query = "SELECT t FROM Tbclassroom t WHERE t.roomcontent = :roomcontent"),
    @NamedQuery(name = "Tbclassroom.findByRoomnumberofseats", query = "SELECT t FROM Tbclassroom t WHERE t.roomnumberofseats = :roomnumberofseats"),
    @NamedQuery(name = "Tbclassroom.findByIsstatus", query = "SELECT t FROM Tbclassroom t WHERE t.isstatus = :isstatus")})
public class Tbclassroom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "roomcode")
    private String roomcode;
    @Column(name = "centercode")
    private Integer centercode;
    @Size(max = 500)
    @Column(name = "roomname")
    private String roomname;
    @Column(name = "roomfloor")
    private Integer roomfloor;
    @Size(max = 500)
    @Column(name = "roomcontent")
    private String roomcontent;
    @Column(name = "roomnumberofseats")
    private Integer roomnumberofseats;
    @Column(name = "isstatus")
    private Integer isstatus;

    public Tbclassroom() {
    }

    public Tbclassroom(String roomcode) {
        this.roomcode = roomcode;
    }

    public String getRoomcode() {
        return roomcode;
    }

    public void setRoomcode(String roomcode) {
        this.roomcode = roomcode;
    }

    public Integer getCentercode() {
        return centercode;
    }

    public void setCentercode(Integer centercode) {
        this.centercode = centercode;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public Integer getRoomfloor() {
        return roomfloor;
    }

    public void setRoomfloor(Integer roomfloor) {
        this.roomfloor = roomfloor;
    }

    public String getRoomcontent() {
        return roomcontent;
    }

    public void setRoomcontent(String roomcontent) {
        this.roomcontent = roomcontent;
    }

    public Integer getRoomnumberofseats() {
        return roomnumberofseats;
    }

    public void setRoomnumberofseats(Integer roomnumberofseats) {
        this.roomnumberofseats = roomnumberofseats;
    }

    public Integer getIsstatus() {
        return isstatus;
    }

    public void setIsstatus(Integer isstatus) {
        this.isstatus = isstatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomcode != null ? roomcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbclassroom)) {
            return false;
        }
        Tbclassroom other = (Tbclassroom) object;
        if ((this.roomcode == null && other.roomcode != null) || (this.roomcode != null && !this.roomcode.equals(other.roomcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbclassroom[ roomcode=" + roomcode + " ]";
    }
    
}
