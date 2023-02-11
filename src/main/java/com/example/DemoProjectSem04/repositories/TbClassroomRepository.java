/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.entities.Tbclassroom;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface TbClassroomRepository extends JpaRepository<Tbclassroom, String> {
    @Query("SELECT t FROM Tbclassroom t WHERE t.roomcode = :roomcode")
    public Tbclassroom getCLassroomByCode(@Param("roomcode") String roomcode);
//    @Query("DELETE FROM Tbclassroom t WHERE t.roomcode = :roomcode")
//    public void deletePermisionByIdPF(@Param("pgcode") String pgcode, @Param("functioncode") String functioncode);
    @Query("SELECT t FROM Tbclassroom t WHERE t.isstatus = 0")
    public List<Tbclassroom> getCLassroomByStatus0();
    
//    @Query("SELECT cr FROM Tbclassroom cr WHERE cr.roomcode not in "
//            + "( SELECT haizz.classroomcode FROM Tbcourseclass t join Tbcourse c on t.tbcourseclassPK.coursecode = c.coursecode "
//            + "join Tbclassschedule haizz on haizz.tbclassschedulePK.classcode = t.tbcourseclassPK.classcode "
//            + "where (:startday between c.startcourse and c.endcourse) and (:endday between c.startcourse and c.endcourse) and haizz.tbclassschedulePK.daycode = :dayofweek)")
    
    @Query("SELECT cr FROM Tbclassroom cr")
    public List<Tbclassroom> getListCLassroomCreateClass(@Param("startday") Date startday,
            @Param("endday") Date endday, @Param("dayofweek") String dayofweek);
    
}
