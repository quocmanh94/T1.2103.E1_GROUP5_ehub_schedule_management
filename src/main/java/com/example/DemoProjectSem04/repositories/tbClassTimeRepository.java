/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbclasstime;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface tbClassTimeRepository extends JpaRepository<Tbclasstime, String> {
    @Query("SELECT ct FROM Tbclasstime ct WHERE ct.classtimelesson not in "
            + "( SELECT a.classtimelessoncode FROM Tbclassschedule a join Tbcourseclass b on b.tbcourseclassPK.classcode = a.tbclassschedulePK.classcode "
            + "where (((:startday between b.startdate and b.enddate) and (:endday between b.startdate and b.enddate)) or ((:startday between b.startdate and b.enddate) and (b.enddate between :startday and :endday))) and a.tbclassschedulePK.daycode = :dayofweek "
            + "and a.classroomcode = :vlRoom)")
    public List<Tbclasstime> getListCLassTimeCreateClass(@Param("startday") Date startday,
            @Param("endday") Date endday, @Param("dayofweek") String dayofweek, @Param("vlRoom") String vlRoom);
    
    @Query("SELECT t FROM Tbclasstime t WHERE t.classtimecode = :classtimecode")
    public Tbclasstime getCLassTimeLessonByCode(@Param("classtimecode") String classtimecode);
    
    @Query("SELECT t FROM Tbclasstime t WHERE t.islock = 0")
    public List<Tbclasstime> getListClassTimeByIslock0();
    
    @Query("SELECT t FROM Tbclasstime t WHERE t.classtimecode = :classtimecode")
    public Tbclasstime getCLassTimeByCode(@Param("classtimecode") String classtimecode);
    
    @Query("SELECT t FROM Tbclasstime t WHERE t.classtimelesson.ctlcode = :classtimelesson and t.islock = 0")
    public List<Tbclasstime> getClassTimeByShift(@Param("classtimelesson") String classtimelesson);
}
