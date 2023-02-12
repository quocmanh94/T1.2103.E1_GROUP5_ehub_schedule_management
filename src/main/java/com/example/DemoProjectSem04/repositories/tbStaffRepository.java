/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.repositories;

import com.example.DemoProjectSem04.DTO.Tbteacherdto;
import com.example.DemoProjectSem04.entities.Tbclassschedule;
import com.example.DemoProjectSem04.entities.Tbcourseclass;
import com.example.DemoProjectSem04.entities.Tbstaff;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface tbStaffRepository extends JpaRepository<Tbstaff, String> {

    @Query("SELECT t FROM Tbstaff t WHERE t.staffemail = :staffemail")
    public Tbstaff getStaffByEmail(@Param("staffemail") String staffemail);

    @Query("SELECT t FROM Tbstaff t WHERE t.islock = 0 and t.stafftype = 'PG00000004'")
    public List<Tbstaff> getStaffListStillWorking();

    @Query("SELECT t FROM Tbstaff t WHERE t.staffcode = :staffcode")
    public Tbstaff getStaffByCode(@Param("staffcode") String staffcode);

    @Query("SELECT t FROM Tbstaff t WHERE t.stafftype = :stafftype")
    public List<Tbstaff> getStaffByTypeCode(@Param("stafftype") String stafftype);

//    @Query("SELECT st FROM Tbstaff st WHERE st.stafftype = 'PG00000004' and st.staffcode not in ("
//            + "SELECT haizz.tbclassschedulePK.teachercode FROM Tbcourseclass t join Tbcourse c on t.tbcourseclassPK.coursecode = c.coursecode "
//            + "join Tbclassschedule haizz on haizz.tbclassschedulePK.classcode = t.tbcourseclassPK.classcode "
//            + "where (((:startday between c.startcourse and c.endcourse) and (:endday between c.startcourse and c.endcourse)) or ((:startday between c.startcourse and c.endcourse) and (:endday > c.endcourse))) and haizz.tbclassschedulePK.daycode = :dayofweek "
//            + "and haizz.classroomcode = :vlRoom and haizz.tbclassschedulePK.classtimecode not in (:shift))")
//    @Query("SELECT st FROM Tbstaff st WHERE st.stafftype = 'PG00000004' and st.staffcode not in ("
//            + "SELECT haizz.tbclassschedulePK.teachercode FROM Tbcourseclass t join Tbcourse c on t.tbcourseclassPK.coursecode = c.coursecode "
//            + "join Tbclassschedule haizz on haizz.tbclassschedulePK.classcode = t.tbcourseclassPK.classcode "
//            + "where (((:startday between c.startcourse and c.endcourse) and (:endday between c.startcourse and c.endcourse)) or ((:startday between c.startcourse and c.endcourse) and (:endday > c.endcourse))) and haizz.tbclassschedulePK.daycode = :dayofweek "
//            + "and haizz.classroomcode = :vlRoom)")
//    public List<Tbstaff> getListStaffCreateClass(@Param("startday") Date startday, @Param("endday") Date endday, @Param("dayofweek") String dayofweek, @Param("vlRoom") String vlRoom);
    @Query("SELECT st FROM Tbstaff st WHERE st.stafftype = 'PG00000004' and st.staffcode not in ("
            + "SELECT a.tbclassschedulePK.teachercode FROM Tbclassschedule a join Tbcourseclass b on b.tbcourseclassPK.classcode = a.tbclassschedulePK.classcode "
            + "where (((:startday between b.startdate and b.enddate) and (:endday between b.startdate and b.enddate)) or ((:startday between b.startdate and b.enddate) and (:endday > b.enddate))) and a.tbclassschedulePK.daycode = :dayofweek "
            + "and a.classtimelessoncode in (:shift))")
    public List<Tbstaff> getListStaffCreateClass(@Param("startday") Date startday, @Param("endday") Date endday, @Param("dayofweek") String dayofweek, @Param("shift") String shift);

    @Query("SELECT st FROM Tbstaff st WHERE st.stafftype = 'PG00000004' and st.staffcode in ("
            + "SELECT haizz.tbclassschedulePK.teachercode FROM Tbcourseclass t join Tbcourse c on t.tbcourseclassPK.coursecode = c.coursecode "
            + "join Tbclassschedule haizz on haizz.tbclassschedulePK.classcode = t.tbcourseclassPK.classcode "
            + "where (((:startday between c.startcourse and c.endcourse) and (:endday between c.startcourse and c.endcourse)) or ((:startday between c.startcourse and c.endcourse) and (:endday > c.endcourse))) and haizz.tbclassschedulePK.daycode = :dayofweek "
            //            + "and haizz.classroomcode = :vlRoom "
            + "and haizz.classtimelessoncode not in (:shift))")
//    public List<Tbstaff> getListStaffHaveClassInTime(@Param("startday") Date startday, @Param("endday") Date endday, @Param("dayofweek") String dayofweek, @Param("vlRoom") String vlRoom, @Param("shift") String shift);
    public List<Tbstaff> getListStaffHaveClassInTime(@Param("startday") Date startday, @Param("endday") Date endday, @Param("dayofweek") String dayofweek, @Param("shift") String shift);

    @Query("SELECT MAX(t.staffcode) as maxstaffcode FROM Tbstaff t")
    public String getMaxCodeStaff();

}
