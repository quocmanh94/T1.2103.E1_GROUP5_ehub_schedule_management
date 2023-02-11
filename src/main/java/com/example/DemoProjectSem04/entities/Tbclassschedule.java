/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.entities;

import java.io.Serializable;
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
@Table(name = "tbclassschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbclassschedule.findAll", query = "SELECT t FROM Tbclassschedule t"),
    @NamedQuery(name = "Tbclassschedule.findByClasscode", query = "SELECT t FROM Tbclassschedule t WHERE t.tbclassschedulePK.classcode = :classcode"),
    @NamedQuery(name = "Tbclassschedule.findByDaycode", query = "SELECT t FROM Tbclassschedule t WHERE t.tbclassschedulePK.daycode = :daycode"),
    @NamedQuery(name = "Tbclassschedule.findByClasstimecode", query = "SELECT t FROM Tbclassschedule t WHERE t.tbclassschedulePK.classtimecode = :classtimecode"),
    @NamedQuery(name = "Tbclassschedule.findByTeachercode", query = "SELECT t FROM Tbclassschedule t WHERE t.tbclassschedulePK.teachercode = :teachercode"),
    @NamedQuery(name = "Tbclassschedule.findByClassroomcode", query = "SELECT t FROM Tbclassschedule t WHERE t.classroomcode = :classroomcode"),
    @NamedQuery(name = "Tbclassschedule.findByClasstimelessoncode", query = "SELECT t FROM Tbclassschedule t WHERE t.classtimelessoncode = :classtimelessoncode"),
    @NamedQuery(name = "Tbclassschedule.findByDayofweek", query = "SELECT t FROM Tbclassschedule t WHERE t.dayofweek = :dayofweek"),
    @NamedQuery(name = "Tbclassschedule.findByClasstimelesson", query = "SELECT t FROM Tbclassschedule t WHERE t.classtimelesson = :classtimelesson"),
    @NamedQuery(name = "Tbclassschedule.findByClasstime", query = "SELECT t FROM Tbclassschedule t WHERE t.classtime = :classtime"),
    @NamedQuery(name = "Tbclassschedule.findByTeachername", query = "SELECT t FROM Tbclassschedule t WHERE t.teachername = :teachername"),
    @NamedQuery(name = "Tbclassschedule.findByRoom", query = "SELECT t FROM Tbclassschedule t WHERE t.room = :room"),
    @NamedQuery(name = "Tbclassschedule.findByStudyyear", query = "SELECT t FROM Tbclassschedule t WHERE t.studyyear = :studyyear"),
    @NamedQuery(name = "Tbclassschedule.findByStudymonth", query = "SELECT t FROM Tbclassschedule t WHERE t.studymonth = :studymonth"),
    @NamedQuery(name = "Tbclassschedule.findByCentercode", query = "SELECT t FROM Tbclassschedule t WHERE t.centercode = :centercode"),
    @NamedQuery(name = "Tbclassschedule.findByIsforeigner", query = "SELECT t FROM Tbclassschedule t WHERE t.isforeigner = :isforeigner")})
public class Tbclassschedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbclassschedulePK tbclassschedulePK;
    @Size(max = 10)
    @Column(name = "classroomcode")
    private String classroomcode;
    @Size(max = 10)
    @Column(name = "classtimelessoncode")
    private String classtimelessoncode;
    @Size(max = 250)
    @Column(name = "dayofweek")
    private String dayofweek;
    @Size(max = 250)
    @Column(name = "classtimelesson")
    private String classtimelesson;
    @Size(max = 250)
    @Column(name = "classtime")
    private String classtime;
    @Size(max = 250)
    @Column(name = "teachername")
    private String teachername;
    @Size(max = 50)
    @Column(name = "room")
    private String room;
    @Column(name = "studyyear")
    private Integer studyyear;
    @Column(name = "studymonth")
    private Integer studymonth;
    @Column(name = "centercode")
    private Integer centercode;
    @Column(name = "isforeigner")
    private Integer isforeigner;

    public Tbclassschedule() {
    }

    public Tbclassschedule(TbclassschedulePK tbclassschedulePK) {
        this.tbclassschedulePK = tbclassschedulePK;
    }

    public Tbclassschedule(String classcode, String daycode, String classtimecode, String teachercode) {
        this.tbclassschedulePK = new TbclassschedulePK(classcode, daycode, classtimecode, teachercode);
    }

    public TbclassschedulePK getTbclassschedulePK() {
        return tbclassschedulePK;
    }

    public void setTbclassschedulePK(TbclassschedulePK tbclassschedulePK) {
        this.tbclassschedulePK = tbclassschedulePK;
    }

    public String getClassroomcode() {
        return classroomcode;
    }

    public void setClassroomcode(String classroomcode) {
        this.classroomcode = classroomcode;
    }

    public String getClasstimelessoncode() {
        return classtimelessoncode;
    }

    public void setClasstimelessoncode(String classtimelessoncode) {
        this.classtimelessoncode = classtimelessoncode;
    }

    public String getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(String dayofweek) {
        this.dayofweek = dayofweek;
    }

    public String getClasstimelesson() {
        return classtimelesson;
    }

    public void setClasstimelesson(String classtimelesson) {
        this.classtimelesson = classtimelesson;
    }

    public String getClasstime() {
        return classtime;
    }

    public void setClasstime(String classtime) {
        this.classtime = classtime;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getStudyyear() {
        return studyyear;
    }

    public void setStudyyear(Integer studyyear) {
        this.studyyear = studyyear;
    }

    public Integer getStudymonth() {
        return studymonth;
    }

    public void setStudymonth(Integer studymonth) {
        this.studymonth = studymonth;
    }

    public Integer getCentercode() {
        return centercode;
    }

    public void setCentercode(Integer centercode) {
        this.centercode = centercode;
    }

    public Integer getIsforeigner() {
        return isforeigner;
    }

    public void setIsforeigner(Integer isforeigner) {
        this.isforeigner = isforeigner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbclassschedulePK != null ? tbclassschedulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbclassschedule)) {
            return false;
        }
        Tbclassschedule other = (Tbclassschedule) object;
        if ((this.tbclassschedulePK == null && other.tbclassschedulePK != null) || (this.tbclassschedulePK != null && !this.tbclassschedulePK.equals(other.tbclassschedulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.DemoProjectSem04.entities.Tbclassschedule[ tbclassschedulePK=" + tbclassschedulePK + " ]";
    }
    
}
