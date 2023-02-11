/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.controller;

import com.example.DemoProjectSem04.DTO.Tbcoursedto;
import com.example.DemoProjectSem04.DTO.Tbfunctionandpositiondto;
import com.example.DemoProjectSem04.DTO.Tbfunctiondto;
import com.example.DemoProjectSem04.DTO.Tbteacherdto;
import com.example.DemoProjectSem04.entities.Tbcenter;
import com.example.DemoProjectSem04.entities.Tbclass;
import com.example.DemoProjectSem04.entities.Tbclassroom;
import com.example.DemoProjectSem04.entities.Tbclassschedule;
import com.example.DemoProjectSem04.entities.TbclassschedulePK;
import com.example.DemoProjectSem04.entities.Tbclasstime;
import com.example.DemoProjectSem04.entities.Tbclasstimelesson;
import com.example.DemoProjectSem04.entities.Tbcourse;
import com.example.DemoProjectSem04.entities.Tbcourseclass;
import com.example.DemoProjectSem04.entities.TbcourseclassPK;
import com.example.DemoProjectSem04.entities.Tbcoursemodule;
import com.example.DemoProjectSem04.entities.Tbday;
import com.example.DemoProjectSem04.entities.Tbfunction;
import com.example.DemoProjectSem04.entities.Tbmodule;
import com.example.DemoProjectSem04.entities.Tbpositiongroup;
import com.example.DemoProjectSem04.entities.Tbpositiongroupfunction;
import com.example.DemoProjectSem04.entities.TbpositiongroupfunctionPK;
import com.example.DemoProjectSem04.entities.Tbstaff;
import com.example.DemoProjectSem04.entities.Tbworkingschedule;
import com.example.DemoProjectSem04.services.tbCenterService;
import com.example.DemoProjectSem04.services.tbClassScheduleService;
import com.example.DemoProjectSem04.services.tbClassService;
import com.example.DemoProjectSem04.services.tbClassTimeLessonService;
import com.example.DemoProjectSem04.services.tbClassTimeService;
import com.example.DemoProjectSem04.services.tbClassroomService;
import com.example.DemoProjectSem04.services.tbCourseClassService;
import com.example.DemoProjectSem04.services.tbCourseModuleService;
import com.example.DemoProjectSem04.services.tbCourseService;
import com.example.DemoProjectSem04.services.tbDayService;
import com.example.DemoProjectSem04.services.tbFunctionService;
import com.example.DemoProjectSem04.services.tbModuleService;
import com.example.DemoProjectSem04.services.tbPositionGroupFunctionService;
import com.example.DemoProjectSem04.services.tbPositionGroupService;
import com.example.DemoProjectSem04.services.tbStaffService;
import com.example.DemoProjectSem04.services.tbWorkingScheduleService;
import groovyjarjarantlr4.v4.tool.DOTGenerator;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @Autowired
    tbFunctionService functionService;

    @Autowired
    tbModuleService moduleService;

    @Autowired
    tbCourseService courseService;

    @Autowired
    tbPositionGroupFunctionService positionGroupFunctionService;

    @Autowired
    tbPositionGroupService positionGroupService;

    @Autowired
    tbCenterService centerService;

    @Autowired
    tbStaffService staffService;

    @Autowired
    tbClassService classService;

    @Autowired
    tbClassroomService classroomService;

    @Autowired
    tbCourseModuleService courseModuleService;

    @Autowired
    tbClassTimeService classTimeService;

    @Autowired
    tbClassScheduleService classScheduleService;

    @Autowired
    tbCourseClassService courseClassService;

    @Autowired
    tbWorkingScheduleService workingScheduleService;

    @Autowired
    tbClassTimeLessonService classTimeLessonService;
    
    @Autowired
    tbDayService dayService;
    
    @RequestMapping({"/dashboard", "/"})
    public String dashboardPage(Model model) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
        model.addAttribute("userLogin", user.getUsername());

        return "admin/dashboard";
    }

    @RequestMapping({"/staffdashboard"})
    public String staffdashboard(Model model) {
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
//        model.addAttribute("userLogin", user.getUsername());

        return "admin/staffdashboard";
    }
    
    @RequestMapping({"/teacherdashboard"})
    public String teacherdashboard(Model model) {
        return "admin/teacherdashboard";
    }
    
    @RequestMapping({"/timestudying"})
    public String tinestudying(Model model) {
        List<Tbclasstime> giohoc = classTimeService.getListClasstimeByIslock();
        List<Tbclasstimelesson> ca = classTimeLessonService.getListClassTimeLesson();
        model.addAttribute("giohoc", giohoc);
        model.addAttribute("ca", ca);
        return "admin/timestudying";
    }
    
    @RequestMapping({"/day"})
    public String dayPage(Model model) {
//        List<Tbclasstime> giohoc = classTimeService.getListClasstimeByIslock();
//        List<Tbclasstimelesson> ca = classTimeLessonService.getListClassTimeLesson();
//        model.addAttribute("giohoc", giohoc);
//        model.addAttribute("ca", ca);
        return "admin/day";
    }
    
    @RequestMapping({"/loadAllDay"})
    public @ResponseBody List<Tbday> loadAllDay(Model model) {
        List<Tbday> dayList = dayService.getAllDay();
//        List<Tbclasstimelesson> ca = classTimeLessonService.getListClassTimeLesson();
//        model.addAttribute("giohoc", giohoc);
//        model.addAttribute("ca", ca);
        return dayList;
    }
    
    @RequestMapping({"/loadAllClasstimeInTimeStudyingPage"})
    public @ResponseBody
    List<Tbclasstime> loadAllClasstimeInTimeStudyingPage(Model model) {
        List<Tbclasstime> dtlClassTime = classTimeService.getListClasstimeByIslock();
        return dtlClassTime;
    }
    
    @RequestMapping({"/loadClasstimeInTimeStudyingPage"})
    public @ResponseBody
    List<Tbclasstime> loadClasstimeInTimeStudyingPage(Model model, @RequestParam("id") String id) {
        List<Tbclasstime> dtlClassTime = classTimeService.getClasstimebyShift(id);
        return dtlClassTime;
    }
    
    @RequestMapping({"/staffdashboardclass"})
    public String staffdashboardclass(Model model) {
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
//        model.addAttribute("userLogin", user.getUsername());

        return "admin/staffdashboardclass";
    }
    
    @RequestMapping({"/staffdashboardstudent"})
    public String staffdashboardstudent(Model model) {
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
//        model.addAttribute("userLogin", user.getUsername());

        return "admin/staffdashboardstudent";
    }
    
    @RequestMapping({"/staffdashboardinterviewing"})
    public String staffdashboardinterviewing(Model model) {
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
//        model.addAttribute("userLogin", user.getUsername());

        return "admin/staffdashboardinterviewing";
    }
    
    @RequestMapping({"/clientsPage"})
    public String clientsPage(Model model) {
        return "admin/clients";
    }
    
    @RequestMapping({"/setting"})
    public String settingPage(Model model, @ModelAttribute("messageResult") String messageResult) {

        model.addAttribute("center", new Tbcenter());

        if (messageResult != "") {
            model.addAttribute("messageResult", messageResult);
        }

        model.addAttribute("centerList", centerService.findAllCenter());
        return "admin/setting";
    }

    @RequestMapping({"/addclass"})
    public String addclassPage(Model model) {

        // isactive  = 1, = 0 thì không cho hiển thị lên và là khoá học cbi mở và đag mở
        List<Tbcourse> tbcMain = courseService.findAllCourse();
        List<Tbcourse> tbcTemp = new ArrayList<>();

        for (Tbcourse c : tbcMain) {

            Date date = new Date();

            int result = c.getOpentimecourse().compareTo(date);
            int result2 = c.getStartcourse().compareTo(date);
            int result3 = c.getEndcourse().compareTo(date);

            boolean checkCourse = true;

            if (result < 0 && result2 <= 0 && result3 >= 0) {
                // course is progressing
                checkCourse = false;
            }

            if (result < 0 && result2 < 0 && result3 < 0) {
                // course finished
                checkCourse = false;
            }

            if (checkCourse == true) {
                tbcTemp.add(c);
            }

        }

        model.addAttribute("tbcTemp", tbcTemp);
        return "admin/addclass";
    }

    @RequestMapping({"/getRoomCreateClass"})
    public @ResponseBody
    List<Tbclassroom> getRoomCreateClass(Model model, @RequestParam("vlSelectCourse") String vlSelectCourse, @RequestParam("cbDOW") String cbDOW) {

        Tbcourse tbcourseTemp = courseService.findCourseByCode(vlSelectCourse);
        String startday = tbcourseTemp.getStartcourse().toString();
        String endday = tbcourseTemp.getEndcourse().toString();
        List<Tbclassroom> tbclassRoom = classroomService.findClassroomCreateClass(tbcourseTemp.getStartcourse(), tbcourseTemp.getEndcourse(), cbDOW);

        return tbclassRoom;
    }

    @RequestMapping({"/getShiftCreateClass"})
    public @ResponseBody
    List<Tbclasstime> getShiftCreateClass(Model model, @RequestParam("vlSelectCourse") String vlSelectCourse, @RequestParam("cbDOW") String cbDOW, @RequestParam("vlSelectRoom") String vlSelectRoom) {

        Tbcourse tbcourseTemp = courseService.findCourseByCode(vlSelectCourse);
        String startday = tbcourseTemp.getStartcourse().toString();
        String endday = tbcourseTemp.getEndcourse().toString();
        List<Tbclasstime> tbclasstime = classTimeService.finClassTimeCreatClass(tbcourseTemp.getStartcourse(), tbcourseTemp.getEndcourse(), cbDOW, vlSelectRoom);

        return tbclasstime;
    }

    @RequestMapping({"/getTeacherCreateClass"})
    public @ResponseBody
    List<Tbstaff> getTeacherCreateClass(Model model, @RequestParam("vlSelectCourse") String vlSelectCourse, @RequestParam("cbDOW") String cbDOW, @RequestParam("vlSelectRoom") String vlSelectRoom, @RequestParam("selectedValues") ArrayList<String> selectedValues) {

        Tbcourse tbcourseTemp = courseService.findCourseByCode(vlSelectCourse);
        String startday = tbcourseTemp.getStartcourse().toString();
        String endday = tbcourseTemp.getEndcourse().toString();
        String shift = "";
        int i = selectedValues.size();
        int i2 = 1;

        for (String str : selectedValues) {
            if (i2 == i) {
                //shift += "'" + str + "'";
                shift += str;
            } else {
                shift += "'" + str + "',";
            }
            i2++;
        }
        Tbclasstime classtime = classTimeService.getCLassTimeByCode(shift);
//        List<Tbstaff> tbstaffTemp = staffService.findTeacherCreateClass(tbcourseTemp.getStartcourse(), tbcourseTemp.getEndcourse(), cbDOW, vlSelectRoom);
        List<Tbstaff> tbstaffTemp = staffService.findTeacherCreateClass(tbcourseTemp.getStartcourse(), tbcourseTemp.getEndcourse(), cbDOW, classtime.getClasstimelesson().getCtlcode());
//        List<Tbstaff> tbstaffHaveClassInTime = staffService.findTeacherHaveClassInTime(tbcourseTemp.getStartcourse(), tbcourseTemp.getEndcourse(), cbDOW, vlSelectRoom, classtime.getClasstimelesson().getCtlcode());
        List<Tbstaff> tbstaffHaveClassInTime = staffService.findTeacherHaveClassInTime(tbcourseTemp.getStartcourse(), tbcourseTemp.getEndcourse(), cbDOW, classtime.getClasstimelesson().getCtlcode());

//        if (tbstaffHaveClassInTime != null) {
//            for (Tbstaff tbsf : tbstaffHaveClassInTime) {
//                tbstaffTemp.add(tbsf);
//            }
//        }

//        for (String str : selectedValues) {
//            for (Tbclassschedule cs : tbstaffHaveClassInTime) {
//                if(str == "CLT0000001"){
//                
//                }else if(str == "CLT0000002"){
//                    
//                }else if(str == "CLT0000003"){
//                    
//                }else if(str == "CLT0000004"){
//                    
//                }else if(str == "CLT0000005"){
//                    
//                }else if(str == "CLT0000006"){
//                    
//                }else if(str == "CLT0000007"){
//                    
//                }else if(str == "CLT0000008"){
//                    
//                }else if(str == "CLT0000009"){
//                    
//                }else if(str == "CLT0000010"){
//                    
//                }else if(str == "CLT0000011"){
//                    
//                }else if(str == "CLT0000012"){
//                    
//                }else if(str == "CLT0000013"){
//                    
//                }else if(str == "CLT0000014"){
//                    
//                }
//            }
//        }

        return tbstaffTemp;
    }

    @RequestMapping({"/module"})
    public String modulePage(Model model) {

//        model.addAttribute("module", new Tbmodule());
//        model.addAttribute("moduleList", moduleService.findAllModule());
        model.addAttribute("moduleList", moduleService.findAllModule());
        return "admin/module";

    }

    @RequestMapping({"/loadModuleByClassBlock"})
    public @ResponseBody
    List<Tbmodule> loadModuleByClassBlock(Model model, @RequestParam("idclassblock") String idclassblock) {

        List<Tbmodule> as = new ArrayList<>();

        if (idclassblock.equalsIgnoreCase("All")) {
            as = moduleService.findAllModule();
        } else {
            as = moduleService.findAllModuleByClassBlock(idclassblock);
        }

        return as;
    }

    @RequestMapping({"/course"})
    public String coursePage(Model model) {
        List<Tbmodule> moduleList = moduleService.findAllModule();
        model.addAttribute("moduleList", moduleList);
        List<Tbcoursedto> courseDTO = new ArrayList<>();
        List<Tbcourse> course = courseService.findAllCourse();
        for (Tbcourse tbc : course) {
            Tbcoursedto tbcoursedto = new Tbcoursedto();
            tbcoursedto.setCoursecode(tbc.getCoursecode());
            tbcoursedto.setCoursename(tbc.getCoursename());
            tbcoursedto.setOpentimecourse(tbc.getOpentimecourse());
            tbcoursedto.setStartcourse(tbc.getStartcourse());
            tbcoursedto.setEndcourse(tbc.getEndcourse());
            tbcoursedto.setNumberlesson(tbc.getNumberlesson());
            tbcoursedto.setMonth(tbc.getMonth());
            tbcoursedto.setYear(tbc.getYear());

            Date date = new Date();

            int result = tbc.getOpentimecourse().compareTo(date);
            int result2 = tbc.getStartcourse().compareTo(date);
            int result3 = tbc.getEndcourse().compareTo(date);

            if (result > 0 && result2 > 0 && result3 > 0) {
                tbcoursedto.setStatus("Will Open");
            } else if (result <= 0 && result2 > 0 && result3 > 0) {
                tbcoursedto.setStatus("Opening");
            } else if (result < 0 && result2 <= 0 && result3 >= 0) {
                tbcoursedto.setStatus("In Processing");
            } else if (result < 0 && result2 < 0 && result3 < 0) {
                tbcoursedto.setStatus("Close");
            }

            courseDTO.add(tbcoursedto);
        }
        model.addAttribute("courseList", courseDTO);
        return "admin/course";

    }

    @RequestMapping({"/localization"})
    public String localizationPage(Model model) {

        return "admin/abc";

    }

    @RequestMapping({"/role-permision"})
    public String rolePermisionPage(Model model) {

        model.addAttribute("positiongroup", new Tbpositiongroup());
        return "admin/role-permision";

    }

    @RequestMapping({"/loadPositionGroup"})
    public @ResponseBody
    List<Tbpositiongroup> loadPositionGroup(Model model) {

        List<Tbpositiongroup> listPG = positionGroupService.findAllPositionGroup();
        return listPG;

    }

    @RequestMapping({"/loadPermisionPosision"})
    public @ResponseBody
    List<Tbpositiongroup> loadPermisionPosision(Model model) {

        List<Tbpositiongroup> listPG = positionGroupService.findAllPositionGroup();
        return listPG;

    }

    @RequestMapping({"/loadFunction"})
    public @ResponseBody
    List<Tbfunctiondto> loadFunction(Model model, @RequestParam("idPermistion") String idPermistion) {

        List<Tbpositiongroupfunction> listPositionFunction = positionGroupFunctionService.findAllPositionGroupFunction(idPermistion);
        List<Tbfunction> listFunct = functionService.findAllFunction();
        List<Tbfunctiondto> listFunctiondto = new ArrayList<>();
        for (Tbfunction tbF : listFunct) {
            Tbpositiongroup tbPG = positionGroupService.getPositionGroupById(idPermistion);
            Tbfunctiondto tbfunctiondto = new Tbfunctiondto();
            tbfunctiondto.setFunctioncode(tbF.getFunctioncode());
            tbfunctiondto.setFunctionname(tbF.getFunctionname());
            tbfunctiondto.setPgcode(idPermistion);
            tbfunctiondto.setPgname(tbPG.getPgname());
            boolean check = false;

            for (Tbpositiongroupfunction tbPF : listPositionFunction) {

                if (tbPF.getTbfunction().getFunctioncode() == tbF.getFunctioncode()) {
                    check = true;
                    break;
                }

            }

            if (check == false) {
                tbfunctiondto.setPermision("False");
            } else {
                tbfunctiondto.setPermision("True");
            }

            listFunctiondto.add(tbfunctiondto);
        }
        return listFunctiondto;

    }

    @RequestMapping({"/loadOnlyFunction"})
    public @ResponseBody
    List<Tbfunction> loadOnlyFunction(Model model) {

        List<Tbfunction> listFunct = functionService.findAllFunction();
        return listFunct;

    }

    @RequestMapping(value = "/createClass", method = RequestMethod.POST)
    public String createClass(Model model, @RequestParam(required = false, value = "className") String className, @RequestParam(required = false, value = "sltcourse") String sltcourse, @RequestParam(required = false, value = "classDescription") String classDescription, @RequestParam(required = false, value = "sltRoom") String sltRoom, @RequestParam(required = false, value = "sltShift") ArrayList<String> sltShift, @RequestParam(required = false, value = "sltTeacherVNESE") String sltTeacherVNESE, @RequestParam(required = false, value = "sltRoomTuesday") String sltRoomTuesday, @RequestParam(required = false, value = "sltShiftTuesday") ArrayList<String> sltShiftTuesday, @RequestParam(required = false, value = "sltTeacherVNESETuesday") String sltTeacherVNESETuesday, @RequestParam(required = false, value = "sltRoomWednesday") String sltRoomWednesday, @RequestParam(required = false, value = "sltShiftWednesday") ArrayList<String> sltShiftWednesday, @RequestParam(required = false, value = "sltTeacherVNESEWednesday") String sltTeacherVNESEWednesday, @RequestParam(required = false, value = "sltRoomThursday") String sltRoomThursday, @RequestParam(required = false, value = "sltShiftThursday") ArrayList<String> sltShiftThursday, @RequestParam(required = false, value = "sltTeacherVNESEThursday") String sltTeacherVNESEThursday, @RequestParam(required = false, value = "sltRoomFriday") String sltRoomFriday, @RequestParam(required = false, value = "sltShiftFriday") ArrayList<String> sltShiftFriday, @RequestParam(required = false, value = "sltTeacherVNESEFriday") String sltTeacherVNESEFriday, @RequestParam(required = false, value = "sltRoomSaturday") String sltRoomSaturday, @RequestParam(required = false, value = "sltShiftSaturday") ArrayList<String> sltShiftSaturday, @RequestParam(required = false, value = "sltTeacherVNESESaturday") String sltTeacherVNESESaturday, @RequestParam(required = false, value = "sltRoomSunday") String sltRoomSunday, @RequestParam(required = false, value = "sltShiftSunday") ArrayList<String> sltShiftSunday, @RequestParam(required = false, value = "sltTeacherVNESESunday") String sltTeacherVNESESunday) {

        Tbclass tbclass = classService.findMaxClassCode();
        Tbcourse tbcourse = courseService.findCourseByCode(sltcourse);
        List<Tbcoursemodule> listCourseModule = courseModuleService.findCourseModuleByCourse(sltcourse);

        Date StartDate = tbcourse.getStartcourse();
        Date EndDate = tbcourse.getEndcourse();

        String strModuleCode = listCourseModule.get(0).getTbcoursemodulePK().getModulecode();
        Tbmodule tbmodule = moduleService.findModuleByCode(strModuleCode);

        // begin add tbclass
        // set value cho các field của class object để lát lưu dữ liêu
        String strLevelClass = tbmodule.getClassblock();
        String strClassCode = "";
        String strClassName = className;
        String strClassContent = classDescription;
        int month = tbcourse.getMonth();
        int year = tbcourse.getYear();
        int centercode = 1;
        int isclock = 0;
        if (tbclass == null) {
            strClassCode = "LH00000001";
        } else {
            // lấy new max class code
            String maxCodeClass = tbclass.getClasscode();
            String temp = maxCodeClass.substring(2, 10);
            int tempInt = Integer.parseInt(temp);
            tempInt = tempInt + 1;
            String newTempInt = String.valueOf(tempInt);
            String kihieuclass = maxCodeClass.substring(0, 2).toString();
            if (newTempInt.length() == 1) {
                strClassCode = kihieuclass + "0000000" + newTempInt;
            } else if (newTempInt.length() == 2) {
                strClassCode = kihieuclass + "000000" + newTempInt;
            } else if (newTempInt.length() == 3) {
                strClassCode = kihieuclass + "00000" + newTempInt;
            } else if (newTempInt.length() == 4) {
                strClassCode = kihieuclass + "0000" + newTempInt;
            } else if (newTempInt.length() == 5) {
                strClassCode = kihieuclass + "000" + newTempInt;
            } else if (newTempInt.length() == 6) {
                strClassCode = kihieuclass + "00" + newTempInt;
            } else if (newTempInt.length() == 7) {
                strClassCode = kihieuclass + "0" + newTempInt;
            } else {
                strClassCode = kihieuclass + newTempInt;
            }
        }

        // tạo class object để lưu new class xuống bảng tbclass
        Tbclass newTBClass = new Tbclass();
        newTBClass.setClasscode(strClassCode);
        newTBClass.setClassname(strClassName);
        newTBClass.setClasscontent(strClassContent);
        newTBClass.setMonth(month);
        newTBClass.setYear(year);
        newTBClass.setLevelcode(strLevelClass);
        newTBClass.setCentercode(centercode);
        newTBClass.setIslock(isclock);
        classService.createClass(newTBClass);
        // end add tbclass

        // begin add Tbclassschedule
        List<Tbclassschedule> classScheduleList = new ArrayList<>();

        if (sltTeacherVNESE != null) {

            for (String str : sltShift) {
                Tbclassroom dtCR = classroomService.findClassroomByCode(sltRoom);
                Tbclassschedule tbclassschedule = new Tbclassschedule();
                TbclassschedulePK tbclassschedulePK = new TbclassschedulePK();
                tbclassschedulePK.setClasscode(strClassCode);
                tbclassschedulePK.setDaycode("DAY0000002");
                tbclassschedulePK.setTeachercode(sltTeacherVNESE);
                tbclassschedulePK.setClasstimecode(str);
                tbclassschedule.setClassroomcode(sltRoom);
                tbclassschedule.setClasstimelessoncode(classTimeService.getClassTimeLessonByCode(str).getClasstimelesson().getCtlcode());
                tbclassschedule.setDayofweek("Monday");
                tbclassschedule.setClasstimelesson(classTimeService.getClassTimeLessonByCode(str).getClasstimelesson().getCtlname());
                tbclassschedule.setClasstime(classTimeService.getClassTimeLessonByCode(str).getClasstimename());
                tbclassschedule.setTeachername(staffService.findStaffByCode(sltTeacherVNESE).getStaffname());
                tbclassschedule.setStudymonth(month);
                tbclassschedule.setStudyyear(year);
                tbclassschedule.setCentercode(1);
                tbclassschedule.setRoom(dtCR.getRoomname());
                tbclassschedule.setTbclassschedulePK(tbclassschedulePK);
                classScheduleList.add(tbclassschedule);
            }

        }

        if (sltTeacherVNESETuesday != null) {
            for (String str : sltShiftTuesday) {
                Tbclassroom dtCR = classroomService.findClassroomByCode(sltRoomTuesday);
                Tbclassschedule tbclassschedule = new Tbclassschedule();
                TbclassschedulePK tbclassschedulePK = new TbclassschedulePK();
                tbclassschedulePK.setClasscode(strClassCode);
                tbclassschedulePK.setDaycode("DAY0000003");
                tbclassschedulePK.setTeachercode(sltTeacherVNESETuesday);
                tbclassschedulePK.setClasstimecode(str);
                tbclassschedule.setClassroomcode(sltRoomTuesday);
                tbclassschedule.setClasstimelessoncode(classTimeService.getClassTimeLessonByCode(str).getClasstimelesson().getCtlcode());
                tbclassschedule.setDayofweek("Tuesday");
                tbclassschedule.setClasstimelesson(classTimeService.getClassTimeLessonByCode(str).getClasstimelesson().getCtlname());
                tbclassschedule.setClasstime(classTimeService.getClassTimeLessonByCode(str).getClasstimename());
                tbclassschedule.setTeachername(staffService.findStaffByCode(sltTeacherVNESETuesday).getStaffname());
                tbclassschedule.setStudymonth(month);
                tbclassschedule.setStudyyear(year);
                tbclassschedule.setCentercode(1);
                tbclassschedule.setRoom(dtCR.getRoomname());
                tbclassschedule.setTbclassschedulePK(tbclassschedulePK);
                classScheduleList.add(tbclassschedule);
            }
        }

        if (sltTeacherVNESEWednesday != null) {
            for (String str : sltShiftWednesday) {
                Tbclassroom dtCR = classroomService.findClassroomByCode(sltRoomWednesday);
                Tbclassschedule tbclassschedule = new Tbclassschedule();
                TbclassschedulePK tbclassschedulePK = new TbclassschedulePK();
                tbclassschedulePK.setClasscode(strClassCode);
                tbclassschedulePK.setDaycode("DAY0000004");
                tbclassschedulePK.setTeachercode(sltTeacherVNESEWednesday);
                tbclassschedulePK.setClasstimecode(str);
                tbclassschedule.setClassroomcode(sltRoomWednesday);
                tbclassschedule.setClasstimelessoncode(classTimeService.getClassTimeLessonByCode(str).getClasstimelesson().getCtlcode());
                tbclassschedule.setDayofweek("Wednesday");
                tbclassschedule.setClasstimelesson(classTimeService.getClassTimeLessonByCode(str).getClasstimelesson().getCtlname());
                tbclassschedule.setClasstime(classTimeService.getClassTimeLessonByCode(str).getClasstimename());
                tbclassschedule.setTeachername(staffService.findStaffByCode(sltTeacherVNESEWednesday).getStaffname());
                tbclassschedule.setStudymonth(month);
                tbclassschedule.setStudyyear(year);
                tbclassschedule.setCentercode(1);
                tbclassschedule.setRoom(dtCR.getRoomname());
                tbclassschedule.setTbclassschedulePK(tbclassschedulePK);
                classScheduleList.add(tbclassschedule);
            }
        }

        if (sltTeacherVNESEThursday != null) {
            for (String str : sltShiftThursday) {
                Tbclassroom dtCR = classroomService.findClassroomByCode(sltRoomThursday);
                Tbclassschedule tbclassschedule = new Tbclassschedule();
                TbclassschedulePK tbclassschedulePK = new TbclassschedulePK();
                tbclassschedulePK.setClasscode(strClassCode);
                tbclassschedulePK.setDaycode("DAY0000005");
                tbclassschedulePK.setTeachercode(sltTeacherVNESEThursday);
                tbclassschedulePK.setClasstimecode(str);
                tbclassschedule.setClassroomcode(sltRoomThursday);
                tbclassschedule.setClasstimelessoncode(classTimeService.getClassTimeLessonByCode(str).getClasstimelesson().getCtlcode());
                tbclassschedule.setDayofweek("Thursday");
                tbclassschedule.setClasstimelesson(classTimeService.getClassTimeLessonByCode(str).getClasstimelesson().getCtlname());
                tbclassschedule.setClasstime(classTimeService.getClassTimeLessonByCode(str).getClasstimename());
                tbclassschedule.setTeachername(staffService.findStaffByCode(sltTeacherVNESEThursday).getStaffname());
                tbclassschedule.setStudymonth(month);
                tbclassschedule.setStudyyear(year);
                tbclassschedule.setCentercode(1);
                tbclassschedule.setRoom(dtCR.getRoomname());
                tbclassschedule.setTbclassschedulePK(tbclassschedulePK);
                classScheduleList.add(tbclassschedule);
            }
        }

        if (sltTeacherVNESEFriday != null) {
            for (String str : sltShiftFriday) {
                Tbclassroom dtCR = classroomService.findClassroomByCode(sltRoomFriday);
                Tbclassschedule tbclassschedule = new Tbclassschedule();
                TbclassschedulePK tbclassschedulePK = new TbclassschedulePK();
                tbclassschedulePK.setClasscode(strClassCode);
                tbclassschedulePK.setDaycode("DAY0000006");
                tbclassschedulePK.setTeachercode(sltTeacherVNESEFriday);
                tbclassschedulePK.setClasstimecode(str);
                tbclassschedule.setClassroomcode(sltRoomFriday);
                tbclassschedule.setClasstimelessoncode(classTimeService.getClassTimeLessonByCode(str).getClasstimelesson().getCtlcode());
                tbclassschedule.setDayofweek("Friday");
                tbclassschedule.setClasstimelesson(classTimeService.getClassTimeLessonByCode(str).getClasstimelesson().getCtlname());
                tbclassschedule.setClasstime(classTimeService.getClassTimeLessonByCode(str).getClasstimename());
                tbclassschedule.setTeachername(staffService.findStaffByCode(sltTeacherVNESEFriday).getStaffname());
                tbclassschedule.setStudymonth(month);
                tbclassschedule.setStudyyear(year);
                tbclassschedule.setCentercode(1);
                tbclassschedule.setRoom(dtCR.getRoomname());
                tbclassschedule.setTbclassschedulePK(tbclassschedulePK);
                classScheduleList.add(tbclassschedule);
            }
        }

        if (sltTeacherVNESESaturday != null) {
            for (String str : sltShiftSaturday) {
                Tbclassroom dtCR = classroomService.findClassroomByCode(sltRoomSaturday);
                Tbclassschedule tbclassschedule = new Tbclassschedule();
                TbclassschedulePK tbclassschedulePK = new TbclassschedulePK();
                tbclassschedulePK.setClasscode(strClassCode);
                tbclassschedulePK.setDaycode("DAY0000007");
                tbclassschedulePK.setTeachercode(sltTeacherVNESESaturday);
                tbclassschedulePK.setClasstimecode(str);
                tbclassschedule.setClassroomcode(sltRoomSaturday);
                tbclassschedule.setClasstimelessoncode(classTimeService.getClassTimeLessonByCode(str).getClasstimelesson().getCtlcode());
                tbclassschedule.setDayofweek("Saturday");
                tbclassschedule.setClasstimelesson(classTimeService.getClassTimeLessonByCode(str).getClasstimelesson().getCtlname());
                tbclassschedule.setClasstime(classTimeService.getClassTimeLessonByCode(str).getClasstimename());
                tbclassschedule.setTeachername(staffService.findStaffByCode(sltTeacherVNESESaturday).getStaffname());
                tbclassschedule.setStudymonth(month);
                tbclassschedule.setStudyyear(year);
                tbclassschedule.setCentercode(1);
                tbclassschedule.setRoom(dtCR.getRoomname());
                tbclassschedule.setTbclassschedulePK(tbclassschedulePK);
                classScheduleList.add(tbclassschedule);
            }
        }

        if (sltTeacherVNESESunday != null) {
            for (String str : sltShiftSunday) {
                Tbclassroom dtCR = classroomService.findClassroomByCode(sltRoomSunday);
                Tbclassschedule tbclassschedule = new Tbclassschedule();
                TbclassschedulePK tbclassschedulePK = new TbclassschedulePK();
                tbclassschedulePK.setClasscode(strClassCode);
                tbclassschedulePK.setDaycode("DAY0000008");
                tbclassschedulePK.setTeachercode(sltTeacherVNESESunday);
                tbclassschedulePK.setClasstimecode(str);
                tbclassschedule.setClassroomcode(sltRoomSunday);
                tbclassschedule.setClasstimelessoncode(classTimeService.getClassTimeLessonByCode(str).getClasstimelesson().getCtlcode());
                tbclassschedule.setDayofweek("Sunday");
                tbclassschedule.setClasstimelesson(classTimeService.getClassTimeLessonByCode(str).getClasstimelesson().getCtlname());
                tbclassschedule.setClasstime(classTimeService.getClassTimeLessonByCode(str).getClasstimename());
                tbclassschedule.setTeachername(staffService.findStaffByCode(sltTeacherVNESESunday).getStaffname());
//                tbclassschedule.setRoom(sltRoom);
                tbclassschedule.setStudymonth(month);
                tbclassschedule.setStudyyear(year);
                tbclassschedule.setCentercode(1);
                tbclassschedule.setRoom(dtCR.getRoomname());
                tbclassschedule.setTbclassschedulePK(tbclassschedulePK);
                classScheduleList.add(tbclassschedule);
            }
        }

        for (Tbclassschedule cs : classScheduleList) {
            classScheduleService.createNewClassSchedule(cs);
        }

        // end add Tbclassschedule
        // begin add Tbcourseclass
        TbcourseclassPK tbcourseclassPK = new TbcourseclassPK();
        tbcourseclassPK.setClasscode(strClassCode);
        tbcourseclassPK.setCoursecode(sltcourse);
        Tbcourseclass tbcourseclass = new Tbcourseclass();
        tbcourseclass.setTbcourseclassPK(tbcourseclassPK);
        tbcourseclass.setDescrip(strClassContent);
        tbcourseclass.setClassname(strClassName);
        
        // them du lieu enddate va startdate
        //tbcourseclass.setMonth(month);
        //tbcourseclass.setYear(year);
        
        courseClassService.saveCourseClass(tbcourseclass);
        // end add Tbcourseclass

        LocalDate StartLocalDate = StartDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int start = StartLocalDate.getDayOfMonth();
        int end = start + tbcourse.getNumberlesson();
        //int a = 1;
        Date newEndDate = new Date();
        List<Tbworkingschedule> workingscheduleList = new ArrayList<>();
        
        for (int i = start, a = 1; a <= tbcourse.getNumberlesson(); i++) {
            
            int dayOfWeek = StartLocalDate.plusDays(i - start).getDayOfWeek().getValue();
            LocalDate workingDay = StartLocalDate.plusDays(i - start);
            Date workingDate = Date.from(workingDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
            
            if(a == tbcourse.getNumberlesson()){
                newEndDate = workingDate;
            }
            
            if (sltTeacherVNESE != null && dayOfWeek == 1) {
                for (String strShift : sltShift) {
                    Tbworkingschedule tbworkingschedule = new Tbworkingschedule();
                    tbworkingschedule.setStaffcode(sltTeacherVNESE);
                    tbworkingschedule.setClasstimecode(strShift);
                    tbworkingschedule.setClasscode(strClassCode);
                    tbworkingschedule.setClassroomcode(sltRoom);
                    tbworkingschedule.setMonth(month);
                    tbworkingschedule.setYear(year);
                    tbworkingschedule.setCentercode(1);
                    tbworkingschedule.setCompleted(0);
                    tbworkingschedule.setWorkingday(workingDate);
                    workingscheduleList.add(tbworkingschedule);
                }
                a++;
            } else if (sltTeacherVNESETuesday != null && dayOfWeek == 2) {
                for (String strShift : sltShiftTuesday) {
                    Tbworkingschedule tbworkingschedule = new Tbworkingschedule();
                    tbworkingschedule.setStaffcode(sltTeacherVNESETuesday);
                    tbworkingschedule.setClasstimecode(strShift);
                    tbworkingschedule.setClasscode(strClassCode);
                    tbworkingschedule.setClassroomcode(sltRoomTuesday);
                    tbworkingschedule.setMonth(month);
                    tbworkingschedule.setYear(year);
                    tbworkingschedule.setCentercode(1);
                    tbworkingschedule.setCompleted(0);
                    tbworkingschedule.setWorkingday(workingDate);
                    workingscheduleList.add(tbworkingschedule);
                }
                a++;
            } else if (sltTeacherVNESEWednesday != null && dayOfWeek == 3) {
                for (String strShift : sltShiftWednesday) {
                    Tbworkingschedule tbworkingschedule = new Tbworkingschedule();
                    tbworkingschedule.setStaffcode(sltTeacherVNESEWednesday);
                    tbworkingschedule.setClasstimecode(strShift);
                    tbworkingschedule.setClasscode(strClassCode);
                    tbworkingschedule.setClassroomcode(sltRoomWednesday);
                    tbworkingschedule.setMonth(month);
                    tbworkingschedule.setYear(year);
                    tbworkingschedule.setCentercode(1);
                    tbworkingschedule.setCompleted(0);
                    tbworkingschedule.setWorkingday(workingDate);
                    workingscheduleList.add(tbworkingschedule);
                }
                a++;
            } else if (sltTeacherVNESEThursday != null && dayOfWeek == 4) {
                for (String strShift : sltShiftThursday) {
                    Tbworkingschedule tbworkingschedule = new Tbworkingschedule();
                    tbworkingschedule.setStaffcode(sltTeacherVNESEThursday);
                    tbworkingschedule.setClasstimecode(strShift);
                    tbworkingschedule.setClasscode(strClassCode);
                    tbworkingschedule.setClassroomcode(sltRoomThursday);
                    tbworkingschedule.setMonth(month);
                    tbworkingschedule.setYear(year);
                    tbworkingschedule.setCentercode(1);
                    tbworkingschedule.setCompleted(0);
                    tbworkingschedule.setWorkingday(workingDate);
                    workingscheduleList.add(tbworkingschedule);
                }
                a++;
            } else if (sltTeacherVNESEFriday != null && dayOfWeek == 5) {
                for (String strShift : sltShiftFriday) {
                    Tbworkingschedule tbworkingschedule = new Tbworkingschedule();
                    tbworkingschedule.setStaffcode(sltTeacherVNESEFriday);
                    tbworkingschedule.setClasstimecode(strShift);
                    tbworkingschedule.setClasscode(strClassCode);
                    tbworkingschedule.setClassroomcode(sltRoomFriday);
                    tbworkingschedule.setMonth(month);
                    tbworkingschedule.setYear(year);
                    tbworkingschedule.setCentercode(1);
                    tbworkingschedule.setCompleted(0);
                    tbworkingschedule.setWorkingday(workingDate);
                    workingscheduleList.add(tbworkingschedule);
                }
                a++;
            } else if (sltTeacherVNESESaturday != null && dayOfWeek == 6) {
                for (String strShift : sltShiftSaturday) {
                    Tbworkingschedule tbworkingschedule = new Tbworkingschedule();
                    tbworkingschedule.setStaffcode(sltTeacherVNESESaturday);
                    tbworkingschedule.setClasstimecode(strShift);
                    tbworkingschedule.setClasscode(strClassCode);
                    tbworkingschedule.setClassroomcode(sltRoomSaturday);
                    tbworkingschedule.setMonth(month);
                    tbworkingschedule.setYear(year);
                    tbworkingschedule.setCentercode(1);
                    tbworkingschedule.setCompleted(0);
                    tbworkingschedule.setWorkingday(workingDate);
                    workingscheduleList.add(tbworkingschedule);
                }
                a++;
            } else if (sltTeacherVNESESunday != null && dayOfWeek == 7) {
                for (String strShift : sltShiftSunday) {
                    Tbworkingschedule tbworkingschedule = new Tbworkingschedule();
                    tbworkingschedule.setStaffcode(sltTeacherVNESESunday);
                    tbworkingschedule.setClasstimecode(strShift);
                    tbworkingschedule.setClasscode(strClassCode);
                    tbworkingschedule.setClassroomcode(sltRoomSunday);
                    tbworkingschedule.setMonth(month);
                    tbworkingschedule.setYear(year);
                    tbworkingschedule.setCentercode(1);
                    tbworkingschedule.setCompleted(0);
                    tbworkingschedule.setWorkingday(workingDate);
                    workingscheduleList.add(tbworkingschedule);
                }
                a++;
            }
        }
        
        for (Tbworkingschedule tbws : workingscheduleList) {
            workingScheduleService.createWorkingSchedule(tbws);
        }
        
        courseModuleService.updateEndDate(newEndDate, sltcourse);
        courseService.updateEndDate(newEndDate, sltcourse);
        
        // end add Tbworkingschedule
        return "redirect:/admin/classes";
    }

    @RequestMapping({"/loadModulePermission"})
    public @ResponseBody
    Tbfunctionandpositiondto loadModulePermission(Model model) {

        Tbfunctionandpositiondto listPermission = new Tbfunctionandpositiondto();
        List<Tbfunction> listFunct = functionService.findAllFunction();
        listPermission.setListFunction(listFunct);
        return listPermission;

    }

    @RequestMapping(value = "/updatePermision", method = RequestMethod.GET)
    public @ResponseBody
    String updatePermision(Model model, @RequestParam("idPermistion") String idPermistion, @RequestParam("idPosition") String idPosition) {

        Tbpositiongroupfunction tbPF = positionGroupFunctionService.getTbpositiongroupfunctionByPermision(idPermistion, idPosition);
        Tbfunction tbFunc = functionService.getFunctionById(idPermistion);
        Tbpositiongroup tbPG = positionGroupService.getPositionGroupById(idPosition);
        TbpositiongroupfunctionPK tpk = new TbpositiongroupfunctionPK();
        tpk.setFunctioncode(idPermistion);
        tpk.setPgcode(idPosition);
        if (tbPF == null) {
            Tbpositiongroupfunction tbpositiongroupfunction = new Tbpositiongroupfunction();
            tbpositiongroupfunction.setTbfunction(tbFunc);
            tbpositiongroupfunction.setTbpositiongroup(tbPG);
            tbpositiongroupfunction.setCentercode(1);
            tbpositiongroupfunction.setIsdelete(0);
            tbpositiongroupfunction.setTbpositiongroupfunctionPK(tpk);
            positionGroupFunctionService.createTbpositiongroupfunction(tbpositiongroupfunction);
            return "true";
        } else {
            positionGroupFunctionService.removeTbpositiongroupfunction(tbPF);
            return "false";
        }

    }

    @RequestMapping(value = "/setting/editCenterModal", method = RequestMethod.GET)
    public @ResponseBody
    Tbcenter editCenterModal(@RequestParam("id") String id) {

        int centerId = Integer.parseInt(id);
        Tbcenter tbcenter = centerService.findCenterById(centerId);
        return tbcenter;

    }

    @RequestMapping(value = "/setting/deleteCenterModal", method = RequestMethod.POST)
    public String deleteCenterModal(Model model, @RequestParam("idcenterDlt") String idcenterDlt) {

        int centerId = Integer.parseInt(idcenterDlt);
        Tbcenter tbcenter = centerService.findCenterById(centerId);
        tbcenter.setIsdelete(1);
        centerService.saveCenter(tbcenter);
        return "redirect:/admin/setting";

    }

    @RequestMapping(value = "/setting/create", method = RequestMethod.POST)
    public String createCenter(Model model, Tbcenter tbcenter) {

        tbcenter.setCenterdefault(0);
        tbcenter.setIsdelete(0);
        centerService.saveCenter(tbcenter);
        return "redirect:/admin/setting";

    }

    @RequestMapping(value = "/setting/update", method = RequestMethod.POST)
    public String updateCenter(Model model, Tbcenter tbcenter, RedirectAttributes redirectAttributes) {

        centerService.saveCenter(tbcenter);
        redirectAttributes.addFlashAttribute("messageResult", "Update Successfully !");
        return "redirect:/admin/setting";

    }

}
