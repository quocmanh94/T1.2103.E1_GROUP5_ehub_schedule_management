/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.controller;

import com.example.DemoProjectSem04.DTO.Tbclassdto;
import com.example.DemoProjectSem04.utils.PasswordGenerator;
import com.example.DemoProjectSem04.DTO.Tbstaffdto;
import com.example.DemoProjectSem04.DTO.Tbstudentdto;
import com.example.DemoProjectSem04.DTO.Tbuserdto;
import com.example.DemoProjectSem04.DTO.Tbuserdto2;
import com.example.DemoProjectSem04.entities.Tbclass;
import com.example.DemoProjectSem04.entities.Tbclassroom;
import com.example.DemoProjectSem04.entities.Tbclassschedule;
import com.example.DemoProjectSem04.entities.Tbcourse;
import com.example.DemoProjectSem04.entities.Tbcourseclass;
import com.example.DemoProjectSem04.entities.Tbcoursemodule;
import com.example.DemoProjectSem04.entities.Tbmodule;
import com.example.DemoProjectSem04.entities.Tbpositiongroup;
import com.example.DemoProjectSem04.entities.Tbrole;
import com.example.DemoProjectSem04.entities.Tbstaff;
import com.example.DemoProjectSem04.entities.Tbstudent;
import com.example.DemoProjectSem04.entities.Tbuser;
import com.example.DemoProjectSem04.interfaces.tbUserInterface;
import com.example.DemoProjectSem04.services.tbCenterService;
import com.example.DemoProjectSem04.services.tbClassScheduleService;
import com.example.DemoProjectSem04.services.tbClassService;
import com.example.DemoProjectSem04.services.tbClassroomService;
import com.example.DemoProjectSem04.services.tbCourseClassService;
import com.example.DemoProjectSem04.services.tbCourseModuleService;
import com.example.DemoProjectSem04.services.tbCourseService;
import com.example.DemoProjectSem04.services.tbModuleService;
import com.example.DemoProjectSem04.services.tbPositionGroupService;
import com.example.DemoProjectSem04.services.tbRoleService;
import com.example.DemoProjectSem04.services.tbStaffService;
import com.example.DemoProjectSem04.services.tbStudentService;
import com.example.DemoProjectSem04.services.tbUserService;
import com.example.DemoProjectSem04.utils.FileUploadUtil;
import static com.example.DemoProjectSem04.utils.PasswordGenerator.encryptPassword;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(Model model) {
        return "admin/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpServletRequest request, HttpServletResponse response) {
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
        if (messageResult != "") {
            model.addAttribute("messageResult", messageResult);
        }
        List<Tbuser> listTbuser = userService.findAllUser();
        model.addAttribute("listTbuser", listTbuser);
        return "admin/users";
    }

    @RequestMapping({"/classrooms"})
    public String classroomsPage(Model model, @ModelAttribute("messageResult") String messageResult) {
        model.addAttribute("classroom", new Tbclassroom());
        if (messageResult != "") {
            model.addAttribute("messageResult", messageResult);
        }
        List<Tbclassroom> listTbclassroom = classroomService.findAllClassroom();
        model.addAttribute("listTbclassroom", listTbclassroom);
        return "admin/classrooms";
    }

    @RequestMapping({"/stafflist"})
    public String stafflistPage(Model model, @ModelAttribute("messageResult") String messageResult) {
        return "admin/stafflist";
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

        model.addAttribute("classList", classDTOList);
        return "admin/class";
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
        return "admin/changepassword";
    }

    @RequestMapping({"/detailclass/{id}"})
    public String detailclassPage(Model model, @PathVariable("id") String id) {
        Tbcourseclass dtcourseclass = courseClassService.getCourseClassByClassCode(id);
        Tbcourse dtcourse = courseService.findCourseByCode(dtcourseclass.getTbcourseclassPK().getCoursecode());
        List<Tbmodule> dlModule = moduleService.getModuleByCourseCode(dtcourse.getCoursecode());
        model.addAttribute("dtcourse", dtcourse);
        model.addAttribute("dlModule", dlModule);
        return "admin/detailsclass";
    }

    @RequestMapping({"/workingschedule"})
    public String workingschedulePage(Model model) {
        return "admin/workingschedule";
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
        return "admin/student";
    }

    @RequestMapping({"/addstudent"})
    public String addstudentPage(Model model) {
        Tbstudent maxCodeStudent = studentService.getMaxCodeStudent();
        List<Tbclass> dtClass = classService.getClassesStillWorking();
        String codeStudent = "";
        if (maxCodeStudent == null) {
            codeStudent = "HV00000001";
        }
        model.addAttribute("dtClass", dtClass);
        model.addAttribute("roll", codeStudent);
        return "admin/addstudent";
    }

    @RequestMapping(value = "/createNewStudent", method = RequestMethod.POST)
    public String createNewStudent(Model model, @RequestParam(required = false, value = "sltStudentPaid") String sltStudentPaid, @RequestParam(required = false, value = "studentcode") String studentcode, @RequestParam(required = false, value = "studentname") String studentname, @RequestParam(required = false, value = "sltGender") String sltGender, @RequestParam(required = false, value = "studentdob") Date studentdob, @RequestParam(required = false, value = "studentphone") String studentphone, @RequestParam(required = false, value = "studentemail") String studentemail, @RequestParam(required = false, value = "sltClass") String sltClass, @RequestParam(required = false, value = "sltStatusStudent") String sltStatusStudent, @RequestParam(required = false, value = "studentaddress") String studentaddress, @RequestParam(required = false, value = "parentname") String parentname, @RequestParam(required = false, value = "parentphone") String parentphone) throws IOException {

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
        //newStudent.setStudentlevel(sltStudentLevel);
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
        return "redirect:/admin/student";
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
        return "admin/profile";
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
        return "admin/modulecourse";
    }

    @RequestMapping({"/getModuleByCourse"})
    public @ResponseBody
    List<Tbmodule> getModuleByCourse(Model model, @RequestParam("idCourse") String idCourse) {
        List<Tbcoursemodule> dtcoursemodule = courseModuleService.findCourseModuleByCourse(idCourse);
        List<Tbmodule> dtmodule = new ArrayList<>();
        for(Tbcoursemodule k : dtcoursemodule){
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
        return "redirect:/admin/classrooms";
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

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("list", userService.findAllUser());
        return "index";
    }

    @GetMapping(value = "/403")
    public String erro403() {
        return "403";
    }

}
