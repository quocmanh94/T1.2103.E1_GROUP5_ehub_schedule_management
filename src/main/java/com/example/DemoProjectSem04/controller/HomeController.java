/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.controller;

import com.example.DemoProjectSem04.DTO.*;
import com.example.DemoProjectSem04.entities.*;
import com.example.DemoProjectSem04.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.DemoProjectSem04.utils.PasswordGenerator.encryptPassword;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/admin")
public class HomeController {
    
    @Value("${upload.path}")
    private String fileUpload;
    
    @Autowired
    tbCenterService centerService;
    
    @Autowired
    tbStudentService studentService;
    
    @Autowired
    tbCourseModuleService courseModuleService;
    
    @Autowired
    tbUserService userService;
    
    @Autowired
    tbPositionGroupService positionGroupService;
    
    @Autowired
    tbRoleService roleService;
    
    @Autowired
    tbStaffService staffService;
    
    @Autowired
    tbClassroomService classroomService;
    
    @Autowired
    tbClassService classService;
    
    @Autowired
    tbCourseClassService courseClassService;
    
    @Autowired
    tbCourseService courseService;
    
    @Autowired
    tbModuleService moduleService;
    
    @Autowired
    tbClassScheduleService classScheduleService;
    
    @Autowired
    tbClassStudentService classStudentService;
    
    @Autowired
    tbClassTimeService classTimeService;
    
    @Autowired
    tbClassTimeLessonService classTimeLessonService;
    
    @Autowired
    tbWorkingScheduleService workingScheduleService;
    
    @Autowired
    tbStudyingScheduleService studyingScheduleService;
    
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "admin/login";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        boolean isSecure = false;
        String contextPath = null;
        if (request != null) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            isSecure = request.isSecure();
            contextPath = request.getContextPath();
        }
        SecurityContext context = SecurityContextHolder.getContext();
        SecurityContextHolder.clearContext();
        context.setAuthentication(null);
        if (response != null) {
            Cookie cookie = new Cookie("JSESSIONID", null);
            String cookiePath = StringUtils.hasText(contextPath) ? contextPath : "/";
            cookie.setPath(cookiePath);
            cookie.setMaxAge(0);
            cookie.setSecure(isSecure);
            response.addCookie(cookie);
        }
        return "admin/login";
    }
    
    @RequestMapping({"/users"})
    public String usersPage(Model model, @ModelAttribute("messageResult") String messageResult) {
        if (messageResult.equals("")) {
            model.addAttribute("messageResult", messageResult);
        }
        List<Tbuser> listTbuser = userService.findAllUser();
        model.addAttribute("listTbuser", listTbuser);
        return "admin/pages/users";
    }
    
    @RequestMapping({"/classrooms"})
    public String classroomsPage(Model model, @ModelAttribute("messageResult") String messageResult) {
        model.addAttribute("classroom", new Tbclassroom());
        if (messageResult.equals("")) {
            model.addAttribute("messageResult", messageResult);
        }
        List<Tbclassroom> listTbclassroom = classroomService.findAllClassroom();
        model.addAttribute("listTbclassroom", listTbclassroom);
        return "admin/pages/classrooms";
    }
    
    @RequestMapping({"/stafflist"})
    public String stafflistPage(Model model, @ModelAttribute("messageResult") String messageResult) {
        return "admin/pages/stafflist";
    }
    
    @RequestMapping({"/classes"})
    public String classesPage(Model model, @ModelAttribute("messageResult") String messageResult) {
        
        List<Tbclass> classList = classService.getClassesStillWorking();
        List<Tbclassdto> classDTOList = new ArrayList<>();
        for (Tbclass dt : classList) {
            Tbcourseclass dtcl = courseClassService.getCourseClassByClassCode(dt.getClasscode());
            Tbcourse dtc = courseService.findCourseByCode(dtcl.getTbcourseclassPK().getCoursecode());
            List<Tbclassschedule> dtlClassSchedule = classScheduleService.getListClassScheduleByClassCode(dt.getClasscode());
            Format formatter = new SimpleDateFormat("dd-MM-yyyy");
            String coursetime = formatter.format(dtcl.getStartDate()) + " - " + formatter.format(dtcl.getEndDate());
            Tbclassdto classDTO = new Tbclassdto();
            classDTO.setClasscode(dt.getClasscode());
            classDTO.setClassname(dt.getClassname());
            classDTO.setCoursecode(dtc.getCoursecode());
            classDTO.setCoursename(dtc.getCoursename());
            classDTO.setCoursetime(coursetime);
            int k = dtlClassSchedule.size();
            int a = 1;
            String roomname = "";
            for (Tbclassschedule cs : dtlClassSchedule) {
                if (a != k) {
                    roomname = ", " + cs.getRoom() + " - Date: " + cs.getDayofweek();
                } else {
                    roomname = cs.getRoom() + " - Date: " + cs.getDayofweek();
                }
                a++;
            }
            classDTO.setClassroomname(roomname);
            Date date = new Date();

//            int result = dtc.getOpentimecourse().compareTo(date);
            int result2 = dtcl.getStartDate().compareTo(date);
            int result3 = dtcl.getEndDate().compareTo(date);
            
            String trangthailop = "";
//            if (result > 0 && result2 > 0 && result3 > 0) {
//                trangthailop = "Will Open";
//            } else if (result <= 0 && result2 > 0 && result3 > 0) {
//                trangthailop = "Opening";
//            } else if (result < 0 && result2 <= 0 && result3 >= 0) {
//                trangthailop = "In Processing";
//            } else if (result < 0 && result2 < 0 && result3 < 0) {
//                trangthailop = "Close";
//            }

            if (result2 > 0 && result3 > 0) {
                trangthailop = "Opening";
            } else if (result2 <= 0 && result3 >= 0) {
                trangthailop = "In Processing";
            } else if (result2 < 0 && result3 < 0) {
                trangthailop = "Finished";
            }
            
            classDTO.setClassstatus(trangthailop);
            classDTOList.add(classDTO);
        }
        
        model.addAttribute("classList", classDTOList);
        return "admin/pages/class";
    }
    
    @RequestMapping({"/loadClassList"})
    public @ResponseBody
    List<Tbclassdto> loadClassList(Model model) {
        List<Tbclass> classList = classService.getClassesStillWorking();
        List<Tbclassdto> classDTOList = new ArrayList<>();
        for (Tbclass dt : classList) {
            Tbcourseclass dtcl = courseClassService.getCourseClassByClassCode(dt.getClasscode());
            Tbcourse dtc = courseService.findCourseByCode(dtcl.getTbcourseclassPK().getCoursecode());
            List<Tbclassschedule> dtlClassSchedule = classScheduleService.getListClassScheduleByClassCode(dt.getClasscode());
            Format formatter = new SimpleDateFormat("dd-MM-yyyy");
            String coursetime = formatter.format(dtc.getStartcourse()) + " - " + formatter.format(dtc.getEndcourse());
            Tbclassdto classDTO = new Tbclassdto();
            classDTO.setClasscode(dt.getClasscode());
            classDTO.setClassname(dt.getClassname());
            classDTO.setCoursecode(dtc.getCoursecode());
            classDTO.setCoursename(dtc.getCoursename());
            classDTO.setCoursetime(coursetime);
            int k = dtlClassSchedule.size();
            int a = 1;
            String roomname = "";
            for (Tbclassschedule cs : dtlClassSchedule) {
                if (a != k) {
                    roomname = ", " + cs.getRoom() + " - Date: " + cs.getDayofweek();
                } else {
                    roomname = cs.getRoom() + " - Date: " + cs.getDayofweek();
                }
                a++;
            }
            classDTO.setClassroomname(roomname);
            Date date = new Date();
            
            int result = dtc.getOpentimecourse().compareTo(date);
            int result2 = dtc.getStartcourse().compareTo(date);
            int result3 = dtc.getEndcourse().compareTo(date);
            
            String trangthailop = "";
            if (result > 0 && result2 > 0 && result3 > 0) {
                trangthailop = "Will Open";
            } else if (result <= 0 && result2 > 0 && result3 > 0) {
                trangthailop = "Opening";
            } else if (result < 0 && result2 <= 0 && result3 >= 0) {
                trangthailop = "In Processing";
            } else if (result < 0 && result2 < 0 && result3 < 0) {
                trangthailop = "Close";
            }
            classDTO.setClassstatus(trangthailop);
            classDTOList.add(classDTO);
        }
        return classDTOList;
    }
    
    @RequestMapping({"/changepassword"})
    public String changepasswordPage(Model model, @ModelAttribute("messageResult") String messageResult) {
        return "admin/pages/changepassword";
    }
    
    @RequestMapping({"/detailstudent/{id}"})
    public String detailstudent(Model model, @PathVariable("id") String id) {
        Tbcourseclass dtcourseclass = courseClassService.getCourseClassByClassCode(id);
        Tbcourse dtcourse = courseService.findCourseByCode(dtcourseclass.getTbcourseclassPK().getCoursecode());
        List<Tbmodule> dlModule = moduleService.getModuleByCourseCode(dtcourse.getCoursecode());
        model.addAttribute("dtcourse", dtcourse);
        model.addAttribute("dlModule", dlModule);
        return "admin/pages/editstudent";
    }
    
    @RequestMapping({"/detailclass/{id}"})
    public String detailclassPage(Model model, @PathVariable("id") String id) {
        Tbclass dtClass = classService.findClassByCode(id);
        Tbcourseclass dtcourseclass = courseClassService.getCourseClassByClassCode(id);
        Tbcourse dtcourse = courseService.findCourseByCode(dtcourseclass.getTbcourseclassPK().getCoursecode());
        List<Tbmodule> dlModule = moduleService.getModuleByCourseCode(dtcourse.getCoursecode());
        List<Tbstudent> dlStudent = studentService.getStudentListByClassCode(id);
        int actuallyseats = 0;
        for (Tbstudent student : dlStudent) {
            actuallyseats++;
        }
        Tbcourseclass dtCourseClass = courseClassService.getCourseClassByClassCode(id);
        List<Tbclassschedule> dtClassSchedule = classScheduleService.getListClassScheduleByClassCode(id);
        Tbclassroom dtClassRoom = classroomService.findClassroomByCode(dtClassSchedule.get(0).getClassroomcode());
        Tbclasstimelesson dtShift = classTimeLessonService.getClassTimeLessonByCode(dtClassSchedule.get(0).getClasstimelessoncode());
        Tbclassinformationdto tbclassinformationdto = new Tbclassinformationdto();
        tbclassinformationdto.setClasscode(id);
        tbclassinformationdto.setActuallyseats(actuallyseats);
        tbclassinformationdto.setClassname(dtClass.getClassname());
        tbclassinformationdto.setShiftcode(dtShift.getCtlcode());
        tbclassinformationdto.setShiftname(dtShift.getCtlname());
        tbclassinformationdto.setClassroomname(dtClassRoom.getRoomname());
        List<String> objTimeStudying = new ArrayList<>();
        List<String> objTeacher = new ArrayList<>();
        for (Tbclassschedule tbclassschedule : dtClassSchedule) {
            String time = tbclassschedule.getDayofweek() + " : " + tbclassschedule.getClasstime();
            objTeacher.add(tbclassschedule.getTeachername());
            objTimeStudying.add(time);
        }
        tbclassinformationdto.setTeacher(objTeacher);
        tbclassinformationdto.setTimestudying(objTimeStudying);
        tbclassinformationdto.setToalseats(dtClassRoom.getRoomnumberofseats());
        
        model.addAttribute("dtcourse", dtcourse);
        model.addAttribute("dlModule", dlModule);
        model.addAttribute("dlStudent", dlStudent);
        model.addAttribute("classInfor", tbclassinformationdto);
        
        return "admin/pages/detailsclass";
    }
    
    @RequestMapping({"/workingschedule"})
    public String workingschedulePage(Model model) {
        return "admin/pages/workingschedule";
    }
    
    @RequestMapping({"/getTHeadWorkingScheduleByTime"})
    public @ResponseBody
    List<String> getTHeadWorkingScheduleByTime(Model model, @RequestParam(required = false, value = "fromD") String fromD, @RequestParam(required = false, value = "toD") String toD) {
        List<String> theadList = new ArrayList<>();
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date fromDate = df.parse(fromD);
            
            DateFormat dff = new SimpleDateFormat("dd/MM/yyyy");
            Date toDate = dff.parse(toD);
            
            LocalDate FromLocalDate = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate ToLocalDate = toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            //Date workingDate = Date.from(workingDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Tbworkingschedule listPermission = new Tbworkingschedule();
            
            int check = 1;
            for (LocalDate date = FromLocalDate; date.isBefore(ToLocalDate.plusDays(1)); date = date.plusDays(1)) {
                
                if (check == 1) {
                    theadList.add("Scheduled Shift");
                }
                
                String dow = date.getDayOfWeek().toString().substring(0, 3);
                
                Date d = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
                String todayAsStrings = df.format(d);
                String dayss = todayAsStrings.substring(0, 2);
                String month = todayAsStrings.substring(3, 5);
                theadList.add(dow + " " + dayss + "/" + month);
                
                check++;
            }
        } catch (Exception e) {
            //The handling for the code
        }

//        List<Tbworkingschedule> listTbworkingschedule = functionService.findAllFunction();
//        listPermission.setListFunction(listFunct);
//        model.addAttribute("theadList", theadList);
        return theadList;
        
    }
    
    @RequestMapping({"/getTBodyWorkingScheduleByTime"})
    public @ResponseBody
    List<Tbworkingstafflistdto> getTBodyWorkingScheduleByTime(Model model, @RequestParam(required = false, value = "fromD") String fromD, @RequestParam(required = false, value = "toD") String toD) {
//        List<String> theadList = new ArrayList<>();
        List<Tbstaff> stafflist = staffService.getStaffListStillWorking();
        List<Tbworkingstafflistdto> workingList = new ArrayList<>();
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date fromDate = df.parse(fromD);
            
            DateFormat dff = new SimpleDateFormat("dd/MM/yyyy");
            Date toDate = dff.parse(toD);
            
            for (Tbstaff m : stafflist) {
                List<Tbworkingschedule> wsList = workingScheduleService.getWorkingDateByStaffCode(m.getStaffcode());
                LocalDate FromLocalDate = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate ToLocalDate = toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                //Date workingDate = Date.from(workingDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
                Tbworkingschedule listPermission = new Tbworkingschedule();
                List<Tbteachingschedule> lNew = new ArrayList<>();
                Tbworkingstafflistdto wsldto = new Tbworkingstafflistdto();
                for (Tbworkingschedule u : wsList) {
                    
                    String todayAsStrings = df.format(u.getWorkingday());
                    String dayss = todayAsStrings.substring(0, 2);
                    String monthss = todayAsStrings.substring(3, 5);
                    String yearss = todayAsStrings.substring(6, 10);
                    
                    Tbclassroom crWD = classroomService.findClassroomByCode(u.getClassroomcode());
                    Tbclass clWD = classService.findClassByCode(u.getClasscode());
                    Tbclasstime ctWD = classTimeService.getCLassTimeByCode(u.getClasstimecode());
                    
                    Tbteachingschedule tbTmp = new Tbteachingschedule();
                    tbTmp.setClasscode(u.getClasscode());
                    tbTmp.setClassroomcode(u.getClassroomcode());
                    tbTmp.setClasstimecode(u.getClasstimecode());
                    tbTmp.setDay(dayss);
                    tbTmp.setMonth(monthss);
                    tbTmp.setStaffcode(u.getStaffcode());
                    tbTmp.setWorkingday(u.getWorkingday());
                    tbTmp.setYear(yearss);
                    tbTmp.setClassname(clWD.getClassname());
                    tbTmp.setClassroomname(crWD.getRoomname());
                    tbTmp.setClasstimename(ctWD.getClasstimename());
                    lNew.add(tbTmp);
                    
                }
                wsldto.setStaffcode(m.getStaffcode());
                wsldto.setStaffname(m.getStaffname());
                wsldto.setStaffimg(m.getStaffimg());
                wsldto.setListworkingschedule(lNew);
                workingList.add(wsldto);
//            int check = 1;
//                for (LocalDate date = FromLocalDate; date.isBefore(ToLocalDate.plusDays(1)); date = date.plusDays(1)) {
//                    Date d = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
//                    String todayAsStrings = df.format(d);
//                    String dayss = todayAsStrings.substring(0, 2);
//                    String month = todayAsStrings.substring(3, 5);
//                    for (Tbworkingschedule u : wsList) {
//                        LocalDate workingday = u.getWorkingday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//                        Date workingday2 = Date.from(workingday.atStartOfDay(ZoneId.systemDefault()).toInstant());
//                        String working = df.format(d);
//
//                        String dayssworking = working.substring(0, 2);
//                        String monthworking = working.substring(3, 5);
//
//                    }
//                if (check == 1) {
//                    theadList.add("Scheduled Shift");
//                }
//                String dow = date.getDayOfWeek().toString().substring(0, 3);
//

//                theadList.add(dow + " " + dayss + "/" + month);
//
//                check++;
//                }
//                Tbteachingschedule tsdto = new Tbteachingschedule();
//                Tbworkingstafflistdto wsldto = new Tbworkingstafflistdto();
//                wsldto.setStaffcode(m.getStaffcode());
//                wsldto.setStaffname(m.getStaffname());
//                for (Tbworkingschedule u : wsList) {
//
//                }
//                wsldto.setListworkingschedule(listworkingschedule);
            }
            
        } catch (Exception e) {
            //The handling for the code
        }

//        List<Tbworkingschedule> listTbworkingschedule = functionService.findAllFunction();
//        listPermission.setListFunction(listFunct);
//        model.addAttribute("theadList", theadList);
        return workingList;
        
    }
    
    @RequestMapping({"/student"})
    public String studentPage(Model model) {
        List<Tbstudent> listStudent = studentService.getStudentList();
        List<Tbstudentdto> listStudentdto = new ArrayList<>();
        
        if (listStudent != null) {
            for (Tbstudent std : listStudent) {
                Tbclass tclassT = classService.findClassByCode(std.getClasscode());
                Tbstudentdto sdto = new Tbstudentdto();
                sdto.setClasscode(std.getClasscode());
                sdto.setClassname(tclassT.getClassname());
                sdto.setDob(std.getStudentdob());
                sdto.setParentname(std.getParentsname());
                sdto.setParentphone(std.getParentsphone());
                if (std.getPaid() == 0) {
                    sdto.setStatuspaid("Paid");
                } else {
                    sdto.setStatuspaid("Partially Paid");
                }
                sdto.setStudentcode(std.getStudentcode());
                sdto.setStudentname(std.getStudentname());
                listStudentdto.add(sdto);
            }
        }
        model.addAttribute("listStudent", listStudentdto);
        return "admin/pages/student";
    }
    
    @RequestMapping({"/addstudent"})
    public String addstudentPage(Model model) {
        Tbstudent maxCodeStudent = studentService.getMaxCodeStudent();
        List<Tbclass> dtClass = classService.getClassesStillWorking();
        String codeStudent = "";
        if (maxCodeStudent == null) {
            codeStudent = "HV00000001";
        } else {
            String temp = maxCodeStudent.getStudentcode().substring(2, 10);
            int tempInt = Integer.parseInt(temp);
            tempInt = tempInt + 1;
            String newTempInt = String.valueOf(tempInt);
            String kihieuStudent = maxCodeStudent.getStudentcode().substring(0, 2).toString();
            if (newTempInt.length() == 1) {
                codeStudent = kihieuStudent + "0000000" + newTempInt;
            } else if (newTempInt.length() == 2) {
                codeStudent = kihieuStudent + "000000" + newTempInt;
            } else if (newTempInt.length() == 3) {
                codeStudent = kihieuStudent + "00000" + newTempInt;
            } else if (newTempInt.length() == 4) {
                codeStudent = kihieuStudent + "0000" + newTempInt;
            } else if (newTempInt.length() == 5) {
                codeStudent = kihieuStudent + "000" + newTempInt;
            } else if (newTempInt.length() == 6) {
                codeStudent = kihieuStudent + "00" + newTempInt;
            } else if (newTempInt.length() == 7) {
                codeStudent = kihieuStudent + "0" + newTempInt;
            } else {
                codeStudent = kihieuStudent + newTempInt;
            }
        }
        model.addAttribute("dtClass", dtClass);
        model.addAttribute("roll", codeStudent);
        return "admin/pages/addstudent";
    }
    
    @RequestMapping(value = "/createNewStudent", method = RequestMethod.POST)
    public String createNewStudent(Model model, @RequestParam(required = false, value = "sltStudentPaid") String sltStudentPaid, @RequestParam(required = false, value = "studentcode") String studentcode, @RequestParam(required = false, value = "studentname") String studentname, @RequestParam(required = false, value = "sltGender") String sltGender, @RequestParam(required = false, value = "studentdob") Date studentdob, @RequestParam(required = false, value = "studentphone") String studentphone, @RequestParam(required = false, value = "studentemail") String studentemail, @RequestParam(required = false, value = "sltClass") String sltClass, @RequestParam(required = false, value = "sltStatusStudent") String sltStatusStudent, @RequestParam(required = false, value = "studentaddress") String studentaddress, @RequestParam(required = false, value = "parentname") String parentname, @RequestParam(required = false, value = "parentphone") String parentphone) throws IOException {
        Tbcourseclass courseClassDt = courseClassService.getCourseClassByClassCode(sltClass);
        String idCourse = courseClassDt.getTbcourseclassPK().getCoursecode();
        String idModule = "";
        List<Tbcoursemodule> courseModuleL = courseModuleService.findCourseModuleByCourse(idCourse);
        idModule = courseModuleL.get(0).getTbcoursemodulePK().getModulecode();
        Tbmodule moduleDt = moduleService.findModuleByCode(idModule);
        Tbstudent newStudent = new Tbstudent();
        newStudent.setStudentcode(studentcode);
        newStudent.setStudentname(studentname);
        newStudent.setStudentname(studentname);
        newStudent.setStudentstatus(Integer.parseInt(sltStatusStudent));
        newStudent.setStudentaddress(studentaddress);
        newStudent.setStudentphone(studentphone);
        newStudent.setStudentemail(studentemail);
        newStudent.setParentsname(parentname);
        newStudent.setParentsphone(parentphone);
        newStudent.setStudentlevel(moduleDt.getClassblock());
        newStudent.setStudentdob(studentdob);
        newStudent.setCentercode(1);
        newStudent.setIsdelete(0);
        Date dte = new Date();
        newStudent.setMonth(dte.getMonth());
        newStudent.setYear(dte.getYear());
        newStudent.setStudentgender(Integer.parseInt(sltGender));
        newStudent.setClasscode(sltClass);
        newStudent.setPaid(Integer.parseInt(sltStudentPaid));
        studentService.createNewStudent(newStudent);
        
        TbclassstudentPK tbclassstudentPK = new TbclassstudentPK();
        tbclassstudentPK.setClasscode(sltClass);
        tbclassstudentPK.setStudentcode(studentcode);
        
        Tbclassstudent objClassStudent = new Tbclassstudent();
        objClassStudent.setCentercode(1);
        objClassStudent.setIsdelete(0);
        objClassStudent.setTbclassstudentPK(tbclassstudentPK);
        objClassStudent.setStudentname(studentname);
        objClassStudent.setStudentphone(studentphone);
        
        classStudentService.save(objClassStudent);
        
        Date end = courseClassDt.getEndDate();
        Date start = courseClassDt.getStartDate();
        
        LocalDate endLD = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate startLD = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate newEndLD = endLD.plusDays(1);
//        LocalDate StartLocalDate = StartDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        int start = StartLocalDate.getDayOfMonth();
//        int end = start + tbcourse.getNumberlesson();
//        //int a = 1;
//        Date newEndDate = new Date();
//        Date newStartClass = new Date();
//        List<Tbworkingschedule> workingscheduleList = new ArrayList<>();
        for (LocalDate date = startLD; date.isBefore(newEndLD); date = date.plusDays(1)) {
            
            int dayOfWeek = date.getDayOfWeek().getValue();
//            LocalDate workingDay = StartLocalDate.plusDays(i - start);
            Date studyingDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
            
            List<Tbclassschedule> listClassSchedule = classScheduleService.getListClassScheduleByClassCode(sltClass);
            
            Tbstudyingschedule objTbStudyingSchedule = new Tbstudyingschedule();
            objTbStudyingSchedule.setCentercode(1);
            objTbStudyingSchedule.setClasscode(sltClass);
            objTbStudyingSchedule.setStudentcode(studentcode);
            objTbStudyingSchedule.setCompleted(0);
            objTbStudyingSchedule.setCredt(new Date());
            objTbStudyingSchedule.setWorkingday(studyingDate);
            boolean check = false;
            for (Tbclassschedule u : listClassSchedule) {
                if (u.getDayofweek().equals("Monday") && dayOfWeek == 1) {
                    check = true;             
                }else if(u.getDayofweek().equals("Tuesday") && dayOfWeek == 2){
                    check = true;
                }else if(u.getDayofweek().equals("Wednesday") && dayOfWeek == 3){
                    check = true;
                }else if(u.getDayofweek().equals("Thursday") && dayOfWeek == 4){
                    check = true;
                }else if(u.getDayofweek().equals("Friday") && dayOfWeek == 5){
                    check = true;
                }else if(u.getDayofweek().equals("Saturday") && dayOfWeek == 6){
                    check = true;
                }else if(u.getDayofweek().equals("Sunday") && dayOfWeek == 7){
                    check = true;
                }
            }
            
            if(check == true){
                studyingScheduleService.save(objTbStudyingSchedule);
            }
        }
        
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
        String uEmail = user.getUsername();
        Tbuser tbu = userService.findUserByEmail(uEmail);
        if (tbu.getPermision().getPgcode().equals("PG00000005")) {
            model.addAttribute("userLogin", user.getUsername());
            return "redirect:/admin/student";
        }else if (tbu.getPermision().getPgcode().equals("PG00000001")) {
            return "redirect:/admin/staffdashboardstudent";
        }
        return "redirect:/admin/pages/student";
//        else if (tbu.getPermision().getPgcode().equals("PG00000004")) {
//            return "pages/teacherdashboard";
//        } else {
//            model.addAttribute("userLogin", user.getUsername());
//            return "pages/teacherdashboard";
//        }
        
//        return "redirect:/pages/student";
    }
    
    @RequestMapping(value = "/createNewCourse", method = RequestMethod.POST)
    public String createNewCourse(Model model, @RequestParam(required = false, value = "coursename") String coursename, @RequestParam(required = false, value = "opendates") @DateTimeFormat(pattern = "yyyy-MM-dd") Date opendates, @RequestParam(required = false, value = "startdates") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startdates, @RequestParam(required = false, value = "sltModule") ArrayList<String> sltModule) throws IOException {
        
        List<Tbcoursemodule> tbCourseModuleList = new ArrayList<>();
        
        Tbcourse maxCourseCode = courseService.getMaxCode();
        
        String max = "";
        
        if (maxCourseCode == null) {
            max = "COURSE0001";
        } else {
            max = maxCourseCode.getCoursecode();
            String temp = max.substring(6, 10);
            int tempInt = Integer.parseInt(temp);
            tempInt = tempInt + 1;
            String newTempInt = String.valueOf(tempInt);
            String kihieucourse = max.substring(0, 6).toString();
            
            if (newTempInt.length() == 1) {
                max = kihieucourse + "000" + newTempInt;
            } else if (newTempInt.length() == 2) {
                max = kihieucourse + "00" + newTempInt;
            } else if (newTempInt.length() == 3) {
                max = kihieucourse + "0" + newTempInt;
            } else {
                max = kihieucourse + newTempInt;
            }
        }
        
        LocalDate StartLocalDate = startdates.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int monS = StartLocalDate.getMonth().getValue();
        int yeaS = StartLocalDate.getYear();
        
        Tbcourse newCourse = new Tbcourse();
        newCourse.setCoursecode(max);
        newCourse.setCoursename(coursename);
        newCourse.setMonth(monS);
        newCourse.setYear(yeaS);
        newCourse.setOpentimecourse(opendates);
        newCourse.setStartcourse(startdates);
        LocalDate EndLocalDate = StartLocalDate.plusDays(1);
        Date newEndDate = Date.from(EndLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        newCourse.setEndcourse(newEndDate);
        newCourse.setIsactive(1);
        
        int totalnumber = 0;
        
        for (String st : sltModule) {
            Tbmodule mdl = moduleService.findModuleByCode(st);
            totalnumber += Integer.parseInt(mdl.getModuletime().substring(0, 2));
            TbcoursemodulePK cmpk = new TbcoursemodulePK();
            cmpk.setCoursecode(max);
            cmpk.setModulecode(st);
            Tbcoursemodule cm = new Tbcoursemodule();
            cm.setTbcoursemodulePK(cmpk);
            cm.setMonth(monS);
            cm.setYear(yeaS);
            cm.setModulename(mdl.getModulename());
            cm.setFromdate(startdates);
            cm.setTodate(newEndDate);
            tbCourseModuleList.add(cm);
        }
        newCourse.setNumberlesson(totalnumber);
        
        courseService.save(newCourse);
        
        for (Tbcoursemodule m : tbCourseModuleList) {
            courseModuleService.save(m);
        }
        
        return "redirect:/admin/course";
    }
    
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @RequestMapping({"/profile"})
    public String profilePage(Model model, @ModelAttribute("messageResult") String messageResult, @ModelAttribute("staffcode") String staffcode) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
        String username = user.getUsername();
        Tbstaff tbstaff = staffService.findStaffByEmail(username);
        Tbuser tbuser = userService.findUserByEmail(username);
        Tbpositiongroup tbpositiongroup = positionGroupService.getPositionGroupById(tbuser.getPermision().getPgcode());
        Tbstaffdto tbstaffdto = new Tbstaffdto();
        tbstaffdto.setCode(tbstaff.getStaffcode());
        tbstaffdto.setName(tbstaff.getStaffname());
        tbstaffdto.setPositioncode(tbuser.getPermision().getPgcode());
        tbstaffdto.setPositionname(tbpositiongroup.getPgname());
        tbstaffdto.setPhone(tbstaff.getStaffphone());
        tbstaffdto.setEmail(tbstaff.getStaffemail());
        tbstaffdto.setAddress(tbstaff.getStaffaddress());
        tbstaffdto.setGender(tbstaff.getStaffgender().toString());
        tbstaffdto.setDob(tbstaff.getStaffdob());
        tbstaffdto.setPassword(tbuser.getPassword());
        tbstaffdto.setTypestaff(tbstaff.getStafftype().toString());
        tbstaffdto.setImage(tbstaff.getStaffimg());
        model.addAttribute("tbstaffdto", tbstaffdto);
        List<Tbpositiongroup> tbpositiongroup2List = positionGroupService.findAllPositionGroup();
        model.addAttribute("tbpositiongroup2List", tbpositiongroup2List);
        //model.addAttribute("messag", tbpositiongroup2List);
        return "admin/pages/profile";
    }
    
    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    public String updateProfile(Model model, @Valid @ModelAttribute("tbstaffdto") Tbstaffdto tbstaffdto, BindingResult bindingResult, @ModelAttribute("dateofbirth") Date dateofbirth) throws IOException {
        
        MultipartFile file = tbstaffdto.img;
        String fileName = file.getOriginalFilename();
        
        Tbstaff tbStaffOld = staffService.findStaffByCode(tbstaffdto.getCode());
        tbStaffOld.setStaffname(tbstaffdto.getName());
        
        tbStaffOld.setStaffdob(dateofbirth);
        
        tbStaffOld.setStaffaddress(tbstaffdto.getAddress());
        tbStaffOld.setStaffphone(tbstaffdto.getPhone());
        tbStaffOld.setStaffgender(Integer.parseInt(tbstaffdto.getGender()));
        if (!fileName.equals("")) {
            tbStaffOld.setStaffimg(fileName);
            FileCopyUtils.copy(file.getBytes(), new File(this.fileUpload, fileName));
        }
        
        staffService.updateProfile(tbStaffOld);
        
        return "redirect:/admin/profile";
    }
    
    @RequestMapping({"/modulecourse"})
    public String modulecoursePage(Model model, @ModelAttribute("messageResult") String messageResult) {
        List<Tbcourse> dtcourse = courseService.findAllCourse();
        model.addAttribute("dtcourse", dtcourse);
        return "admin/pages/modulecourse";
    }
    
    @RequestMapping({"/getModuleByCourse"})
    public @ResponseBody
    List<Tbmodule> getModuleByCourse(Model model, @RequestParam("idCourse") String idCourse) {
        List<Tbcoursemodule> dtcoursemodule = courseModuleService.findCourseModuleByCourse(idCourse);
        List<Tbmodule> dtmodule = new ArrayList<>();
        for (Tbcoursemodule k : dtcoursemodule) {
            Tbmodule objMD = moduleService.findModuleByCode(k.getTbcoursemodulePK().getModulecode());
            dtmodule.add(objMD);
        }
        return dtmodule;
    }
    
    @RequestMapping({"/loadStaffList"})
    public @ResponseBody
    List<Tbstaffdto> loadStaffList(Model model) {
        List<Tbstaff> listStaff = staffService.findAllStaff();
        List<Tbpositiongroup> lp = positionGroupService.findAllPositionGroup();
        List<Tbstaffdto> lpdto = new ArrayList<>();
        
        for (Tbstaff ts : listStaff) {
            Tbstaffdto sdto = new Tbstaffdto();
            sdto.setCode(ts.getStaffcode());
            sdto.setName(ts.getStaffname());
            sdto.setLevelstudy(ts.getStafflevel());
            sdto.setImage(ts.getStaffimg());
            sdto.setTypestaff(ts.getStafftype());
            for (Tbpositiongroup tp : lp) {
                if (ts.getStafftype().equals(tp.getPgcode())) {
                    sdto.setTypestaffname(tp.getPgname());
                }
            }
            lpdto.add(sdto);
        }
        return lpdto;
    }
    
    @RequestMapping(value = "/loadStaffDetails", method = RequestMethod.GET)
    public @ResponseBody
    Tbstaffdto loadStaffDetails(Model model, @RequestParam(required = false, name = "staffID") String staffID) {
        Tbstaff s = staffService.findStaffByCode(staffID);
        List<Tbpositiongroup> lp = positionGroupService.findAllPositionGroup();
        
        Tbstaffdto sdto = new Tbstaffdto();
        sdto.setCode(s.getStaffcode());
        sdto.setName(s.getStaffname());
        sdto.setEmail(s.getStaffemail());
        sdto.setGender(s.getStaffgender().toString());
        sdto.setTypestaff(s.getStafftype());
        return sdto;
    }
    
    @RequestMapping(value = "/editClassroomModal", method = RequestMethod.GET)
    public @ResponseBody
    Tbclassroom editClassroomModal(@RequestParam("code") String code) {
        Tbclassroom tbclassroom = classroomService.findClassroomByCode(code);
        return tbclassroom;
    }
    
    @RequestMapping(value = "/updateClassroom", method = RequestMethod.POST)
    public String updateClassroom(Model model, Tbclassroom tbclassroom, RedirectAttributes redirectAttributes) {
        classroomService.saveClassroom(tbclassroom);
        redirectAttributes.addFlashAttribute("messageResult", "Update Successfully !");
        return "redirect:/admin/classrooms";
    }
    
    @RequestMapping(value = "/user/resetPassword", method = RequestMethod.POST)
    public String resetPassword(Model model, @RequestParam(required = false, name = "userID") String userID, RedirectAttributes redirectAttributes) {
        Tbuser tuser = userService.findUserByEmail(userID);
        tuser.setPassword(encryptPassword("123"));
        userService.save(tuser);
        return "redirect:/admin/logout";
    }
    
    @RequestMapping(value = "/staff/updateDetails", method = RequestMethod.POST)
    public String updateDetails(Model model, @RequestParam(required = false, name = "editstaffcode") String editstaffcode, @RequestParam(required = false, name = "slteditstaffposition") String slteditstaffposition, RedirectAttributes redirectAttributes) {
        Tbstaff stf = staffService.findStaffByCode(editstaffcode);
        stf.setStafftype(slteditstaffposition);
        staffService.updateProfile(stf);
        return "redirect:/admin/stafflist";
    }
    
    @RequestMapping(value = "/staff/addNewStaff", method = RequestMethod.POST)
    public String addNewStaff(Model model, @RequestParam(required = false, name = "addsltstaffposition") String addsltstaffposition, @RequestParam(required = false, name = "addsltstaffgender") String addsltstaffgender, @RequestParam(required = false, name = "addstaffemail") String addstaffemail, @RequestParam(required = false, name = "addstaffusername") String addstaffusername, @RequestParam(required = false, name = "addstaffname") String addstaffname, RedirectAttributes redirectAttributes) {
        
        String maxCodeStaff = staffService.getMaxCodeStaff();
        String temp = maxCodeStaff.substring(5, 10);
        int tempInt = Integer.parseInt(temp);
        tempInt = tempInt + 1;
        String newTempInt = String.valueOf(tempInt);
        String newMaxCodeStaff = "";
        if (newTempInt.length() == 1) {
            newMaxCodeStaff = maxCodeStaff.substring(0, 5) + "0000" + newTempInt;
        } else if (newTempInt.length() == 2) {
            newMaxCodeStaff = maxCodeStaff.substring(0, 5) + "000" + newTempInt;
        } else if (newTempInt.length() == 3) {
            newMaxCodeStaff = maxCodeStaff.substring(0, 5) + "00" + newTempInt;
        } else if (newTempInt.length() == 4) {
            newMaxCodeStaff = maxCodeStaff.substring(0, 5) + "0" + newTempInt;
        } else {
            newMaxCodeStaff = maxCodeStaff.substring(0, 5) + newTempInt;
        }
        
        Tbuser tbuserTemp = userService.findUserByEmail(addstaffemail);
        Tbstaff tbstaffTemp = new Tbstaff();
        Tbuser newTbuser = new Tbuser();
        
        tbstaffTemp.setStaffcode(newMaxCodeStaff);
        tbstaffTemp.setStafftype(addsltstaffposition);
        tbstaffTemp.setStaffname(addstaffname);
        tbstaffTemp.setStaffemail(addstaffemail);
        tbstaffTemp.setStaffgender(Integer.parseInt(addsltstaffgender));
        tbstaffTemp.setIslock(0);
        tbstaffTemp.setCentercode(1);
        
        if (tbuserTemp == null) {
            
            newTbuser.setUsername(addstaffusername);
            newTbuser.setPassword(encryptPassword("123"));
            newTbuser.setFullname("FPT-" + addstaffname);
            newTbuser.setUseremail(addstaffemail);
            newTbuser.setCentercode(centerService.findCenterById(1));
            newTbuser.setPermision(positionGroupService.getPositionGroupById(addsltstaffposition));
            newTbuser.setEnabled(true);
            newTbuser.setIsclock(0);
            newTbuser.setIsdelete(0);
            tbstaffTemp.setStaffuser(newTbuser);
            
        } else {
            tbstaffTemp.setStaffuser(tbuserTemp);
        }
        
        userService.save(newTbuser);
        staffService.updateProfile(tbstaffTemp);
        
        return "redirect:/admin/stafflist";
    }
    
    @RequestMapping(value = "/deleteClassroom", method = RequestMethod.POST)
    public String deleteClassroom(Model model, @RequestParam("idclassroomDlt") String idclassroomDlt) {
        String idclassroomDlts = idclassroomDlt;
        Tbclassroom tbclassroom = classroomService.findClassroomByCode(idclassroomDlts);
        classroomService.deleteClassroom(tbclassroom);
        return "redirect:admin/classrooms";
    }
    
    @RequestMapping({"/loadUsers"})
    public @ResponseBody
    Tbuserdto loadUsers(Model model) {
        List<Tbuser> ulists = userService.findAllUser();
        List<Tbpositiongroup> pLists = positionGroupService.findAllPositionGroup();
        List<Tbstaff> sLists = staffService.findStaffByTypeCode("PG00000001");
        List<Tbuserdto2> ulists2 = new ArrayList();
        for (Tbuser tuser : ulists) {
            Tbuserdto2 tbuserdto2 = new Tbuserdto2();
            tbuserdto2.setStaffid(staffService.findStaffByEmail(tuser.getUseremail()).getStaffcode());
            tbuserdto2.setUsername(tuser.getUsername());
            tbuserdto2.setPassword(tuser.getPassword());
            tbuserdto2.setFullname(staffService.findStaffByEmail(tuser.getUseremail()).getStaffname());
            tbuserdto2.setUseremail(tuser.getUseremail());
            tbuserdto2.setEnabled(tuser.getEnabled());
            tbuserdto2.setIsclock(tuser.getIsclock());
            tbuserdto2.setIsdelete(tuser.getIsdelete());
            tbuserdto2.setCentercode(tuser.getCentercode().getCentercode());
            tbuserdto2.setCentername(tuser.getCentercode().getCentername());
            tbuserdto2.setPgcode(tuser.getPermision().getPgcode());
            tbuserdto2.setPgname(tuser.getPermision().getPgname());
            ulists2.add(tbuserdto2);
        }
        return new Tbuserdto(ulists, ulists2, pLists, sLists);
    }
    
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String upadteUser(Model model, @RequestParam(required = false, name = "edituseremail") String edituseremail, @RequestParam(required = false, name = "editposition") String editposition, RedirectAttributes redirectAttributes) {
        
        Tbuser tuser = userService.findUserByEmail(edituseremail);
        Tbpositiongroup tpg = positionGroupService.getPositionGroupById(editposition);
        tuser.setPermision(tpg);
        userService.save(tuser);
        redirectAttributes.addFlashAttribute("messageResult", "Update Successfully !");
        return "redirect:/admin/users";
        
    }
    
    @RequestMapping({"/loadClassrooms"})
    public @ResponseBody
    List<Tbclassroom> loadClassrooms(Model model) {
        List<Tbclassroom> listTbclassroom = classroomService.findAllClassroom();
        return listTbclassroom;
    }
    
    @RequestMapping({"/loadStaffByPosition"})
    public @ResponseBody
    List<Tbstaff> loadStaffByPosition(Model model, @RequestParam(required = false, name = "idPosition") String idPosition) {
        List<Tbstaff> l = staffService.findStaffByTypeCode(idPosition);
        return l;
    }

    /*@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("list", userService.findAllUser());
        return "index";
    }*/
    @GetMapping(value = "/403")
    public String erro403() {
        return "admin/403";
    }
    
}
