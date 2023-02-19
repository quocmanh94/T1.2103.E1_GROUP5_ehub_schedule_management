/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.controller;

import com.example.DemoProjectSem04.entities.Tbadvise;
import com.example.DemoProjectSem04.entities.Tbfee;
import com.example.DemoProjectSem04.interfaces.tbFeeService;
import com.example.DemoProjectSem04.services.tbAdviseService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/client")
public class ClientController {
    
    @Autowired
    tbAdviseService adviseService;
    
    @Autowired
    tbFeeService feeService;
    
    @RequestMapping("/homepage")
    public String clienthomepage(Model model) {
        //model.addAttribute("attribute", "value");
        return "client/clienthomepage";
    }
    
    
    
    @RequestMapping("/aboutus")
    public String clientaboutuspage(Model model) {
        //model.addAttribute("attribute", "value");
        return "client/clientaboutus";
    }
    
    @RequestMapping("/gallery")
    public String clientgallerypage(Model model) {
        //model.addAttribute("attribute", "value");
        return "client/clientgallery";
    }
    
    @RequestMapping("/course")
    public String clientcoursepage(Model model, @ModelAttribute("ids") String ids, @ModelAttribute("name") String name) {
        //model.addAttribute("attribute", "value");
        if (ids != "") {
            model.addAttribute("ids", ids);
            model.addAttribute("name", name);
        }
        List<Tbfee> tbfeesList = feeService.getAllFee();
        model.addAttribute("fee", tbfeesList);
        return "client/clientcourse";
    }
    
    @RequestMapping("/contact")
    public String contactpage(Model model) {
        //model.addAttribute("attribute", "value");
//        if (notice != "") {
//            model.addAttribute("notice", notice);
//        }
//        String as = "I Will Contact To You Soon !";
//        model.addAttribute("notice", as);
        return "client/clientcontact";
    }
    
    @RequestMapping(value = "/requestadvise", method = RequestMethod.POST)
    public String requestadvise(Model model, @RequestParam(required = false, value = "classblock") String classblock, @RequestParam(required = false, value = "name") String name, @RequestParam(required = false, value ="email") String email, @RequestParam(required = false, value ="namecourses") String namecourses, @RequestParam(required = false, value ="message") String message, RedirectAttributes redirectAttributes) {
//        String as = "I Will Contact To You Soon !";
//        redirectAttributes.addFlashAttribute("notice", as);
//        model.addAttribute("notice", as);
        Tbadvise tbadvise = new Tbadvise();
        tbadvise.setAdivsestatus(0);
        if(classblock != null){
            tbadvise.setAdviseclassblock(classblock);
            tbadvise.setAdvisecoursename(namecourses);
        }
        tbadvise.setAdvisecontent(message);
        tbadvise.setAdviseemail(email);
        tbadvise.setAdvisename(name);
        adviseService.save(tbadvise);
        return "redirect:/client/course";
    }
    
    @RequestMapping(value = "/registercourse", method = RequestMethod.POST)
    public String registercourse(Model model, @RequestParam(required = false, value = "ids") String ids, @RequestParam(required = false, value ="name") String name, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("ids", ids);
        redirectAttributes.addFlashAttribute("name", name);
        return "redirect:/client/contact";
    }
    
}
