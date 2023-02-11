/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.custom;

import com.example.DemoProjectSem04.entities.Tbpositiongroupfunction;
import com.example.DemoProjectSem04.entities.Tbuser;
import com.example.DemoProjectSem04.repositories.tbPositiongroupFunctionRepository;
import com.example.DemoProjectSem04.repositories.tbUserRepository;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Admin
 */

public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    tbUserRepository userRepository;
    
    @Autowired
     tbPositiongroupFunctionRepository positiongroupFunctionRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Tbuser tbuser = userRepository.getUserByUserEmail(username);
        List<Tbpositiongroupfunction> list = positiongroupFunctionRepository.getFunctionByPermision(tbuser.getPermision().getPgcode().toString());
        if(tbuser == null){
            throw new UsernameNotFoundException("Could not find user");
        }
//        HttpSession session = new HttpSession() {};
//        session.setMaxInactiveInterval(20*60);
        return new MyUserDetails(tbuser, list);
    }
    
}
